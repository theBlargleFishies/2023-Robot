package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

public class TestGroup extends SequentialCommandGroup {
  private DriveTrain driveTrain;
  private double speed;

  public TestGroup(DriveTrain driveTrain, double speed) {
    this.driveTrain = driveTrain;
    this.speed = speed;
    addCommands(
      new SetDrive(this.driveTrain, this.speed), 
      new AutoDrive(this.driveTrain, this.speed)
    );
  }

}
