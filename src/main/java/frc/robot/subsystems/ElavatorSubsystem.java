package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

    private final PWMSparkMax elevatorMotor = new PWMSparkMax(2); // Motor on port 2

    public ElevatorSubsystem() {
        // Elevator motor initialization
    }

    public void moveElevator(double speed) {
        elevatorMotor.set(speed); // Move the elevator based on speed input
    }
}