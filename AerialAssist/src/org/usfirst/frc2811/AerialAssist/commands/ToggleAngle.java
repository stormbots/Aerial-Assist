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
 * @author Kelson
 */
public class ToggleAngle extends Command {
    public static double curPos;
    public ToggleAngle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
                System.out.println("SetAngle Start");

       curPos = Robot.lifter2.getPosition();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //System.out.println(curPos);
       System.out.println("WTF Toggle Angle " + curPos);
        if(curPos>30){
            Robot.lifter2.set(0);
        }
        else{
            Robot.lifter2.set(60);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
                System.out.println("Toggle Angle Finished");

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
