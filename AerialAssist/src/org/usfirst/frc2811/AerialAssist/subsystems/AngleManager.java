/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.commands.AutoAim;

/**
 * calculates the arm angle we need to use to score in the high goal
 * @author 2811
 */
public class AngleManager extends Subsystem {
    public static double trueRange;
    public static double rangeInInches;
    public static double rangeMagicNumber;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new AutoAim());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void getRange(){
        //Read the two rangefinder sensors
        RobotMap.range1 = RobotMap.rangeFinder8.getAverageVoltage();
        RobotMap.range2 = RobotMap.rangeFinder9.getAverageVoltage();
    }
    
    /*public float mapvalue(float input, float maximum, float minimum, float outputMax, float outputMin){
        float output = (input/(maximum-minimum)-minimum/(maximum-minimum))*(outputMax-outputMin)+outputMin;
        return output;
    }*/
    public void rangeManager(){
        
        //FIXME Get rid of magic numbers, and use map for converting sensordata
        rangeMagicNumber = 21.5;
        if(RobotMap.range1>RobotMap.range2){
            trueRange=RobotMap.range1;
        }
        
        else{
            trueRange=RobotMap.range2;
        }
    //finds larger value, sets trueRange to it.    
        rangeInInches=trueRange/rangeMagicNumber; //finds rangeInInches
        RobotMap.distance = rangeInInches/12; //converts to feet
        
        //Since Laurel's copy of this got delete somehow, it should look like this:
        //map( trueRange, sensor_value_at_5_feet, sensor_value_at_10_feet, 5,10);
    }
      
    public double calculate(){
    //TODO Look at this beautifully commented code. Excellent work Laurel!
    //                 ___________________
    //                /(V^4-g(gx^2+2yv^2))
    //              V
    // atan( V^2 -  -----------------------
    //                        gx            )
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
        return Math.toDegrees(atan);// converted to degrees
        
    }
    //TODO delete this copy of the map, since we have it in Subsystems
    /*
    public float mapvalue(float input, float maximum, float minimum, float outputMax, float outputMin){
        float output = (input/(maximum-minimum)-minimum/(maximum-minimum))*(outputMax-outputMin)+outputMin;
        return output;
    }
     */
}
