// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

  private CANSparkMax m_leadMotor;
  private CANSparkMax m_followMotor;
  
  public ShooterSubsystem() {
    m_leadMotor = new CANSparkMax(Constants.Shooter.leadProtoMotorID, MotorType.kBrushless);
    m_followMotor = new CANSparkMax(Constants.Shooter.followProtoMotorID, MotorType.kBrushless);
    configMotors();
  }


  public void configMotors() {
    m_leadMotor.restoreFactoryDefaults();
    m_followMotor.restoreFactoryDefaults();
    m_followMotor.follow(m_leadMotor, false);

  }

  /**
   * @param value
   * -1.0 to 1.0
   */
  public void setMotors(double value) {
    m_leadMotor.set(value);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
