package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmDown extends CommandBase {
  Arm arm;

  public ArmDown(Arm a) {
    arm = a;
    addRequirements(arm);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    arm.armdown();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}