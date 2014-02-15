// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2811.AerialAssist.subsystems;

import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.AerialAssist.OI;


/**
 *
 */
public class Chassis extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController speedController1 = RobotMap.chassisSpeedController1;
    SpeedController speedController2 = RobotMap.chassisSpeedController2;
    SpeedController speedController3 = RobotMap.chassisSpeedController3;
    SpeedController speedController4 = RobotMap.chassisSpeedController4;
    Solenoid gearShifter3 = RobotMap.gearShifter3;
    RobotDrive robotDrive41 = RobotMap.chassisRobotDrive41;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    boolean ShiftDirection = false;
    double RegulatedSpeed = 0;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new DriveRobot());
    }
    public void JoystickControl(Joystick stick) {
        double a = stick.getRawAxis(OI.LEFT_RIGHT_STICK);
        a = a*(OI.LEFT_RIGHT_DIRECTION? -1 : 1);
        double b = stick.getRawAxis(OI.FORE_BACK_STICK);
        b = b*(OI.FORE_BACK_DIRECTION? -1 : 1);
        manualControl(deadZone(a),deadZone(b));
    }
    public void manualControl(double a, double b){
       
        robotDrive41.arcadeDrive(a,b);
    }
    private double deadZone(double position) {
        if (Math.abs(position) <= 0.05) { return 0.0; }
        return position;
    }
    public void manualShift(boolean a){
        ShiftDirection = a;
        gearShifter3.set(ShiftDirection);
    }
    public void normalShift(){
        ShiftDirection = !ShiftDirection;
        gearShifter3.set(ShiftDirection);
    }
    public boolean getShiftDirection(){
        return ShiftDirection;
    }
    public float mapvalue(float input, float maximum, float minimum, float outputMax, float outputMin){
        float output = (input/(maximum-minimum)-minimum/(maximum-minimum))*(outputMax-outputMin)+outputMin;
        return output;
    }
}

