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

/**
 *
 * @author Kelson
 */
public class Shooter extends PIDSubsystem {

    
    
    
    Encoder input = RobotMap.somesuchi6;
    Encoder output = RobotMap.somesuchi5;
    // Initialize your subsystem here
    public Shooter() {
        super("newPIDSubsystem", 1, 0, 0);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        getPIDController().enable(); //- Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
      //  setDefaultCommand(new Command3());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return output.getRate();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        //robotDrive41.arcadeDrive(output,0.0);
    }

    public void lol(double rate) {
        getPIDController().setSetpoint(-rate);
    }
}
