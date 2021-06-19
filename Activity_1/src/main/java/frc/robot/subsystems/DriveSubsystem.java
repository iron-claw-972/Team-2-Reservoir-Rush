/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

  //TODO: 1. Set the motor ports in Constants.java
  /*TODO: 1. Set the motor to the right type (Talon, CAN, etc.) 
  / See https://github.com/iron-claw-972/HowToProgramming for how to do this
  / Make sure to set the right amount of motors! (if you only have 2 motors don't make 4)*/
  
  WPI_TalonFX leftMotor1 = new WPI_TalonFX(DriveConstants.kLeftMotor1Port);
  WPI_TalonFX leftMotor2 = new WPI_TalonFX(DriveConstants.kLeftMotor2Port);
  WPI_TalonFX rightMotor1 = new WPI_TalonFX(DriveConstants.kRightMotor1Port);
  WPI_TalonFX rightMotor2 = new WPI_TalonFX(DriveConstants.kRightMotor2Port);

  // The motors on the left side of the drive.
  private final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);

  // The motors on the right side of the drive.
  private final SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);
  
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    //TODO: 1. Your robot may need to have the left motors inverted and not the right
    m_rightMotors.setInverted(true);
  }

  /**
   * Drives the robot using tank drive controls
   * Tank drive is slightly easier to code but less intuitive to control, so this is here as an example for now
   * @param leftPower the commanded power to the left motors
   * @param rightPower the commanded power to the right motors
   */

  public void tankDrive(double leftPower, double rightPower) {
    m_leftMotors.set(leftPower);
    m_rightMotors.set(rightPower);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param forward the commanded forward movement
   * @param turn the commanded turn rotation
   */
  public void arcadeDrive(double forward, double turn) {
    //TODO: 2. Add arcade drive here by setting the motors
  }
}
