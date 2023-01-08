package frc.robot.utilities;

import frc.robot.subsystems.*;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlAutoCommands {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private ArrayList<Command> commands;


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
        // SmartDashboard.putNumber("Size", commands.size());
        System.out.println(commands.size());
        return (Command[])commands.toArray();
    }

    public void addCommand(Command cmd){
        commands.add(cmd);
    }

}
