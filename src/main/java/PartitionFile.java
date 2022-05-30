import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class PartitionFile {
    
    private static int bigCount;
    private static int middleCount;
    private static int smallCount;


    public static void main(String[] args) throws IOException {
        // ecore
        String sourcePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_filter";
        File sourceDir = new File(sourcePath);

        String bigPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_big";
        File bigDir = new File(bigPath);

        String middlePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_middle";
        File middleDir = new File(middlePath);

        String smallPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_small";
        File smallDir = new File(smallPath);

//        // uml
//        String sourcePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_file";
//        File sourceDir = new File(sourcePath);
//
//        String bigPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_big";
//        File bigDir = new File(bigPath);
//
//        String middlePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_middle";
//        File middleDir = new File(middlePath);
//
//        String smallPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_small";
//        File smallDir = new File(smallPath);

        func(sourceDir, bigDir, middleDir, smallDir);
    }

    public static void func(File sourceDir, File bigDir, File middleDir, File smallDir) throws IOException {
        File[] fs = sourceDir.listFiles();

        int size = fs.length;
        int interval1 = (int) (size * 0.2);

        int interval2 = (int) (size * 0.4);
        int interval3 = (int) (size * 0.6);

        int interval4 = (int) (size * 0.8);

        Arrays.sort(fs, Comparator.comparingLong(File::length).reversed());

        for(int i=0; i<size; i++){
            if(i < interval1){
                FileUtils.copyFileToDirectory(fs[i], bigDir);
                bigCount++;
                System.out.println("big: " + bigCount);
            } else if(i>interval2 && i<interval3){
                FileUtils.copyFileToDirectory(fs[i], middleDir);
                middleCount++;
                System.out.println("middle: " + middleCount);
            } else if(i>interval4){
                FileUtils.copyFileToDirectory(fs[i], smallDir);
                smallCount++;
                System.out.println("small: " + smallCount);
            }
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("sumCount: " + (bigCount + middleCount + smallCount));
        System.out.println("done");

    }
}
