/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author Jacob
 */
public class ShotMotors extends Command {

    protected void initialize() {
        RobotMap.motor1.set(10);
        RobotMap.motor2.set(10);
        RobotMap.shootMotors = true;
        System.out.print("Motors Activated");
        
    }

    protected void execute() {
        System.out.println("ShotMotors");
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
