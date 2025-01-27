package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RobotDriveCommand extends CommandBase {

    private final DriveSubsystem driveSubsystem;

    public RobotDriveCommand(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        double forward = 0.5;  // Placeholder for joystick forward (should be passed from RobotContainer)
        double rotation = 0.0; // Placeholder for joystick rotation
        driveSubsystem.drive(forward, rotation);
    }

    @Override
    public boolean isFinished() {
        return false; // Keep running until interrupted
    }
}