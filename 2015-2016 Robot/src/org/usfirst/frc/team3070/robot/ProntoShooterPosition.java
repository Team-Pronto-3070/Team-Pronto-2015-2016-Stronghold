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
				return Up;
			}
		},
		Down {
			@Override
			public ShooterPosition check() {
				return Down;
			}
		},
		StartUp {
			@Override
			public ShooterPosition check() {
				return Up;
			}
		},
		StartDown {
			@Override
			public ShooterPosition check() {
				return Down;
			}
		},

	}
	public static void periodic() {
		state = state.check();
	}
}
