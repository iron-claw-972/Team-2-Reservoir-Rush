/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Constants.*;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.*;

import frc.robot.commands.UpdateDefault;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final ArcadeDrive m_autoCommand = new ArcadeDrive(m_robotDrive);

  // The driver's controller 
  //TODO: 1. go to Constants.java to set the right port
  static Joystick controller = new Joystick(DriveConstants.kControllerPort);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands (will be run continously when nothing else is scheduled)
    //TODO: 2. Switch this to a new ArcadeDrive, you need to update the method in DriveSubsystem.java
    
    m_robotDrive.setDefaultCommand(
      new RunCommand(() -> new TankDrive(m_robotDrive),
      m_robotDrive
    ));
  }

    /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Do Tank Drive when the 'A' button is pressed.
    //TODO: 2. Add more commands! Each person in your group 
    // should add 1 state, and it buttons should activate the states
    // see this and UpdateDefault.java as an example
    new JoystickButton(controller, ButtonConstants.kA)
    .whenPressed(new UpdateDefault(m_robotDrive, () -> new TankDrive(m_robotDrive)));
  }

  public static double getMotorSpeed(int port) {
    // the vertical axis of the left joystick of the XboxController
    return controller.getRawAxis(port);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //for now, autonomous is Arcade drive
    return m_autoCommand;
  }
}