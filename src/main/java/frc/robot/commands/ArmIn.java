package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmIn extends CommandBase {
  private Arm arm;

  public ArmIn(Arm arm) {
    this.arm = arm;
    addRequirements(this.arm);

  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    this.arm.stopArm();
  }

  @Override
  public boolean isFinished() {
   return false;
  }

}