import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class MyGit {

    public static void main(String[] args) throws IOException, InterruptedException {

//        shallowCloneTest();

//        fetchTest();

    }

    private static void shallowCloneTest() throws IOException, InterruptedException {
        String remoteString = "http://101.43.149.150/lyt/new_project.git";
        String localString = "C:\\Users\\10242\\Desktop\\newppp";
        String branchName = "branch-lyt";
        shallowCloneDepth1(localString, branchName, remoteString);
    }

    private static void fetchTest() throws IOException, InterruptedException {
        String remoteString = "http://101.43.149.150/lyt/new_project.git";
        String localString = "C:\\Users\\10242\\Desktop\\newppp";
        String SHA1 = "4ac098307345b7c2209dae77b45a10aad3cfe7eb";

        fetchBySAH1(localString, remoteString, SHA1);
    }


    public static void shallowCloneDepth1(String localString, String branchName, String remoteString) throws IOException, InterruptedException {
        Path directory = Paths.get(localString);
        runCommand(directory.getParent(), "git", "clone", "--depth", "1", "-b", branchName, remoteString, directory.getFileName().toString());
    }

    public static void commitAndPush(String localString, String message, String branchName) throws IOException, InterruptedException {
        Path directory = Paths.get(localString);
        runCommand(directory, "git", "add", "-A");
        runCommand(directory, "git", "commit", "-m", message);
        runCommand(directory, "git", "push", "origin", branchName);
    }


    public static void fetchBySAH1(String localString, String remoteString, String SHA1) throws IOException, InterruptedException {
        Path directory = Paths.get(localString);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        runCommand(directory, "git", "init");
        runCommand(directory, "git", "remote", "add", "origin", remoteString);
        runCommand(directory, "git", "fetch", "--depth", "1", "origin", SHA1);
        runCommand(directory, "git", "checkout", "FETCH_HEAD");
    }

    public static void runCommand(Path directory, String... command) throws IOException, InterruptedException {
        Objects.requireNonNull(directory, "directory");
        if (!Files.exists(directory)) {
            throw new RuntimeException("can't run command in non-existing directory '" + directory + "'");
        }
        ProcessBuilder pb = new ProcessBuilder()
                .command(command)
                .directory(directory.toFile());
        Process p = pb.start();
        StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "");
        StreamGobbler outputGobbler = new StreamGobbler(p.getInputStream(), "OUTPUT");
        outputGobbler.start();
        errorGobbler.start();
        int exit = p.waitFor();
        errorGobbler.join();
        outputGobbler.join();
        if (exit != 0) {
            throw new AssertionError(String.format("runCommand returned %d", exit));
        }
    }

    private static class StreamGobbler extends Thread {

        private final InputStream is;
        private final String type;

        private StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(type + "> " + line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}
