package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class PinRelease extends CommandBase {
  Arm arm;

  private boolean finished = false;
  public PinRelease(Arm a) {
    arm = a;
    addRequirements(arm);
  }

  @Override
  public void initialize() {
    finished = true;
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return finished;
  }

}
