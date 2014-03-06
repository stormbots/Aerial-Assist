/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/** 
 * 
 * Fires and reloads in one command group.
 * @author Austin
 */
public class ShootingSequence extends CommandGroup {
    //stop rollers
    //fire
    //rearm
    public ShootingSequence() {
        
        System.out.println("ShootingSequence");
        RobotMap.shootPrint = "Shooting Sequence Started";
        //RobotMap.openClaw.start(); //Causes Robots don't quit
        //this.addSequential(new JoystickDisable());        
        this.addSequential(new RollOff());
        this.addSequential(new Shoot());
        //this.addSequential(new Wait(1));
        //this.addSequential(new JoystickEnable());
        this.addSequential(new ReArmGroup());
        
        
        
    }
}
