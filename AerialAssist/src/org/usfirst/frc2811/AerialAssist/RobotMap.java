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
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController rollersSpeedController6;
    public static Compressor Compressor1;
    public static SpeedController chassisSpeedController1;
    public static SpeedController chassisSpeedController2;
    public static SpeedController chassisSpeedController3;
    public static SpeedController chassisSpeedController4;
    public static RobotDrive chassisRobotDrive41;
    public static AnalogChannel lifterPotentiometer1;
    public static SpeedController lifterSpeedController5;
    public static Encoder shooterQuadratureEncoder2;
    public static SpeedController firingSpeedController7;
    public static AnalogChannel rangeFinder8;
    public static AnalogChannel rangeFinder9;
    public static AnalogChannel rangeFinderClaw;
    public static Solenoid punter4;
    public static Solenoid gearShifter3;
    
    public static AnalogChannel pot1 = new AnalogChannel(1);
    //public static AnalogChannel range = new AnalogChannel(2);//TODO use rangeFinder8
    public static AnalogChannel pot2 = new AnalogChannel(3);
    //public static AnalogChannel range2 = new AnalogChannel(3);//TODO use rangeFinder9
    public static AnalogChannel temp1 = new AnalogChannel(5);
    public static AnalogChannel temp2 = new AnalogChannel(6);
    public static AnalogChannel temp3 = new AnalogChannel(7);
    
    //public static int rangeValue = range.getAverageValue();
    //public static int range2Value = range2.getAverageValue();
    public static int largerValue;
    public static boolean reloadedState;
    public static boolean puntedState;
    public static double distance;
    public static double range1;
    public static double range2;
    public static double clawRange;
    public static double shootingAngle;
    public static boolean aimedState;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        firingSpeedController7 = new Talon(1,7);
        LiveWindow.addActuator("Firing", "Speed Controller 7", (Talon) firingSpeedController7);
        
        rollersSpeedController6 = new Talon(1, 6);
	LiveWindow.addActuator("Rollers", "Speed Controller 6", (Talon) rollersSpeedController6);
        
        //Compressor1 = new Compressor(1, 1, 1, 1);
	rangeFinderClaw= new AnalogChannel(1,10);
        chassisSpeedController1 = new Talon(1, 1);
	//LiveWindow.addActuator("Chassis", "Speed Controller 1", (Talon) chassisSpeedController1);
        
        //chassisSpeedController2 = new Talon(1, 2);
	//LiveWindow.addActuator("Chassis", "Speed Controller 2", (Talon) chassisSpeedController2);
        
        chassisSpeedController3 = new Talon(1, 3);
	//LiveWindow.addActuator("Chassis", "Speed Controller 3", (Talon) chassisSpeedController3);
        
        chassisSpeedController4 = new Talon(1, 4);
	//LiveWindow.addActuator("Chassis", "Speed Controller 4", (Talon) chassisSpeedController4);
        
        chassisRobotDrive41 = new RobotDrive(chassisSpeedController1, chassisSpeedController2,
              chassisSpeedController3, chassisSpeedController4);
	
        chassisRobotDrive41.setSafetyEnabled(false);
        chassisRobotDrive41.setExpiration(0.1);
        chassisRobotDrive41.setSensitivity(0.5);
        chassisRobotDrive41.setMaxOutput(1.0);

        lifterPotentiometer1 = new AnalogChannel(1, 1);
	//LiveWindow.addSensor("Lifter", "Potentiometer 1", lifterPotentiometer1);
        
        rangeFinder8 = new AnalogChannel(1,8);
        LiveWindow.addSensor("Angle", "Range Finder 1" , rangeFinder8);
        
        rangeFinder9 = new AnalogChannel(1,9);
        LiveWindow.addSensor("Angle", "Range Finder 2", rangeFinder9);
        
        
        gearShifter3 = new Solenoid(1,1);
        
        punter4 = new Solenoid(1,2);
        
        //TODO @kelson Do we need both encoders here?
  //      shooterQuadratureEncoder2 = new Encoder(1, 2, 1, 3, false, EncodingType.k4X);
        shooterQuadratureEncoder2.setPIDSourceParameter(PIDSourceParameter.kRate);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
       
          
        
    }
}
