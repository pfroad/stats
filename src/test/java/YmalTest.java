import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class YmalTest {
    @Test
    public void testYaml() {
        InputStream inputStream = this.getClass().getResourceAsStream("test.yml");
        Yaml yaml = new Yaml();
        Iterable obj = yaml.loadAll(inputStream);
        obj.forEach(it -> {
                System.out.println(it);
        });
    }

    @Test
    public void testYaml2() {
        InputStream inputStream = this.getClass().getResourceAsStream("test2.yml");
        Yaml yaml = new Yaml();
        Object obj = yaml.load(inputStream);
        System.out.println(obj);
    }

    @Test
    public void testResource() throws IOException {
        Enumeration<URL> urls = getClass().getClassLoader().getResources("com/airparking/azkaban");
//        Enumeration<URL> urls = getClass().getClassLoader().getResources("org/apache/ibatis");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            if (url.getProtocol().endsWith("jar")) {
                System.out.println(url.getFile());
                JarFile jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();
                    String name = entry.getName();
                    if (!name.contains(".class"))
                        continue;
                    System.out.println(name);
                    System.out.println(name.substring(0, name.lastIndexOf(".")).replaceAll("/", "\\."));
                }
            } else {
                printClassFromFile(new File(url.getFile()));
            }

        }
    }

    private void printClassFromFile(File file) {
//        File file = new File(fileName);
        File[] subFiles = file.listFiles();

        if (subFiles != null && subFiles.length > 0) {
            Arrays.stream(subFiles).forEach(it -> {
                if (it.isDirectory()) {
                    printClassFromFile(it);
                } else {
                    System.out.println(it.getName());
                }
            });
        }

    }
}
