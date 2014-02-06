/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author Jacob
 */
public class JoystickAllow extends Command {
   
    
     protected void initialize() {
        
    }

    protected void execute() {
        if (OI.stickEngaged = true){
            OI.motor8.set(OI.joystick1.getRawAxis(1));
            OI.motor9.set(OI.joystick1.getRawAxis(1));
            OI.motor10.set(OI.joystick1.getRawAxis(2));
            OI.motor11.set(OI.joystick1.getRawAxis(2));
            System.out.println("Joystick enabled, Step on it!");
            
        }else{
            System.out.println("Joystick disabled; you'll mess up the shot!!");
                    }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
