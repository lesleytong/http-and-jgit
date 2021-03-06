import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
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
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.NoMergeBaseException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.transport.*;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;

public class PorcessTest2 {

    public static final String baseUrl = "http://101.43.149.150:8080";
    public static final String apiUrl = baseUrl + "/gitserver/";

    @Test
    void testMerge() throws IOException, GitAPIException {

        String localString = "C:\\Users\\10242\\Desktop\\test";

//        tryMerge(localString);
//        gitMerge(localString);

    }


    @Test
    public void testProcess() throws Exception {

        String projectName = "new_project";
        String localString = "C:\\Users\\10242\\Desktop\\newp";

        // ??????????????????????????????
        // ?????????????????????????????????????????? master ????????????
//        createProject("lyt", "lyt12345", projectName, localString);

        // ?????????????????????????????????????????????
//        getProjects("lyt", "lyt12345");

        String projectId = "71";
        String remoteString = "http://101.43.149.150/lyt/new_project.git";

        // ????????????????????????????????????
//        String latestCommit = getLatestCommit(localString);
//        addVersion(projectId, latestCommit);

//        // ????????? projectId ?????????????????????????????????
//        findAllVersions(projectId);   // 1.0






        // ???????????????????????? master ?????????????????????????????????????????????
//        String message = "add file1 lyt";
//        String branchName = "master";
//        MyGit.commitAndPush(localString, message, branchName);

        // ????????????????????????????????????
//        String latestCommit = getLatestCommit(localString);
//        addVersion(projectId, latestCommit);

        // ???????????????????????????
//        findAllVersions(projectId);   // 1.0 ??? 1.1






        // ??????????????????????????????????????????????????????????????????
//        String branchName = "branch-lyt";
//        createBranch(localString, branchName);

        // ?????????????????????????????????????????????????????????????????????
//        String message = "modify file1 lyt";
//        String branchName = "branch-lyt";
//        MyGit.commitAndPush(localString, message, branchName);

        // ????????????????????????????????????
//        String latestCommit = getLatestCommit(localString);
//        addVersion(projectId, latestCommit);

        // ??????????????????????????????????????????
//        findAllVersions(projectId);   // ?????????1.2








        // ???????????????????????? 1 ???????????????
//        addMemmber("lyt", "lyt12345", "lesley", projectId, "30");

        // ???????????????????????????????????????
//        getProjects("lesley", "lesley1234");

        // ??????????????????????????????????????????????????????????????????
//        branchListRemote("lesley", "lesley1234", remoteString);

        // ????????????shallowClone????????????
        String local_lesley = "C:\\Users\\10242\\Desktop\\newpp";

//        String branchName = "master";   // ????????????????????????
//        MyGit.shallowCloneDepth1(local_lesley, branchName, remoteString);





        // ?????????????????????????????????????????????
        // ?????????????????????????????? MyGit ??????
//        String message = "add file2 lesley";
//        String branchName = "master";
//        MyGit.commitAndPush(local_lesley, message, branchName);

        // ????????????????????????????????????
//        String latestCommit = getLatestCommit(local_lesley);
//        addVersion(projectId, latestCommit);

        // ?????????????????????
//        findLastedVersion(projectId);   // ?????????1.3








        // ???????????????????????? 2 ???????????????
//        addMemmber("lyt", "lyt12345", "alice", projectId, "30");

        // ????????????????????????????????????
//        getProjects("alice", "alice1234");

        // ??????????????????????????????????????????????????????????????????
//        branchListRemote("alice", "alice1234", remoteString);

        // ????????????shallowClone????????????
        String local_alice = "C:\\Users\\10242\\Desktop\\newppp";

//        String branchName = "branch-lyt";   // ????????????????????????
//        MyGit.shallowCloneDepth1(local_alice, branchName, remoteString);

        // ????????????????????????????????????????????????????????????
//        createBranch(local_alice, "branch-alice");

        // ??????????????????????????????
//        String message = "add file3 alice";
//        String branchName = "branch-alice";
//        MyGit.commitAndPush(local_alice, message, branchName);

        // ????????????????????????????????????
//        String latestCommit = getLatestCommit(local_alice);
//        addVersion(projectId, latestCommit);

        // ?????????????????????
//        findAllVersions(projectId);   // ?????????1.4







        // ???????????????????????????????????? master ?????????????????? checkOut
//        checkOut(localString, "master");

        // ??????????????????????????? master ?????????????????????
//        checkUpdate(localString, "lyt", "lyt12345", projectId, "master");

        // ?????????????????????????????? master ??????????????????????????????????????????????????? Non-Fast-Forward ??????
        // ???????????????????????????pull
//        pullRepo("lyt", "lyt12345", localString);














        // ??????????????????pull
        String local_test = "C:\\Users\\10242\\Desktop\\newpppp";
//        String branchName = "branch-alice";   // ????????????????????????
//        MyGit.shallowCloneDepth1(local_test, branchName, remoteString);

        // ??????????????????????????????
//        String message = "add bank lesley";
//        String branchName = "branch-alice";
//        MyGit.commitAndPush(local_test, message, branchName);

        // ?????????????????????????????????????????????
        String local_test2 = "C:\\Users\\10242\\Desktop\\newppppp";
//        String branchName = "branch-alice";   // ????????????????????????
//        MyGit.shallowCloneDepth1(local_test2, branchName, remoteString);

        // ??????????????????????????????
//        String message = "add student alice";
//        String branchName = "branch-alice";
//        MyGit.commitAndPush(local_test2, message, branchName);

//        pullRepo("alice", "alice1234", local_test2);









        // ??????commitSHA?????????????????????
        // PENDING: ?????????????????????commitSHA?????????????????????????????????????????????????????????
        String local_version1 = "C:\\Users\\10242\\Desktop\\version1";
//        String commitSHA = "4ac098307345b7c2209dae77b45a10aad3cfe7eb";
//        MyGit.fetchBySAH1(local_version1, remoteString, commitSHA);





    }




