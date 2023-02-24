package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private CANSparkMax intake;

  public Intake() {
    this.intake = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);
  }

  @Override
  public void periodic() { }

  public void intakeBall() {
    this.intake.set(1);
  }

  public void shootBall() {
    this.intake.set(-1);
  }

  public void stopIntake() {
    this.intake.stopMotor();
  }

}