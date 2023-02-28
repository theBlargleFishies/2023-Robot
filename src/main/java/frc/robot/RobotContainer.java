package frc.robot;

import frc.robot.Constants.AutoMode;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmIn;
import frc.robot.commands.ArmOut;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.Balance;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.ShootAndBalance;
import frc.robot.commands.ShootBall;
import frc.robot.commands.StopArm;
import frc.robot.commands.TestGroup;
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

  // public final TestGroup auto;
  private final ArmOut up;
  private final ArmIn down;
  private final Intake ourIntake;
  private final IntakeBall ballIn;
  private final ShootBall ballOut;
  private final Balance balanceCommand;
  // () private final AutoDrive test;
  private AutoMode autoMode;

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

    autoMode = AutoMode.BALANCE;

    ourTrain = new DriveTrain();
    ourDrive = new ArcadeDrive(ourTrain);
    ourArm = new Arm();
    ourIntake = new Intake();

    ballOut = new ShootBall(ourIntake);
    balanceCommand = new Balance(this.ourTrain, true);
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

    // DRIVER CONTROLLER
    driverStartButton = new JoystickButton(driverController, XboxController.Button.kStart.value);
    driverStartButton.onTrue(balanceCommand);
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    switch (autoMode) {
      case BALANCE:
        return new Balance(this.ourTrain, false);
      case SHOOT_BALANCE:
        return new ShootAndBalance(this.ourTrain);
      default:
        return new Balance(this.ourTrain, false);
    }
  }

  public AutoMode getAutoMode() {
    return this.autoMode;
  }

  public void setAutoMode(AutoMode newAutoMode) {
    this.autoMode = newAutoMode;
  }

}