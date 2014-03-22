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
        System.out.println("ArmDown");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //use the Robot.lifter2.set() method. Up is positive angle, down is negative angle
        Robot.lifter2.setIncramental(-3.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //TODO (maybe) Check return value for ArmDown function when we call it from a button
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
