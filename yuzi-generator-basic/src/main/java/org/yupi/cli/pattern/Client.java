package org.yupi.cli.pattern;

public class Client {

    public static void main(String[] args) {

        Device tv = new Device("TV");
        Device stero = new Device("stero");

        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(stero);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOn);
        remote.pressButton();

        remote.setCommand(turnOff);
        remote.pressButton();


    }
}
