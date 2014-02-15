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
 * Responsible for picking balls up from the field 
 * @author 2811
 */
public class ReLoad extends Command {
    
    public ReLoad() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
      //  requires(Robot.shooter);
      
    }

    // Called just before this Command runs the first time
    protected void initialize() {
     
      }  
        
    protected void execute() {
        
        if(RobotMap.rollerState==-1){
            RobotMap.rollerState=0;
            Robot.rollers.Off();
        }
        else{
            RobotMap.rollerState=-1;
            Robot.rollers.Suck();
        }
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
                
    }

    protected void interrupted() {
    }
        
    }

  