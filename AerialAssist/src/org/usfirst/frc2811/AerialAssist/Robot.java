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
    
    public static Rollers rollers;
    public static Shooter shooter;
    public static Chassis chassis;
    public static Lifter2 lifter2;
    public static AngleManager angleManager; 
    public static Map map;
    public static JoystickControl joystickcontrol;
    public static DriverStationLCD lcd;
    private Command Compress;
    
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	RobotMap.init();
        rollers = new Rollers();
        chassis = new Chassis();
        lifter2 = new Lifter2();
        angleManager = new AngleManager();
        map = new Map();
        joystickcontrol = new JoystickControl();
        shooter = new Shooter();
        oi = new OI();
        autonomousCommand = new AutonomousCommand();
        lcd = DriverStationLCD.getInstance();
        Compress = new Compress();
        Compress.start();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //TODO Get autonomous mode up and running
        //Can we make this a commandgroup? 
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        updateLCD();
        Scheduler.getInstance().run();
        //RobotMap.ShootingSequence.start();//.start();
        //Timer.delay(1);
        //TODO Make forward go forward and shoot in autonomous, but only when robot is safe and testable
        //RobotMap.chassisSpeedController1.set(50);

        //Timer.delay(3);
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        Robot.lifter2.set(15);
        
       
        
    }

    /**
     * This function is called periodically during operator control
     */
    
    //Distance is in -Anglemanager.getRange();
    //Angle is in -lifter2.getpidcontroller().get____()
    
    public void teleopPeriodic() {
        //double distance=java.lang.Math.floor(AngleManager.getRange()+0.5);
        double distance=Math.floor( oi.);
        Scheduler.getInstance().run();
           //DriverStationLCD.getInstance().println(Line.kUser1, 1, "Range = " + RobotMap.distance + " ");
           DriverStationLCD.getInstance().println(Line.kUser1, 1, "Angle    = " + "lol");
           DriverStationLCD.getInstance().println(Line.kUser1, 11, "Distance = " );
           DriverStationLCD.getInstance().println(Line.kUser1, 21, "Ready    = " + OI.autoAimEnable);
           
           lcd.updateLCD();

           
           //System.out.print("\t");
           //System.out.println(RobotMap.rangeFinder9.getAverageValue());
 
        
        
    }

    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        updateLCD();
           DriverStationLCD.getInstance().println(Line.kUser1, 1, "Angle" + Robot.lifter2.getPosition() + " ");
         
    }
    private void updateLCD(){
           //DriverStationLCD.getInstance().println(Line.kUser1, 1, "Range = " + RobotMap.distance + " ");
           DriverStationLCD.getInstance().println(Line.kUser2, 1, "Auto Aim = " + OI.autoAimEnable + " ");
           DriverStationLCD.getInstance().println(Line.kUser3, 1, "Controls Enabled= " + OI.stickEngaged + " ");
           DriverStationLCD.getInstance().println(Line.kUser4, 1, "Shooting State: " + RobotMap.shootPrint);
           DriverStationLCD.getInstance().println(Line.kUser5, 1, "Target Angle: " + Robot.lifter2.getSetpoint());
           DriverStationLCD.getInstance().println(Line.kUser6, 1, "Armed State: " + !RobotMap.inPosition.get() + " ");
           DriverStationLCD.getInstance().println(Line.kUser1, 1, "Actual Angle" + Robot.lifter2.getPosition());
           
           lcd.updateLCD();
    }
} 
