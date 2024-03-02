package org.yupi.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name = "ASCIIArt", mixinStandardHelpOptions = true, version = "ASCIIArt 1.0")
public class ASCIIArt implements Runnable {

    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
    description = "The word to print as ASCII art.")
    private String[] words = {"Hello,", "picocli"};

    @Override
    public void run() {
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}
