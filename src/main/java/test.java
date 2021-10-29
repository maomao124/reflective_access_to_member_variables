import java.lang.reflect.Field;

/**
 * Project name(项目名称)：反射访问成员变量
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/29
 * Time(创建时间)： 16:51
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        Book2 book = new Book2();
        book.setId(158);
        book.setName("张三");
        book.setPrice(98);
        book.setLoan(false);
        book.setaChar('a');
        book.setAddress("asfghhdhrdhjeje");
        book.setSfg(6.8978);
        System.out.println(book);
        // 获取动态类Book2
        Class<? extends Book2> class1 = book.getClass();
        // 获取Book2类的所有成员
        Field[] declaredFields = class1.getDeclaredFields();
        // 遍历所有的成员
        for (int i = 0; i < declaredFields.length; i++)
        {
            // 获取类中的成员变量
            Field field = declaredFields[i];
            System.out.println("成员名称为：" + field.getName());
            Class fieldType = field.getType();
            System.out.println("成员类型为：" + fieldType);
            boolean isTurn = true;
            while (isTurn)
            {
                try
                {
                    // 如果该成员变量的访问权限为private，则抛出异常
                    isTurn = false;
                    System.out.println("修改前成员的值为：" + field.get(book));
                    // 判断成员类型是否为int
                    if (fieldType.equals(int.class))
                    {
                        System.out.println("利用setInt()方法修改成员的值");
                        field.setInt(book, 118);
                    }
                    else if (fieldType.equals(float.class))
                    {
                        // 判断成员变量类型是否为float
                        System.out.println("利用setFloat()方法修改成员的值");
                        field.setFloat(book, 29.36f);
                    }
                    else if (fieldType.equals(boolean.class))
                    {
                        // 判断成员变量是否为boolean
                        System.out.println("利用setBoolean()方法修改成员的值");
                        field.setBoolean(book, true);
                    }
                    else if (fieldType.equals(char.class))
                    {
                        // 判断成员变量是否为boolean
                        System.out.println("利用setChar()方法修改成员的值");
                        field.setChar(book, 'w');
                    }
                    else if (fieldType.equals(double.class))
                    {
                        // 判断成员变量是否为boolean
                        System.out.println("利用setDouble()方法修改成员的值");
                        field.setDouble(book, 587.69854);
                    }
                    else
                    {
                        System.out.println("利用set()方法修改成员的值");
                        field.set(book, "hello word");
                    }
                    System.out.println("修改后成员的值为：" + field.get(book));
                }
                catch (Exception e)
                {
                    System.out.println("在设置成员变量值时抛出异常，下面执行setAccessible()方法");
                    field.setAccessible(true);
                    isTurn = true;
                }
            }
            System.out.println("=============================\n");
        }
        System.out.println("结果：");
        System.out.println(book);
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
