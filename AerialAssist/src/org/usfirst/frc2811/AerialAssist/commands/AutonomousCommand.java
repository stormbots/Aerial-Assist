package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author 2811 
 */
public class AutonomousCommand extends CommandGroup {
        
    public AutonomousCommand() {
        System.out.println("Auto command started");
        //this.addSequential(new SetToZero());
        
//        this.addSequential(new DriveUntil(7.0));
//        this.addSequential (new SetToAngle (70));
//        this.addSequential(new Shoot());
//        this.addSequential(new SetToAngle(15));
//        
//        this.addSequential(new Arming());
//        this.addSequential(new SetToZero());
        
    }

    public AutonomousCommand(boolean b) {
        System.out.println("Simple auto command started");
        //this.addSequential(new JoystickDisable());
        //this.addSequential(new tempForward(.25));
        //this.addSequential(new JoystickEnable());
        //this.addSequential(new DriveTimer(2.0));
        //this.addSequential (new SetToAngle (60));
        //this.addSequential(new ShootingSequence());
        //this.addSequential(new SetToZero());
   }
}
