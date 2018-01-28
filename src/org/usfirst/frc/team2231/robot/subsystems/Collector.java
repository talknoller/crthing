// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	public static final double SPEED = 1;
	public final SpeedControllerGroup wheels = RobotMap.collectorWheels;
	public final DigitalInput microSwitchCollector = RobotMap.collectorMicroSwitch;
	public final DoubleSolenoid holderPiston = RobotMap.collectorHolderPiston;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setSpeed(double speed) {
		if (isCubeCollected()) {
			stop();
		} else {
			wheels.set(speed);
		}
	}

	public void stop() {
		wheels.set(0);
	}

	public boolean isCollecting() {
		return wheels.get() != 0;

	}

	public boolean isCubeCollected() {
		if (microSwitchCollector.get()) {
			return true;
		}
		return false;
	}
	
	public void changeHolderPistonPosition(DoubleSolenoid.Value value) {
		holderPiston.set(value);
	}
}
