/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月26日
 * 修改历史 : 
 *     1. [2017年4月26日]创建文件 by gehanbiao
 */
package test;


import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 添加类/接口功能描述
 * @author gehanbiao
 * @version 2017年4月26日
 */
public class DemoTest 
implements Serializable
                            {

    private static final long serialVersionUID = 1L;
    
    private String var = "hello";
    
    public int num = 5;

    /**
     * 通过一个对象获得完整的包名和类名
     */
//    public static void main(String[] args) {
//        DemoTest demo = new DemoTest();
//        System.out.println(demo.getClass().getName());
//    }
    
    /**
     * 实例化Class类对象
     */
//    public static void main(String[] args) throws Exception {
//        DemoTest demo = new DemoTest();
//        System.out.println(demo.getClass().getName());
//        Class<?> class1 = null;
//        Class<?> class2 = null;
//        Class<?> class3 = null;
//        // 一般采用这种形式
//        class1 = Class.forName("test.DemoTest");
//        class2 = new DemoTest().getClass();
//        class3 = DemoTest.class;
//        System.out.println("类名称   " + class1.getName());
//        System.out.println("类名称   " + class2.getName());
//        System.out.println("类名称   " + class3.getName());
//    }
    
    /**
     * 获取一个对象的父类与实现的接口
     */
//    public static void main(String[] args) throws Exception {
//        Class<?> clazz = Class.forName("test.DemoTest");
//        // 取得父类
//        Class<?> parentClass = clazz.getSuperclass();
//        System.out.println("clazz的父类为：" + parentClass.getName());
//        // clazz的父类为： java.lang.Object
//        // 获取所有的接口
//        Class<?> intes[] = clazz.getInterfaces();
//        System.out.println("clazz实现的接口有：");
//        for (int i = 0; i < intes.length; i++) {
//            System.out.println((i + 1) + "：" + intes[i].getName());
//        }
//    }
    
    /**
     * 获取某个类中的全部构造函数 - 详见下例
     * 通过反射机制实例化一个类的对象
     */
//    public static void main(String[] args) throws Exception {
//        Class<?> class1 = null;
//        class1 = Class.forName("test.User");
//        // 第一种方法，实例化默认构造方法，调用set赋值
//        User user = (User) class1.newInstance();
//        user.setAge(20);
//        user.setName("Rollen");
//        System.out.println(user);
//        // 结果 User [age=20, name=Rollen]
//        // 第二种方法 取得全部的构造函数 使用构造函数赋值
//        Constructor<?> cons[] = class1.getConstructors();
//        // 查看每个构造方法需要的参数
//        for (int i = 0; i < cons.length; i++) {
//            Class<?> clazzs[] = cons[i].getParameterTypes();
//            System.out.print("cons[" + i + "] (");
//            for (int j = 0; j < clazzs.length; j++) {
//                if (j == clazzs.length - 1)
//                    System.out.print(clazzs[j].getName());
//                else
//                    System.out.print(clazzs[j].getName() + ",");
//            }
//            System.out.println(")");
//        }
//        // 结果
//        // cons[0] (java.lang.String)
//        // cons[1] (int,java.lang.String)
//        // cons[2] ()
//        user = (User) cons[2].newInstance("Rollen");
//        System.out.println(user);
//        user = (User) cons[1].newInstance(20, "Rollen","Rollen");
//        System.out.println(user);
//        // 结果 User [age=0, name=Rollen]
//        user = (User) cons[0].newInstance(20, "Rollen");
//        System.out.println(user);
////         结果 User [age=20, name=Rollen]
//    }
//}
//    class User {
//        private int age;
//        private String name;
//        public User() {
//            super();
//        }
//        public User(String name) {
//            super();
//            this.name = name;
//        }
//        
//        public User(int age, String name, String names) {
//            super();
//            this.age = age;
//            this.name = name;
//            this.name = names;
//        }
//        public User(int age, String name) {
//            super();
//            this.age = age;
//            this.name = name;
//        }
//        public int getAge() {
//            return age;
//        }
//        public void setAge(int age) {
//            this.age = age;
//        }
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return "User [age=" + age + ", name=" + name + "]";
//        }
    
    
    /**
     * 获取某个类的全部属性
     */
        public static void main(String[] args) throws Exception {
            Class<?> clazz = Class.forName("test.DemoTest");
            System.out.println("===============本类属性===============");
            // 取得本类的全部属性
            Field[] field = clazz.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                // 权限修饰符
                int mo = field[i].getModifiers();
                String priv = Modifier.toString(mo);
                // 属性类型
                Class<?> type = field[i].getType();
                System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
            }
             
            System.out.println("==========实现的接口或者父类的属性==========");
            // 取得实现的接口或者父类的属性
            Field[] filed1 = clazz.getFields();
            for (int j = 0; j < filed1.length; j++) {
                // 权限修饰符
                int mo = filed1[j].getModifiers();
                String priv = Modifier.toString(mo);
                // 属性类型
                Class<?> type = filed1[j].getType();
                System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
            }
        }
    
    /**
     * 获取某个类的全部方法
     */
