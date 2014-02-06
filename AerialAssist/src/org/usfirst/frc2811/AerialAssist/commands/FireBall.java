/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2811.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2811.AerialAssist.RobotMap;

/**
 *
 * @author Jacob
 */
public class FireBall extends CommandGroup {
    public FireBall(){
        if (RobotMap.armed = true){
            this.addSequential(new SolSet());
            this.addSequential(new ShotMotors());
            if (RobotMap.punchActive = true){
                if (RobotMap.shootMotors = true){
                    System.out.println("Ball Released!");
                    Timer.delay(0.3);
                    RobotMap.armed = false;
                }
            }
        }
    }
}
