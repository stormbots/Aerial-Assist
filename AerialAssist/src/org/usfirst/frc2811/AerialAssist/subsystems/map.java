package org.usfirst.frc2811.AerialAssist.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.AerialAssist.RobotMap;


/**
 * Maps an input range to an output range
 * Useful for converting raw sensor values into more readable values, and vice-versa
 * input: The current input value  (eg, 300 from a potentiometer)
 * maximum and minimum: The range of our input values (eg, 0 to 1024, for a analogRAW reading)
 * outputMax and outputMin: range of the output value (eg, 0'-10')
 * @author 2811
 */
public class map extends Subsystem {

    public double map(double input, double maximum, double minimum, double outputMax, double outputMin){
        double output = (input/(maximum-minimum)-minimum/(maximum-minimum))*(outputMax-outputMin)+outputMin;
        return output;  
        }


     public void initDefaultCommand() {
        setDefaultCommand(new map());
    }

        
}
