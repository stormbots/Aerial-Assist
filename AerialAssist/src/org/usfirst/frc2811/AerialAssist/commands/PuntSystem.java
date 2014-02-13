/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 * Command group for handling the steps necessary for punting the ball //Not the same as Punt
 * @author Kelson
 */
public class PuntSystem extends CommandGroup {
    
    public PuntSystem() {
        if (RobotMap.puntedState==false){
            RobotMap.puntedState=true;
            this.addSequential(new Punt(true));
            this.addSequential(new Wait(1));
            this.addSequential(new Punt(false));
            RobotMap.puntedState=false;
        }
    }
}