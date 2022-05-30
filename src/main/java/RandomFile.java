import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class RandomFile {
    
    private static int fileCount;

    public static void main(String[] args) throws IOException {
        // ecore
//        String sourcePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_filter";
//        File sourceDir = new File(sourcePath);
//
//        File printFile = new File("E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_ecore.txt");
//
//        String bigPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_big_20";
//        File bigDir = new File(bigPath);
//
//        String middlePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_middle_20";
//        File middleDir = new File(middlePath);
//
//        String smallPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-ecore-all\\data_small_20";
//        File smallDir = new File(smallPath);

        // uml
        String sourcePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_filter";
        File sourceDir = new File(sourcePath);

        File printFile = new File("E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_uml_+7.txt");

        String bigPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_big_1";
        File bigDir = new File(bigPath);

//        String middlePath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_middle_20";
//        File middleDir = new File(middlePath);
//
//        String smallPath = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_small_20";
//        File smallDir = new File(smallPath);

        func(sourceDir, bigDir, printFile);
    }

    public static void func(File sourceDir, File bigDir, File printFile) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(printFile);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);

        File[] fs = sourceDir.listFiles();

//        List<Integer> list1 = getRandomNonRepeatingIntegers(100, 21, 3743);
        List<Integer> list1 = getRandomNonRepeatingIntegers(1, 9312, 11617);
        System.out.println(list1.size()+ ": " + list1);
        System.out.println("------------------------------------------------------------");

////        List<Integer> list2 = getRandomNonRepeatingIntegers(100, 3744, 7466);
//        List<Integer> list2 = getRandomNonRepeatingIntegers(100, 24113, 48204);
//        System.out.println(list2.size()+ ": " + list2);
//        System.out.println("------------------------------------------------------------");
//
////        List<Integer> list3 = getRandomNonRepeatingIntegers(100, 7467, 11190);
//        List<Integer> list3 = getRandomNonRepeatingIntegers(100, 48205, 72297);
//        System.out.println(list3.size()+ ": " + list3);
//        System.out.println("------------------------------------------------------------");

//        // 取中间的20个出来
        List<String> res1 = new ArrayList<>();
//        List<String> res2 = new ArrayList<>();
//        List<String> res3 = new ArrayList<>();

        for(int n : list1){
            res1.add(n+"");
        }


        // 遍历source目录下的文件，如果后缀匹配的话，拷贝到对应arget目录下
        if(bigDir.exists()){
            FileUtils.cleanDirectory(bigDir);
        }
//        if(middleDir.exists()){
//            FileUtils.cleanDirectory(middleDir);
//        }
//        if(smallDir.exists()){
//            FileUtils.cleanDirectory(smallDir);
//        }

        int bigCount = 1;
//        int middleCount = 1;
//        int smallCount = 1;
        for(int i=0; i<fs.length; i++){
            String str = StringUtils.substringBetween(fs[i].getName(), "_", ".");

            if(res1.contains(str)){
                System.out.println("bigCount: " + bigCount  +": " +str);
                bigCount++;
                FileUtils.copyFileToDirectory(fs[i], bigDir);
            }
//            else if(res2.contains(str)){
//                System.out.println("middleCount: " + middleCount + ": " + str);
//                middleCount++;
//                FileUtils.copyFileToDirectory(fs[i], middleDir);
//            }
//            else if(res3.contains(str)){
//                System.out.println("smallCount: " + smallCount + ": " + str);
//                smallCount++;
//                FileUtils.copyFileToDirectory(fs[i], smallDir);
//            }
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("done");

    }

    public static List<Integer> getRandomNonRepeatingIntegers(int size, int min,
                                                                   int max) {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < size) {
            int random = getRandomInt(min, max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        Collections.sort(numbers);
        return numbers;
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

}
