/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.Robot;


/**
 * This function sets the target angle, and then completes when the PID system
 * has reached it's target
 * @author 2811
 */
public class AutoAim extends Command {
      double angle;
    
    public AutoAim() {
        // Use requires() here to declare subsystem dependencies
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       
         
        //RobotMap.aimedState=true;
        angle = Robot.angleManager.calculate();
        
        //TODO Make AutoAim actually write to the PID controller if auto-aim is enabled
        //Saved as OI.autoAimEnable
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //TODO @kelson Make autoAim exit when PID.onTarget()==true
        //TODO Autoaim should always return true immediately if auto-aim is disabled
        //This is saved as OI.autoAimEnable currently
        if(true){
            return true;
        }
        else{
            return false;
        }
       
        
    }

    // Called once after isFinished returns true
    protected void end() {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