    @Test
    public void testServerAPI2() throws IOException, GitAPIException, URISyntaxException {

        String projectId = "60";

        // ????????????????????????
//        forkProject("alice", "alice1234", projectId, "testfork");

        // ???????????????????????????
//        findByVersion(projectId, "1.0");


        // ??????SHA???????????????
//        String commitSHA = "d60bc12a952012f9f93b0894d3f83f9ab7087302";
//        findVersionBySHA(projectId, commitSHA);

        // ??????????????????????????????
//        findAllVersions(projectId);

        // ??????????????????????????????
//        findLastedVersion(projectId);

        // ??????????????????????????????????????????
//        JSONObject params = new JSONObject();
//        params.put("id", "12");
//        params.put("type", "delete");
//        insertLog("lyt", "lyt12345", projectId, params.toString());

        // ??????????????????
//        findAllLogs("lyt", "lyt12345", projectId);

        // ??????????????????
//        bindLog(projectId, "6", "a99be7a1ba9d4c53ce9910047e69b5428f86d1e3");

        // ??????????????????????????????
//        findLogByVersion(projectId, "2.2");


        // ??????????????????
//        String localString = "C:\\Users\\10242\\Desktop\\xmu";
//        createPublicProject("lesley", "lesley1234", "xmu", "test create public project", localString);

        // ??????????????????
//        getPublicProjects("lesley", "lesley1234");

//        getProjects("lesley", "lesley1234");

        // ???????????????????????????????????????????????????
//        deletePorject("lesley", "lesley1234", "73");


    }


    public void tryMerge(String localString) throws IOException {
        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        Repository repo = git.getRepository();
        RevWalk revWalk = new RevWalk(repo);

        Ref head = repo.exactRef(Constants.HEAD);
        ObjectId headId = head.getObjectId();
        RevCommit headCommit = revWalk.lookupCommit(headId);

        ObjectId objectId = repo.resolve("fix");
        RevCommit srcCommit = revWalk.lookupCommit(objectId);

        RevCommit baseCommit = getBaseCommit(revWalk, headCommit, srcCommit);
        ObjectId baseId = baseCommit.toObjectId();
        System.out.println("baseCommit: " + baseCommit);



    }

    /**
     * ???????????? commit????????????????????? commit
     * @param walk
     * @param a
     * @param b
     * @return base
     * @throws IncorrectObjectTypeException
     * @throws IOException
     */
    protected RevCommit getBaseCommit(RevWalk walk, RevCommit a, RevCommit b)
            throws IncorrectObjectTypeException, IOException {
        walk.reset();
        walk.setRevFilter(RevFilter.MERGE_BASE);
        walk.markStart(a);
        walk.markStart(b);
        final RevCommit base = walk.next();
        if (base == null)
            return null;
        final RevCommit base2 = walk.next();
        if (base2 != null) {
            throw new NoMergeBaseException(
                    NoMergeBaseException.MergeBaseFailureReason.MULTIPLE_MERGE_BASES_NOT_SUPPORTED,
                    MessageFormat.format(
                            JGitText.get().multipleMergeBasesFor, a.name(), b.name(),
                            base.name(), base2.name()));
        }
        return base;
    }

