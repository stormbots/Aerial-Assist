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
    Encoder input = RobotMap.somesuchi5;
    Encoder outputf = RobotMap.somesuchi6;
    private double newrate;
    // Initialize your subsystem here
    public Shooter() {
        //super("shooter", 0.002, 0.000001, 0);
        super("shooter", 0.002, 0.0000000, 0);
        super.enable();
        super.setAbsoluteTolerance(1);
    }
    
    public void initDefaultCommand() {
    }
    
    protected double returnPIDInput() {
        return outputf.getRate()+newrate;
    }
    
    protected void usePIDOutput(double output) {
        //FIxME: Temporarily put hard cap on motor output
        /*We should put a hard cap on the raw motor output here for debugging while we hunt down the current issue
        The reason being, if our encoder is returning 4x as many ticks as the lst one, 
        then our error term (and our resulting P) is 4 times as high, and the motor value
        4 times as large. Capping the motor output directly will ensure that if the PID or sensor is at fault, 
        the motor will never push so hard that it can break things.
        Something like this should do.
        if(output>.2 or output <0.2) {println ("OH NO WTF?");output=0.2}
        */
        
        //DriveMotor1.set(returnPIDInput()<0?output:output);
        DriveMotor1.pidWrite(output);
        getPIDController().setSetpoint(input.getRate());
        System.out.println("shooter motor speed: "+Math.floor(output*20)/20);
        System.out.println("input: "+input.get());
        System.out.println("outputf: "+outputf.get());
        //System.out.println("returnPIDInput: "+returnPIDInput());
        //System.out.println("setpoint: "+super.getSetpoint());
    }
    public void set(double rate) {
        newrate = -rate;
    }
}
