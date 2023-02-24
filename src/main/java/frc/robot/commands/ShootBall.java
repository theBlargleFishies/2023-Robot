package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ShootBall extends CommandBase {
  private Intake intake;

  public ShootBall(Intake intake) {
    this.intake = intake;
    addRequirements(this.intake);
  }

  @Override
  public void initialize() {
    this.intake.shootBall();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    this.intake.stopIntake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
