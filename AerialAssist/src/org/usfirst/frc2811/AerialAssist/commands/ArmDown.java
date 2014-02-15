/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.Robot;

/**
 *
 * @author Austin
 */
public class ArmDown extends Command {
    
    public ArmDown() {
        requires(Robot.lifter2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //FIXME Figure out a good motor rate for lowering arm
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //FIMXE Check return value for ArmDown function when we call it from a button
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
