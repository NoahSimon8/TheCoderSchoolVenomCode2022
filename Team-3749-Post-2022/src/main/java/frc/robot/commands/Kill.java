// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.*;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** A command to instantly and permanently stop all robot movement in emergancies */
public class Kill extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private final Drivetrain m_drive;
    private final Shooter m_shooter;
    private final Shintake m_shintake;
    private final Intake m_intake;

    private DoubleSupplier y;
    private DoubleSupplier x;

    public Kill(Drivetrain drivetrain, Shooter shooter, Shintake shintake, Intake intake) {
        m_drive = drivetrain;
        m_shintake = shintake;
        m_shooter = shooter;
        m_intake = intake;
        addRequirements(drivetrain,shooter,shintake,intake);
    }

    @Override
    public void initialize() {


        m_drive.kill();
        m_intake.kill();
        m_shooter.kill();
        m_shintake.kill();
    }

    @Override
    public void execute() {
        m_drive.kill();
        m_intake.kill();
        m_shooter.kill();
        m_shintake.kill();
    }

    @Override
    public void end(boolean interrupted) {
        m_drive.kill();
        m_intake.kill();
        m_shooter.kill();
        m_shintake.kill();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
