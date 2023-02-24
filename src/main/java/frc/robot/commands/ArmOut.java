package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmOut extends CommandBase {
  private Arm arm;
  public ArmOut(Arm arm) {
    this.arm = arm;
    addRequirements(arm);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    this.arm.armOut();
   }

  @Override
  public void end(boolean interrupted) {
    this.arm.stopArm();
  }

  @Override
  public boolean isFinished() {
   /* if (arm.getleftarmcounts() >= lsetpoint || arm.getrightarmcounts() >= rsetpoint){
      return true;
    }
    else{
    return false;
    }/* */
    return false;
  }
}
