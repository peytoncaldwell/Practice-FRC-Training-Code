package frc.robot;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.commands.RobotDriveCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.LimelightCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

    // Declare subsystems
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
    private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();

    // Declare controller
    private final XboxController driverController = new XboxController(0);
    private final XboxController operatorController = new XboxController(1); // Assuming operator controls elevator

    // Constructor
    public RobotContainer() {
        configureButtonBindings();
    }

    // Configure button bindings
    private void configureButtonBindings() {
        // Drive: Left Stick for forward/reverse, Right Stick for turning
        // Operator Controller: A for elevator up, B for elevator down
        Button aButton = new Button(() -> operatorController.getAButton());
        aButton.whenPressed(new ElevatorCommand(elevatorSubsystem, 1.0)); // Move elevator up when A is pressed

        Button bButton = new Button(() -> operatorController.getBButton());
        bButton.whenPressed(new ElevatorCommand(elevatorSubsystem, -1.0)); // Move elevator down when B is pressed

        // Limelight: Y Button to get target info
        Button yButton = new Button(() -> operatorController.getYButton());
        yButton.whenPressed(new LimelightCommand(limelightSubsystem));

        // Limelight Vision: Use trigger to adjust vision alignment
        Trigger rightTrigger = new Trigger(() -> driverController.getRightTriggerAxis() > 0.5);
        rightTrigger.whenActive(new LimelightCommand(limelightSubsystem));
    }

    // Autonomous command
    public Command getAutonomousCommand() {
        // Return the autonomous drive command for the robot
        return new RobotDriveCommand(driveSubsystem);
    }

    // Teleoperated control logic
    public void teleopPeriodic() {
        // Drive control logic (arcade drive or tank drive)
        double forward = driverController.getLeftY(); // Left joystick vertical axis
        double turn = driverController.getRightX(); // Right joystick horizontal axis
        driveSubsystem.drive(forward, turn);
    }
}