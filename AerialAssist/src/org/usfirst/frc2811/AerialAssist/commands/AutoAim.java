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
    double internal;

    public AutoAim() {
        // Use requires() here to declare subsystem dependencies
        internal = 8;//TODO Figure out if we need timeout on our AutoAim

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("AutoAim Start");
        OI.stickEngaged=false;

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(OI.autoAimEnable==true){         
        //RobotMap.aimedState=true;
        angle = Robot.angleManager.calculate();
        Robot.lifter2.set(angle);
        }
    }    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
               
        if(OI.autoAimEnable==true){
            return Robot.lifter2.getOnTarget();
        }
         
        else{
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Auto Aim Finished");
        RobotMap.shootPrint="Aimed";
        OI.stickEngaged=true;
   }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
