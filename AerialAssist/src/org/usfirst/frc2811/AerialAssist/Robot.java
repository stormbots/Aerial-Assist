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
import edu.wpi.first.wpilibj.PIDController;
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
    
        Command joystickthing;

    public static OI oi;
    public static final boolean autonomousEnabled = false;
    public static boolean currentlyAutonomous = false;
    public static Rollers rollers;
    public static Shooter shooter;
    public static Chassis chassis;
    public static Lifter2 lifter2;
    public static AngleManager angleManager; 
    public static Map map;
    public static JoystickControl joystickcontrol;
    public static DriverStationLCD lcd;
    private Command Compress;
    private Preferences PIDs;
    private PIDController lifter2PID;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	RobotMap.init();
        rollers = new Rollers();
        chassis = new Chassis();
        chassis.manualControl(0.0, 0.0);
        lifter2 = new Lifter2();
        angleManager = new AngleManager();
        map = new Map();
        joystickcontrol = new JoystickControl();
        shooter = new Shooter();
        oi = new OI();
       joystickthing = new DriveRobot();
        lcd = DriverStationLCD.getInstance();
        Compress = new Compress();
        Compress.start();
        lifter2PID = lifter2.getPIDController();
        PIDs = Preferences.getInstance();
            SmartDashboard.putNumber("PVal", PIDs.getDouble("PVal", lifter2.getPIDController().getP()));
            SmartDashboard.putNumber("IVal", PIDs.getDouble("IVal", lifter2.getPIDController().getI()));
            SmartDashboard.putNumber("DVal", PIDs.getDouble("DVal", lifter2.getPIDController().getD()));
    }

    public void autonomousInit() {
        OI.stickEngaged=false;
        System.out.println("autonomous init");
        autonomousCommand = new AutonomousCommand(true); 
        autonomousCommand.start();
        if (joystickthing != null) joystickthing.cancel();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        updateLCD();
        Scheduler.getInstance().run();
        System.out.println("Autonomous scheduled to run");
    }

    public void teleopInit() {
        OI.stickEngaged=true;
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        joystickthing.start();
        //Robot.lifter2.set(15);
        RobotMap.MaximumArmAngle=80;
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateLCD();
        Robot.angleManager.getRange();
        //System.out.println(RobotMap.lifterSpeedController.get() + "?");
           //System.out.print("\t");
           //System.out.println(RobotMap.rangeFinder9.getAverageValue());
 
    }

    /**
     * This function called periodically during test mode
     */
    public void testInit(){
        //lifter2PID
        System.out.println("TEST MODE ACTIVE");
        RobotMap.MaximumArmAngle=90;
    }
    
    public void testPeriodic() {
        
        //Set up PID tuning 
        Robot.lifter2.setIncramental(OI.joystick1.getRawAxis(6)*-1);
        
        //Read values from dash
        double P = SmartDashboard.getNumber("PVal",  lifter2PID.getP());
        double I = SmartDashboard.getNumber("IVal",  lifter2PID.getI());
        double D = SmartDashboard.getNumber("DVal",  lifter2PID.getD());
        //sets cRio values
        lifter2PID.setPID(P, I, D);//FIXME: ensure PID changes in test work correctly //u mad bro? problem? *trollface*
            System.out.println("Read P: " + lifter2PID.getP());
        
        //sets prefs from current pid
        PIDs.putDouble("PVal", P);
        PIDs.putDouble("IVal", I);
        PIDs.putDouble("DVal", D);
            //System.out.println("From Controller P: " +  lifter2PID.getP());
        //updates dashboard
        //SmartDashboard.putNumber("PVal", lifter2PID.getP());
        //SmartDashboard.putNumber("IVal", lifter2PID.getI());
        //SmartDashboard.putNumber("DVal", lifter2PID.getD());
            //System.out.println("Writes to dash P: " + lifter2PID.getP());
        
        
        
        //Update the DriverStation window
        LiveWindow.run();
       // updateLCD();
       }
    private void updateLCD(){
            //TODO Make this do proper things and give drive team instant data
            
            DriverStationLCD.getInstance().println(Line.kUser1, 1, "Target Angle: " + Robot.lifter2.getSetpoint());
            DriverStationLCD.getInstance().println(Line.kUser2, 1, "Actual Angle" + Robot.lifter2.getPosition());
            DriverStationLCD.getInstance().println(Line.kUser3, 1, "Range: " + RobotMap.distance + " ");
            DriverStationLCD.getInstance().println(Line.kUser4, 1, "Armed State: " + (OI.shooterArmed==RobotMap.inPosition.get()) + " ");
            DriverStationLCD.getInstance().println(Line.kUser5, 1, "Auto Aim: " + OI.autoAimEnable + " ");
            DriverStationLCD.getInstance().println(Line.kUser6, 1, "Shooting State: " + RobotMap.shootPrint);
            
           
           
            lcd.updateLCD();
    }
} 
