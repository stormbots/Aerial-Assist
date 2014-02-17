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
        this.addSequential(new SetToAngle(60),3); // setting indegrees to 60
        this.addSequential(new Wait(.5));// make sure claw done opening
        this.addSequential(new Shoot());
        this.addSequential(new Wait(.5));// let motor on shoot run
        this.addSequential(new SetToZero());
        this.addSequential(new ReArmFast()); 
        //TODO Add Truss command group
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
