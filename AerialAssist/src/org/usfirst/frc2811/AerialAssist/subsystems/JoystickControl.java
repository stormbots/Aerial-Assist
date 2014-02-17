/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author 2811
 */
public class JoystickControl extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void JoystickMove() {
        
        if (OI.stickEngaged == true){
            /*
            RobotMap.chassisSpeedController1.set(OI.joystick1.getRawAxis(1)); 
            RobotMap.chassisSpeedController2.set(OI.joystick1.getRawAxis(1)); 
            RobotMap.chassisSpeedController3.set(OI.joystick1.getRawAxis(2)); 
            RobotMap.chassisSpeedController4.set(OI.joystick1.getRawAxis(2));
            //*/
            //System.out.println("Joystick enabled, Step on it!");
            
        }
        else{
           /* RobotMap.chassisSpeedController1.set(0); 
            RobotMap.chassisSpeedController2.set(0); 
            RobotMap.chassisSpeedController3.set(0); 
            RobotMap.chassisSpeedController4.set(0);
            //System.out.println("Joystick disabled; you'll mess up the shot!!");
                   //*/
       }
    }
    
    public void AimToggle(){
        
    }
    
    }

