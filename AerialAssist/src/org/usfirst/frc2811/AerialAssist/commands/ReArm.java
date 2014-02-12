/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.Robot;

/** 
 * Handles pulling back the primary firing mechanism and checking 
 * sensors to determine completion
 * @author Austin
 */
public class ReArm extends Command {
    
    public ReArm() {
        requires(Robot.shooter);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //TODO set motors in motion
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //TODO Make Rearm terminate after sensor is triggered
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        //TODO Stop motors
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
