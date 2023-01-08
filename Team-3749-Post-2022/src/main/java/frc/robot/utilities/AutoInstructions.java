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

        
        // forward(4);
        // wait(0.2);
        // left(180);
        // wait(0.2);
        // forward(2);
        // wait(0.2);
        //  right(180);
        // forward(2);
        //  shoot();
        // right(90);
        // backward(1);
        // wait(0.2);
         intake();
        // sloths_are_cool(0.2)
        // forward(5);
        // right(180);



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
        System.out.println("PREDRIIIIVEE");

        controller.addCommand(new AutoDrivetrain(controller.m_drivetrain, feet, 0));
        System.out.println("DRIIIIVEE");

    }
    private void forward(int feet){
        System.out.println("PREDRIIIIVEE");

        controller.addCommand(new AutoDrivetrain(controller.m_drivetrain, (double)feet, 0));
        System.out.println("DRIIIIVEE");

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
