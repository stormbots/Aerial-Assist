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
        requires(Robot.shooter);
        //FIXME ReLoad should require Rollers
    }

    // Called just before this Command runs the first time
    protected void initialize() {
     
      }  
        //set motors running inward
        //when rangefinder equals certain value stop turning

    protected void execute() {
        RobotMap.rollersSpeedController6.set(.5);
    }

    protected boolean isFinished() {
        //TODO Calibrate reload using rangefinder + map
        RobotMap.clawRange = RobotMap.rangeFinderClaw.getAverageVoltage();
        if (RobotMap.clawRange <= .5){// in inches?? 
            return true;
        }
        else {
          return false;
        }
                
    }

    protected void end() {
        RobotMap.rollersSpeedController6.set(0);
        
    }

    protected void interrupted() {
    }
        
    }

  