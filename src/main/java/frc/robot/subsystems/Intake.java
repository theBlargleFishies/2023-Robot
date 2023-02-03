package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private static CANSparkMax Intake = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);
  public Intake() {}

  @Override
  public void periodic() {}

  public void intakeball() {
    Intake.set(1);
  }

  public void shootball() {
    Intake.set(-1);
  }

  public void stopintake() {
    Intake.stopMotor();
  }

}