package frc.robot.commands.def;

import frc.robot.subsystems.*;
import frc.robot.utilities.Constants;
import frc.robot.utilities.POV;
import frc.robot.utilities.Xbox;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shintaking extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private Shintake m_shintake;
  private Shooter m_shooter;

  private Xbox Pilot;
  private Xbox Operator;
  private POV OpPOV;

  public Shintaking(Shintake shintake, Shooter shooter,
      Xbox pilot, Xbox operator, POV opPOV) {
    Pilot = pilot;
    m_shooter = shooter;
    m_shintake = shintake;
    Operator = operator;
    OpPOV = opPOV;
    addRequirements(shintake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
// Is this needed?

    // // Operator A = shintake PID
    // if (Operator.a().get()) {
    //   m_shintake.setShintakePID();

    //   // Pilot right trigger = set shintake (upper hub)
    // } 


    // This right? Pilot a = upper hub
    if (Pilot.a().get()) {
      if (m_shooter.getRPM() < Constants.Shooter.upperRPM) {
        m_shintake.setShintakeFix();
      } else {
        m_shintake.stopShintake();
      }
    } 


      // Operator right POV = reverse shintake
    else if (OpPOV.right().get()) {
      m_shintake.setShintakeReverse();

    } 


      // Operator left POV = slow outtake (setShintake)
    else if (Pilot.rightBumper().get()) {
      m_shintake.setShintake();

    } else {
      m_shintake.stopShintake();

    }
  }

  @Override
  public void end(boolean interrupted) {
    m_shooter.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}