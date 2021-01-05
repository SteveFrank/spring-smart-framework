package org.smart.framwork.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.smart.framwork.config.SmartConstants.CLASS_SUFFIX;
import static org.smart.framwork.config.SmartConstants.FILE_PROTOCOL;

/**
 * @author yangqian
 * @date 2021/1/4
 */
@Slf4j
public class ClassUtil {

    /**
     * 根据包名获取包下的类集合
     *
     * 1、获取类加载器（解决实际路径的问题，如果用户传入绝对路径很不友好且不合理，且部署无法确定绝对路径）
     *  类加载器 ClassLoader
     *      根据一个指定的类的名称，找到或者生成其对应的字节码
     *      加载Java应用所需的资源
     * 2、通过类加载器获取到加载的资源信息
     * 3、依据不同的资源类型，采用不同的方式获取资源的集合
     *
     * @param packageName 包名
     * @return 类的Set集合
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        // 获取类加载器
        ClassLoader classLoader = getClassLoader();
        // 通过类加载器获取到加载的资源
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            log.warn("please check package, unable to retrieve anything from this package: {}", packageName);
            return null;
        }
        // 依据不同的资源类型，采用不同的方式获取资源集合
        Set<Class<?>> classSet = null;
        // 过滤出文件类型的资源
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            // 如果是file
            classSet = new HashSet<Class<?>>();
            File packageDirectory = new File(url.getPath());
            // 提取file下的class文件
            extractClassFile(classSet, packageDirectory, packageName);
        }
        return classSet;
    }

    /**
     * 提取出classFile的信息,所有Class文件
     * @param emptyClassSet 类的基本信息
     * @param fileSource 实际file资源
     * @param packageName 包名称
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        // 递归，传入集合收集结果 1）推进 2）终止
        if (!fileSource.isDirectory()) {
            // 如果不是一个文件夹则终止
            return;
        }
        // 如果是一个文件夹，则调用文件夹所有的文件 、 文件夹
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    // 提取文件夹
                    return true;
                } else {
                    // 获取文件的绝对值路径
                    String absoluteFilePath = file.getAbsolutePath();
                    if (absoluteFilePath.endsWith(CLASS_SUFFIX)) {
                        // 如果是class文件，则直接加载
                        addToClassSet(absoluteFilePath);
                    }
                }
                // 非目录的目标文件直接过滤掉
                return false;
            }

            private void addToClassSet(String absoluteFilePath) {
                // 1. 从class文件的绝对值路径里提取出包含了package的类名
                // /Users/baidu/imooc/springframework/sampleframework/target/classes/com/imooc/entity/dto/MainPageInfoDTO.class
                // 需要弄成com.xxx.MainPageInfoDTO
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                // 去掉.class
                className = className.substring(0, className.lastIndexOf("."));
                // 2. 通过反射机制获取对应的Class对象并且加入到classSet中
                Class<?> targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });
        if (files != null) {
            for (File f : files) {
                // 递归调用
                extractClassFile(emptyClassSet, f, packageName);
            }
        }
    }


    /**
     * 获取ClassLoader实例
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        // 根据线程获取到类加载器
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 获取class对象
     * @param className
     * @return
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("loadClass error!", e);
            throw new RuntimeException(e);
        }
    }

}
