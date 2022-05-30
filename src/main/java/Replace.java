import java.io.*;

public class Replace {

    public static void main(String[] args) throws IOException {
        //要遍历的路径
        String path = "E:\\4-研二下\\3-模型合并修改\\3-模型收集\\modelset\\modelset\\models\\repo-genmymodel-uml\\data_filter_and_https_change";
        File file = new File(path);
        String[] result = func(file);
        for(int i=0; i<result.length; i++){
            System.out.println(i+1);
            if(result[i] != null){
                batchSub(result[i]);
            }
        }
    }

    public static void batchSub(String path) throws IOException {
        //原有的内容
        String srcStr = "http://www.omg.org/spec/UML/20131001/PrimitiveTypes";
        //要替换的内容
        String replaceStr = "https://www.omg.org/spec/UML/20131001/PrimitiveTypes";
        // 读
        File file = new File(path);
        FileReader in = new FileReader(file);
        BufferedReader bufIn = new BufferedReader(in);
        // 内存流, 作为临时流
        CharArrayWriter tempStream = new CharArrayWriter();
        // 替换
        String line = null;
        while ( (line = bufIn.readLine()) != null) {
            // 替换每行中, 符合条件的字符串
            line = line.replaceAll(srcStr, replaceStr);
            // 将该行写入内存
            tempStream.write(line);
            // 添加换行符
            tempStream.append(System.getProperty("line.separator"));
        }
        // 关闭 输入流
        bufIn.close();
        // 将内存中的流 写入 文件
        FileWriter out = new FileWriter(file);
        tempStream.writeTo(out);
        out.close();
//        System.out.println("====path:"+path);
    }

    public static String[] func(File file){
        //创建一个存*个字符串的数组
        String[] files = new String[57676];
        File[] fs = file.listFiles();
        int count = 0;

        for(int i=0; i<fs.length; i++){
            if(fs[i].isDirectory()){     //若是目录，则递归打印该目录下的文件
                func(fs[i]);
            } else if(fs[i].isFile()){   //若是文件，直接打印
                //把file类型的数组转化成Sting类型的数组
                files[count] = fs[i].getAbsolutePath();
                count++;
            }
        }

        return files;
    }
}
