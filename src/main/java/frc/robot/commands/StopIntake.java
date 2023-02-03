package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class StopIntake extends CommandBase {
  Intake stop;

  public StopIntake(Intake st) {
    stop = st;
    addRequirements(stop);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    stop.stopintake();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}
