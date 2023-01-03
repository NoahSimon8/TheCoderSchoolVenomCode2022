package frc.robot.commands.auton;

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
        m_drivetrain = drivetrain;
        this.distance = distance;
        this.rotation = rotation;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        t.reset();
        t.start();
        m_drivetrain.resetEncoders();
        start_distance = m_drivetrain.getAverageEncoderDistance();

    }

    @Override
    public void execute() {
        if (distance > 0) {
            m_drivetrain.arcadeDrive(0.15, 0);
        } else if (distance < 0) {
            m_drivetrain.arcadeDrive(-0.15, 0);

        } else if (rotation > 0) {
            m_drivetrain.arcadeDrive(0, 0.1);
        } else if (rotation < 0) {
            m_drivetrain.arcadeDrive(0, -0.1);
        }

    }

    @Override
    public void end(boolean interrupted) {
        t.reset();
        m_drivetrain.arcadeDrive(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (distance == 0) {
            //also what should the time multiplier be
            return t.get()>0.02*Math.abs(rotation);

        } 
        else if (distance>0) {
            // I got nooooooo clue what the correct multipliers to get distance should be
            return (m_drivetrain.getAverageEncoderDistance() - start_distance) >= (distance * Constants.Auto.wheelMult);
        }
        else{
            return (m_drivetrain.getAverageEncoderDistance() - start_distance) <= (distance * Constants.Auto.wheelMult);
        }

    }
}
