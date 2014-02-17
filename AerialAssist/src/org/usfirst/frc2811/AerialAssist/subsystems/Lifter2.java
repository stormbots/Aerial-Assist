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
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.commands.templifter;
/**
 *
 */
public class Lifter2 extends PIDSubsystem {
    //AnalogChannel potentiometer1 = RobotMap.pIDSubsystem1Potentiometer1;
//<<<<<<< HEAD //Kelson side
    //SpeedController DriveMotor1 = RobotMap.rollersSpeedController5;
    //    private static final double MaximumValue = 95.0;//TODO Set stop to a more reasonable value
///=======
    SpeedController DriveMotor1 = RobotMap.lifterSpeedController;
    AnalogChannel pot = RobotMap.lifterPotentiometer;
        private static final double MaximumValue = 80.0;
//>>>>>>> some random stuff idk
//*/
        private static final double MinimumValue = 0;
    
    // Initialize your subsystem here
    public Lifter2() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("PIDSubsystem1", 0.1, 0.0, 0.0);
        setAbsoluteTolerance(1);
        //getPIDController().setContinuous(true);
        //FIXME enable this pid getPIDController().enable();
        //FIXME Make sure we have correct code for chain follower
        getPIDController().enable();
        //getPIDController().setSetpoint(20.0);
        
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new templifter());
    }
    
    public void setIncramental(double input){
       // getPIDController().setSetpoint((Robot.oi.joystick1.getRawAxis(3)*-1+1)*40);
        //getPIDController().setSetpoint(getPIDController()+input);
	if (getPIDController().getSetpoint()+input>MaximumValue) {
            getPIDController().setSetpoint(MaximumValue);
        }else 
	if (getPIDController().getSetpoint()+input<MinimumValue) {
            getPIDController().setSetpoint(MinimumValue);
        } else {
        getPIDController().setSetpoint(getPIDController().getSetpoint()+input);
        }
        //DriveMotor1.set(input);
        System.out.println(getPIDController().getSetpoint()+" "+returnPIDInput()+" "+DriveMotor1.get());
    }
    public void set(double input){
       // getPIDController().setSetpoint((Robot.oi.joystick1.getRawAxis(3)*-1+1)*40);
        //getPIDController().setSetpoint(getPIDController()+input);
	if (getPIDController().getSetpoint()+input>MaximumValue) {
            getPIDController().setSetpoint(MaximumValue);
        }else 
	if (getPIDController().getSetpoint()+input<MinimumValue) {
            getPIDController().setSetpoint(MinimumValue);
        } else {
        getPIDController().setSetpoint(input);
        }
    }
    
    protected double returnPIDInput() {
        //yay map value no complicated "magic number" crud
     return mapvalue(pot.getAverageVoltage(),2.8881159880000005, 1.4326566100000002,86,-1);
    
    }
    
    protected void usePIDOutput(double output) {
        //fancy sinusoidal monstrosity below
        //DriveMotor1.pidWrite(output > 0 ? -output*cosmap(returnPIDInput()>45?(returnPIDInput()-45)/45:0,0.2,0.4):-output*sinmap(returnPIDInput()/90,0.25,0.1));
        //simple and inneficient below
        double output2 = 0.0;
        if (returnPIDInput() >= MaximumValue) {
            output2 = output>0?0:output;
        }
        if (returnPIDInput() < MinimumValue) {
            output2 = output<0?0:output;
        }
        DriveMotor1.pidWrite(-output2);
        //DriveMotor2.pidWrite(output > 0?output/3.9:output/3);
    }
    public double mapvalue(double input, double maximum, double minimum, double outputMax, double outputMin){
        double output = (input/(maximum-minimum)-minimum/(maximum-minimum))*(outputMax-outputMin)+outputMin;
        return output;
        
        
    }
    public boolean getOnTarget(){
        return getPIDController().onTarget();
    }
    public double cosmap(double input, double maximum, double minimum){
        double output = Math.abs((-Math.cos(Math.PI*input)/2+0.5)*(maximum-minimum)+minimum)+0.1;
        //function calc3(alpha,be,en)local a = 0 if be ~= en then a = (-math.cos(math.pi*alpha)/2+0.5)*(en-be)+be else a = be end return a end
        return output;
    }
    public double sinmap(double input, double maximum, double minimum){
        double output = Math.abs((Math.sin(Math.PI*input*2))*(maximum-minimum)+minimum)+0.1;
        //function calc3(alpha,be,en)local a = 0 if be ~= en then a = (-math.cos(math.pi*alpha)/2+0.5)*(en-be)+be else a = be end return a end
        return output;
    }
}
