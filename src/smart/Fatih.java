package smart;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Fatih {
    Properties property;
    public Properties loadProperty(){
        property=new Properties();
        try {

            FileInputStream fios;
             fios=new FileInputStream(System.getProperty("user.dir")
                    +"\\src\\data\\data.properties");
            property.load(fios);
        } catch (IOException e){
            e.printStackTrace();
        }
        return property;
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        Fatih fatih=new Fatih();
        String response=scanner.nextLine();
        Properties property=fatih.loadProperty();
        FileOutputStream fios=new FileOutputStream(System.getProperty("user.dir")
                +"\\src\\data\\data.properties");
        boolean flag=true;
        String tempResponse="hello";
        String tempScanner="hello";
        while (flag){
            if (response.equals("bye")){
                System.out.println("Bye, I will miss you");
                System.exit(0);
            } else {
                property.store(fios, "new ones");
                if (response==null){
                    response=scanner.nextLine();
                    property.setProperty(tempScanner, response);
                    continue;
                }
                property.setProperty(tempResponse, response);
                System.out.println(property.getProperty(response));
                tempResponse = property.getProperty(response);
                response=scanner.nextLine();
                tempScanner=response;
            }
        }
    }
}

