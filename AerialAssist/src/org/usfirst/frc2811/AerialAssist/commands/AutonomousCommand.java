// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.Robot;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.subsystems.AngleManager;
import org.usfirst.frc2811.AerialAssist.subsystems.Lifter2;
import org.usfirst.frc2811.AerialAssist.subsystems.Shooter;

/**
 * Obviously, runs during autonomous . 
 */
public class  AutonomousCommand extends Command {
    public static AngleManager angle = new AngleManager();
    public static Shooter shoot = new Shooter();
    public static Lifter2 lift = new Lifter2();

    public AutonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (Robot.chassis);
        requires (shoot);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //Set claw to 15 degrees
        //Possibly activate rollers
        angle.getRange();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Get range values
        //When ranges are close to a wall, stop motors
        //Shoot the ball
        
        
        
        RobotMap.chassisSpeedController1.set(50);
        RobotMap.chassisSpeedController2.set(50);
        RobotMap.chassisSpeedController3.set(50);
        RobotMap.chassisSpeedController4.set(50);
        System.out.println("Autonomous Motors");
      
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println("Angle = " + angle.getRange() + " ");
        if(angle.getRange() < 7){
            return true;
        
    }else{
            return false;
        }
        
        //FIXME Make sure autonomous returns properly
    }

    // Called once after isFinished returns true
    protected void end() {
        //Calculate the angle
        //Set arm angle
        //Wait for angle to be achieved
        //Actually shoot the ball
        RobotMap.chassisSpeedController1.set(0);
        RobotMap.chassisSpeedController2.set(0);
        RobotMap.chassisSpeedController3.set(0);
        RobotMap.chassisSpeedController4.set(0);
        shoot.set(150);
        
        
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
