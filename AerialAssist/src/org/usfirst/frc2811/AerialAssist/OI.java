
package org.usfirst.frc2811.AerialAssist;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc2811.AerialAssist.commands.AimToggle;
import org.usfirst.frc2811.AerialAssist.commands.AutoAim;
import org.usfirst.frc2811.AerialAssist.commands.ReLoadA;
import org.usfirst.frc2811.AerialAssist.commands.ReLoadB;
import org.usfirst.frc2811.AerialAssist.commands.ShiftGear;
import org.usfirst.frc2811.AerialAssist.commands.ShootingSequence;
import org.usfirst.frc2811.AerialAssist.commands.TrussGroup;
import org.usfirst.frc2811.AerialAssist.commands.UnLoad;
import org.usfirst.frc2811.AerialAssist.commands.tempshoot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
   public static Joystick joystick1;
   
    public static JoystickButton truss;
   public JoystickButton shift;
   //public JoystickButton b3; 
   //public JoystickButton b4;
   public JoystickButton autoAim;
   public JoystickButton shoot;
   public JoystickButton spitBall;
   public JoystickButton suckBall;
   //public JoystickButton b9;
   public JoystickButton manual;
    public JoystickButton shoot;
    
   public static int FORE_BACK_STICK= 3;//joystick for controlling robot in freedom
   public static final int FORE_BACK_STICK_CONTROLLER = 3;
   public static final int FORE_BACK_STICK_JOYSTICK = 1;
   public static int LEFT_RIGHT_STICK = 2;
   public static boolean FORE_BACK_DIRECTION = false;//reverses direction of the stick
   public static boolean LEFT_RIGHT_DIRECTION = false;
   
   public OI() {
        
        joystick1 = new Joystick(1);
              
        truss = new JoystickButton(joystick1, 1);
        shift = new JoystickButton(joystick1, 2);
       spitBall = new JoystickButton(joystick1, 3);
       suckBall = new JoystickButton(joystick1, 4);
       punt = new JoystickButton(joystick1, 5);
        shoot = new JoystickButton(joystick1, 6);
        spitBall = new JoystickButton(joystick1, 7);
        suckBall = new JoystickButton(joystick1, 8);
        //b9 = new JoystickButton(joystick1, 9);
        manual = new JoystickButton(joystick1, 10);
        
        truss.whenPressed(new TrussGroup());
        shift.whenPressed(new ShiftGear());
        //b3.whileHeld(null); 
        //b4.whileHeld(null);
       shoot.whenPressed(new tempshoot());
        autoAim.whileHeld(new AutoAim());
        spitBall.whenPressed(new UnLoad());
        suckBall.whenPressed(new ReLoadA());
        suckBall.whenReleased(new ReLoadB());
        //b9.whenReleased(null);
        manual.whenReleased(new AimToggle());
    }
        
    public Joystick getJoystick1() {
        return joystick1;
    }

    
    public static boolean stickEngaged=true;
    public static boolean armed=true;
    public static boolean shootMotors;
    public static boolean punchActive=false;
    public static boolean autoAimEnable=true;
}

