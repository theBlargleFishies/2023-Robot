package frc.robot;

import frc.robot.Constants.AutoMode;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmIn;
import frc.robot.commands.ArmOut;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.Balance;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.ManualArmIn;
import frc.robot.commands.ManualArmOut;
import frc.robot.commands.ShootAndBalance;
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
  private final Balance balance;

  private final ArcadeDrive ourDrive;

  private AutoMode autoMode;

  // public final TestGroup auto;
  private final ManualArmOut up;
  private final ManualArmIn down;
  private final Intake ourIntake;
  private final IntakeBall ballIn;
  private final ShootBall ballOut;
  private Auto auto;
  private ShootAndBalance auto1;
  private AutoDrive auto2;

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
    // auto = new TestGroup(ourTrain, this.DRIVE_SPEED);

    up = new ManualArmOut(ourArm);
    down = new ManualArmIn(ourArm);
    ballIn = new IntakeBall(ourIntake);
    // test = new AutoDrive(ourTrain, -this.DRIVE_SPEED);
    StopArm armStop = new StopArm(ourArm);
    auto1 = new ShootAndBalance(ourTrain, ourArm, ourIntake);
    auto2 = new AutoDrive(ourTrain, 0.4, 37);
    balance = new Balance(ourTrain);

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

    /*switch(autoMode) {
      case BALANCE:
        return auto.Balance(this.ourTrain);
      case SHOOT:
        return auto.Shoot();
      case SHOOT_BALANCE:
        return auto.ShootBalance();
      case MULTI_SHOOT_BALANCE:
        return auto.MultiShootBalance();
      default:S
        return auto.Shoot();
    }*/
    return balance;
  }

}