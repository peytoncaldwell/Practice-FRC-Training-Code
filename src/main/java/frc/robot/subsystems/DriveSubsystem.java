package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private final PWMSparkMax leftMotor = new PWMSparkMax(0);
    private final PWMSparkMax rightMotor = new PWMSparkMax(1);

    public DriveSubsystem() {
        // Initialization logic (can configure motor safety, invert motors, etc.)
    }

    public void drive(double forward, double rotation) {
        leftMotor.set(forward + rotation);  // Combine forward and rotation for left motor
        rightMotor.set(forward - rotation); // Combine forward and rotation for right motor
    }
}