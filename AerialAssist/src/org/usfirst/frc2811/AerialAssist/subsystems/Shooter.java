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
        super("shooter", 0.002, 0.0, 0);
        //used to work 0.002,0.0,0
        super.enable();
        super.setAbsoluteTolerance(2);
    }
    
    public void initDefaultCommand() {
    }
    
    protected double returnPIDInput() {
        return -newrate;//-outputf.getRate()-newrate;
    }
    
    protected void usePIDOutput(double output) {

        //negative is up, positive is out)
        if (newrate < 4){//TODO only for without rachet
            DriveMotor1.set(-output);
        } else {
        DriveMotor1.set(returnPIDInput()<0?-output*0.7:-output*1.2);
        }

       DriveMotor1.set(returnPIDInput()<0?-output:-output);
       // DriveMotor1.pidWrite(-output);
       getPIDController().setSetpoint(input.getRate());
       //THIS     //   System.out.println("shooter absolutely value "+DriveMotor1.get());
       //System.out.println("shooter motor speed: "+Math.floor(output*20)/20);
        //System.out.println("input: "+input.getRate());
        //System.out.println("outputf: "+outputf.getRate());
        //System.out.println("returnPIDInput: "+returnPIDInput());
        //System.out.println("setpoint: "+super.getSetpoint());
    }
    public void set(double rate) {
        newrate = -rate;
    }
}