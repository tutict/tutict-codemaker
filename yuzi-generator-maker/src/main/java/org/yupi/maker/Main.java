package org.yupi.maker;

import org.yupi.maker.cli.CommandExecutor;

public class Main {

    public static void main(String[] args) {

      //  args = new String[]{"generate", "-l", "-a", "-o"};

        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
