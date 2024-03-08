package org.yupi.maker.generator;

import java.io.*;

public class JarGenerator {

    public static void doGenerator(String projectDir) throws IOException, InterruptedException {

        //调用maven打包命令
        String mavenCommand = "mvn clean package -DskipTests=true";

        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));
        Process process = processBuilder.start();

        //读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }


        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码：" + exitCode);
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerator("/home/tutict/work/yuzi-generator/yuzi-generator-basic");
    }

}
