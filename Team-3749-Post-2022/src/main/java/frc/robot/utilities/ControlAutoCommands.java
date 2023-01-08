package frc.robot.utilities;

import frc.robot.subsystems.*;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlAutoCommands {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private Command[] commands = new Command[200];
    private int cmdIndex = 0;

    public Drivetrain m_drivetrain;
    public Intake m_intake;
    public Shooter m_shooter;
    public Shintake m_shintake;


    public ControlAutoCommands(Drivetrain drive, Intake intake, Shooter shoot, Shintake shintake) {
        m_drivetrain = drive;
        m_intake = intake;
        m_shooter = shoot;
        m_shintake = shintake;
        
    }

    public Command[] getCommands(){
        AutoInstructions instructions = new AutoInstructions(this);
        instructions.writeInstructions();

        Command[] temp = new Command[cmdIndex];
        int count = 0;
        for (Command cmd : commands){
            if (cmd != null){
                System.out.println(count);
                temp[count] = cmd;
                count++;
            }
        }

        for (Command cmd : temp){
            System.out.println(cmd);
        }

        return (temp);
    }

    public void addCommand(Command cmd){
        System.out.println(cmd.getClass().getName());
        commands[cmdIndex] = cmd;
        cmdIndex++;
        
    }

}
