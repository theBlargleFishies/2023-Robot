package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmOut extends CommandBase {
  private Arm arm;
  private double lsetpoint;
  private double rsetpoint;
  private double ldist;
  private double rdist;
  public ArmOut(Arm arm, double lset, double rset) {
    this.arm = arm;
    ldist = lset;
    rdist = rset;
    addRequirements(arm);
  }

  @Override
  public void initialize() {
    lsetpoint = arm.getleftarmcounts() + ldist;
    rsetpoint = arm.getrightarmcounts() + rdist;
  }

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
    if (arm.getleftarmcounts() >= lsetpoint || arm.getrightarmcounts() >= rsetpoint){
      return true;
    }
    else{
    return false;
    }
  }
}
