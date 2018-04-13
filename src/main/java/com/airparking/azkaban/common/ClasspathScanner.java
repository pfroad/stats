package com.airparking.azkaban.common;

import com.airparking.azkaban.utils.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClasspathScanner {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClasspathScanner.class);
    private final static String JAR = "jar";
    private final static String CLASS = ".class";
    private Boolean debugEnbaled = false;
    private String[] packageNames;
    private ClassLoader classLoader;

    public ClasspathScanner(String... packageNames) {
        assert packageNames != null;
        this.packageNames = packageNames;
        this.classLoader = ClassUtils.getDefaultClassLoader();
    }

    public List<Class<?>> scan() throws IOException {
        LOGGER.info("start to scan classes in packages {}", this.packageNames);
        return doScan(this.packageNames);
    }

    private List<Class<?>> doScan(String... packageNames) throws IOException {
        final List<Class<?>> scannedClasses = new ArrayList<>();

        for (String packageName : packageNames) {
            final String scanPath = packageName.replaceAll("\\.", "/");
            final Enumeration<URL> urls = this.classLoader.getResources(scanPath);

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
//            String rootPath = getRootPath(url);
                String protocol = url.getProtocol();

                if (protocol.equals(JAR)) {
                    scanJar(url, packageName, scannedClasses);
                } else {
                    try {
                        if (debugEnbaled) {
                            LOGGER.debug("Load class from file {}", url.getFile());
                        }
                        final File file = new File(url.getFile());
                        loadClassFromFile(file, packageName, scannedClasses);
                    } catch (Exception e) {
                    }

                }
            }
        }
        return scannedClasses;
    }

    private void loadClassFromFile(File file, String packageName, List<Class<?>> scannedClasses) {
        final File[] subFiles = file.listFiles();
        if (subFiles == null || subFiles.length == 0) {
            return;
        }

        Arrays.stream(subFiles).forEach(it -> {
            if (it.isDirectory()) {
                loadClassFromFile(it, packageName + "." + it.getName(), scannedClasses);
            } else {
                String fileName = it.getName();

                if (!fileName.endsWith(CLASS))
                    return;

                String className = packageName + "." + trimClassExt(fileName);

                try {
                    if (debugEnbaled) {
                        LOGGER.debug("Load class {}", className);
                    }
                    scannedClasses.add(this.classLoader.loadClass(className));
                } catch (ClassNotFoundException e) {
                    // cannot load class
                }
            }
        });

    }

    private void scanJar(URL url, String packageName, List<Class<?>> scannedClasses) throws IOException {
        if (debugEnbaled) {
            LOGGER.debug("Scan jar file {}", url.getFile());
        }

        final JarFile jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
        final Enumeration<JarEntry> entryEnum = jarFile.entries();

        while (entryEnum.hasMoreElements()) {
            final JarEntry entry = entryEnum.nextElement();
            String srcName = entry.getName();

            if (!srcName.endsWith(CLASS))
                continue;

            if (srcName.charAt(0) == '/') {
                srcName = srcName.substring(1);
            }

            String className = trimClassExt(srcName).replaceAll("/", "\\.");
            if (!className.startsWith(packageName))
                continue;

            try {
                if (debugEnbaled) {
                    LOGGER.debug("Load class {}", className);
                }
                scannedClasses.add(this.classLoader.loadClass(className));
            } catch (ClassNotFoundException e) {
                // cannot load class
            }
        }
    }

    private String trimClassExt(String classFile) {
        return classFile.substring(0, classFile.lastIndexOf("."));
    }

    /**
     * jar: "file:/home/whf/foo.jar!cn/fh" -> "/home/whf/foo.jar"
     * file : "/home/whf/cn/fh" -> "/home/whf/cn/fh""
     * @param url
     * @return
     */
    private String getRootPath(URL url) {
        String filePath = url.getFile();
        int end = filePath.indexOf("!");

        return end > 0 ? filePath.substring(5, end) : filePath;
    }

    public String[] getPackageName() {
        return packageNames;
    }

    public void setPackageName(String... packageName) {
        this.packageNames = packageNames;
    }
}
