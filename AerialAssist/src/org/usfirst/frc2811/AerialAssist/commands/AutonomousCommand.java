package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author 2811
 */
public class AutonomousCommand extends CommandGroup {
        
    public AutonomousCommand() {
        System.out.println("Auto command started");
        this.addSequential(new DriveUntil(7.0));
        this.addSequential(new ShootingSequence());
        this.addSequential(new SetToZero());
    }
}
