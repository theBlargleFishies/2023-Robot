package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SetDrive extends CommandBase {
  DriveTrain aTrain;
  Timer timer;

  private boolean finished = false;
  double s;

  public SetDrive(DriveTrain d, double speed) {
    aTrain = d;
    s = speed;
    addRequirements(aTrain);
    timer = new Timer();
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      aTrain.setdrive(-s);
    }

    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      aTrain.setdrive(s);
    }

    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      aTrain.setturn(-s, s);
    }

    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      aTrain.setturn(s, -s);
    }

    finished = true;
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    aTrain.drivestop();
  }

  @Override
  public boolean isFinished() {
    return finished;
  }

}
