package ClassLoader;

import java.io.*;

public class CustomClassLoader2 extends ClassLoader {
    private String name;

    public CustomClassLoader2(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> clazz = null;
        ClassLoader system = getSystemClassLoader();
        try {
            clazz = system.loadClass(name);
        } catch (Exception e) {
            // ignore
        }
        if (clazz != null)
            return clazz;
        clazz = findClass(name);
        return clazz;
    }

    @Override
    public Class<?> findClass(String name) {

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File("C:\\Java\\Github\\LeetCode\\misc\\src\\main\\java\\ClassLoader\\Hello.class"));
            int c = 0;
            while (-1 != (c = is.read())) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.defineClass(name, data, 0, data.length);
    }
}
