package org.yupi.maker.generator;

import java.io.File;

public class JarGenerator {

    public static void doGenerator(String projectDir){

        //调用maven打包命令
        String mavenCommand = "mvn clean package -DskipTests=true";

        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));
        Process process = processBuilder.start();

        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码：");

    }

}
