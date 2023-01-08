package frc.robot.commands.auton;

import javax.sound.sampled.SourceDataLine;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import frc.robot.utilities.Constants;

public class AutoDrivetrain extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private final Drivetrain m_drivetrain;
    private final double distance;
    private final double rotation;
    private double start_distance;
    private final Timer t = new Timer();


    public AutoDrivetrain(Drivetrain drivetrain, double distance, double rotation) {
        System.out.println("constructor");

        m_drivetrain = drivetrain;
        System.out.println("dtrain");

        this.distance = distance;
        this.rotation = rotation;
        System.out.println("dist y rotation");

        addRequirements(drivetrain);
        System.out.println("req");

    }

    @Override
    public void initialize() {
        System.out.println("Initial");
        t.reset();
        System.out.println("t reset");

        t.start();
        System.out.println("t start");

        m_drivetrain.resetEncoders();
        System.out.println("reset encoder");

        start_distance = m_drivetrain.getAverageEncoderDistance();
        System.out.println("start dist");

    }

    @Override
    public void execute() {

        if (distance > 0) {
            m_drivetrain.arcadeDrive(-0.43, 0);
        } else if (distance < 0) {

            m_drivetrain.arcadeDrive(0.43, 0);

        } else if (rotation > 0) {

            m_drivetrain.arcadeDrive(0, 0.8);
        } else if (rotation < 0) {

            m_drivetrain.arcadeDrive(0, -0.8);
        }

    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("END");

        t.reset();
        m_drivetrain.arcadeDrive(0, 0);
        System.out.println("END-END");

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (distance == 0) {
            //also what should the time multiplier be

            return t.get()>0.0078*Math.abs(rotation);

        } 
        else{
            return t.get()>Math.abs(distance);
         }


    }
}
