/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author StormBot
 */
public class tempForward extends Command {
    public static double timer;
    public tempForward(double timeout) {
       timer = timeout; 
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(timer);
       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        RobotMap.chassisSpeedController1.set(.5);
        RobotMap.chassisSpeedController2.set(.5);
        RobotMap.chassisSpeedController3.set(.5);
        RobotMap.chassisSpeedController4.set(.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotMap.chassisSpeedController1.set(0);
        RobotMap.chassisSpeedController2.set(0);
        RobotMap.chassisSpeedController3.set(0);
        RobotMap.chassisSpeedController4.set(0);
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
