package frc.robot.commands;

import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LimelightCommand extends CommandBase {

    private final LimelightSubsystem limelightSubsystem;

    public LimelightCommand(LimelightSubsystem limelightSubsystem) {
        this.limelightSubsystem = limelightSubsystem;
        addRequirements(limelightSubsystem);
    }

    @Override
    public void execute() {
        if (limelightSubsystem.hasTarget()) {
            double offset = limelightSubsystem.getHorizontalOffset();
            // Use this offset to align robot to the target, could drive in a curve to align
        }
    }

    @Override
    public boolean isFinished() {
        return false; // Keep running until interrupted
    }
}