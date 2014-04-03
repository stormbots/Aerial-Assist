package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2811.AerialAssist.OI;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author 2811 
 */
public class AutonomousCommand extends CommandGroup {
    public AutonomousCommand(int mode) {
        if(mode==0){
            //single ball a rangefinder.
            //System.out.println("Simple auto command started");
            //this.addSequential(new JoystickDisable());
            this.addSequential(new RollOff());
            this.addSequential(new ReLoad());
            this.addSequential(new Wait(.25),.25);
            this.addSequential(new SetToAngle(65));
            this.addSequential(new DriveTimer(3.5));
            //this.addSequential(new DriveTimer(3));
            ///* Uncomment this comment to disable additional autonomous
            //this.addSequential(new SetToAngle(RobotMap.MaximumArmAngle));
            //this.addSequential(new DriveUntil(7.0),2);
            //System.out.println("finished driving");
            //this.addSequential(new JoystickEnable());
            this.addParallel(new DriveStop());
            this.addSequential(new Wait(.5),.5);
            this.addSequential(new UnsafeArming());
            //System.out.println("set to angle" );
            this.addSequential(new ShootingSequence());
            //System.out.println("shoot");
            this.addSequential(new SetToZero());
            this.addSequential(new UnsafeArming());
            //*/
        }
        else if(mode==1){
            //Single ball with range finder
            System.out.println("Auto command started");
            System.out.println("distance "+RobotMap.distance);
           
            this.addSequential(new SetTolerance(5));
            this.addSequential(new ReLoad());
            this.addSequential(new Wait(.25),.25);
            this.addSequential(new SetToAngle(45));
            this.addSequential(new DriveTimer(2.5));
            this.addSequential(new DriveUntil(6.5),.7);
            this.addParallel(new DriveStop());
            this.addSequential(new Wait(.25),.25);
            this.addSequential(new SetTolerance(5));
            this.addSequential(new SetToAngle(60));
            this.addSequential(new Wait(.25),.25);
            this.addSequential(new ShootingSequence());
            this.addSequential(new SetTolerance(2));
            this.addSequential(new SetToZero());
            this.addSequential(new UnsafeArming());
                        
        }
        else if(mode==2){
            //Attempt two balls
        }
    }
}
