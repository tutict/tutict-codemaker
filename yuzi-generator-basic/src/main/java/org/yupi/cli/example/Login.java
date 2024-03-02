package org.yupi.cli.example;

import picocli.CommandLine;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {

    @CommandLine.Option(names = {"-u", "--user"}, description = "Username")
    String user;

    @CommandLine.Option(names = {"-p", "--password"}, description = "Password", arity = "0..1", interactive = true, echo = false, prompt = "请输入密码")
    String password;

    @CommandLine.Option(names = {"-cp", "--checkpassword"}, description = "Check Password", arity = "0..1", interactive = true)
    String checkPassword;
    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p", "xxx", "-cp");
    }
}
