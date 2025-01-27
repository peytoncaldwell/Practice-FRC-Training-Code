package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ElevatorCommand extends CommandBase {

    private final ElevatorSubsystem elevatorSubsystem;
    private final double speed;

    public ElevatorCommand(ElevatorSubsystem elevatorSubsystem, double speed) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.speed = speed;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        elevatorSubsystem.moveElevator(speed);
    }

    @Override
    public boolean isFinished() {
        return false; // Keeps the elevator command running unless interrupted
    }
}