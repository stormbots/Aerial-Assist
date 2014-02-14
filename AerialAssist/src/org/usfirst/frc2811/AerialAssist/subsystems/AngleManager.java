/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.AerialAssist.Robot;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.commands.AutoAim;

/**
 * calculates the arm angle we need to use to score in the high goal
 * @author 2811
 */
public class AngleManager extends Subsystem {
    public static double rangeInInches;
    public static double rangeMagicNumber;
    public static AnalogChannel rangeFinderLeft = RobotMap.rangeFinder8;
    public static AnalogChannel rangeFinderRight = RobotMap.rangeFinder9;
    //FIXME We don't need to read these variables, since this subsystem actually should e setting them.
    double rangeLeft = RobotMap.range1;
    double rangeRight = RobotMap.range2;
    double trueRange = RobotMap.trueRange;
    double distance = RobotMap.distance;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new AutoAim());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void getRange(){
        //Read the two rangefinder sensors
        rangeLeft = rangeFinderLeft.getAverageVoltage();
        rangeRight = rangeFinderRight.getAverageVoltage();
        
    }
    
   
    public void rangeManager(){
        //TODO This probably doesn't need to be a seperate function than getRange
        
         //finds larger value, sets trueRange to it.    
        if(rangeLeft>rangeRight){
            trueRange=rangeLeft;
        }
        else{
            trueRange=rangeRight;
        }
        //Convert raw sensor reading into feet
        distance = Robot.map.Map(trueRange,RobotMap.rangeAt5,RobotMap.rangeAt10,5,10);
        
        //FIXME Delete these two, as Map will return the distnace in feet without magic numbers
        //rangeInInches=trueRange/rangeMagicNumber; //finds rangeInInches
        //distance = rangeInInches/12; //converts to feet
        
        //TODO Write the sensorvalues back to RobotMap so we can show them on the Driver Staion for testing
        
    }
    /**
     * Returns the angle needed to shoot a target at the current range
     */
    public double calculate(){
        //FIXME Nowhere in the code does it call getRange or rangeManager
        //We should make sure we use those to actually update our sensor values
        
    //Leave this comment    
    //                 ___________________
    //                /(V^4-g(gx^2+2yv^2))
    //              V
    // atan( V^2 -  -----------------------
    //                        gx            )
        double velocity = 35;//TODO need to get value (in FPS) (calibrate)
        double veloc2= velocity*velocity;// velocity squared
        double veloc4 = velocity*velocity*velocity*velocity;//velocity to the 4th power
        double gravity = 32.173;//gravity
        double distance2 = distance*distance; //distance (from sensor) squared
        double height = 8.4375;// height of the goal
        double disgrav= distance*gravity;//distance times gravity
        double disgrav2 = distance2*gravity; //distance squared times velocity
        double equa1 = (gravity*((disgrav2)+(2*height*veloc2))); // all of the equation that belongs under the square root
        double equa2 = Math.sqrt(veloc4-equa1);// The square root of velocity to the forth - equation one
        double equa3 = equa2/disgrav; // equation two divided gravity times distance
        double atan = MathUtils.atan(equa3);// arc tangent of equation 3
        return Math.toDegrees(atan);// converted to degrees
        
    }
    
}
