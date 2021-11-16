package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class AutonomousSubsystem extends SubsystemBase {

  TalonSRX leftMotor1 = new TalonSRX(DriveConstants.kLeftMotor1Port);
  
  TalonSRX rightMotor1 = new TalonSRX(DriveConstants.kRightMotor1Port);

  public AutonomousSubsystem() {

  }