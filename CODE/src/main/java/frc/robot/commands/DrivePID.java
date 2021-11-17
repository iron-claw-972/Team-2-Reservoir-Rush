package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveConstants;

public class DrivePID extends CommandBase {
    private final DriveSubsystem m_drive;
    int current = 0;
    int goal; 

    public DrivePID(DriveSubsystem subsystem, int goal_) {
        m_drive = subsystem;
        addRequirements(m_drive);
        goal = goal_;
      }
    /*
    private final ExampleSubsystem m_subsystem;
    public ExampleCommand(ExampleSubsystem m_drive) {
      m_subsystem = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
    */
  
    // Called when the command is initially scheduled.
    public void initialize() {
        current = 0; 
    }

    // Called every time the scheduler runs while the command is scheduled.
    public void execute() {
        m_drive.arcadeDrive(0,-0.1);
        current = current + 1;
        System.out.println(current);
    }
    // Called once the command ends or is interrupted.
    public void end(boolean interrupted) {
        current = 0;
    }

    // Returns true when the command should end.
    public boolean isFinished() {
      
        return (current < goal);
    }
  }