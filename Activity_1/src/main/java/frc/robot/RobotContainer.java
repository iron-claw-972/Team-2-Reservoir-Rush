/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Constants.DriveConstants;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();

  // The driver's controller 
  //TODO: 1. go to Constants.java to set the right port
  Joystick m_controller = new Joystick(DriveConstants.kControllerPort);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Configure default commands (will be run continously when nothing else is scheduled)
    //TODO: 2. Switch this to a new ArcadeDrive (see ArcadeDrive.java)
    m_robotDrive.setDefaultCommand(
        new TankDrive(
            m_robotDrive,
            () -> m_controller.getRawAxis(DriveConstants.kLeftJoyAxis),
            () -> m_controller.getRawAxis(DriveConstants.kRightJoyAxis)));
  }
}