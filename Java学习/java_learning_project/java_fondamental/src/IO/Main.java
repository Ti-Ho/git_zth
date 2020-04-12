package IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        //1. 接收输入
        Scanner s = new Scanner(System.in);
        System.out.println("请输入类的名称：");
        String className = s.nextLine();
        System.out.println("请输入属性的类型：");
        String type = s.nextLine();
        System.out.println("请输入类型的名称：");
        String property = s.nextLine();
        String Uproperty = toUpperFirstLetter(property);

        //2. 读取模板文件
        File modelFile = new File("D:\\java_fondamental\\src\\IO\\Model.txt");
        String modelContent = null;
        try(FileReader fr = new FileReader(modelFile)){
            char cs[] = new char[(int) modelFile.length()];
            fr.read(cs);
            modelContent = new String(cs);
        }catch (Exception e){
            e.printStackTrace();
        }

        //3.替换
        String fileContent = modelContent.replaceAll("@class@", className);
        fileContent = fileContent.replaceAll("@type@", type);
        fileContent = fileContent.replaceAll("@property@", property);
        fileContent = fileContent.replaceAll("@Uproperty@", Uproperty);
        String fileName = className + ".java";

        //4.替换后的内容
        System.out.println("替换后的内容：");
        System.out.println(fileContent);
        File file = new File("D:\\java_fondamental\\src\\IO", fileName);
        try(FileWriter fw = new FileWriter(file)){
            fw.write(fileContent);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("文件保存在:" + file.getAbsolutePath());
    }

    private static String toUpperFirstLetter(String property) {
        char upperCaseFirst = Character.toUpperCase(property.charAt(0));
        String rest = property.substring(1);
        return upperCaseFirst + rest;
    }
}