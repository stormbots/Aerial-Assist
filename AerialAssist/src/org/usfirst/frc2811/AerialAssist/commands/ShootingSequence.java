/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** very good use of CommandGroup, but it still isn't fully fledged.
 *
 * @author 128925
 */
public class ShootingSequence extends CommandGroup {
    
    public ShootingSequence() {
        this.addSequential(new Shoot());//make sure to add this.
        this.addParallel(new ReArm());//why addParallel?
        this.addParallel(new ReLoad());
    }
}
