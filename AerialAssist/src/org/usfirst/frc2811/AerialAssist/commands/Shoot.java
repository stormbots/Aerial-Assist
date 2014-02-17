/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.Robot;

/** 
 * Handles pulling back the primary firing mechanism and checking 
 * sensors to determine completion
 * @author austin
 */
public class Shoot extends Command {
        DigitalInput inPosition = RobotMap.inPosition;
        boolean prevsensor = true;
    
    public Shoot() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        prevsensor = inPosition.get();
                
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (prevsensor == true && inPosition.get() == false);
        //TODO Add switch compatability
        
    }

    // Called once after isFinished returns true
    protected void end() {
        // Stop motors
        //RobotMap.firingSpeedController7.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
