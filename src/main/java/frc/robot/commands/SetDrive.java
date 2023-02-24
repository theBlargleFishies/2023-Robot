package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SetDrive extends CommandBase {
  private DriveTrain driveTrain;
  private Timer timer;
  private boolean finished;
  private double speed;

  public SetDrive(DriveTrain driveTrain, double speed) {
    this.finished = false;
    this.driveTrain = driveTrain;
    this.speed = speed;
    timer = new Timer();
    addRequirements(this.driveTrain);
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      this.driveTrain.setDrive(-this.speed);
    }

    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      this.driveTrain.setDrive(this.speed);
    }

    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      this.driveTrain.setTurn(-this.speed, this.speed);
    }

    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      this.driveTrain.setTurn(this.speed, -this.speed);
    }

    this.finished = true;
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    this.driveTrain.driveStop();
  }

  @Override
  public boolean isFinished() {
    return this.finished;
  }

}