//    public static void main(String[] args) throws Exception {
//        Class<?> clazz = Class.forName("test.DemoTest");
//        Method method[] = clazz.getMethods();
//        for (int i = 0; i < method.length; ++i) {
//            //返回值
//            Class<?> returnType = method[i].getReturnType();
//            //输入值
//            Class<?> para[] = method[i].getParameterTypes();
//            //权限修饰符
//            int temp = method[i].getModifiers();
//            System.out.print(Modifier.toString(temp) + " ");
//            System.out.print(returnType.getName() + "  ");
//            System.out.print(method[i].getName() + " ");
//            System.out.print("(");
//            for (int j = 0; j < para.length; ++j) {
//                System.out.print(para[j].getName() + " " + "arg" + j);
//                if (j < para.length - 1) {
//                    System.out.print(",");
//                }
//            }
//            //抛出异常信息
//            Class<?> exce[] = method[i].getExceptionTypes();
//            if (exce.length > 0) {
//                System.out.print(") throws ");
//                for (int k = 0; k < exce.length; ++k) {
//                    System.out.print(exce[k].getName() + " ");
//                    if (k < exce.length - 1) {
//                        System.out.print(",");
//                    }
//                }
//            } else {
//                System.out.print(")");
//            }
//            System.out.println();
//        }
//    }
    
    /**
     * 通过反射机制调用某个类的方法
     */
//    public static void main(String[] args) throws Exception {
//        Class<?> clazz = Class.forName("test.DemoTest");
//        // 调用TestReflect类中的reflect1方法
//        Method method = clazz.getMethod("reflect1");
//        // Java 反射机制 - 调用某个类的方法1.
//        method.invoke(clazz.newInstance());
//        // 调用TestReflect的reflect2方法
//        method = clazz.getMethod("reflect2", int.class, String.class);
//        method.invoke(clazz.newInstance(), 20, "张三");
//        // Java 反射机制 - 调用某个类的方法2.
//        // age -> 20. name -> 张三
//    }
//    public void reflect1() {
//        System.out.println("Java 反射机制 - 调用某个类的方法1.");
//    }
//    public void reflect2(int age, String name) {
//        System.out.println("Java 反射机制 - 调用某个类的方法2.");
//        System.out.println("age -> " + age + ". name -> " + name);
//    }
    
    /**
     * 通过反射机制操作某个类的属性
     */
//    private String proprety = null;
//    public static void main(String[] args) throws Exception {
//        Class<?> clazz = Class.forName("test.DemoTest");
//        Object obj = clazz.newInstance();
//        // 可以直接对 private 的属性赋值
//        Field field = clazz.getDeclaredField("proprety");
//        //先检查 AccessibleObject的override属性是否为true。
//        //AccessibleObject是Method,Field,Constructor的父类，override属性默认为false,可调用setAccessible方法改变，如果设置为true,则表示可以忽略访问权限的限制，直接调用。
//        field.setAccessible(true);
//        field.set(obj, "Java反射机制");
//        System.out.println(field.get(obj));
//    }
    
    /**
     * 在泛型为Integer的ArrayList中存放一个String类型的对象。
     */
//    public static void main(String[] args) throws Exception {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        Method method = list.getClass().getMethod("add", Object.class);
//        method.invoke(list, "Java反射机制实例。");
//        System.out.println(list.get(0));
//    }
    
    /**
     * 通过反射取得并修改数组的信息
     */
//    public static void main(String[] args) throws Exception {
//        int[] temp = { 1, 2, 3, 4, 5 };
//        //方法返回类的组件类型的数组
//        Class<?> demo = temp.getClass().getComponentType();
//        System.out.println("数组类型： " + demo.getName());
//        System.out.println("数组长度  " + Array.getLength(temp));
//        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
//        Array.set(temp, 0, 100);
//        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
//    }
    
    /**
     * 通过反射机制修改数组的大小
     */
//    public static void main(String[] args) throws Exception {
//        int[] temp = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//        int[] newTemp = (int[]) arrayInc(temp, 15);
//        print(newTemp);
//        String[] atr = { "a", "b", "c" };
//        String[] str1 = (String[]) arrayInc(atr, 8);
//        print(str1);
//    }
//
//    // 修改数组大小
//    public static Object arrayInc(Object obj, int len) {
//        Class<?> arr = obj.getClass().getComponentType();
//        Object newArr = Array.newInstance(arr, len);
//        int co = Array.getLength(obj);
//        System.arraycopy(obj, 0, newArr, 0, co);
//        return newArr;
//    }
//
//    // 打印
//    public static void print(Object obj) {
//        Class<?> c = obj.getClass();
//        if (!c.isArray()) {
//            return;
//        }
//        System.out.println("数组长度为： " + Array.getLength(obj));
//        for (int i = 0; i < Array.getLength(obj); i++) {
//            System.out.print(Array.get(obj, i) + " ");
//        }
//        System.out.println();
//    }
    

}
