import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class RenameFile {

    public static void main(String[] args) throws IOException {
//        // ecore
//        String sourcePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_filter";

        // uml
        String sourcePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_filter";

        File file = new File(sourcePath);

        func(file);
    }

    public static void func(File file){
        File[] fs = file.listFiles();

        // 按照文件大小排序
        Arrays.sort(fs, Comparator.comparingLong(File::length).reversed());

        // ecore
//        for(int i=0; i<fs.length; i++){
//            String parent = fs[i].getParent();
//            String name = fs[i].getName();
//
//            String newName = "Ecore_" + (i+1) + ".ecore";
//            File rename = new File(parent + "/" + newName);
//            fs[i].renameTo(rename);
//
//            System.out.println((i+1));
//        }

        // uml
        for(int i=0; i<fs.length; i++){
            String parent = fs[i].getParent();
            String name = fs[i].getName();

            String newName = "UML_" + (i+1) + ".xmi";
            File rename = new File(parent + "/" + newName);
            fs[i].renameTo(rename);

            System.out.println((i+1));
        }


        System.out.println("done");
    }

}
