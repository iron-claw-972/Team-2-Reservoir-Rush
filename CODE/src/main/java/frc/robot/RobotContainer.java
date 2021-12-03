/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Constants.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.*;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final DoorSubsystem m_door = new DoorSubsystem();

  //autonomous command, will spin robot in circle
  private final Command m_autoCommand =   new SequentialCommandGroup(    
    //start intake
    new DrivePID(m_robotDrive, 18 * DriveConstants.feetRatio),
    new TurnPID(m_robotDrive,  1 * DriveConstants.turn90Ratio),
    new DrivePID(m_robotDrive, 6 * DriveConstants.feetRatio),
    new TurnPID(m_robotDrive,  1 * DriveConstants.turn90Ratio),
    new DrivePID(m_robotDrive, 7 * DriveConstants.feetRatio),
    new TurnPID(m_robotDrive,  -1 * DriveConstants.turn90Ratio),
    new DrivePID(m_robotDrive, -3 * DriveConstants.feetRatio)
    //dump


    //code for seting veriables
    // new DrivePID(m_robotDrive, 1 * DriveConstants.feetRatio),
    // new TurnPID(m_robotDrive,  1 * DriveConstants.turn90Value)
  );

  /*
  private final Command m_autoCommand = new SequentialCommandGroup(
    new InstantCommand(() -> m_robotDrive.tankDrive(0.2, -0.2),
    m_robotDrive),
    new WaitCommand(3),
    new InstantCommand(() -> m_robotDrive.tankDrive(-0.2, -0.2),
    m_robotDrive),
    new WaitCommand(0.5),
    new InstantCommand(() -> m_robotDrive.tankDrive(0.2, -0.2),
    m_robotDrive),
    new WaitCommand(3),
    new InstantCommand(() -> m_robotDrive.tankDrive(-0.2, -0.2),
    m_robotDrive),
    new WaitCommand(0.5),
    new InstantCommand(() -> m_robotDrive.tankDrive(0.2, -0.2),
    m_robotDrive),
    new WaitCommand(3),
    new InstantCommand(() -> m_robotDrive.tankDrive(0.2, -0.2),
    m_robotDrive),
    //new InstantCommand(() -> m_robotDrive.tankDrive(0.2, 0),m_robotDrive),
    new WaitCommand(0.5),
    new InstantCommand(() -> m_robotDrive.tankDrive(0.2, -0.2),
    m_robotDrive),
    new WaitCommand(3),
    new InstantCommand(() -> m_robotDrive.tankDrive(0.2, -0.2),
    m_robotDrive),
    new WaitCommand(0.5)
    
    );
    */

  // The driver's controller
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
      new ArcadeDrive(m_robotDrive)
    );
  }

    /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(controller, 1).whenPressed(new InstantCommand(() -> m_intake.intakeSpin()));

    new JoystickButton(controller, 2).whenPressed(new InstantCommand(() -> m_intake.intakeStop()));

    new JoystickButton(controller, 4).whenPressed(new InstantCommand(() -> m_intake.intakeFast()));

    new JoystickButton(controller, 3).whenPressed(new InstantCommand(() -> m_intake.intakeReverse()));

    JoystickButton leftBump = new JoystickButton(controller, ButtonConstants.kBL);
    leftBump.whenHeld(new RunCommand(() -> m_door.doorSpin()));
    leftBump.whenReleased(new RunCommand(() -> m_door.doorStop()));

    JoystickButton rightBump = new JoystickButton(controller, ButtonConstants.kBR);
    rightBump.whenHeld(new RunCommand(() -> m_door.doorReverse()));
    rightBump.whenReleased(new RunCommand(() -> m_door.doorStop()));
  }

  public static double getMotorSpeed(int port) {
    // get a joystick axis
    return controller.getRawAxis(port);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //auto should spin in a circle
    return m_autoCommand;
  }
}