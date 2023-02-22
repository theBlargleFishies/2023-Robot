package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.DigitalSource;

public class ArmOut extends CommandBase {
  Arm arm;
  double rsetpoint;
  double lsetpoint;
  public ArmOut(Arm a, double rdistance, double ldistance) {
    arm = a;
    addRequirements(arm);
    lsetpoint = ldistance;
    rsetpoint = rdistance;

  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    arm.armout();
   }

  @Override
  public void end(boolean interrupted) {
    arm.stoparm();
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
