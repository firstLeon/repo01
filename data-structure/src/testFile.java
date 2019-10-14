import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class testFile {
    public static void main(String[] args) throws IOException {
        String path="D:/test";
        String descParent="D:/test/mp3/";
        String descName="";
        File file=new File(descParent);
        if (!file.exists()){
            file.mkdirs();
        }
        String[] fileNames = changeSuffixName(path);
        for (String s:fileNames){
            File source=new File(path+"/"+s);
            if (descFileName(path,s)!=null){
                descName=descFileName(path,s);
            }
            File desc=new File(descParent+descName);
            if (desc.exists()){
                continue;
            }

            Files.copy(source.toPath(),desc.toPath());
            System.out.println(s);
        }
    }

    public static String[] changeSuffixName(String path){

        File file=new File(path);
        String[] fileNames={};
        if (file.exists()){
            fileNames=file.list();
        }

        return fileNames;
    }

    public static String descFileName(String Parent,String FileName){
        File file=new File(Parent,FileName);
        if (file.isFile()) {
            return FileName.substring(0, FileName.lastIndexOf(".")) + ".mp3";
        }
        return null;
    }
}
