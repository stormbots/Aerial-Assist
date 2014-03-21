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
        this.addSequential(new DriveTimer(3));
        
        ///* Uncomment this comment to disable additional autonomous
        this.addSequential(new SetToAngle(20));
        this.addSequential(new DriveUntil(7.0),2);
        //System.out.println("finished driving");
        //this.addSequential(new JoystickEnable());
        this.addParallel(new DriveStop());
        this.addSequential(new SetToAngle(50));
        this.addSequential(new Wait(.75),.75);
        //this.addParallel(new DriveStop(),3);
        //System.out.println("set to angle" );
        this.addSequential(new Shoot());
        this.addSequential(new Wait(.5),.5);
        //System.out.println("shoot");
        this.addSequential(new Arming());
        this.addSequential(new Wait(1),1);
        this.addSequential(new SetToZero());
        //*/
        
   }
}
