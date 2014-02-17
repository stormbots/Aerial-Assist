/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Austin
 */
public class TrussGroup extends CommandGroup {
    
    public TrussGroup() {
        this.addParallel(new OpenClaw(),.5);
        this.addSequential(new SetToAngle(30),3); // setting indegrees to 60
        this.addSequential(new Wait(.5));// make sure claw done opening
        this.addSequential(new Shoot());
        this.addSequential(new Wait(.5));// let motor on shoot run
        this.addSequential(new SetToZero());
       // this.addSequential(new ReArmFast());
    }
}
