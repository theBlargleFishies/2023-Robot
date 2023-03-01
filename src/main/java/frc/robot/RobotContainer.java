package frc.robot;

import frc.robot.Constants.AutoMode;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmIn;
import frc.robot.commands.ArmOut;
import frc.robot.commands.Balance;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.ShootBall;
import frc.robot.commands.StopArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  // private final double DRIVE_SPEED = 0.5;

  public static XboxController driverController;
  public static XboxController armController;
  private final DriveTrain ourTrain;
  private final Arm ourArm;

  private final ArcadeDrive ourDrive;

  private AutoMode autoMode;

  // public final TestGroup auto;
  private final ArmOut up;
  private final ArmIn down;
  private final Intake ourIntake;
  private final IntakeBall ballIn;
  private final ShootBall ballOut;
  private final Balance balance;
  // () private final AutoDrive test;

  Trigger rightBumper;
  Trigger leftBumper;
  Trigger buttonA;
  Trigger buttonB;
  Trigger buttonX;
  Trigger buttonY;
  Trigger driverStartButton;

  public RobotContainer() {
    driverController = new XboxController(Constants.DRIVER_CONTROLLER);
    armController = new XboxController(Constants.ARM_CONTROLLER);

    ourTrain = new DriveTrain();
    ourDrive = new ArcadeDrive(ourTrain);
    ourArm = new Arm();
    ourIntake = new Intake();

    ballOut = new ShootBall(ourIntake);
    balance = new Balance(this.ourTrain);
    // auto = new TestGroup(ourTrain, this.DRIVE_SPEED);

    up = new ArmOut(ourArm);
    down = new ArmIn(ourArm);
    ballIn = new IntakeBall(ourIntake);
    // test = new AutoDrive(ourTrain, -this.DRIVE_SPEED);
    StopArm armStop = new StopArm(ourArm);

    ourTrain.setDefaultCommand(ourDrive);
    // ourArm.setDefaultCommand(armStop);
    // ourIntake.setDefaultCommand(stopIn);

    // ARM CONTROLLER COMMANDS
    rightBumper = new JoystickButton(armController, XboxController.Button.kRightBumper.value);
    leftBumper = new JoystickButton(armController, XboxController.Button.kLeftBumper.value);
    buttonA = new JoystickButton(armController, XboxController.Button.kA.value);
    buttonB = new JoystickButton(armController, XboxController.Button.kB.value);
    buttonX = new JoystickButton(armController, XboxController.Button.kX.value);
    buttonY = new JoystickButton(armController, XboxController.Button.kY.value);

    configureBindings();
    leftBumper.whileTrue(down);
    rightBumper.whileTrue(up);
    buttonA.whileTrue(ballIn);
    buttonX.whileTrue(ballOut);
    // buttonB.whileTrue(stopIn);
    buttonY.onTrue(armStop);
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return balance;
  }

  public AutoMode getAutoMode() {
    return this.autoMode;
  }

  public void setAutoMode(AutoMode newAutoMode) {
    this.autoMode = newAutoMode;
  }

}