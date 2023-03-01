
package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

// Auto Only Balancing Command
public class MultiShootAndBalance extends ShootAndBalance {
  public MultiShootAndBalance(DriveTrain driveTrain, Arm arm, Intake intake) {
    super(driveTrain, arm, intake);
    
    addCommands(
      new Balance(this.driveTrain, false)
    );
  }
}
