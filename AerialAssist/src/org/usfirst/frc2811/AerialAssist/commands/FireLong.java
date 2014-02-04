/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.Robot;

/**
 *
 * @author Jacob
 */
public class FireLong extends Command {

    protected void initialize() {
        if (OI.armed = true){
        OI.motor5.set(10);
        OI.motor6.set(10);
        System.out.println("Shot Motors Activated!");
        Timer.delay(0.1);
        OI.punch.set(true);
        System.out.println("Ball Away!");
        Timer.delay(0.2);
        OI.armed = false;
        System.out.println("armed = " + OI.armed);
        OI.stickEngaged = true;
        Timer.delay(0.5);
        }else{
            System.out.println("Not Ready to Fire!");
        }
        

    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
