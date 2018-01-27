package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystick;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystickWithLock;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public static final WPI_TalonSRX firstLeft = Robot.m_robotMap.driveTrainFirstLeft;
	public static final WPI_TalonSRX secondLeft = Robot.m_robotMap.driveTrainSecondLeft;
	public static final WPI_TalonSRX firstRight= Robot.m_robotMap.driveTrainFirstRight;
	public static final WPI_TalonSRX secondRight = Robot.m_robotMap.driveTrainSecondRight;
	public static final DifferentialDrive robotDrive = Robot.m_robotMap.driveTrainRobotDrive;
	public static final SpeedControllerGroup leftTalons = Robot.m_robotMap.driveTrainleftTalons;
	public static final SpeedControllerGroup rightTalons = Robot.m_robotMap.driveTrainRightTalons;
	public static final AHRS m_navX = Robot.m_robotMap.driveTrainNavX;
	public static final PIDController leftRotationPIDController = Robot.m_robotMap.driveTrainLeftRotationPIDController;
	public static final PIDController rightRotationPIDController = Robot.m_robotMap.driveTrainRightRotationPIDController;
	public final double rotation_Absolute_Tolerence = 1;
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveByJoystickWithLock());
    }
    
    public void arcadeDrive(Joystick stick) {
    	robotDrive.arcadeDrive(-stick.getRawAxis(1) * 2, stick.getRawAxis(4) * 2);
    }
    
    public void resetAHRSGyro() {
    	m_navX.reset();
    }
    
    public double getAngle() {
    	return m_navX.getAngle();
    }
    
    public void setRotationSetpoint(double setpoint) {
    	rightRotationPIDController.setSetpoint(setpoint);
    	leftRotationPIDController.setSetpoint(setpoint);
    }
    
    public void enableRotationPIDControllers() {
    	rightRotationPIDController.enable();
    	leftRotationPIDController.enable();
    }
    
    public boolean isRotationPIDOnPoint() {
    	return rightRotationPIDController.onTarget() && leftRotationPIDController.onTarget() && leftTalons.get() < 0.05;
    }
    
    public void stop() {
    	leftTalons.stopMotor();
    	rightTalons.stopMotor();
    }
    
    public void disableRotationPIDControllers() {
    	leftRotationPIDController.disable();
    	rightRotationPIDController.disable();
    }
    
    public void setOutputRange() {
    	leftRotationPIDController.setOutputRange(-1, 1);
    	rightRotationPIDController.setOutputRange(-1, 1);
    }
}

