/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.Robot;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author 128925
 */
public class SetToAngle extends Command {
    double inputangle;
    
    public SetToAngle(double input) {
       // requires(Robot.shooter);
        inputangle=input;
        requires(Robot.lifter2);
    }
    public SetToAngle() {//Set a default way to call it without angles
        inputangle=0;
        requires(Robot.lifter2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       Robot.lifter2.set(inputangle);
        //FIXME Set motors to 60
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.lifter2.getOnTarget() ;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
