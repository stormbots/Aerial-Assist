/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc2811.AerialAssist.Robot;
/**
 *
 * @author Laurel Bingham
 */
public class SetToZero extends Command {
    
    public SetToZero() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      Robot.lifter2.set(0,this.getClass());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.lifter2.getOnTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
