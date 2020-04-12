package IO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileContent {
    /**
     * @param file 查找的目录
     * @param search 查找的字符串
     */
    public static void search(File file, String search){
        if(file.isFile()){
            if(file.getName().toLowerCase().endsWith(".txt")){
                String fileContent = readFileContent(file);
                if(fileContent.contains(search)){
                    System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
                }
            }
        }
        if(file.isDirectory()){
            File fs[] = file.listFiles();
            for(File f : fs){
                search(f, search);
            }
        }
    }

    public static String readFileContent(File file){
        try(FileReader fr = new FileReader(file)){
            char all[] = new char[(int)file.length()];
            fr.read(all);
            return new String(all);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]){
        File folder = new File("d:/JAVAIOTest");
        search(folder, "test");
    }
}
