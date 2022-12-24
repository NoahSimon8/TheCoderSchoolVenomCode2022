package frc.robot.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import frc.robot.utilities.Constants;

public class AutoWait extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private final Timer t = new Timer();
    private final double duration;

    public AutoWait(double duration) {
        this.duration = duration;

    }

    @Override
    public void initialize() {
        t.reset();
        t.start();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        t.reset();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (t.get() >= duration);
    }
}