    /**
     * JGit ??? Merge
     * @param localString
     * @throws IOException
     * @throws GitAPIException
     */
    public void gitMerge(String localString) throws IOException, GitAPIException {
        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        Repository repository = git.getRepository();
        ObjectId fix = repository.resolve("fix");

        MergeResult mergeResult = git.merge().include(fix).setFastForward(MergeCommand.FastForwardMode.NO_FF).call();

        System.out.println(mergeResult);

        for (Map.Entry<String,int[][]> entry : mergeResult.getConflicts().entrySet()) {
            System.out.println("Key: " + entry.getKey());
            for(int[] arr : entry.getValue()) {
                System.out.println("value: " + Arrays.toString(arr));
            }
        }

    }


    /**
     * ???????????????commitSHA
     * @param localString
     * @return
     * @throws IOException
     * @throws GitAPIException
     */
    public String getLatestCommit(String localString) throws IOException, GitAPIException {
        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        RevCommit latestCommit = git.log().setMaxCount(1).call().iterator().next();

        return latestCommit.getName();
    }

    /**
     * ????????????
     *
     * @param dir
     */
    public void deleteDirectory(String dir) {
        File file = new File(dir);
        try {
            FileUtils.deleteDirectory(file);
            System.out.println("Directory is deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * ???????????????????????????????????????
     *
     * @param remoteString
     * @throws GitAPIException
     */
    public void branchListRemote(String username, String password, String remoteString) throws GitAPIException {
        Collection<Ref> refs = Git.lsRemoteRepository()
                .setHeads(true)
                .setTags(true)
                .setRemote(remoteString)
                .setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password))
                .call();

        System.out.println("\n************************All remote branches: ");
        for (Ref ref : refs) {
            System.out.println(ref);
        }
    }

    /**
     * ????????????
     *
     * @param localString
     * @param branchName
     * @throws IOException
     * @throws GitAPIException
     */
    public void deleteLocalBranch(String localString, String branchName) throws IOException, GitAPIException {

        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        List<String> call = git.branchDelete().setBranchNames(branchName).setForce(true).call();
        System.out.println(call);

        System.out.println("\n" + call + " is deleted. ");
    }


    /**
     * ?????????????????????????????????????????????????????????????????????????????????
     *
     * @param localString
     * @param branchName
     * @throws IOException
     * @throws GitAPIException
     */
    public void createTrackingBranch(String localString, String branchName) throws IOException, GitAPIException {
        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        Ref ref = git.checkout().
                setCreateBranch(true).
                setName(branchName).
                setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK).
                setStartPoint("origin/" + branchName).
                call();

        System.out.println("Tracking Branch: " + branchName);
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????
     *
     * @param localString
     * @throws IOException
     * @throws GitAPIException
     */
    public void branchList(String localString) throws IOException, GitAPIException {

        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        List<Ref> call = git.branchList().call();
        System.out.println("\n\n***************************All branches:");
        call = git.branchList().setListMode(ListBranchCommand.ListMode.ALL).call();
        for (Ref ref : call) {
            System.out.println("Branch: " + ref + " " + ref.getName() + " " + ref.getObjectId().getName());
        }
    }

    /**
     * ?????????????????????????????????
     *
     * @param projectId
     * @param version
     */
    public void findLogByVersion(String projectId, String version) {
        String res = gitGet("blackboard/findLogByVersion" + "?projectId=" + projectId + "&version=" + version, 200);
        System.out.println("\n\n" + res);
    }


    /**
     * ??????????????????
     *
     * @param projectId
     * @param logId
     * @param commitSHA
     */
    public void bindLog(String projectId, String logId, String commitSHA) {
        String res = gitPost("blackboard/bindLog", new HashMap<String, String>() {{
            put("projectId", projectId);
            put("logId", logId);
            put("commitSHA", commitSHA);
        }}, 200);
        System.out.println(res);
    }


    /**
     * ???????????????????????????
     *
     * @param projectId
     */
    public void findLastedVersion(String projectId) {
        String res = gitGet("blackboard/findLastedVersion" + "?projectId=" + projectId, 200);
        System.out.println("\n\n" + res);
    }


    /**
     * ??????????????????????????????
     *
     * @param projectId
     */
    public void findAllVersions(String projectId) {
        String res = gitGet("blackboard/findAllVersion" + "?projectId=" + projectId, 200);
        System.out.println("\n\n" + res);
    }


    /**
     * ?????? commitSHA ???????????????
     *
     * @param projectId
     * @param commitSHA
     */
    public void findVersionBySHA(String projectId, String commitSHA) {
        String res = gitGet("blackboard/findBySHA" + "?projectId=" + projectId + "&commitSHA=" + commitSHA, 200);
        System.out.println("\n\n" + res);
    }

    /**
     * ???????????????????????????
     *
     * @param projectId
     * @param version
     */
    public void findByVersion(String projectId, String version) {
        String res = gitGet("blackboard/findByVer" + "?projectId=" + projectId + "&version=" + version, 200);
        System.out.println("\n\n" + res);
    }

    /**
     * ????????????????????????
     * @param username
     * @param password
     * @param projectId
     * @throws IOException
     */
    public void deletePorject(String username, String password, String projectId) throws IOException {
        String token = signInTest(username, password);
        String res = gitGet("project/delete" + "?projectId=" + projectId + "&token=" + token, 200);
        System.out.println("\n\n" + res);
    }

    /**
     * ??????????????????
     * @param username
     * @param password
     * @throws IOException
     */
    public void getPublicProjects(String username, String password) throws IOException {
        String token = signInTest(username, password);
        String res = gitGet("project/getAllProject" + "?token=" + token, 200);
        System.out.println("\n\n" + res);
    }

    /**
     * ???????????? fork ??????
     *
     * @param username
     * @param password
     * @param projectId
     * @param name
     * @throws IOException
     */
    public void forkProject(String username, String password, String projectId, String name) throws IOException {
        String token = signInTest(username, password);
        String res = gitPost("project/fork", new HashMap<String, String>() {{
            put("projectId", projectId);
            put("token", token);
            put("name", name);
        }}, 200);

        System.out.println(res);
    }


    /**
     * ?????????????????????
     *
     * @param username
     * @param password
     * @param projectId
     * @param localString
     * @throws IOException
     */
    public void checkUpdate(String localString, String username, String password, String projectId, String branchName) throws IOException {
        String token = signInTest(username, password);

        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());
        Repository repository = git.getRepository();

        ObjectId lastCommitId = repository.resolve(Constants.HEAD);

        RevWalk revWalk = new RevWalk(repository);
        RevCommit commit = revWalk.parseCommit(lastCommitId);
        int time = commit.getCommitTime();
        System.out.println("last CommitTime: " + time);

        String res = gitGet("project/checkUpdate" + "?time=" + time + "&id=" + projectId +"&name"+ branchName + "&token=" + token, 200);
        System.out.println("\n\n" + res);
    }

