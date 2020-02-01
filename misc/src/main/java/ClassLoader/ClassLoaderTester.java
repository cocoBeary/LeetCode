package ClassLoader;

public class ClassLoaderTester {
    public static void main(String[] args) {
        CustomClassLoader loader = new CustomClassLoader(
                CustomClassLoader.class.getClassLoader(), "Hello");
//        CustomClassLoader2 loader2 = new CustomClassLoader2(
//                CustomClassLoader2.class.getClassLoader(), "Hello");
        Class clazz;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(loader);
        try {
            //clazz = loader2.loadClass("ClassLoader.Hello");
            //Object object = clazz.newInstance();
            clazz = Class.forName("ClassLoader.Hello");
            Object object = clazz.newInstance();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
