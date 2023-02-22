package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;

public class ArmIn extends CommandBase {
  Arm arm;
  double distance;

  public ArmIn(Arm a) {
    arm = a;
    addRequirements(arm);

  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
     }

  @Override
  public void end(boolean interrupted) {
    arm.stoparm();
  }

  @Override
  public boolean isFinished() {
   return false;
  }

}