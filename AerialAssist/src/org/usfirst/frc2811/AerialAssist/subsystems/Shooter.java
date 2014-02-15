/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.commands.Shoot;

/**
 *
 * @author Kelson
 */
public class Shooter extends PIDSubsystem {

    SpeedController DriveMotor1 = RobotMap.lifterSpeedController6;
    Encoder input = RobotMap.somesuchi6;
    Encoder output = RobotMap.somesuchi5;
    private double newrate;
    // Initialize your subsystem here
    public Shooter() {
        super("newPIDSubsystem", 0.4, 0, 0);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        getPIDController().enable(); //- Enables the PID controller.
        getPIDController().setAbsoluteTolerance(2);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new Shoot());
        // Set the default command for a subsystem here.
      //  setDefaultCommand(new Command3());
    }
    
    protected double returnPIDInput() {
        getPIDController().setSetpoint(newrate-input.getRate());
        return output.getRate();
    }
    
    protected void usePIDOutput(double output) {
        
    }
    public void setspeed(double rate) {
        newrate = -rate;
    }
}