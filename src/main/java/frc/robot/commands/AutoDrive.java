package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
  DriveTrain aTrain;

  private boolean finished = false;
  private static double leftdistance;
  private double rightdistance;

  double s;
  public AutoDrive(DriveTrain d, double speed) {
    aTrain = d;
    s = speed;
    addRequirements(aTrain);
  }

  @Override
  public void initialize() {
    aTrain.encoderreset();
    leftdistance = 0;
    rightdistance = 0;

    while (leftdistance < 207 && rightdistance < 207) {
      leftdistance = Math.abs(DriveTrain.getleftdistance());
      rightdistance = Math.abs(DriveTrain.getrightdistance());
      aTrain.setdrive(s);
    }

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
