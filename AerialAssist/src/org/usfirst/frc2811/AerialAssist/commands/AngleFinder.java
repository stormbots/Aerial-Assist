/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.commands;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Command;
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
    //               /V^4-g(gx^2+2yv^2)
    //             V
    //atan( V^2 -   
    //         ---------------------------------
    //                           gx                   )
    
    //
    //
     public double calculate(double theta){
        double velocity = 35;
        double veloc2= velocity*velocity;// velocity squared
        double veloc4 = velocity*velocity*velocity*velocity;//velocity to the 4th
        double gravity = 32.173;//gravity
        double distance = 10; // not a constant 
        double distance2 = distance*distance;
        double hight = 8.4375;// hight of the goal
        double disgrav= distance*gravity;
        double disgrav2 = distance2*gravity; //distance squared times velocity
        double equa1 = (gravity*((disgrav2)+(2*hight*veloc2))); // all of the equation that belogs under the square root
        double equa2 = Math.sqrt(veloc4-equa1);// The squareroot of velocity to the forth - equation one
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
