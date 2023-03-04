package frc.robot;

public class Utilities {
  public static final double ticksToMeters(double position){
    // TODO: Update these values
    return position / Constants.COUNTS_PER_REVOLUTION / Constants.GEAR_RATIO * Constants.WHEEL_CIRCUMFERENCE_METERS;
  }     

  public static final double velocityToMetersPerSecond(double velocity){
    return ticksToMeters(velocity) * 10; //10 100 milisecond units per second
  }
}