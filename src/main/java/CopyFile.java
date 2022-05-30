import org.apache.commons.io.FileUtils;

import java.io.*;

public class CopyFile {

    private static int fileCount;
    static String targetPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_file";

    public static void main(String[] args) throws IOException {
        //要遍历的路径
        String sourcePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_valid";
        File targetDir = new File(targetPath);

        File file = new File(sourcePath);

        func(file, targetDir);
    }

    public static void func(File file, File targetDir) throws IOException {
        File[] fs = file.listFiles();

        for(int i=0; i<fs.length; i++){
            if(fs[i].isDirectory()){     //若是目录，则递归
                func(fs[i], targetDir);
            } else if(fs[i].isFile()){   //若是文件，则拷贝到目标文件夹下

                FileUtils.copyFileToDirectory(fs[i], targetDir);

                String name = fs[i].getName();
                File copy = new File(targetPath +"/" + name);
                // 防止同一目录下，相同的文件名被覆盖。
                String newName = name.substring(0, name.length()-6)+ "_" + fileCount + ".ecore";
                copy.renameTo(new File(targetPath + "/" + newName));

                fileCount++;
                System.out.println(fileCount);

            }
        }
    }

}
