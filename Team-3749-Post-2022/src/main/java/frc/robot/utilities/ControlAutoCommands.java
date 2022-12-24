package frc.robot.utilities;

import frc.robot.subsystems.*;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlAutoCommands {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private static ArrayList<Command> commands;
    

    public static Command[] getCommands(){
        AutoInstructions.writeInstructions();
        return (Command[])commands.toArray();
    }

    public static void addCommand(Command cmd){
        commands.add(cmd);
    }

}
