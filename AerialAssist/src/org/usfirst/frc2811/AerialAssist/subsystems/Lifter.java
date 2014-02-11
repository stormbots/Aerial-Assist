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

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/** Controls the PID subsystem that controls the claw angle
 *  If you need to set a value for the claw, you would set it by doing the following:
 *  //FIXME document method to control arm angle
 *  To ensure the claw is in position, you would do the following:
 *  //FIXME Ensure programs can read if target is set 
 */
public class Lifter extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    AnalogChannel potentiometer1 = RobotMap.lifterPotentiometer1;
    SpeedController speedController5 = RobotMap.lifterSpeedController5;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

        //TODO Ensure  Minimum and Maximum values are correct
        private double MaximumValue = 100;
        private double MinimumValue = 20;
    // Initialize your subsystem here
    public Lifter() {
        super("Lifter", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Lifter", "PIDSubsystem Controller", getPIDController());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //            setSetpoint      to
         getPIDController().enable();// - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
	if (getPIDController().getSetpoint()>MaximumValue) {
            getPIDController().setSetpoint(MaximumValue);
        }
	if (getPIDController().getSetpoint()<MinimumValue) {
            getPIDController().setSetpoint(MinimumValue);
        }
        return potentiometer1.getAverageVoltage();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
	
        speedController5.pidWrite(output);
    }
    
    
}
