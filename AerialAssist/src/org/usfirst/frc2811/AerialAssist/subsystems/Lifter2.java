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
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.commands.templifter;
/**
 *
 */
public class Lifter2 extends PIDSubsystem {
    SpeedController DriveMotor1 = RobotMap.lifterSpeedController;
    AnalogChannel pot = RobotMap.lifterPotentiometer;
        double MaximumValue = RobotMap.MaximumArmAngle;
        private static final double MinimumValue = 0;
        
        
    public Lifter2() {
        //super("PIDSubsystem1", 0.004, 0.0, 0.0); a little slow
        //super("PIDSubsystem1", 0.006, 0.000, 0.0); weak
        //super("PIDSubsystem1", 0.008, 0.00001, 0.0); fast, not correcting
        //super("PIDSubsystem1", 0.007, 0.00005, 0.0); little quick on correction, add integral
        //super("PIDSubsystem1", 0.0065, 0.0001, 0.0); slow response
        //super("PIDSubsystem1", 0.00675, 0.000125, 0.0); jerky, slow response
        //super("PIDSubsystem1", 0.0065, 0.000175, 0.0);//overcompensating, slow
        //super("PIDSubsystem1", 0.006625, 0.00015, 0.0);//high integral
        //super("PIDSubsystem1", 0.007, 0.000125, 0.003); mostly ok, maybe better
        //super("PIDSubsystem1", 0.00725, 0.0001, 0.004);// good differential,integral
        //super("PIDSubsystem1", 0.01, 0.0001, 0.004);//good p, i
        //super("PIDSubsystem1", 0.01, 0.000075, 0.006);//nice, but laggy
        //super("PIDSubsystem1", 0.01, 0.000075, 0.008);//good diff, higher p
        //super("PIDSubsystem1", 0.025, 0.000075, 0.008);//great, +i
        //super("PIDSubsystem1", 0.025, 0.000075, 0.008);//Perfect w/o ball
        //super("PIDSubsystem1", 0.025, 0.00008, 0.008);// overshoots 60
        //super("PIDSubsystem1", 0.025, 0.00008, 0.006);//current good
        
        
        super("PIDSubsystem1", 0.025, 0.00008, 0.006);//current good
        setAbsoluteTolerance(2);
        getPIDController().setContinuous(true);
        getPIDController().enable();
        getPIDController().setSetpoint(returnPIDInput());
        
 /* 
           _                           _
         /   \                       /   \
        |     |                     |     |
        |_____|                     |_____|
         _____                       _____
        |     |                     |     |
        |_____|                     |_____|
           _        _        _
         _| |_    ( _ )    ( _ )      ( )
        |_   _|     _              ( )   ( )
          |_|     ( _ )               ( )
  
                  _            _  
                /   \        /   \
               (     )      (     )
                \ _ /        \ _ /
     
    */  }
    
    public void initDefaultCommand() {
        setDefaultCommand(new templifter());
    }
    
    public void setIncramental(double input){
        //System.out.println("setIncramental was called in Lifter2, value "+input);
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
       // System.out.println(getPIDController().getSetpoint()+" "+returnPIDInput()+" "+DriveMotor1.get()+" "+pot.getAverageVoltage());
        //DriveMotor1.set(input);
    }
    public void set(double input){
        //System.out.println("set was called in Lifter2, value "+input);
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
    public boolean getUnder30(){
        return returnPIDInput()< 15; //iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
    }
    
    protected double returnPIDInput() {
        //yay map value no complicated "magic number" crud
     //return mapvalue(pot.getAverageVoltage(),1.9160954140000004, 1.3966558480000002,30,0);
     return mapvalue(pot.getAverageVoltage(),1.376083984, 0.69721472,28,-2);
    
    }
    
    protected void usePIDOutput(double output) {
        //fancy sinusoidal monstrosity below
        //DriveMotor1.pidWrite(output > 0 ? -output*cosmap(returnPIDInput()>45?(returnPIDInput()-45)/45:0,0.2,0.4):-output*sinmap(returnPIDInput()/90,0.25,0.1));
        //simple and inneficient below
        double output2 = 0.0;
        if (returnPIDInput() >= MaximumValue) {
            output2 = output>0?0:output;
        } else if (returnPIDInput() < MinimumValue) {
            output2 = output<0?0:output;
        } else {
            output2 = output;
        }
        output2 = Math.abs(output2)>0.5?output2/Math.abs(output2)*0.5:output;
        if(output2<0){ //reduce motor power when going down
            output2 = output2/2;
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
