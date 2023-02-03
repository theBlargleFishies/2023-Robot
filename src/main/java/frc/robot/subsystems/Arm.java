package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {

  public static CANSparkMax rightArm = new CANSparkMax(Constants.RIGHT_ARM_MOTOR, MotorType.kBrushless);
  public static CANSparkMax leftArm = new CANSparkMax(Constants.LEFT_ARM_MOTOR, MotorType.kBrushless);

  public Arm() {
    rightArm.setInverted(false);
    leftArm.setInverted(true);
  }

  @Override
  public void periodic() {
  }

  public void armup() {
    leftArm.set(0.5);
    rightArm.set(0.5);
  }

  public void armdown() {
    leftArm.set(-0.2);
    rightArm.set(-0.2);
  }

  public void stoparm() {
    leftArm.stopMotor();
    rightArm.stopMotor();
  }

}
