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
        System.out.println("Claw Open");
        this.addSequential(new AutoAim());
        System.out.println("Aimed");
        this.addSequential(new JoystickDisable());
        System.out.println("Joystick Disabled");
        this.addSequential(new Shoot());
        System.out.println("Fired");
        this.addSequential(new JoystickEnable());
        System.out.println("Joystick Enabled");
        this.addSequential(new ReArmFast());
        System.out.println("Fast ReArm Done"); 
        this.addSequential(new ReArmSlow());
        System.out.println("Slow ReArm Done");
        this.addSequential(new CloseClaw());
        System.out.println("Claw Closed");
        System.out.println("Shooting Sequence done");
        //TODO Add LCD Printouts
    }
}
