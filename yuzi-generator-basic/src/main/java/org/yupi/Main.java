package org.yupi;

import org.yupi.cli.CommandExecutor;
import org.yupi.cli.pattern.Command;

public class Main {

    public static void main(String[] args) {

      //  args = new String[]{"generate", "-l", "-a", "-o"};

        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
