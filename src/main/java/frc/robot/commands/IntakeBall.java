package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeBall extends CommandBase {
  Intake intake;

  public IntakeBall(Intake n) {
    intake = n;
    addRequirements(intake);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    intake.intakeball();
  }

  @Override
  public void end(boolean interrupted) {
    intake.stopintake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
