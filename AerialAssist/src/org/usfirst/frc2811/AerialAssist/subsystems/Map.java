package org.usfirst.frc2811.AerialAssist.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.AerialAssist.RobotMap;


/**
 * maps a value from one input range to a different output range
 * Useful for converting raw sensor values into more readable values, and vice-versa
 * input: The current input value  (eg, 300 from a potentiometer)
 * maximum and minimum: The range of our input values (eg, 0 to 1024, for a analogRAW reading)
 * outputMax and outputMin: range of the output value (eg, 0'-10')
 * @author 2811
 */
public class Map extends Subsystem {

    // int input = 0;
      double minimum=33; //TODO Find correct input ranges for claw sensor Calibrate
      double maximum=300; 
      double outputMin=0;
      double outputMax=1024; 
        


     public void initDefaultCommand() {
    }

    }

    public double Map(double input, double maximum, double minimum, double outputMax, double outputMin){ 
        double output = (input/(maximum-minimum)-minimum/(maximum-minimum))*(outputMax-outputMin)+outputMin;
        return output; 
        }     
}
