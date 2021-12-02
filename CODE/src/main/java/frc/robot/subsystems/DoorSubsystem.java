/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class DoorSubsystem extends SubsystemBase {

  TalonSRX motor4 = new TalonSRX(1);

  public void doorSpin() {
    motor4.set(ControlMode.PercentOutput, 0.25);
  }

  public void doorReverse() {
    motor4.set(ControlMode.PercentOutput, -0.25);
  }

  public void doorStop(){
    motor4.set(ControlMode.PercentOutput, 0);
  }
}