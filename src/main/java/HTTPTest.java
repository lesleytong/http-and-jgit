import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.*;

public class HTTPTest {

    public static final String baseUrl = "http://101.43.149.150:8080";
    public static final String apiUrl = baseUrl + "/gitserver/";

    public static void main(String[] args) throws IOException {
//        signUpTest("alice", "alice", "alice@example.com", "alice1234");

//        signInTest("lesley", "lesley1234");
//        signInTest("lyt", "lyt12345");
        signInTest("alice", "alice1234");

    }


    /**
     * 注册
     */
    public static void signUpTest(final String name, final String username, final String email, final String password){
        //完整url为http://101.43.149.150:8080/gitserver/user/signUp?name=test5&username=test5&email=test5@test.com&password=asdf1234
        String res =gitPost("user/signUp", new HashMap<String, String>() {{
            put("name",name);
            put("username", username);
            put("email", email);
            put("password",password);
        }},200);
        System.out.println("\n\n" + res);
    }

    public static void signInTest(String name, String password) throws IOException {
        //完整url为http://101.43.149.150:8080/gitserver/user/signIn?login=test&password=test1234
        String res1 =gitGet("user/signIn"+"?login="+name+"&password="+password,200);
//        System.out.println("\n\n" + res1);

        JSONObject resultJson = JSONObject.parseObject(res1);
        Result result1 = JSON.toJavaObject(resultJson, Result.class);
        System.out.println("\n\nResult Object: " + result1);
        String token = result1.getData();

        // 创建项目
//        createProjectTest("newp", token);

        // 获取参与的项目列表
//        String res2 = getProjectsTest(token);
//        System.out.println("\n\n" + res2);
//        resultJson = JSONObject.parseObject(res2);
//        Result result2 = JSON.toJavaObject(resultJson, Result.class);
//        System.out.println("\n\nResult Object: " + result2);

        // 为项目添加用户
//        addMemmberTest("26","lyt","30", token);
//
        // 下载全部分支文件
//        MultipartFile allArchive = getAllArchiveTest("28", token);
//        File file = new File("C:\\Users\\10242\\Desktop\\files.zip");
//        allArchive.transferTo(file);
//        System.out.println("\n\ngetAllArchive done");

    }

    /**
     * 下载项目中所有分支文件（zip）.*
     * @param id    项目id
     * @param token 用户个人访问令牌
     * @return {@link MultipartFile}
     */
    public static MultipartFile getAllArchiveTest(String id, String token) {
        MultipartFile file = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl + "project/getAllArchive"+"?id="+id+"&token="+token);
        httpGet.addHeader("PRIVATE-TOKEN", token);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String filename = response.getFirstHeader("Content-Disposition").toString().split("\"")[1];
                HttpEntity httpEntity = response.getEntity();
                file = new MockMultipartFile(filename, httpEntity.getContent());
                System.out.println("\n\n" + "download");
            }
            //关闭服务器响应
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 为项目添加用户
     */
    public static void addMemmberTest(final String projectId, final String username, final String accessLevel, final String token){
        // {{url}}/project/addMember?projectId=2&username=root&accessLevel=20&token={{token}}
        String res =gitPost("project/addMember", new HashMap<String, String>() {{
            put("projectId", projectId);
            put("username", username);
            put("accessLevel", accessLevel);
            put("token", token);
        }},200);
        System.out.println("\n\n" + res);
    }



    /**
     * 获取参与的项目列表
     */
    public static String getProjectsTest(String token){
        // {{url}}/project/getProjects?token={{token}}
        String res = gitGet("project/getProjects"+"?token="+token,200);
        return res;
    }

    /**
     * 创建项目
     */
    public static void createProjectTest(final String projectName, final String token){
        //完整url为http://localhost:8080/gitserver/project/create?name=test4&token={{token}}
        String res =gitPost("project/create", new HashMap<String, String>() {{
            put("name", projectName);
            put("token", token);
        }},200);
        System.out.println("\n\n" + res);

    }

    /**
     * 对gitlab发出GET请求.
     *
     * @param url          请求的api地址
     * @param OkCode       请求成功时的返回码
     * @return 请求成功返回内容，否则返回StatusLine
     */
    public static String gitGet(String url, int OkCode) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl + url);
        return getResponse(httpGet, client, OkCode);
    }

    /**
     * 对gitlab发出POST请求.
     *
     * @param url          请求的api地址
     * @param params       参数列表
     * @param OkCode       请求成功时的返回码
     * @return 请求成功返回内容，否则返回StatusLine
     */
    public static String gitPost(String url, Map<String, String> params, int OkCode) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiUrl + url);
        List<NameValuePair> formList = new ArrayList<>();
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            formList.add(new BasicNameValuePair(key, params.get(key)));
        }
        StringEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(formList, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(entity);

        return getResponse(httpPost, client, OkCode);
    }

    /**
     * 返回请求结果.
     * <p>
     * 特别注意EntityUtils.toString会将CloseableHttpResponse的资源消耗掉
     * 调用一次后会关闭其中的IOStream，后不能再接任何赋值等操作
     * 例如在println语句中调用了该函数后再次对string赋值，解注释后再运行会报错Stream closed
     *
     * @param httpRequest  发出的请求，如httpPost、httpGet
     * @param httpClient   用于发送请求的httpClient客户端
     * @param OkCode       请求成功时的返回码
     * @return 请求成功返回内容，否则返回StatusLine
     */
    public static String getResponse(HttpRequestBase httpRequest, CloseableHttpClient httpClient, int OkCode) {
        CloseableHttpResponse response;
        String res = null;

        try {
            response = httpClient.execute(httpRequest);
            //System.out.println(response.getStatusLine().toString());
            //System.out.println(response.getEntity().getContentType());
            //System.out.println(EntityUtils.toString(response.getEntity()));
            if (response.getStatusLine().getStatusCode() == OkCode) {
                //特别注意EntityUtils.toString会将CloseableHttpResponse的资源消耗掉
                //调用一次后会关闭其中的IOStream，后不能再接任何赋值
                //例如之前的println语句中调用了该函数，解注释后再运行这里会报错Stream closed
                res = EntityUtils.toString(response.getEntity());
            } else {
                res = response.getStatusLine().toString();
            }
            //关闭服务器响应
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


}

