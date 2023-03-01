
package frc.robot.commands;

import java.util.HashMap;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.PathPlannerTrajectory.PathPlannerState;
import com.pathplanner.lib.auto.BaseAutoBuilder;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Balance extends CommandBase {
  private final int TRAJECTORY_PATH_MAX_VEL = 4;
  private final int TRAJECTORY_PATH_MAX_ACC = 3;
  private final double TRAJECTORY_PATH_SAMPLE_RATE = 1.2;

  private PathPlannerTrajectory trajectoryPath;
  private PathPlannerState trajectoryPathState;
  private DriveTrain driveTrain;
  private BaseAutoBuilder autoBuilder;
  private Command fullAuto;
  private boolean isTeleop;
  private boolean finished;

  public Balance(DriveTrain driveTrain, boolean isTeleop) {
    this.trajectoryPath = PathPlanner.loadPath("balance_only", new PathConstraints(this.TRAJECTORY_PATH_MAX_VEL, this.TRAJECTORY_PATH_MAX_ACC));
    this.trajectoryPathState = (PathPlannerState) this.trajectoryPath.sample(TRAJECTORY_PATH_SAMPLE_RATE);
    //this.fullAuto = autoBuilder.fullAuto(this.trajectoryPath);
    this.driveTrain = driveTrain;
    this.finished = false;

    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    // Balance robot
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
