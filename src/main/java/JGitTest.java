import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class JGitTest {

    public static void main(String[] args) throws GitAPIException, IOException, URISyntaxException {

        // HTTPTest 创建项目

        Path repoPath = Paths.get("C:\\Users\\10242\\Desktop\\newp");
        String remoteString = "http://101.43.149.150/alice/newp.git";

//        init(repoPath);
//        commit(repoPath, "alice", "alice@example.com");
//        branchList(repoPath);
//        push(repoPath, remoteString, "origin","alice", "alice1234");
//        branchList(repoPath);
        
//        createBranch(repoPath, "branch-alice");
//        branchList(repoPath);
//        checkOutBranch(repoPath, "branch-alice");
//        commit(repoPath, "alice", "alice@example.com");
//        push(repoPath, remoteString, "branch-alice","alice", "alice1234");
//        branchList(repoPath);

        // HTTPTest 为项目添加用户

//        Path localPath = Paths.get("C:\\Users\\10242\\Desktop\\newpp");
//        String clonePath = "http://101.43.149.150/alice/newp.git";

//        cloneRepo(localPath, clonePath, "lyt", "lyt12345");
//        branchList(localPath);
//        createBranch(localPath, "branch-lyt");
//        checkOutBranch(localPath, "branch-lyt");
//        commit(localPath, "lyt", "lyt@example.com");
//        push(localPath, clonePath, "branch-lyt","lyt", "lyt12345");
//        branchList(localPath);

//        createBranch(localPath, "branch-alice");
//        checkOutBranch(localPath, "branch-alice");
//        commit(localPath, "lyt", "lyt@example.com");
//        push(localPath, clonePath, "branch-alice","lyt", "lyt12345");

        // HTTPTest 下载全部分支文件

//        checkOutBranch(localPath, "branch_lyt");
//        commit(localPath, "lyt", "lyt@example.com");
//        push(localPath, clonePath, "branch_alice","lyt", "lyt12345");


        // 当主程序员alice拿到所有分支版本，并且在本地进行n路合并后，更新master
//        checkOutBranch(repoPath, "master");
//        commit(repoPath, "alice", "alice@example.com");
//        push(repoPath, remoteString, "master","alice", "alice1234");

        // master发生变化，其它用户需要pull
//        checkOutBranch(localPath, "master");
//        pullRepo(localPath, "lyt", "lyt12345");

    }

    /**
     * 初始化本地仓库
     * @param repoPath
     * @throws GitAPIException
     */
    public static void init(Path repoPath) throws GitAPIException {
        InitCommand init = Git.init();
        init.setDirectory(repoPath.toFile());
        try(Git git = init.call()){
            Repository repository = git.getRepository();
            System.out.println("\n\ninit repository: " + repository.getDirectory());
        }
    }

    /**
     * 打开本地仓库
     * @param repoPath
     * @return
     * @throws IOException
     */
    public static Git open(Path repoPath) throws IOException {
        try(Git git = Git.open(repoPath.toFile())){
            Repository repository = git.getRepository();
            System.out.println("\n\nopen repository: " + repository.getDirectory());
            return git;
        }
    }

    /**
     * 提交到本地仓库
     * @param repoPath
     * @param author
     * @param email
     * @throws IOException
     * @throws GitAPIException
     */
    public static void commit(Path repoPath, String author, String email) throws IOException, GitAPIException {
        Git git = open(repoPath);
        Files.writeString(repoPath.resolve("file4.txt"), "Hello World 4");
        git.add().addFilepattern("file4.txt").call();
        git.commit().setMessage("create file4.txt").setAuthor(author, email)
                .call();
        System.out.println("\n\ncommit done");

//        git.add().addFilepattern(".").call();
//        git.commit().setMessage("master #1.0").setAuthor(author, email)
//                .call();
//        System.out.println("\n\ncommit done");

    }

    public static void push(Path repoPath, String remoteString, String remoteBranch, String username, String password) throws IOException, URISyntaxException, GitAPIException {
        Git git = open(repoPath);
        RemoteAddCommand remoteAddCommand = git.remoteAdd();
        remoteAddCommand.setName(remoteBranch); // the name of remote branch
        remoteAddCommand.setUri(new URIish(remoteString));
        remoteAddCommand.call();

        PushCommand pushCommand = git.push();
        pushCommand.setRemote(remoteBranch);    // the name of remote branch
        pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password));
        Iterable<PushResult> results = pushCommand.call();
        PushResult next = results.iterator().next();
        Collection<RemoteRefUpdate> remoteUpdates = next.getRemoteUpdates();
        if(remoteUpdates.isEmpty()){
            System.out.println("\n\npush done");
        } else{
            for(RemoteRefUpdate r : remoteUpdates){
                System.out.println(r);
            }
        }
    }

    public static void createBranch(Path repoPath, String newBranch) throws IOException, GitAPIException {
        Git git = open(repoPath);
        git.branchCreate().setName(newBranch).call();
        System.out.println("\n\nbranch created");
    }

    public static void checkOutBranch(Path repoPath, String branchName) throws IOException, GitAPIException {
        Git git = open(repoPath);
        System.out.println("before checkout: " + git.getRepository().getFullBranch());
        git.checkout().setName(branchName).call();
        System.out.println("after checkout: " + git.getRepository().getFullBranch());

    }

    public static void deleteBranch(Path repoPath,String branchName) throws IOException, GitAPIException {
        Git git = open(repoPath);
        git.checkout().setName("master").call();
        git.branchDelete().setBranchNames(branchName).setForce(true).call();
        System.out.println("\n\nbranch deleted");
    }

    public static void branchList(Path repoPath) throws IOException, GitAPIException {
        Git git = open(repoPath);
        List<Ref> branches = git.branchList().setListMode(ListBranchCommand.ListMode.ALL).call();
        for (Ref branch : branches) {
            System.out.println("branchName: " + branch.getName());
        }
    }

    public static void cloneRepo(Path localPath, String clonePath, String username, String password) throws GitAPIException {

        CloneCommand cloneCommand = Git.cloneRepository();
        cloneCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password));
        Git git = cloneCommand.setURI(clonePath)
                .setDirectory(localPath.toFile()).call();
        System.out.println("\n\nclone done");
    }

    public static void pullRepo(Path localPath, String username, String password) throws IOException, GitAPIException {
        Git git = open(localPath);
        PullCommand pullCommand = git.pull();
        pullCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password));
        PullResult result = pullCommand.call();
        FetchResult fetchResult = result.getFetchResult();
        for (TrackingRefUpdate update : fetchResult.getTrackingRefUpdates()) {
            System.out.println("\n\nlocalName: " + update.getLocalName());
            System.out.println("remoteName: " + update.getRemoteName());
            System.out.println("result: " + update.getResult());
        }

    }


}
