package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ShootBall extends CommandBase {
  Intake shoot;

  public ShootBall(Intake s) {
    shoot = s;
    addRequirements(shoot);
  }

  @Override
  public void initialize() {
    shoot.shootball();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}
