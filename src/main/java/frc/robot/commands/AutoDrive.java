package frc.robot.commands;

import org.opencv.core.Mat;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
  
  private DriveTrain driveTrain;
  private double lsetpoint;
  private double rsetpoint;
  private double speed;
  private double dist;
  
  public AutoDrive(DriveTrain driveTrain, double speed, double d) {
    this.driveTrain = driveTrain;
    this.speed = speed;
    dist = d;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
    lsetpoint = Math.abs(driveTrain.getLeftDistance()) + dist;
    rsetpoint = Math.abs(driveTrain.getRightDistance()) + dist;
  }

  @Override
  public void execute() {
    driveTrain.setDrive(speed);
  }

  @Override
  public void end(boolean interrupted) {} 

  @Override
  public boolean isFinished() {
   if (Math.abs(driveTrain.getLeftDistance()) <= lsetpoint && Math.abs(driveTrain.getRightDistance()) <= rsetpoint){
    return true;
   }
   else{
    return false;
   }
  }

}
