
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Balance extends CommandBase {
  private DriveTrain driveTrain;
  private boolean isTeleop;
  private boolean finished;

  public Balance(DriveTrain driveTrain, boolean isTeleop) {
    this.driveTrain = driveTrain;
    this.isTeleop = false;
    this.finished = false;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    driveTrain.balanceRobot();
    this.finished = true;
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.driveStop();
  }

  @Override
  public boolean isFinished() {
    return this.isTeleop && this.finished;
  }
}
