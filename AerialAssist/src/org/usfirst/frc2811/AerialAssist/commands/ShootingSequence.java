/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

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
        this.addSequential(new OpenClaw());
        
        this.addSequential(new AutoAim());
        this.addParallel(new JoystickDisable());
        
        this.addSequential(new Shoot());
        
        this.addSequential(new JoystickEnable());
        this.addParallel(new ReArmFast());
        
        this.addSequential(new ReArmSlow());
        this.addParallel(new CloseClaw());
    }
}
