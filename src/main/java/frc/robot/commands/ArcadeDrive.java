package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  private final DriveTrain dTrain;
  public ArcadeDrive(DriveTrain drTrain) {
    dTrain = drTrain;
    addRequirements(dTrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    dTrain.arcadedrive(RobotContainer.driverController);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}
