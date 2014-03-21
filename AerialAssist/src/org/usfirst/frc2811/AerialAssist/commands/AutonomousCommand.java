package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author 2811 
 */
public class AutonomousCommand extends CommandGroup {
        
    public AutonomousCommand() {
        System.out.println("Auto command started");
        System.out.println("distance "+RobotMap.distance);
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
        //System.out.println("Simple auto command started");
        //this.addSequential(new JoystickDisable());
        this.addSequential(new ReLoad());
        this.addSequential(new Wait(.25),.25);
        this.addSequential(new SetToAngle(62.5));
        this.addSequential(new DriveTimer(3.2));
        //this.addSequential(new DriveTimer(3));
        ///* Uncomment this comment to disable additional autonomous
        //this.addSequential(new SetToAngle(RobotMap.MaximumArmAngle));
        //this.addSequential(new DriveUntil(7.0),2);
        //System.out.println("finished driving");
        //this.addSequential(new JoystickEnable());
        this.addParallel(new DriveStop());
        this.addSequential(new Wait(.5),.5);
        //System.out.println("set to angle" );
        this.addSequential(new ShootingSequence());
        //System.out.println("shoot");
        this.addSequential(new SetToZero());
        this.addSequential(new UnsafeArming());
        //*/
        
   }
}
