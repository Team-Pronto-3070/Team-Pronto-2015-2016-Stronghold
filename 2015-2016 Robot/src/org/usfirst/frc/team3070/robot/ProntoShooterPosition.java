package org.usfirst.frc.team3070.robot;

import org.usfirst.frc.team3070.robot.ProntoShooterPosition.ShooterPosition;

import edu.wpi.first.wpilibj.Joystick;

public class ProntoShooterPosition implements Pronstants {
	interface ShooterPosition {
		public ShooterPosition check();
	}

	static ShooterPosition state;
	static Joystick joyLeft, joyRight;
	
	//Used to calculate how long the driver holds and shoot depending on this number.
	static int holdTime;
		
	enum ShooterPositions implements ShooterPosition {

		Up {
			@Override
			public ShooterPosition check() {
				ProntoShooter.periodic();
				if(joyLeft.getRawButton(3)){
					return GoingDown;
				}
				return Up;
			}
		},
		Down {
			@Override
			public ShooterPosition check() {
				if(joyLeft.getRawButton(3)){
					return GoingUp;
				}
				return Down;
			}
		},
		GoingUp {
			@Override
			public ShooterPosition check() {
				//move shooter
				//check for limit switch
				return GoingUp;
			}
		},
		GoingDown {
			@Override
			public ShooterPosition check() {
				//move shooter
				//check for limit switch
				return GoingDown;
			}
		},

	}
	public void periodic() {
		state = state.check();
	}
}
