package frc.robot;

public final class Constants {
  public static final int FRONT_RIGHT_MOTOR = 2;
  public static final int FRONT_LEFT_MOTOR = 4;
  public static final int BACK_RIGHT_MOTOR = 3;
  public static final int BACK_LEFT_MOTOR = 5;
  public static final int RIGHT_ARM_MOTOR = 9;
  public static final int LEFT_ARM_MOTOR = 8;
  public static final int INTAKE_MOTOR = 7;
  public static final int POWER_DISTRIBUTION = 10;
  
  public static final int TOP_SWITCH = 0;
  public static final int BOTTOM_SWITCH = 1;

  public static final int DRIVER_CONTROLLER = 0;
  public static final int ARM_CONTROLLER = 2;
  public static final int PNEUMATICS_MODULE = 1;

  public static final double WHEEL_DIAMETER = 6.0;
  public static final double WHEEL_CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
  public static final double GEAR_RATIO = 1 / 10.71;
  public static final double COUNTS_PER_REVOLUTION = 42;
}