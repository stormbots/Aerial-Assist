/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc2811.AerialAssist.RobotMap;
/**
 *
 * @author Laurel Bingham
 */
public class OpenClaw extends Command {
    
    public OpenClaw() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("OpenClaw");
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        RobotMap.clawSolenoid.set(true);  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
