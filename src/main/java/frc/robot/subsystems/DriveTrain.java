// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
//import edu.wpi.first.math.geometry.Rotation2d;
//import edu.wpi.first.math.geometry.Translation2d;
//import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.SPI;

import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.commands.PPRamseteCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Utilities;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;

public class DriveTrain extends SubsystemBase {
  DifferentialDrive dDrive;
  double throttle_d;
  double turn_d;
  double arm_a;

  double kP = 0.0035;
  double kI = 0.0002;
  double kD = 0;
  private final Field2d field;
  private static CANSparkMax leftFront;
  private static CANSparkMax leftBack;
  private static CANSparkMax rightFront;
  private static CANSparkMax rightBack;

  public static RelativeEncoder leftEncoder;
  public static RelativeEncoder rightEncoder;
  public static AHRS gyro;
  private final PIDController ourPID;
  private DifferentialDriveOdometry odometry;

  public DriveTrain() {
    this.field = new Field2d();
    leftFront = new CANSparkMax(Constants.FRONT_LEFT_MOTOR, MotorType.kBrushless);
    leftBack = new CANSparkMax(Constants.BACK_LEFT_MOTOR, MotorType.kBrushless);
    rightBack = new CANSparkMax(Constants.BACK_RIGHT_MOTOR, MotorType.kBrushless);
    rightFront = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR, MotorType.kBrushless);

    leftFront.setInverted(true);
    rightFront.setInverted(false);
    leftBack.setInverted(true);
    rightBack.setInverted(false);

    leftFront.setSmartCurrentLimit(35);
    rightFront.setSmartCurrentLimit(35);
    leftBack.setSmartCurrentLimit(35);
    rightBack.setSmartCurrentLimit(35);

    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

    leftEncoder = leftFront.getEncoder();
    rightEncoder = rightFront.getEncoder();

    dDrive = new DifferentialDrive(leftFront, rightFront);
    gyro = new AHRS(SPI.Port.kMXP);
    ourPID = new PIDController(kP, kI, kD);
    ourPID.setSetpoint(0.0);

    //odometry = new DifferentialDriveOdometry(gyro.getRotation2d(), leftEncoder.getPosition(),
    //    rightEncoder.getPosition(), this.getPose());
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Angle", gyro.getRoll());
    SmartDashboard.putNumber("Yaw", gyro.getAngle());
    SmartDashboard.putNumber("Forward", RobotContainer.driverController.getLeftY());
    SmartDashboard.putNumber("left", getLeftDistance());
    SmartDashboard.putNumber("right", getRightDistance());
  }

/*  public void resetOdometry(Pose2d pose) {
    this.encoderReset();
    odometry.resetPosition(gyro.getRotation2d(), leftEncoder.getPosition(), rightEncoder.getPosition(), this.getPose());

    SmartDashboard.putBoolean("pose reset", true);
  }

  public Pose2d getPose() {
    return this.field.getRobotPose();
  }

  // Assuming this method is part of a drivetrain subsystem that provides the
  // necessary methods
  public Command followTrajectoryCommand(PathPlannerTrajectory traj, boolean isFirstPath) {
    return new SequentialCommandGroup(
        new InstantCommand(() -> {
          // Reset odometry for the first path you run during auto
          if (isFirstPath) {
            this.resetOdometry(traj.getInitialPose());
          }
        }),
        new PPRamseteCommand(
            traj,
            this::getPose, // Pose supplier
            new RamseteController(Constants.k_ramesete_b, Constants.k_ramesete_zeta), // object does path following
                                                                                      // conputation and converts to
                                                                                      // chassis speed
            new SimpleMotorFeedforward(Constants.ks_volts,
                Constants.kv_volts_seconds_per_meter,
                Constants.ka_volts_seconds_squared_per_meter),
            Constants.k_drive_kinematics, // DifferentialDriveKinematics
            this::getWheelSpeeds, // DifferentialDriveWheelSpeeds supplier
            this.ourPID, // Left controller. Tune these values for your robot. Leaving them 0 will only
            // use feedforwards.
            this.ourPID, // Right controller (usually the same values as left controller)
            this::tankDriveVolts, // Voltage biconsumer
            true, // Should the path be automatically mirrored depending on alliance color.
                  // Optional, defaults to true
            this // Requires this drive subsystem
        ));
  }*/

  public void setMode(boolean mode) {
    if (mode) {
      leftBack.setIdleMode(IdleMode.kBrake);
      leftFront.setIdleMode(IdleMode.kBrake);
      rightBack.setIdleMode(IdleMode.kBrake);
      rightFront.setIdleMode(IdleMode.kBrake);
    } else {
      leftBack.setIdleMode(IdleMode.kCoast);
      leftFront.setIdleMode(IdleMode.kCoast);
      rightBack.setIdleMode(IdleMode.kCoast);
      rightFront.setIdleMode(IdleMode.kCoast);
    }

  }

  public void arcadeDrive(XboxController controller) {
    throttle_d = controller.getLeftY();
    turn_d = controller.getRightX();
    dDrive.arcadeDrive(throttle_d, turn_d);
  }

  public void setDrive(double speed) {
    dDrive.tankDrive(speed, speed);
  }

  public void setTurn(double leftSpeed, double rightSpeed) {
    dDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void driveStop() {
    dDrive.stopMotor();
  }

  public double getLeftDistance() {
    return getLeftCounts() / 6.82 * 12;
  }

  public double getRightDistance() {
    return getRightCounts() / 6.82 * 12; // inches
  }

  public void encoderReset() {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
  }

  private double getLeftCounts() {
    return leftEncoder.getPosition();
  }

  private double getRightCounts() {
    return rightEncoder.getPosition();
  }

  public void balanceRobot() {
    double angle = gyro.getRoll();
    double driveOut = ourPID.calculate(angle);

    if (angle < -1.0) {
      leftFront.set(driveOut);
      rightFront.set(driveOut);
    } else if (angle > 1.0) {
      leftFront.set(driveOut);
      rightFront.set(driveOut);
    } else {
      driveStop();
    }

  }
 /* public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(
        Utilities.velocityToMetersPerSecond(leftEncoder.getVelocity()), // get Left Drive Motor Speed
        Utilities.velocityToMetersPerSecond(rightEncoder.getVelocity())); // get Right Drive Motor Speed
  }*/

 /* public void tankDriveVolts(double leftVolts, double rightVolts) {
    leftFront.setVoltage(leftVolts);
    rightFront.setVoltage(rightVolts);
    this.dDrive.feed();
  }*/

}
