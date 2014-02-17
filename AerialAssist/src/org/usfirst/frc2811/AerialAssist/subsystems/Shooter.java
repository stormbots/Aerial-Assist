/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author Kelson
 */
public class Shooter extends PIDSubsystem {

    SpeedController DriveMotor1 = RobotMap.firingSpeedController;
    Encoder input = RobotMap.somesuchi6;
    Encoder output = RobotMap.somesuchi5;
    private double newrate;
    // Initialize your subsystem here
    public Shooter() {
        super("shooter", 0.003, 0.0000, 0);
        getPIDController().enable();
        getPIDController().setAbsoluteTolerance(1);
    }
    
    public void initDefaultCommand() {
    }
    
    protected double returnPIDInput() {
        return output.getRate()+newrate;
    }
    
    protected void usePIDOutput(double output) {
        DriveMotor1.set(returnPIDInput()<0?output:output);
        getPIDController().setSetpoint(input.getRate());
    }
    public void set(double rate) {
        newrate = -rate;
    }
}