package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveConstants;

public class TurnPID extends CommandBase {
    private final DriveSubsystem m_drive;
    int current = 0;
    int goal; 

    public TurnPID(DriveSubsystem subsystem, int goal_) {
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
      double maxOutput = 0.2;
      double maxError = 2;
      double error = goal - m_drive.getPosition();
      double p_gain = 0.1;
      double finalVal = error * p_gain;
      if (finalVal > maxOutput){
        finalVal = maxOutput;
      }if (finalVal < -maxOutput) {
        finalVal = -maxOutput;
      }if (maxError > error && error > maxError) {
        finalVal = 0;
      }
      m_drive.tankDrive(finalVal,finalVal);
    }
    
    // Called once the command ends or is interrupted.
    public void end(boolean interrupted) {
        current = 0;
    }

    // Returns true when the command should end.
    public boolean isFinished() {
        // return false;
        return (current > goal);
    }
  }