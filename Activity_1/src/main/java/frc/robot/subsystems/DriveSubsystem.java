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
  
  //TODO: Set the motor ports in Constants.java
  //TODO: Set the motor to the right type (Talon, CAN, etc.)

  // The motors on the left side of the drive.
  private final SpeedControllerGroup m_leftMotors =
      new SpeedControllerGroup(new WPI_TalonFX(DriveConstants.kLeftMotor1Port),
                               new WPI_TalonFX(DriveConstants.kLeftMotor2Port));

  // The motors on the right side of the drive.
  private final SpeedControllerGroup m_rightMotors =
      new SpeedControllerGroup(new WPI_TalonFX(DriveConstants.kRightMotor1Port),
                               new WPI_TalonFX(DriveConstants.kRightMotor2Port));


  private double leftPower = 0;
  private double rightPower = 0;
  
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    m_rightMotors.setInverted(true);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double forward, double turn) {
    leftPower = forward + turn;
    rightPower = forward - turn;
  }

  @Override
  public void periodic(){
    m_leftMotors.set(leftPower);
    m_rightMotors.set(rightPower);
  }
}
