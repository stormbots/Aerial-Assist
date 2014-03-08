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
 * @author Laurel Bingham
 */
public class DriveTimer extends Command {
    public static double driveDistance;
            
    public DriveTimer(double time) {
        driveDistance = time;
        requires(Robot.chassis);
           }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(driveDistance);
        System.out.println("autonomous driving timer");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.chassis.manualControl(.75, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.chassis.manualControl(0, 0);
        System.out.println("TIMER OVER");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
