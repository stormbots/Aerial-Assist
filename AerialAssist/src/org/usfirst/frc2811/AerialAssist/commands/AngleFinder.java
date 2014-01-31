/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author Laurel Bingham
 */
public class AngleFinder extends Command {
    public double goalAngle = 0;
    public AngleFinder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    //         The Equation: ...BEHOLD ITS GLORY!!!!!!
    //                _____________________
    //               /V^4-g(g*x^2+2y*v^2)
    //             V
    //atan( V^2 -  ________________________ 
    //                        g*x                   )
    
    //
    //
     public double calculate(double theta){
        double velocity = 35;//need to get value
        double veloc2= velocity*velocity;// velocity squared
        double veloc4 = velocity*velocity*velocity*velocity;//velocity to the 4th power
        double gravity = 32.173;//gravity
        double distance2 = RobotMap.distance*RobotMap.distance; //distance squared
        double height = 8.4375;// height of the goal
        double disgrav= RobotMap.distance*gravity;//distance times gravity
        double disgrav2 = distance2*gravity; //distance squared times velocity
        double equa1 = (gravity*((disgrav2)+(2*height*veloc2))); // all of the equation that belongs under the square root
        double equa2 = Math.sqrt(veloc4-equa1);// The square root of velocity to the forth - equation one
        double equa3 = equa2/disgrav; // equation two divided gravity times distance
        double atan = MathUtils.atan(equa3);// arc tangent of equation 3
        double angle = Math.toDegrees(atan);// converted to degrees
       
        return angle;
                }
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    calculate(90);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
