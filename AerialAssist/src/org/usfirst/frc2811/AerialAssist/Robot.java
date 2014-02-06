// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2811.AerialAssist;


import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc2811.AerialAssist.commands.*;
import org.usfirst.frc2811.AerialAssist.subsystems.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
        public static DriverStationLCD dsText;

    Command autonomousCommand;
    

    public static OI oi;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Rollers rollers;
    public static Chassis chassis;
    public static Lifter lifter;;
    public static Shooter shooter;
    public static Punter punter;
    public static Punter punter;
    public static Reloader reloader;
    public static AngleManager angleManager; 
    
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        rollers = new Rollers();
        chassis = new Chassis();
        lifter = new Lifter();
        shooter = new Shooter();
        punter = new Punter();
        punter = new Punter();
        angleManager = new AngleManager();
        reloader = new Reloader();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
	
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new AutonomousCommand();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
         
        
       
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        /**you should feel ashamed for bad code like the code below. */
        
        
        //Timer.delay(0.5);
        //System.out.println("Average Values:");
        //Timer.delay(0.5);
        //System.out.println("pot1 = " + OI.pot1.getAverageValue());
        //Timer.delay(0.5);
        //System.out.println("pot2 = " + OI.pot2.getAverageValue());
        //Timer.delay(0.5);
        //System.out.print("range = " + OI.range.getAverageValue()+"  ");
        //Timer.delay(0.5);
        //System.out.println("range2 = " + OI.range2.getAverageValue());
//        Timer.delay(0.5);
        //System.out.println("Actual Range 1 = " + (OI.pot1.getAverageValue() - OI.range.getAverageValue()));
        //Timer.delay(0.5);
        //System.out.println("Actual Range 2 = " + (OI.pot2.getAverageValue() - OI.range2.getAverageValue()));
        //Timer.delay(0.5);
        //System.out.println("Larger Value = " + OI.largerValue);
        //Timer.delay(0.5);
        //System.out.println("No errors thus far...");
        
//           DriverStationLCD.getInstance().println(Line.kUser1, 1, "Motor Temperatures:" + " ");
//           DriverStationLCD.getInstance().println(Line.kUser2, 1, "Motor 1 = " + OI.temp1.getValue() + " ");
//           DriverStationLCD.getInstance().println(Line.kUser3, 1, "Motor 2 = " + OI.temp2.getValue() + " ");
//           DriverStationLCD.getInstance().println(Line.kUser4, 1, "Motor 3 = " + OI.temp3.getValue() + " ");
//           DriverStationLCD.getInstance().println(Line.kUser5, 1, "Ranges: "+ OI.range.getAverageValue() + " " + OI.range2.getAverageValue());
//           DriverStationLCD.getInstance().updateLCD();
//        
//        if (OI.rangeValue >= OI.range2Value){
//            OI.largerValue = OI.rangeValue;
//        }else{
//            OI.largerValue = OI.range2Value;
//        }
        
        //OI.botArm.whenActive(new PrepareToFire());
        //OI.longShot.whenActive(new FireLong());
        
        
    }

    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
