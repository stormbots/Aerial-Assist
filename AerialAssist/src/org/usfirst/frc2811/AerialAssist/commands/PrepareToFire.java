/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.OI;

/**
 *
 * @author Jacob
 */
public class PrepareToFire extends Command {

    protected void initialize() {
        OI.armed = true;
        OI.stickEngaged = false;
        System.out.println("Stick disabled ===========================");

    }

    protected void execute() {
       System.out.println("Ready to Fire!");

        
        
        }
        
    

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
