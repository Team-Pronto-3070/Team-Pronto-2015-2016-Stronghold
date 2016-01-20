package org.usfirst.frc.team3070.robot;

import org.usfirst.frc.team3070.robot.ProntoShooter.ShooterState;

import edu.wpi.first.wpilibj.Joystick;

public class ProntoShooter implements Pronstants {
	interface ShooterState {
		public ShooterState check();
	}

	static ShooterState state;
	static Joystick joyLeft, joyRight;
	
	//Used to calculate how long the driver holds and shoot depending on this number.
	static int holdTime;
		
	enum ShooterStates implements ShooterState {

		Shoot {
			@Override
			public ShooterState check() {
				return ShootStop;
			}
		},
		ShootStop {
			@Override
			public ShooterState check() {
				if(joyRight.getTrigger()){
					holdTime++;
					//move shooter into position
					//start shooter
					if(holdTime>=100){
						return Shoot;
					}
				}else if(!joyRight.getTrigger()){
					holdTime=0;
				}
				
				return ShootStop;
			}
		},

	}
	public static void periodic() {
		state = state.check();
	}
}
