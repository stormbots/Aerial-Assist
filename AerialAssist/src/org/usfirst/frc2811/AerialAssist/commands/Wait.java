/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Kelson
 */
public class Wait extends Command {
    double internal;
    public Wait(double input) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        internal = input;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(internal);
        System.out.println("started wiating for "+internal+" seconds");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("stopped wiating for "+internal+" seconds");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
