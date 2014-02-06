/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Jacob
 */
public class JoystickAllow extends Command {

    protected void initialize() {
        
    }

    protected void execute() {
        /** use RobotMap not OI. */
//        if (OI.stickEngaged = true){
//            OI.motor1.set(OI.joystick1.getRawAxis(1)); VERY VERY BAD, USE ROBOTMAP
//            OI.motor2.set(OI.joystick1.getRawAxis(1)); VERY VERY BAD, USE ROBOTMAP
//            OI.motor3.set(OI.joystick1.getRawAxis(2)); VERY VERY BAD, USE ROBOTMAP
//            OI.motor4.set(OI.joystick1.getRawAxis(2)); VERY VERY BAD, USE ROBOTMAP
//            System.out.println("Joystick enabled, Step on it!");
//            
//        }else{
//            System.out.println("Joystick disabled; you'll mess up the shot!!");
//                    }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
