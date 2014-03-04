/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Laurel Bingham
 */
public class AutonomousCommand extends CommandGroup {
    
    public AutonomousCommand() {
        this.addSequential(DriveUntil(7.0));
    }
}
