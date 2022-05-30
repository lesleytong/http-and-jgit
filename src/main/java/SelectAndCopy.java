
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


public class SelectAndCopy {
    public static void main(String[] args) {
        // ecore
        String sourceDirPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data\\";
        String targetDirPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_valid\\";
        String validPath = "E:/4-研二下/3-模型合并修改/3-模型收集/modelset/modelset/models/repo-ecore-all/analysis/valid.txt";

//        // uml
//        String sourceDirPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data\\";
//        String targetDirPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_valid\\";
//        String validPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\analysis\\valid.txt";

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(validPath));

            String line = reader.readLine();

            int count = 1;
            while (line != null) {
                int len = line.length();
                line = line.substring(5);
                System.out.println(line);

                File sourceFile = new File(sourceDirPath + line);

                if(sourceFile != null){
                    try{
                        File targetFile = new File(targetDirPath + line);
                        FileUtils.copyFile(sourceFile, targetFile);
                        System.out.println(count);
                    } catch (Exception e){
                    }
                }
                // read next line
                line = reader.readLine();
                count++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
