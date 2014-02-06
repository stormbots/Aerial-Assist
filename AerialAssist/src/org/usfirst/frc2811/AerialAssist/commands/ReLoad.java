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
 * @author 2811
 */
public class ReLoad extends Command {
    
    public ReLoad() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      // int input = 0;
      // double minimum=33; //TODO Find this!
      // double maximum=300; //TODO Find this! 
       //double outputMin=0;//TODO Find This!
      // double outputMax=1024; 
        
        //TO DO set to zero
      }  
        //set motors running inward
        //when rangefinder equals certain value stop turning

    protected void execute() {
        RobotMap.rollersSpeedController6.set(.5);
//        Robot.shooter.reloadMotors();
       // throw new java.lang.UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected boolean isFinished() {
         RobotMap.clawrange = RobotMap.rangeFinderClaw.getAverageVoltage();
     if (RobotMap.clawrange <= .5){// in inches?? 
        return true;
         }
        else {
          return false;
                }
                
        
       // throw new java.lang.UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected void end() {
        RobotMap.rollersSpeedController6.set(0);
        
    }
       // throw new java.lang.UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    

    protected void interrupted() {
  
       // throw new java.lang.UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    }

  