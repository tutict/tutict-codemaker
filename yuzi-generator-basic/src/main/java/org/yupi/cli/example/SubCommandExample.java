package org.yupi.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable{

    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @Command(name = "sub", description = "增加", mixinStandardHelpOptions = true)
    static class SubCommand implements Runnable{
        public void run() {
            System.out.println("执行增加命令");
        }
    }

    @Command(name = "delete", description = "删除", mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable{
        public void run() {
            System.out.println("执行删除命令");
        }
    }

    @Command(name = "query", description = "查询", mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable{
        public void run() { System.out.println("执行查询命令"); }
    }

    public static void main(String[] args) {

        String[] myArgs = new String[]{"sub"};

        int exitCode = new CommandLine(new SubCommandExample())
                .addSubcommand(new SubCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(myArgs);
        System.exit(exitCode);
    }
}
