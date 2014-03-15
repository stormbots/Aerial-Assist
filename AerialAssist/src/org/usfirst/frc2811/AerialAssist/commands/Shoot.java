/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.Robot;

/** 
 * Handles pulling back the primary firing mechanism and checking 
 * sensors to determine completion
 * @author Austin
 */
public class Shoot extends Command {
    
    public static double timeRunning;
    public static double timeStarted;
    DigitalInput inPosition = RobotMap.inPosition;
    public Shoot() {
        requires(Robot.shooter);  //FIXME Is shooter required breaking things?
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timeStarted = timeSinceInitialized();
        RobotMap.shootState=true;
        this.setTimeout(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        timeRunning = timeSinceInitialized();
        if (!Robot.lifter2.getUnder30()) {
        Robot.shooter.set(190);
        System.out.println("In position: "+inPosition.get());
        } else {
        System.out.println("under angle don't shoot!");
    }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (timeRunning>timeStarted+1  && RobotMap.inPosition.get()!=OI.shooterArmed);
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.shooter.set(0);
        RobotMap.Armed=false;
        RobotMap.shootState=false;
        System.out.println("done shooting");
        if (this.isTimedOut()==true) {
            System.out.println(
                 "shot timed out");
            
        }
        if (RobotMap.inPosition.get()!=OI.shooterArmed){
            System.out.println("in position is different than shooter armed");
        }
}

    protected void interrupted() {
      
    }
}
