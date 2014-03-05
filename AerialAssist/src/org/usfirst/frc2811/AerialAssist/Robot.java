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
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        System.out.println("autonomous init");
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
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateLCD();
           //System.out.print("\t");
           //System.out.println(RobotMap.rangeFinder9.getAverageValue());
 
    }

    /**
     * This function called periodically during test mode
     */
    public void testInit(){
        Preferences PIDs  = Preferences.getInstance();//Tuning stuff. Don't touch. inits values
            
        //This is reading a value, and using the current hardcoded values as defaults
        PIDs.getDouble("PVal", lifter2.getPIDController().getP());
        PIDs.getDouble("IVal", lifter2.getPIDController().getI());
        PIDs.getDouble("DVal", lifter2.getPIDController().getD());
            System.out.println("init P: " + lifter2.getPIDController().getP());
            
        //display on dashboard
        SmartDashboard.putNumber("PVal", lifter2.getPIDController().getP());
        SmartDashboard.putNumber("IVal", lifter2.getPIDController().getI());
        SmartDashboard.putNumber("DVal", lifter2.getPIDController().getD());
            //System.out.print("testinit");
    }
    
    public void testPeriodic() {
        //Set up PID tuning 
        Preferences PIDs  = Preferences.getInstance();
        //Read values from dash
        double P = SmartDashboard.getNumber("PVal", lifter2.getPIDController().getP());
        double I = SmartDashboard.getNumber("IVal", lifter2.getPIDController().getI());
        double D = SmartDashboard.getNumber("DVal", lifter2.getPIDController().getD());
            System.out.println("Read P: " + P);
        //sets cRio values
        lifter2.getPIDController().setPID(P, I, D);//FIXME: u mad bro? problem? *trollface*
        
        //sets prefs from current pid
        PIDs.putDouble("PVal", lifter2.getPIDController().getP());
        PIDs.putDouble("IVal", lifter2.getPIDController().getI());
        PIDs.putDouble("DVal", lifter2.getPIDController().getD());
            System.out.println("From Controller P: " + lifter2.getPIDController().getP());
        //updates dashboard
        SmartDashboard.putNumber("PVal", lifter2.getPIDController().getP());
        SmartDashboard.putNumber("IVal", lifter2.getPIDController().getI());
        SmartDashboard.putNumber("DVal", lifter2.getPIDController().getD());
            System.out.println("Writes to dash P: " + lifter2.getPIDController().getP());
        
        
        
        //Update the DriverStation window
        LiveWindow.run();
        updateLCD();
        DriverStationLCD.getInstance().println(Line.kUser1, 1, "Angle" + Robot.lifter2.getPosition() + " ");
        Robot.lifter2.setInputRange(0,90);

        
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
