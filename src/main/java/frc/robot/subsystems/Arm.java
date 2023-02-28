package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private CANSparkMax rightArm;
  private CANSparkMax leftArm;
  private RelativeEncoder leftArmEncoder;
  private RelativeEncoder rightArmEncoder;

  public Arm() {
    this.rightArm = new CANSparkMax(Constants.RIGHT_ARM_MOTOR, MotorType.kBrushless);
    this.leftArm = new CANSparkMax(Constants.LEFT_ARM_MOTOR, MotorType.kBrushless);
    this.rightArm.setInverted(false);
    this.leftArm.setInverted(true); 
    this.rightArm.setSmartCurrentLimit(15);
    this.leftArm.setSmartCurrentLimit(15);
    this.leftArmEncoder = this.leftArm.getEncoder();
    this.rightArmEncoder = this.rightArm.getEncoder();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("left arm motor", leftArmEncoder.getPosition());
    SmartDashboard.putNumber("right arm motor", rightArmEncoder.getPosition());
  }

  public void armOut() {
    leftArm.set(0.4);
    rightArm.set(0.4);
  }

  public void armIn() {
    leftArm.set(-0.3);
    rightArm.set(-0.3);
  }
  
  public void stopArm() {
    leftArm.stopMotor();
    rightArm.stopMotor();
  }
 /* public double getleftarmcounts() {
    
    return leftArmEncoder.getPosition();
    
  }
  public double getrightarmcounts() {
    
    return rightArmEncoder.getPosition();

  }*/
}
