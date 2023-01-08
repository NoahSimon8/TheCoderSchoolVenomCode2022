package frc.robot.utilities;

import java.util.ResourceBundle.Control;

import frc.robot.commands.auton.AutoDrivetrain;
import frc.robot.commands.auton.AutoIntake;
import frc.robot.commands.auton.AutoShootTimer;
import frc.robot.commands.auton.AutoWait;


public class AutoInstructions {

        /**
         * AVAILBLE COMMANDS:
         *   forward(feet);
         *   backward(feet);
         *   right(degrees);
         *   left(degrees);
         *   wait(seconds);
         *   intake();
         *   shoot();
         */

    public void writeInstructions(){
        
        // Example:
        // backward(feet);
        // right(degrees);
        // shoot();



        forward(2); 
        // wait(1);
        // right(90);
        // wait(1);
        shoot();
        // wait(1);
        // intake();
        // wait(1);
        // left(90);
        // backward(1);




    }


    private ControlAutoCommands controller;
    public AutoInstructions(ControlAutoCommands ctrl){
        controller = ctrl;
        
    }

    private void shoot(){
        controller.addCommand(new AutoShootTimer(controller.m_shooter, controller.m_shintake, 50));
    }
    private void intake(){
        controller.addCommand(new AutoIntake(controller.m_intake, controller.m_shintake));
    }
    private void forward(double feet){
        controller.addCommand(new AutoDrivetrain(controller.m_drivetrain, feet, 0));
    }
    private void forward(int feet){
        controller.addCommand(new AutoDrivetrain(controller.m_drivetrain, (double)feet, 0));
    }
    private void backward(double feet){
        controller.addCommand(new AutoDrivetrain(controller.m_drivetrain, -feet, 0));
    }
    private void backward(int feet){
        controller.addCommand(new AutoDrivetrain(controller.m_drivetrain, (double)-feet, 0));
    }
    private void right(int degrees){
        controller.addCommand(new AutoDrivetrain(controller.m_drivetrain, 0, (double)degrees));
    }
    private void left(int degrees){
        controller.addCommand(new AutoDrivetrain(controller.m_drivetrain, 0, (double)-degrees));
    }
    private void wait(double seconds){
        controller.addCommand(new AutoWait(seconds));
    }
    private void wait(int seconds){
        controller.addCommand(new AutoWait((double)seconds));
    }
}
