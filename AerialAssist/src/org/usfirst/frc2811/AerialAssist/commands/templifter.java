/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.Robot;

/**
 *
 * @author Kelson
 */
public class templifter extends Command {
    
    public templifter() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.lifter2);  //FIXME Is lifter required breaking things?
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("lifting arm");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (OI.stickEngaged){
            //  System.out.println("templifter executed");
        Robot.lifter2.setIncramental(OI.joystick1.getRawAxis(6)*-1);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
