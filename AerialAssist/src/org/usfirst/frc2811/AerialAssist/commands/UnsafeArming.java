/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.Robot;
import org.usfirst.frc2811.AerialAssist.RobotMap;


/**
 *
 * @author StormBot
 */
public class UnsafeArming extends Command {
    DigitalInput inPosition = RobotMap.inPosition;
    public UnsafeArming() {
    
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.shooter.set(190);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(inPosition.get()==OI.shooterArmed);
        
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.shooter.set(0);
        System.out.println("ARMING IS OVER");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
