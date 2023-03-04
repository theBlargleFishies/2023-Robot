// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootAndBalance extends SequentialCommandGroup {
  DriveTrain drive;
  Arm arm;
  Intake intake;
  /** Creates a new ShootAndBalance. */
  public ShootAndBalance(DriveTrain dtrain, Arm a, Intake in) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    drive = dtrain;
    arm = a;
    intake = in;
    addCommands(new AutoDrive(dtrain, 0.4, 37), new Balance(dtrain));
    //addCommands(new ArmOut(arm, 0, 0), new WaitCommand(1), new ShootBall(intake), 
    // new WaitCommand(2), new StopIntake(intake), new ArmIn(arm), new AutoDrive(dtrain, 0.4, 37 )  );
  }
}
