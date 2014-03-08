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
        
        //RobotMap.shootPrint = "Shooting Sequence Started";
        //RobotMap.openClaw.start(); //Causes Robots don't quit
        //this.addSequential(new JoystickDisable());        
        this.addSequential(new RollOff());
        this.addSequential(new Shoot());
        //this.addSequential(new JoystickEnable());
        this.addSequential(new SetToAngle(15));
        //this.addSequential(new Wait(2));
        this.addSequential(new SetTolerance(15));
        this.addSequential(new Arming());
        this.addSequential(new SetTolerance(3));
        //this.addSequential(new SetToZero());
        
        
        System.out.println("heyo shooting sequence over");
    }
}
