package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

public class TestGroup extends SequentialCommandGroup {
  DriveTrain dTrain;
  double s;

  public TestGroup(DriveTrain dt, double speed) {
    dTrain = dt;
    s = speed;
    addCommands(new SetDrive(dt, speed), new AutoDrive(dt, speed));
  }

}
