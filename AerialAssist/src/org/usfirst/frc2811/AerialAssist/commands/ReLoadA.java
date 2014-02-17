/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.Robot;
import org.usfirst.frc2811.AerialAssist.RobotMap;


/**
 * Responsible for picking balls up from the field 
 * @author 2811
 */
public class ReLoadA extends Command {
    
    public ReLoadA() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
      //  requires(Robot.shooter);
      
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.lifter2.set(0);//set degrees
        System.out.println("initialize");
      }  
        
    protected void execute() {
        RobotMap.rollerState=-1;//State value, not motor
        Robot.rollers.Suck();
        System.out.println("execute");
    }

    protected boolean isFinished() {
        
         System.out.println("isFinished");
        return Robot.lifter2.getOnTarget();
       
    }

    protected void end() {
        System.out.println("endof");
        
    }

    protected void interrupted() {
    }
        
    }

  