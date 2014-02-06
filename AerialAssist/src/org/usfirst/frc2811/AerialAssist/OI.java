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
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton shootButton;
    public JoystickButton ballCatch;
    public JoystickButton release;
    public static Solenoid punch;
    public static Joystick joystick1;
    public static JoystickButton b1; 
    public static JoystickButton b2; 
    public static JoystickButton b3; 
    public static JoystickButton b4; 
    public static JoystickButton b5; 
    public static JoystickButton b6; 
    public static JoystickButton b7; 
    public static JoystickButton b8; 
    public static JoystickButton b9; 
    public static JoystickButton b10;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        
        
        //release = new JoystickButton(joystick1, 3);
        //release.whileHeld(new SpitBall());
        
        //shootButton = new JoystickButton(joystick1, 1);
        //shootButton.whenPressed(new Shoot());
        
       // ballCatch = new JoystickButton(joystick1, 2);
        //ballCatch.whileHeld(new GrabBall());

	    
        // SmartDashboard Buttons
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
            joystick1 = new Joystick(1);
    b1 = new JoystickButton(joystick1, 1);
    b2 = new JoystickButton(joystick1, 2);
    b3 = new JoystickButton(joystick1, 3);
    b4 = new JoystickButton(joystick1, 4);
    b5 = new JoystickButton(joystick1, 5);
    b6 = new JoystickButton(joystick1, 6);
    b7 = new JoystickButton(joystick1, 7);
    b8 = new JoystickButton(joystick1, 8);
    b9 = new JoystickButton(joystick1, 9);
    b10 = new JoystickButton(joystick1, 10);
    
        b1.whenActive(new PrepareToFire());
        b6.whenActive(new FireBall());
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    
    
   
   
}

