package frc.robot;

import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmUp;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.ShootBall;
import frc.robot.commands.StopArm;
import frc.robot.commands.StopIntake;
import frc.robot.commands.TestGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  public static XboxController driverController;
  private final DriveTrain ourTrain;
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Arm ourArm;
  private final ArcadeDrive ourDrive;

  public final TestGroup auto;
  private final ArmUp up;
  private final ArmDown down;
  private final Intake ourIntake;
  private final IntakeBall ballIn;
  private final ShootBall ballOut;
  private final StopIntake stopIn;
  private final AutoDrive test;

  Trigger rightBumper;
  Trigger leftBumper;
  Trigger buttonA;
  Trigger buttonB;
  Trigger buttonX;
  Trigger buttonY;

  public RobotContainer() {
    driverController = new XboxController(Constants.DRIVER_CONTROLLER);

    ourTrain = new DriveTrain();
    ourDrive = new ArcadeDrive(ourTrain);
    ourArm = new Arm();
    ourIntake = new Intake();

    ballOut = new ShootBall(ourIntake);
    auto = new TestGroup(ourTrain, 0.5);

    up = new ArmUp(ourArm);
    down = new ArmDown(ourArm);
    ballIn = new IntakeBall(ourIntake);
    stopIn = new StopIntake(ourIntake);
    test = new AutoDrive(ourTrain, -0.5);
    StopArm armStop = new StopArm(ourArm);

    ourTrain.setDefaultCommand(ourDrive);
    rightBumper = new JoystickButton(driverController, XboxController.Button.kRightBumper.value);
    leftBumper = new JoystickButton(driverController, XboxController.Button.kLeftBumper.value);
    buttonA = new JoystickButton(driverController, XboxController.Button.kA.value);
    buttonB = new JoystickButton(driverController, XboxController.Button.kB.value);
    buttonX = new JoystickButton(driverController, XboxController.Button.kX.value);
    buttonY = new JoystickButton(driverController, XboxController.Button.kY.value);

    configureBindings();
    leftBumper.onTrue(down);
    rightBumper.onTrue(up);
    buttonA.toggleOnTrue(ballIn);
    buttonX.onTrue(ballOut);
    buttonB.onTrue(stopIn);
    buttonY.onTrue(armStop);
  }

  private void configureBindings() {
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
  }

  public Command getAutonomousCommand() {
    return test;
  }

}