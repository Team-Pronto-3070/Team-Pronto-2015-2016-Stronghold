package org.usfirst.frc.team3070.robot;

import org.usfirst.frc.team3070.robot.ProntoShooter.ShooterState;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

public class ProntoShooter implements Pronstants {
	interface ShooterState {
		public ShooterState check();
	}

	static ShooterState state;
	static Joystick joyLeft, joyRight;
	static Encoder enLeftShoot, enRightShoot;
	static CANTalon leftShoot, rightShoot;

	// Used to calculate how long the driver holds and shoot depending on this
	// number.
	static int holdTime;
	public ProntoShooter(){
		
	}
	enum ShooterStates implements ShooterState {

		Shoot {
			@Override
			public ShooterState check() {
				shoot();
				return ShootStop;
			}
		},
		ShootStop {
			@Override
			public ShooterState check() {
				if (joyRight.getTrigger()) {
					//add to hold time
					holdTime++;
					
					//check speeds of shooting wheels and correct
					checkSpeeds();
					
					// start shooter
					
					
					if (holdTime >= 100) {
						holdTime = 0;
						return Shoot;
					}
				}
				holdTime = 0;
				return ShootStop;
			}
		}

	}

	public static void periodic() {
		state = state.check();
	}
	public static void shoot(){
		//push ball into already spinning wheels
	}
	public static void checkSpeeds(){
		if(enLeftShoot.get()>enRightShoot.get()){
			//adjust speed
		}else if(enRightShoot.get()>enLeftShoot.get()){
			//adjust speed
		}
	}
}
