// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyWithCollector extends Command {
	private final double m_maxSpeed;

	public ConveyWithCollector(final double maxSpeed) {
		m_maxSpeed = maxSpeed;
		requires(Robot.m_collector);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.m_collector.setSpeed(m_maxSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_collector.stop();
		Robot.m_collector.setCubeCollected(Robot.m_collector.isMicroSwitchPressed());
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
