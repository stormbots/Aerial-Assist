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
 * Handles arming of the shooter
 * @author 128925
 */
public class Arming extends Command {
    
    DigitalInput inPosition = RobotMap.inPosition;
    
    public Arming() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//        requires(Robot.shooter);  //TODO confirm shooter not required breaking things?
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(Robot.lifter2.getPosition()>60||Robot.lifter2.getPosition()<15){
            Robot.lifter2.set(0);    
        }
                     
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        Robot.shooter.set(150);
        System.out.println("In position is "+inPosition.get());
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return (inPosition.get()==OI.shooterArmed);
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
