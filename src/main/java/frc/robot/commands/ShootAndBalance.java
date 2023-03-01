
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

// Auto Only Balancing Command
public class ShootAndBalance extends SequentialCommandGroup {
  protected DriveTrain driveTrain;
  protected Arm arm;
  protected Intake intake;

  public ShootAndBalance(DriveTrain driveTrain, Arm arm, Intake intake) {
    this.driveTrain = driveTrain;
    this.arm = arm;
    this.intake = intake;

    addCommands(
      new Balance(this.driveTrain, false)
    );
  }
}
