package frc.robot.commands.def;

import frc.robot.subsystems.*;
import frc.robot.utilities.POV;
import frc.robot.utilities.Xbox;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Intaking extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private Intake m_intake;

  private Xbox Pilot;

  private POV PiPOV;

  public Intaking(Intake intake,
      Xbox pilot, POV piPOV) {
    m_intake = intake;
    Pilot = pilot;
    PiPOV = piPOV;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    // Pilot right trigger = set intake (setIntake & intakeFwd)
    if (Pilot.getLeftTrigger()) {
      m_intake.setIntake();
      m_intake.intakeFwd();



    // Pilot up dpad  = slow outtake (setIntakeHalfReverse & intakeFwd)
    } else if (PiPOV.up().get()) {
      m_intake.setIntakeHalfReverse();
      m_intake.intakeFwd();

    } else {
      m_intake.intakeRev();
      m_intake.stopIntake();
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}