package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public final class Constants {
  public enum AutoMode {
    BALANCE,
    SHOOT_BALANCE,
    MULTI_SHOOT_BALANCE,
    SHOOT
  }
  public static final double k_track_width_meters = 0.6731; //TODO: NEED TO CHANGE THIS VALUE
  public static final DifferentialDriveKinematics k_drive_kinematics = new DifferentialDriveKinematics(k_track_width_meters);
  public static final double ks_volts = 0.71537;
  public static final double kv_volts_seconds_per_meter = 2.4184;
  public static final double ka_volts_seconds_squared_per_meter = 0.38952;
  public static final double k_ramesete_b = 2;
  public static final double k_ramesete_zeta = 0.7;

  public static final int FRONT_RIGHT_MOTOR = 2;
  public static final int FRONT_LEFT_MOTOR = 4;
  public static final int BACK_RIGHT_MOTOR = 3; 
  public static final int BACK_LEFT_MOTOR = 5;
  public static final int RIGHT_ARM_MOTOR = 9;
  public static final int LEFT_ARM_MOTOR = 8;
  public static final int INTAKE_MOTOR = 7;
  public static final int POWER_DISTRIBUTION = 1;
  
  public static final int TOP_SWITCH = 0;
  public static final int BOTTOM_SWITCH = 1;

  public static final int DRIVER_CONTROLLER = 0;
  public static final int ARM_CONTROLLER = 1;

  public static final double WHEEL_DIAMETER = 6.0;
  public static final double WHEEL_CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
  public static final double WHEEL_CIRCUMFERENCE_METERS = WHEEL_CIRCUMFERENCE * 0.0254;
  public static final double GEAR_RATIO = 8.46;
  public static final double COUNTS_PER_REVOLUTION = 42;
}
