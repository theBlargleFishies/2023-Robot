
package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

// Auto Only Balancing Command
public class ShootAndBalance extends Balance {
  private DriveTrain driveTrain;

  public ShootAndBalance(DriveTrain driveTrain) {
    super(driveTrain, false);
  }

  @Override
  public void execute() {
    // TODO: Add code for shooting
    driveTrain.balanceRobot();
  }
}
