package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
//import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  public static CANSparkMax rightArm = new CANSparkMax(Constants.RIGHT_ARM_MOTOR, MotorType.kBrushless);
  public static CANSparkMax leftArm = new CANSparkMax(Constants.LEFT_ARM_MOTOR, MotorType.kBrushless);
  boolean arm; 

  //public static RelativeEncoder leftArmEncoder;
  //public static RelativeEncoder rightArmEncoder;

  public Arm() {
    rightArm.setInverted(false);
    leftArm.setInverted(true);
    
    rightArm.setSmartCurrentLimit(15);
    leftArm.setSmartCurrentLimit(15);
  }

  @Override
  public void periodic() {
   // SmartDashboard.putNumber("left arm motor", leftArmEncoder.getPosition());
    //SmartDashboard.putNumber("right arm motor", rightArmEncoder.getPosition());
  }

  public void armout() {
    leftArm.set(0.4);
    rightArm.set(0.4);
  }

  public void armin() {
    
    leftArm.set(-0.3);
    rightArm.set(-0.3);
  }
  
  public void stoparm() {
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
