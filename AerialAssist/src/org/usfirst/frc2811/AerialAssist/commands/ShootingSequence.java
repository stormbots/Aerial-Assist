/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** 
 * 
 * very good use of CommandGroup, but it still isn't fully fledged.
 * @author 128925
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
        this.addParallel(new CloseClaw());
    }
}
