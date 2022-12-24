package frc.robot.utilities;

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

    static void writeInstructions(){

        // DO NOT USE TO MOVE YET, TEST MULTIPLIERS TO GET DISTANCE

        // Example:
        // forward(10);
        // shoot();
        // backward(10)
        
        // Now you try!
        forward(1);
        left(90);
        right(90);
        backward(1);
        intake();
        shoot();
        wait(5);



    }



    private static void shoot(){
        ControlAutoCommands.addCommand(new AutoShootTimer(AutoGroups.m_shooter, AutoGroups.m_shintake, 50));
    }
    private static void intake(){
        ControlAutoCommands.addCommand(new AutoIntake(AutoGroups.m_intake, AutoGroups.m_shintake));
    }
    private static void forward(double feet){
        ControlAutoCommands.addCommand(new AutoDrivetrain(AutoGroups.m_drivetrain, feet, 0));
    }
    private static void forward(int feet){
        ControlAutoCommands.addCommand(new AutoDrivetrain(AutoGroups.m_drivetrain, (double)feet, 0));
    }
    private static void backward(double feet){
        ControlAutoCommands.addCommand(new AutoDrivetrain(AutoGroups.m_drivetrain, -feet, 0));
    }
    private static void backward(int feet){
        ControlAutoCommands.addCommand(new AutoDrivetrain(AutoGroups.m_drivetrain, (double)-feet, 0));
    }
    private static void right(int degrees){
        ControlAutoCommands.addCommand(new AutoDrivetrain(AutoGroups.m_drivetrain, 0, (double)degrees));
    }
    private static void left(int degrees){
        ControlAutoCommands.addCommand(new AutoDrivetrain(AutoGroups.m_drivetrain, 0, (double)-degrees));
    }
    private static void wait(double seconds){
        ControlAutoCommands.addCommand(new AutoWait(seconds));
    }
    private static void wait(int seconds){
        ControlAutoCommands.addCommand(new AutoWait((double)seconds));
    }
}
