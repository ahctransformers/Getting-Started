package org.usfirst.frc.team6584.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * @author Nam Tran
 */
public class Robot extends IterativeRobot {
	
	// Ports for the motor controller PWM cables
	private static final int LEFT_MOTOR_FRONT = 0;
	private static final int LEFT_MOTOR_BACK = 1;
	private static final int RIGHT_MOTOR_FRONT = 2;
	private static final int RIGHT_MOTOR_BACK = 3;
	
	// Where the joystick is plugged in
	private static final int DRIVER_GAMEPAD = 0;
	
	RobotDrive myRobot = new RobotDrive(LEFT_MOTOR_FRONT, LEFT_MOTOR_BACK, RIGHT_MOTOR_FRONT, RIGHT_MOTOR_BACK);
	Joystick driverJoystick = new Joystick(DRIVER_GAMEPAD);
	Timer timer = new Timer();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	}

	/**
	 * This function is run once each time the robot enters autonomous mode
	 */
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (timer.get() < 2.0) {
			myRobot.drive(-0.5, 0.0); // drive forwards half speed
		} else {
			myRobot.drive(0.0, 0.0); // stop robot
		}
	}

	/**
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 */
	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		myRobot.arcadeDrive(driverJoystick);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