    public void realTime(String username, String password, String projectId) throws IOException, URISyntaxException {
        String token = signInTest(username, password);
        WebSocketTest c = new WebSocketTest(new URI(
                "ws://101.43.149.150:8080/websocket/" + token + "/" + projectId));
        c.connect();
    }

    /**
     * ???????????????????????? Log
     *
     * @param username
     * @param password
     * @param projectId
     * @param date
     * @throws IOException
     */
    public void findLogByDate(String username, String password, String projectId, String date) throws IOException {
        String token = signInTest(username, password);
        // date?????????????????????%20?????????
        date = date.replaceAll(" ", "%20");
        String res = gitGet("blackboard/find" + "?token=" + token + "&date=" + date + "&projectId=" + projectId, 200);
        System.out.println("\n\n" + res);
    }

    /**
     * ???????????? Log
     *
     * @param username
     * @param password
     * @param projectId
     * @throws IOException
     */
    public void findAllLogs(String username, String password, String projectId) throws IOException {
        String token = signInTest(username, password);
        String res = gitGet("blackboard/findAll" + "?token=" + token + "&projectId=" + projectId, 200);
        System.out.println("\n\n" + res);
    }

    /**
     * ?????? Log ?????????
     *
     * @param username
     * @param password
     * @param projectId
     * @param message
     * @throws IOException
     */
    public void insertLog(String username, String password, String projectId, String message) throws IOException {
        String token = signInTest(username, password);
        String res = gitPost("blackboard/insert", new HashMap<String, String>() {{
            put("token", token);
            put("projectId", projectId);
            put("message", message);
        }}, 200);
        System.out.println("\n\n" + res);

        System.out.println("\n\n" + "insert is done");
    }

