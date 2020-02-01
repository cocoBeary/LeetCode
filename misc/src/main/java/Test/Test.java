package Test;

public class Test {
    public static void main(String[] args) {
        Parent child = (new Child());
        System.out.println(child.testValue());
        System.out.println(child.otherMethod());
    }
}
