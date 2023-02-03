// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  DifferentialDrive dDrive;
  double throttle_d;
  double turn_d;

  private static CANSparkMax leftFront;
  private static CANSparkMax leftBack;
  private static CANSparkMax rightFront;
  private static CANSparkMax rightBack;

  public static RelativeEncoder leftEncoder;
  public static RelativeEncoder rightEncoder;

  public void setmode(boolean mode) {
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

  public DriveTrain() {
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
  }

  @Override
  public void periodic() {}

  public void arcadedrive(XboxController controller) {
    throttle_d = controller.getLeftY();
    turn_d = controller.getRightX();
    dDrive.arcadeDrive(throttle_d, turn_d);
  }

  public void setdrive(double speed) {
    dDrive.tankDrive(speed, speed);
  }

  public void setturn(double leftSpeed, double rightSpeed) {
    dDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void drivestop() {
    dDrive.stopMotor();
  }

  public static double getleftcounts() {
    return leftEncoder.getPosition();
  }

  public static double getrightcounts() {
    return rightEncoder.getPosition();
  }

  public static double getleftdistance() {
    return getleftcounts() / 6.82 * 12;
  }

  public static double getrightdistance() {
    return getrightcounts() / 6.82 * 12;
  }

  public void encoderreset() {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
  }

}