    /**
     * pull??????
     *
     * @param username
     * @param password
     * @param localString
     * @throws IOException
     * @throws GitAPIException
     */
    public void pullRepo(String username, String password, String localString) throws IOException, GitAPIException {
        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        PullCommand pullCommand = git.pull();
        pullCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password));
        PullResult result = pullCommand.call();
        FetchResult fetchResult = result.getFetchResult();
        for (TrackingRefUpdate update : fetchResult.getTrackingRefUpdates()) {
            System.out.println("\n\nlocalName: " + update.getLocalName());
            System.out.println("remoteName: " + update.getRemoteName());
            System.out.println("result: " + update.getResult());
        }
        System.out.println("\npull is done");

    }

    /**
     * ????????????
     *
     * @param localString
     * @param toBranchName
     * @throws IOException
     * @throws GitAPIException
     */
    public void cover(String localString, String toBranchName) throws IOException, GitAPIException {
        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        // checkout to specific branch
        System.out.println("before checkout: " + git.getRepository().getFullBranch());
        git.checkout().setName(toBranchName).call();
        System.out.println("after checkout: " + git.getRepository().getFullBranch());

        git.reset().setMode(ResetCommand.ResetType.HARD).setRef("refs/heads/master").call();
        System.out.println("\n\ncover is done");

    }

    /**
     * ???????????????????????????
     *
     * @param username
     * @param password
     * @param projectId
     * @param downloadPath
     * @throws IOException
     */
    public void download(String username, String password, String projectId, String downloadPath) throws IOException {
        String token = signInTest(username, password);
        MultipartFile allArchive = getAllArchive(projectId, token);
        File file = new File(downloadPath);
        allArchive.transferTo(file);
        System.out.println("\n\ndownload");
    }

    public MultipartFile getAllArchive(String projectId, String token) throws IOException {
        MultipartFile file = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl + "project/getAllArchive" + "?id=" + projectId + "&token=" + token);
        httpGet.addHeader("PRIVATE-TOKEN", token);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String filename = response.getFirstHeader("Content-Disposition").toString().split("\"")[1];
                HttpEntity httpEntity = response.getEntity();
                file = new MockMultipartFile(filename, httpEntity.getContent());
            }
            //?????????????????????
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * ????????????????????????
     *
     * @param username
     * @param password
     * @param remoteString
     * @param localString
     * @throws GitAPIException
     * @throws IOException
     */
    public void cloneAll(String username, String password, String remoteString, String localString) throws GitAPIException, IOException {
        Path path = Paths.get(localString);
        CloneCommand cloneCommand = Git.cloneRepository();

        cloneCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password));

        try {
            Git git = cloneCommand.setURI(remoteString)
                    .setDirectory(path.toFile()).call();

            System.out.println("\n\nclone done");
        } catch (InvalidRemoteException e) {
            System.out.println("\n\nerror: ????????????????????????cloneAll");
            FileUtils.deleteDirectory(new File(localString));
        }

    }

    /**
     * ?????????????????????
     *
     * @param username
     * @param password
     * @param newMemberName
     * @param projectId
     * @param accessLevel
     * @throws IOException
     */
    public void addMemmber(String username, String password, final String newMemberName, final String projectId, final String accessLevel) throws IOException {

        final String token = signInTest(username, password);
        // {{url}}/project/addMember?projectId=2&username=root&accessLevel=20&token={{token}}
        String res = gitPost("project/addMember", new HashMap<String, String>() {{
            put("projectId", projectId);
            put("username", newMemberName);
            put("accessLevel", accessLevel);
            put("token", token);
        }}, 200);
        System.out.println("\n\n" + res);
    }

    /**
     * ??????????????????????????????
     *
     * @param username
     * @param password
     * @throws IOException
     */
    public void getProjects(String username, String password) throws IOException {
        String token = signInTest(username, password);
        String res = gitGet("project/getProjects" + "?token=" + token, 200);
        JSONObject resultJson = JSONObject.parseObject(res);
        Result result = JSON.toJavaObject(resultJson, Result.class);
        System.out.println("\n\nResult Object: " + result);
    }

    /**
     * ????????????
     *
     * @param localString
     * @param branchName
     * @throws IOException
     * @throws GitAPIException
     */
    public void checkOut(String localString, String branchName) throws IOException, GitAPIException {
        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        List<Ref> call = git.branchList().call();
        System.out.println("\n\nAll branches:");
        call = git.branchList().setListMode(ListBranchCommand.ListMode.ALL).call();
        for (Ref ref : call) {
            System.out.println("Branch: " + ref + " " + ref.getName() + " " + ref.getObjectId().getName());
        }

        // checkout to specific branch
        System.out.println("\nbefore checkout: " + git.getRepository().getFullBranch());
        git.checkout().setName(branchName).call();
        System.out.println("after checkout: " + git.getRepository().getFullBranch());
    }

    /**
     * ??????????????????
     *
     * @param username
     * @param password
     * @param localString
     * @param message
     * @param branchName
     * @throws IOException
     * @throws GitAPIException
     * @throws URISyntaxException
     */
    public void commitAndPush(String username, String password, String localString, String message, String branchName) throws IOException, GitAPIException, URISyntaxException {

        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        // git add
        git.add().addFilepattern(".").call();

        // git commit
        RevCommit revCommit = git.commit()
                .setMessage(message)
                .call();
        ObjectId commitId = revCommit.getId();
        System.out.println("\n\ncommit done");

        // git push
        Iterable<PushResult> results = git.push()
                .setRefSpecs(new RefSpec(branchName + ":" + branchName))
                .setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password))
                .call();

        PushResult next = results.iterator().next();
        Collection<RemoteRefUpdate> remoteUpdates = next.getRemoteUpdates();

        for (RemoteRefUpdate r : remoteUpdates) {
            System.out.println(r);
        }

    }

    /**
     * ???????????????
     *
     * @param projectId
     * @param commitSHA
     */
    public void addVersion(String projectId, String commitSHA) {
        String res = gitPost("blackboard/addVersion", new HashMap<String, String>() {{
            put("projectId", projectId);
            put("commitSHA", commitSHA);
        }}, 200);
        System.out.println(res);
    }


    /**
     * ??????????????????
     * @param username
     * @param password
     * @param projectName
     * @param description
     * @throws IOException
     */
    public void createPublicProject(String username, String password, String projectName, String description, String localString) throws IOException, GitAPIException, URISyntaxException {
        Path path = Paths.get(localString);
        String token = signInTest(username, password);


        String res = gitPost("project/createPublicProject", new HashMap<String, String>() {{
            put("name", projectName);
            put("token", token);
            put("description", description);
        }}, 200);

        System.out.println(res);

        // initialize local repository
        InitCommand init = Git.init();
        init.setDirectory(path.toFile());
        Git git = init.call();
        Repository repository = git.getRepository();
        System.out.println("\n\ninitialize local repository: " + repository.getDirectory());

        // push README.md to remote master
        // or ref head not found error
        Files.writeString(path.resolve("README.md"), "Hello :)");
        git.add().addFilepattern("README.md").call();
        RevCommit revCommit = git.commit().setMessage("create README.md").call();
        System.out.println("\n\ncommit done");

        // ?????????????????????????????????
        String remoteString = "http://101.43.149.150/" + username + "/" + projectName + ".git";
        RemoteAddCommand remoteAddCommand = git.remoteAdd();
        remoteAddCommand.setName("origin");
        remoteAddCommand.setUri(new URIish(remoteString));
        remoteAddCommand.call();

        //?????? push ??????????????? master ??????
        PushCommand pushCommand = git.push();
        pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password));
        Iterable<PushResult> results = pushCommand.call();

        PushResult next = results.iterator().next();
        Collection<RemoteRefUpdate> remoteUpdates = next.getRemoteUpdates();

        for (RemoteRefUpdate r : remoteUpdates) {
            System.out.println(r);
        }

    }

    /**
     * ?????????????????????????????????????????????
     *
     * @param username
     * @param password
     * @param projectName
     * @param localString
     * @throws IOException
     * @throws GitAPIException
     * @throws URISyntaxException
     */
    public void createProject(String username, String password, String projectName, String localString) throws IOException, GitAPIException, URISyntaxException {

        Path path = Paths.get(localString);
        String token = signInTest(username, password);

        // create remote project
        //??????url???http://localhost:8080/gitserver/project/create?name=test4&token={{token}}
        String res = gitPost("project/create", new HashMap<String, String>() {{
            put("name", projectName);
            put("token", token);
        }}, 200);

        JSONObject resultJson = JSONObject.parseObject(res);
        Result result = JSON.toJavaObject(resultJson, Result.class);
        System.out.println("\n\nResult Object: " + result);

        // initialize local repository
        InitCommand init = Git.init();
        init.setDirectory(path.toFile());
        Git git = init.call();
        Repository repository = git.getRepository();
        System.out.println("\n\ninitialize local repository: " + repository.getDirectory());

        // push README.md to remote master
        // or ref head not found error
        Files.writeString(path.resolve("README.md"), "Hello :)");
        git.add().addFilepattern("README.md").call();
        RevCommit revCommit = git.commit().setMessage("create README.md").call();
        System.out.println("\n\ncommit done");

        // ?????????????????????????????????
        String remoteString = "http://101.43.149.150/" + username + "/" + projectName + ".git";
        RemoteAddCommand remoteAddCommand = git.remoteAdd();
        remoteAddCommand.setName("origin");
        remoteAddCommand.setUri(new URIish(remoteString));
        remoteAddCommand.call();

        //?????? push ??????????????? master ??????
        PushCommand pushCommand = git.push();
        pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password));
        Iterable<PushResult> results = pushCommand.call();

        PushResult next = results.iterator().next();
        Collection<RemoteRefUpdate> remoteUpdates = next.getRemoteUpdates();

        for (RemoteRefUpdate r : remoteUpdates) {
            System.out.println(r);
        }

    }

    /**
     * ?????????????????????????????????
     *
     * @param localString
     * @param branchName
     * @throws GitAPIException
     * @throws IOException
     */
    public void createBranch(String localString, String branchName) throws GitAPIException, IOException {

        Path path = Paths.get(localString);
        Git git = Git.open(path.toFile());

        // ??????????????????
        git.branchCreate().setName(branchName).call();
        System.out.println("\n\n" + branchName + " is created");

        // checkout to a specific branch
        System.out.println("before checkout: " + git.getRepository().getFullBranch());
        git.checkout().setName(branchName).call();
        System.out.println("after checkout: " + git.getRepository().getFullBranch());
    }

    /**
     * ????????????
     *
     * @param username: ??????????????????
     * @param password: ??????
     * @return token
     * @throws IOException
     */
    public String signInTest(String username, String password) throws IOException {
        //??????url???http://101.43.149.150:8080/gitserver/user/signIn?login=test&password=test1234
        String res1 = gitGet("user/signIn" + "?login=" + username + "&password=" + password, 200);

        JSONObject resultJson = JSONObject.parseObject(res1);
        Result result1 = JSON.toJavaObject(resultJson, Result.class);
        System.out.println("\n\nResult Object: " + result1);
        String token = result1.getData();

        return token;
    }

    /**
     * ????????????
     *
     * @param name:     ??????
     * @param username: ???????????????????????????
     * @param email:    ????????????????????????
     * @param password: ???????????????8??????
     */
    public void signUpTest(final String name, final String username, final String email, final String password) {
        //??????url???http://101.43.149.150:8080/gitserver/user/signUp?name=test5&username=test5&email=test5@test.com&password=asdf1234
        String res = gitPost("user/signUp", new HashMap<String, String>() {{
            put("name", name);
            put("username", username);
            put("email", email);
            put("password", password);
        }}, 200);
        System.out.println("\n\n" + res);
    }

    public String gitGet(String url, int OkCode) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl + url);
        return getResponse(httpGet, client, OkCode);
    }

    public String gitPost(String url, Map<String, String> params, int OkCode) {
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

    public String getResponse(HttpRequestBase httpRequest, CloseableHttpClient httpClient, int OkCode) {
        CloseableHttpResponse response;
        String res = null;

        try {
            response = httpClient.execute(httpRequest);
            //System.out.println(response.getStatusLine().toString());
            //System.out.println(response.getEntity().getContentType());
            //System.out.println(EntityUtils.toString(response.getEntity()));
            if (response.getStatusLine().getStatusCode() == OkCode) {
                //????????????EntityUtils.toString??????CloseableHttpResponse??????????????????
                //?????????????????????????????????IOStream??????????????????????????????
                //???????????????println??????????????????????????????????????????????????????????????????Stream closed
                res = EntityUtils.toString(response.getEntity());
            } else {
                res = response.getStatusLine().toString();
            }
            //?????????????????????
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}

