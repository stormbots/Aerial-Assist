/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2811.AerialAssist.commands;

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
        
        //Drive control needs to be disabled by any means necessary
        /** use RobotMap not OI. */
        if (OI.stickEngaged = true){
            RobotMap.chassisSpeedController1.set(OI.joystick1.getRawAxis(1));
            RobotMap.chassisSpeedController2.set(OI.joystick1.getRawAxis(1));
            RobotMap.chassisSpeedController3.set(OI.joystick1.getRawAxis(2));
            RobotMap.chassisSpeedController4.set(OI.joystick1.getRawAxis(2));
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
