package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
  
  private DriveTrain driveTrain;
  private boolean finished = false;
  private double leftDistance;
  private double rightDistance;
  private double speed;
  
  public AutoDrive(DriveTrain driveTrain, double speed) {
    this.driveTrain = driveTrain;
    this.speed = speed;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
    this.driveTrain.encoderReset();
    this.leftDistance = 0;
    this.rightDistance = 0;

    while (this.leftDistance < 207 && this.rightDistance < 207) {
      this.leftDistance = Math.abs(this.driveTrain.getLeftDistance());
      this.rightDistance = Math.abs(this.driveTrain.getRightDistance());
      this.driveTrain.setDrive(this.speed);
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
