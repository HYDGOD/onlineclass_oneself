package package_005;

public class Test111 {
    public static void main(String[] args) {
        System.out.println(ClassAndObjectTest.age);

        ClassAndObjectTest name1 = new ClassAndObjectTest();
        String name = name1.name;
        System.out.println(name);
        System.out.println(ClassAndObjectTest.age(16));
        System.out.println(name1.age2(16));
    }

}

