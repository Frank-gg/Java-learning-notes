package DemoReflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ClassLoaderTest {

    /*
    * Properties:用来读取配置文件
    * */
    public void test1() throws IOException {

        Properties pros = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方式1
        FileInputStream fis = new FileInputStream("src\\jdbc.properties");
        pros.load(fis);

        //读取配置文件的方式2：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //getResourceAsStream:动态的获取某个文件的位置
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user" + user + "password" + password);
    }
}
