package frc.robot;

import java.util.HashMap;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.BaseAutoBuilder;
import com.pathplanner.lib.commands.FollowPathWithEvents;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

/** Add your docs here. */
public class Auto {
  private BaseAutoBuilder autoBuilder;

//public Command Shoot(DriveTrain driveTrain) {
    // TODO: INSERT TRAJECTORY
    //PathPlannerTrajectory shootingPath = PathPlanner.loadPath("test", new PathConstraints(4, 3));

// This is just an example event map. It would be better to have a constant, global event map
// in your code that will be used by all path following commands.
// TODO: Insert events with commands
//HashMap<String, Command> eventMap = new HashMap<>();

/*return new FollowPathWithEvents(
    driveTrain.followTrajectoryCommand(shootingPath, true),
    shootingPath.getMarkers(),
    eventMap);
  }*/

   //public Command Balance() {
     // Insert path data here
    // return Balance();
  // }

  // public Command ShootBalance() {
  //   // Insert path data here
  // }

  // public Command MultiShootBalance() {
  //   // Insert path data here
  // }

  private Command getPathFollowingCommand(PathPlannerTrajectory shootingPath) {
    return null;
  }

  private Auto() {}
}
