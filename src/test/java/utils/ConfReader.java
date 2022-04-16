package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfReader {

    public static Properties props= new Properties();
   // public static FileInputStream fileIn;


    static {

        try {
            FileInputStream fileIn = new FileInputStream("config.properties");
            props.load(fileIn);
            //fileIn.close();
        } catch (IOException e) {
            System.out.println("KeyFailed" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getValue(String key){

        return props.getProperty(key) ;
    }

    public static List<String> getValue(String keyUsername, String keyPassword){
        List<String> list= new ArrayList<>();
       list.addAll( Arrays.asList( props.getProperty(keyUsername),
        props.getProperty(keyPassword) ));

       if (list.get(0) == null || list.get(1)== null){
           throw new RuntimeException ("Configuration Key Fail");
       }
       return list;

    }


}
