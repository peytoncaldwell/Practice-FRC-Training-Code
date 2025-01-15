package frc.robot.subsystems;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {

    private final NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

    public LimelightSubsystem() {
        // Limelight setup, if any
    }

    public double getHorizontalOffset() {
        return limelightTable.getEntry("tx").getDouble(0.0); // Horizontal offset (degrees)
    }

    public boolean hasTarget() {
        return limelightTable.getEntry("ta").getDouble(0.0) > 0.0; // If target area is > 0
    }
}