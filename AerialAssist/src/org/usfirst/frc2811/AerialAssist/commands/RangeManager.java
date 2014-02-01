/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.Robot;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.subsystems.RangeFinder;

/**
 *
 * @author 128925
 */
public class RangeManager extends Command {
    
    public static double range1;
    public static double range2;
    public static double trueRange;
    public static double rangeMagicNumber;
    public static double rangeInInches;
    
    
    public RangeManager() {
        requires(Robot.rangefinder);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        
        
        if(range1>range2){
            trueRange=range1;
        }
        
        else{
            trueRange=range2;
        }
        
        rangeInInches=trueRange/rangeMagicNumber;
        RobotMap.distance = rangeInInches/12;
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
