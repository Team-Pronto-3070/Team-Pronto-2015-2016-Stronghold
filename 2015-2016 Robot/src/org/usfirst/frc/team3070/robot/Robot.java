
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3070.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class Robot extends IterativeRobot implements Pronstants{
	
	//initialize hardware variables
	CANTalon left, right;
	Encoder enLeft, enRight;
	Joystick joyLeft, joyRight;
	
    public void robotInit() {
    	//initialize motors and encoders
    	left=new CANTalon(LEFT);
    	right=new CANTalon(RIGHT);
    	
    	enLeft=new Encoder(LEFT_FIRST, LEFT_SECOND);
    	enLeft=new Encoder(RIGHT_FIRST, RIGHT_SECOND);
    	
    	//initialize joystick
    	joyLeft = new Joystick(JOYSTICK_PORT_LEFT);
    	joyRight = new Joystick(JOYSTICK_PORT_RIGHT);
    }
	
	public void disabledPeriodic() {

	}

    public void autonomousInit() {
    	
    }

    public void autonomousPeriodic() {
        		
    }

    public void teleopInit() {
		
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
    	left.set(joyLeft.getY(null));
    	right.set(joyRight.getY(null));
    	
    	
    }
    
    public void testPeriodic() {
      
    }
}
