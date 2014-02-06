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

import org.usfirst.frc2811.AerialAssist.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton shootButton;
    public JoystickButton ballCatch;
    public JoystickButton release;
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static int FORE_BACK_STICK;//joystick for controlling robot in freedom
    public static final int FORE_BACK_STICK_CONTROLLER = 3;
    public static final int FORE_BACK_STICK_JOYSTICK = 1;
    public static int LEFT_RIGHT_STICK;
    public static boolean FORE_BACK_DIRECTION;//reverses direction of the stick
    public static boolean LEFT_RIGHT_DIRECTION;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        

        joystick1 = new Joystick(1);
        
        release = new JoystickButton(joystick1, 3);
        release.whileHeld(new PuntTheBall());
        
        //release = new JoystickButton(joystick1, 3);
        //release.whileHeld(new SpitBall());
        
        //shootButton = new JoystickButton(joystick1, 1);
        //shootButton.whenPressed(new Shoot());
        
       // ballCatch = new JoystickButton(joystick1, 2);
        //ballCatch.whileHeld(new GrabBall());

	    
        // SmartDashboard Buttons
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public static Joystick joystick1 = new Joystick(1);
    
    /** bad bad bad bad bad bad use RobotMap to declare motors and AnalogChannels. */
//    //public static AnalogChannel pot1 = new AnalogChannel(1);
//    public static AnalogChannel range = new AnalogChannel(2);
//    //public static AnalogChannel pot2 = new AnalogChannel(3);
//    public static AnalogChannel range2 = new AnalogChannel(3);
//    public static AnalogChannel temp1 = new AnalogChannel(5);
//    public static AnalogChannel temp2 = new AnalogChannel(6);
//    public static AnalogChannel temp3 = new AnalogChannel(7);
//    
//    public static int rangeValue = range.getAverageValue();
//    public static int range2Value = range2.getAverageValue();
//    public static int largerValue;
    
    public static boolean stickEngaged = true;
    public static boolean armed;
    public static boolean shootMotors;
    public static boolean punchActive;
    
    //public static SpeedController motor1 = new Jaguar(1,1);
    //public static SpeedController motor2 = new Jaguar(1,2);
    //public static SpeedController motor3 = new Victor(1,3);
    //public static SpeedController motor4 = new Victor(1,4);
    //public static SpeedController motor5 = new Victor(1,5);
    //public static SpeedController motor6 = new Victor(1,6);
    public static SpeedController motor8 = new Victor(1,8);
    public static SpeedController motor9 = new Victor(1,9);
    public static SpeedController motor10 = new Victor(1,10);
    public static SpeedController motor11 = new Victor(1,11);
    //public static JoystickButton longShot = new JoystickButton(joystick1, 6);
    //public static JoystickButton botArm = new JoystickButton(joystick1, 1);
    
    //public static Solenoid punch = new Solenoid(1,2);
    
//    public static DriverStationLCD dsText;
    
    
    /** Don't declare things you don't use. */
    //the button section!
//    JoystickButton b1 = new JoystickButton(joystick1, 1);
//    JoystickButton b2 = new JoystickButton(joystick1, 2);
//    JoystickButton b3 = new JoystickButton(joystick1, 3);
//    JoystickButton b4 = new JoystickButton(joystick1, 4);
//    JoystickButton b5 = new JoystickButton(joystick1, 5);
//    JoystickButton b6 = new JoystickButton(joystick1, 6);
//    JoystickButton b7 = new JoystickButton(joystick1, 7);
//    JoystickButton b8 = new JoystickButton(joystick1, 8);
//    JoystickButton b9 = new JoystickButton(joystick1, 9);
//    JoystickButton b10 = new JoystickButton(joystick1, 10);
   
}

