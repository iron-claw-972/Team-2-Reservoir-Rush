/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TankDrive extends CommandBase {
  private final DriveSubsystem m_drive;
  private final DoubleSupplier m_leftPow;
  private final DoubleSupplier m_rightPow;

  /**
   * Creates a new TankDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param leftPow The control input for driving the left motors
   * @param rightPow The control input for driving the left motors
   */
  public TankDrive(DriveSubsystem subsystem, DoubleSupplier leftPow, DoubleSupplier rightPow) {
    m_drive = subsystem;
    m_leftPow = leftPow;
    m_rightPow = rightPow;
    addRequirements(m_drive);
  }

  @Override
  public void execute() {
    m_drive.tankDrive(m_leftPow.getAsDouble(), m_rightPow.getAsDouble());
  }
}