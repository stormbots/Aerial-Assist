/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Driver
 */
public class ReArmGroup extends CommandGroup {
    
    public ReArmGroup() {
        this.addSequential(new SetToAngle(15));
        System.out.println("set angle to fifteen");
        //this.addSequential(new Wait(2));
        this.addSequential(new Arming());
        System.out.println("armed setting to zero");
        //this.addSequential(new SetToZero());
    }
}
