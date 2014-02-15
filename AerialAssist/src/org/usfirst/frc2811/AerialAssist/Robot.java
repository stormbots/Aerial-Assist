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
    public static Lifter2 lifter2;
    public static Punter punter;
    public static AngleManager angleManager; 
    public static Map map;
    public static JoystickControl joystickcontrol;
    
    
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
        lifter2 = new Lifter2();
        punter = new Punter();
        angleManager = new AngleManager();
        map = new Map();
        joystickcontrol = new JoystickControl();

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
        //TODO Get autonamous mode up and running
        //Can we make this a commandgroup? 
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        //RobotMap.ShootingSequence.start();
        Timer.delay(1);
        RobotMap.chassisSpeedController1.set(50);
        RobotMap.chassisSpeedController2.set(50);
        Timer.delay(3);
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
        
        //TODO Add more information to to the Driver Screen !:D 
           DriverStationLCD.getInstance().println(Line.kUser1, 1, "Motor Temperatures:" + " ");
           DriverStationLCD.getInstance().println(Line.kUser2, 1, "Range 1 = " + RobotMap.rangeFinder8.getAverageValue() + " ");
           DriverStationLCD.getInstance().println(Line.kUser3, 1, "Range 2 = " + RobotMap.rangeFinder9.getAverageValue() + " ");
           DriverStationLCD.getInstance().println(Line.kUser4, 1, "Auto Aim = " + OI.autoAimEnable + " ");
           DriverStationLCD.getInstance().updateLCD();
           System.out.print(RobotMap.rangeFinder8.getAverageValue());
           System.out.print("\t");
           System.out.println(RobotMap.rangeFinder9.getAverageValue());
 
        
        
    }

    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}
