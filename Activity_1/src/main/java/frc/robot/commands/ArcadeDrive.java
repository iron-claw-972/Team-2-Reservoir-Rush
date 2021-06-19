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

public class ArcadeDrive extends CommandBase {
  private final DriveSubsystem m_drive;
  private final DoubleSupplier m_forward;
  private final DoubleSupplier m_turn;

  /**
   * Creates a new ArcadeDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param forward The control input for driving forwards/backwards
   * @param turn The control input for turning
   */
  public ArcadeDrive(DriveSubsystem subsystem, DoubleSupplier forward, DoubleSupplier turn) {
    m_drive = subsystem;
    m_forward = forward;
    m_turn = turn;
    addRequirements(m_drive);
  }

  @Override
  public void execute() {
    //TODO: 2. execute arcade drive function from DriveSubsytem here (look at tankDrive for reference)
  
  }
}