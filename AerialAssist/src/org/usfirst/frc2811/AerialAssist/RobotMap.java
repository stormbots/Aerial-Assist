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
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
//This import is being bothersome, fixed by forcing Encoder.PIDSourceParameter instead of PIDSourceparameter
//import edu.wpi.first.wpilibj.Encoder.PIDSourceParameter;


import org.usfirst.frc2811.AerialAssist.commands.OpenClaw;
import org.usfirst.frc2811.AerialAssist.commands.ShootingSequence;
import org.usfirst.frc2811.AerialAssist.subsystems.AngleManager;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //DRIVE
    public static SpeedController chassisSpeedController1;
    public static SpeedController chassisSpeedController2;
    public static SpeedController chassisSpeedController3;
    public static SpeedController chassisSpeedController4;
    public static RobotDrive chassisRobotDrive41;
    public static Solenoid gearShifter3;
    //CLAW
    public static Solenoid clawsolenoid;
    public static SpeedController lifterSpeedController5;
    public static AnalogChannel lifterPotentiometer1; //FIXME Potential merge issue
    public static SpeedController rollersSpeedController6;
    public static Encoder somesuchi5;
    public static Encoder somesuchi6;
    //SHOOTING
    public static AnalogChannel rangeFinder8;
    public static AnalogChannel rangeFinder9;
    public static AnalogChannel rangeFinderClaw;
    
    public static SpeedController firingSpeedController7;
    public static Encoder shooterQuadratureEncoder2;
    public static Solenoid punter4;
    public static Solenoid claw3;
    public static AnalogChannel temp1;
    public static AnalogChannel temp2;
    public static AnalogChannel temp3;
    //add temps as needed

    //MISC
    public static Compressor Compressor1;
    
    
    public static int largerValue;
    public static boolean reloadedState;
    public static boolean puntedState;
    public static double distance;
    public static double range1;
    public static double range2;
    public static double trueRange;
    public static double clawRange;
    public static double shootingAngle;
    public static boolean aimedState;
    public static double rangeAt5;//TODO Calibrate
    public static double rangeAt10;//TODO Calibrate
    public static int rollerState;
    
    

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        
        //FIXME we need to enable this for the bot
        //Compressor1 = new Compressor(1, 1, 1, 1);
	
        /*
        DECLARE PWM OUTPUTS (in order, please)
        */
        chassisSpeedController1 = new Jaguar(1, 1);
	//LiveWindow.addActuator("Chassis", "Speed Controller 1", (Talon) chassisSpeedController1);
        
        chassisSpeedController2 = new Jaguar(1, 2);
	//LiveWindow.addActuator("Chassis", "Speed Controller 2", (Talon) chassisSpeedController2);
        
        chassisSpeedController3 = new Jaguar(1, 3);
	//LiveWindow.addActuator("Chassis", "Speed Controller 3", (Talon) chassisSpeedController3);
        
        chassisSpeedController4 = new Jaguar(1, 4);
	//LiveWindow.addActuator("Chassis", "Speed Controller 4", (Talon) chassisSpeedController4);
        
        lifterSpeedController5 =  new Jaguar(1,5);
	//LiveWindow.addSensor("Lifter", "Potentiometer 1", lifterPotentiometer1);

        rollersSpeedController6 = new Jaguar(1, 6);
	//LiveWindow.addActuator("Rollers", "Speed Controller 6", (Talon) rollersSpeedController6);
        
        firingSpeedController7 = new Jaguar(1,7);
       // LiveWindow.addActuator("Firing", "Speed Controller 7", (Talon) firingSpeedController7);

        chassisRobotDrive41 = new RobotDrive(chassisSpeedController1, chassisSpeedController2,
              chassisSpeedController3, chassisSpeedController4);
	
        chassisRobotDrive41.setSafetyEnabled(false); //FIXME: We need to test with safety enabled and proper values
        chassisRobotDrive41.setExpiration(0.1);
        chassisRobotDrive41.setSensitivity(0.5);
        chassisRobotDrive41.setMaxOutput(1.0);

        /*
        DECLARE ANALOG SENSORS (in order, please)
        */
        
        lifterPotentiometer1 = new AnalogChannel(1, 1);
        
        rangeFinderClaw= new AnalogChannel(1,2);
        
        rangeFinder8 = new AnalogChannel(1,3);
        //LiveWindow.addSensor("Angle", "Range Finder 1" , rangeFinder8);
        
        rangeFinder9 = new AnalogChannel(1,4);
       // LiveWindow.addSensor("Angle", "Range Finder 2", rangeFinder9);
        
        temp2 = new AnalogChannel(1,5);
        temp3 = new AnalogChannel(1,6);
        
        
        /*
        DECLARE SOLENOID IO (in order, please)
        */

        gearShifter3 = new Solenoid(1,1);
        punter4 = new Solenoid(1,2);
        claw3 = new Solenoid(1,3);
        clawsolenoid = new Solenoid(1,4);
        
        //Digital IO Ports
        somesuchi5 = new Encoder(1, 1, 1, 2, false);//, EncodingType.k4X);
        somesuchi5.start();
        somesuchi6 = new Encoder(1, 8, 1, 9, false);//, EncodingType.k4X);
        somesuchi6.start();
    }
}
