package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

    private RobotContainer robotContainer;

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer(); // Initialize the container with subsystems and commands
    }

    @Override
    public void autonomousInit() {
        CommandScheduler.getInstance().schedule(robotContainer.getAutonomousCommand());
    }

    @Override
    public void teleopInit() {
        CommandScheduler.getInstance().cancelAll(); // Cancel all commands when entering teleop
    }

    @Override
    public void teleopPeriodic() {
        robotContainer.teleopPeriodic(); // Call the periodic method for teleop controls
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run(); // Periodically run commands
    }
}