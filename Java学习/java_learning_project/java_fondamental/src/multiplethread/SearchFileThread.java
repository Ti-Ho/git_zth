package multiplethread;

import java.io.File;
import java.io.FileReader;

public class SearchFileThread extends Thread{
    private File f;
    private String search;
    public SearchFileThread(File f, String s){
        this.f = f;
        this.search = s;
    }
    public void run(){
        String fileContent = readFileContent(f);
        if(fileContent.contains(search)){
            System.out.printf("找到子目标字符串%s,在文件：%s%n",search, f);
        }
    }
    public String readFileContent(File f){
        try(FileReader fr = new FileReader(f)){
            char all[] = new char[(int) f.length()];
            fr.read(all);
            return new String(all);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
