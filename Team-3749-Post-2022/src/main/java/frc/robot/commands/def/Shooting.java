package frc.robot.commands.def;

import frc.robot.subsystems.*;
import frc.robot.utilities.Constants;
import frc.robot.utilities.POV;
import frc.robot.utilities.Xbox;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shooting extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private Shooter m_shooter;

  private Xbox Pilot;
  private Xbox Operator;
  private POV OpPOV;

  public Shooting(Shooter shooter, Xbox pilot, Xbox operator, POV opPOV) {
    m_shooter = shooter;
    Pilot = pilot;
    Operator = operator;
    OpPOV = opPOV;
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    m_shooter.stopMotor();
    m_shooter.stopTurret();
  }

  @Override
  public void execute() {

    double turretControl = Constants.round(Operator.getRightX());

    if (Operator.leftBumper().get()) {
      m_shooter.resetTurret();
    
    } 
    else if (Pilot.rightBumper().get()) {
      m_shooter.setTurretMotor(Constants.Shooter.turretSpeed);

    } 
    else if (Pilot.leftBumper().get()) {
      m_shooter.setTurretMotor(-Constants.Shooter.turretSpeed);

    } 
    else {
      m_shooter.stopTurret();

    }
    
    // Op right trigger = SHOOT upper hub
    if (Pilot.getRightTrigger()) {
      m_shooter.setRPM(450);
    
    
      
    } 
    else {
      m_shooter.stopMotor();
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_shooter.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
