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
    public Shoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
                
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        Robot.shooter.set(150);
        System.out.println(!inPosition.get());
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!inPosition.get()==false);
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.shooter.set(0);
        
}

    protected void interrupted() {
      
    }
}
