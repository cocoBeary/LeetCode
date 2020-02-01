package Test;

public class Child extends Parent {

    public static int testValue(){
        return 2;
    }

    @Override
    public int otherMethod() {
        return 5;
    }
}
