/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.AerialAssist.RobotMap;
import org.usfirst.frc2811.AerialAssist.commands.Reload;

/**
 *
 * @author 128925
 */
public class Reloader extends Subsystem {
    Encoder quadratureEncoder2 = RobotMap.shooterQuadratureEncoder2;
    public SpeedController reloadMotor = RobotMap.firingSpeedController7;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
        
    public void initDefaultCommand() {
        setDefaultCommand(new Reload());
    }
    public void reloadMotors(){
        if(RobotMap.reloadedstate==false)  
            reloadMotor.set(-.5);
            Timer.delay(.5);
            RobotMap.reloadedstate=true;
    }
    
}
