/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.*;

public class UpdateDefault extends CommandBase {
  private final DriveSubsystem m_drive;
  private final Runnable m_toRun;

  /**
   * Creates a new UpdateSettings command.
   *
   * @param subsystem The drive subsystem this command wil run on.
   */
  public UpdateDefault(DriveSubsystem subsystem, Runnable toRun) {
    m_drive = subsystem;
    m_toRun = toRun;
    addRequirements(m_drive);
  }

  @Override
  public void initialize() {
    m_drive.setDefaultCommand(new RunCommand(m_toRun, m_drive));
  }
}