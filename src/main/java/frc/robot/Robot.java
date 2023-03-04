package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.AutoMode;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  private final SendableChooser<AutoMode> m_auto_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    this.m_auto_chooser.setDefaultOption("Balance", AutoMode.BALANCE);
    this.m_auto_chooser.addOption("Shoot and Balance", AutoMode.SHOOT_BALANCE);
    this.m_auto_chooser.addOption("Score twice and Balance", AutoMode.MULTI_SHOOT_BALANCE);
    this.m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    //this.m_robotContainer.setAutoMode(m_auto_chooser.getSelected());
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    if (this.m_autonomousCommand != null) {
      this.m_autonomousCommand.cancel();
    }

  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }

}