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
 * Fires and reloads in one command group: Mapped to trigger.
 * @author Austin
 */
public class ShootingSequence extends CommandGroup {
    //open claw
    //auto aim
    //disable joystick
    //fire
    //enable joystick
    //rearm && close claw
    public ShootingSequence() {
        System.out.println("ShootingSequence");
        RobotMap.shootPrint = "Shooting Sequence Started";
        //RobotMap.openClaw.start(); //Causes Robots don't quit
        this.addSequential(new AutoAim());       
        this.addSequential(new JoystickDisable());        
        this.addSequential(new OpenClaw());
        this.addSequential(new Wait(2));
        this.addSequential(new Shoot(2));
        this.addSequential(new Wait(2));
        this.addSequential(new JoystickEnable());
        this.addSequential(new ReArmFast());
        this.addSequential(new Wait(2));
        this.addSequential(new ReArmSlow());
        this.addSequential(new Wait(2));
        this.addSequential(new CloseClaw());
        this.addSequential(new Wait(2));
           
        //TODO Add LCD Printouts
    }
}
