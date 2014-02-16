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
import edu.wpi.first.wpilibj.Encoder;
//This import is being bothersome, fixed by forcing Encoder.PIDSourceParameter instead of PIDSourceparameter
//import edu.wpi.first.wpilibj.Encoder.PIDSourceParameter;




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
    public static Solenoid gearShifter;
    //CLAW
    public static Solenoid clawSolenoid;
    public static SpeedController rollersSpeedController;
    public static AnalogChannel lifterPotentiometer;
    public static SpeedController lifterSpeedController;
    public static Encoder somesuchi5;
    public static Encoder somesuchi6;
    //SHOOTING
    public static AnalogChannel rangeFinder8;
    public static AnalogChannel rangeFinder9;
    public static AnalogChannel rangeFinderClaw;
    public static DigitalInput inPosition;
    public static SpeedController firingSpeedController;
    public static Encoder shooterQuadratureEncoder;
    //TEMPS
    public static AnalogChannel temp1;
    public static AnalogChannel temp2;
    public static AnalogChannel temp3;
    //add temps as needed

    //MISC
    public static DigitalInput compin;
    public static Relay compout;
    
    //VARIABLES
    public static int largerValue;
    public static boolean reloadedState;
    public static double distance;
    public static double range1;
    public static double range2;
    public static double trueRange;
    public static double clawRange;
    public static double shootingAngle;
    public static boolean aimedState;
    public static double rangeShort;//TODO Calibrate
    public static double rangeLong;//TODO Calibrate
    public static int rollerState;
    public static String shootPrint = "N/A";
    
    

    public static void init() {
        //FIXME we need to enable this for the bot
        //Compressor1 = new Compressor(1, 1, 1, 1);
	
        /*
        DECLARE PWM OUTPUTS (in order, please)
        */
        chassisSpeedController1 = new Jaguar(1, 1);
        chassisSpeedController2 = new Jaguar(1, 2);
        chassisSpeedController3 = new Jaguar(1, 3);
        chassisSpeedController4 = new Jaguar(1, 4);
        chassisRobotDrive41 = new RobotDrive(chassisSpeedController1, chassisSpeedController2,
        chassisSpeedController3, chassisSpeedController4);
        chassisRobotDrive41.setSafetyEnabled(true); //FIXME: We need to test with safety enabled and proper values
        chassisRobotDrive41.setExpiration(0.1);
        chassisRobotDrive41.setSensitivity(0.5);
        chassisRobotDrive41.setMaxOutput(1.0);
        
        rollersSpeedController =  new Jaguar(1,7);
	//LiveWindow.addSensor("Lifter", "Potentiometer 1", lifterPotentiometer);

        lifterSpeedController = new Jaguar(1, 6);
	//LiveWindow.addActuator("Rollers", "Speed Controller 6", (Talon) rollersSpeedController6);
        
        firingSpeedController = new Jaguar(1,5);
       // LiveWindow.addActuator("Firing", "Speed Controller 7", (Talon) firingSpeedController7);

        /*
        DECLARE ANALOG SENSORS (in order, please)
        */
        
        lifterPotentiometer = new AnalogChannel(1, 1);
        
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

        gearShifter = new Solenoid(1,1);
        clawSolenoid = new Solenoid(1,3);
        
        //Digital IO Ports
        somesuchi5 = new Encoder(1, 1, 1, 2, false);//, EncodingType.k4X);
        somesuchi5.start();
        somesuchi6 = new Encoder(1, 8, 1, 9, false);//, EncodingType.k4X);
        somesuchi6.start();
        inPosition = new DigitalInput(1,10);
        compin = new DigitalInput(1,14);
        compout = new Relay(7);
        
    }
}
