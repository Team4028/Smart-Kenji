package org.usfirst.frc.team4028.robot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.usfirst.frc.team4028.robot.constants.Enums.DIGITAL_MODE_BUTTON;
import org.usfirst.frc.team4028.robot.constants.Enums.MODE_CHOICE;
import org.usfirst.frc.team4028.robot.subsystems.DC_Motor;
import org.usfirst.frc.team4028.robot.subsystems.Dashboard;
import org.usfirst.frc.team4028.robot.subsystems.DriversStation2;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;


public class Robot extends IterativeRobot 
{
	
	// Declare all global robot objects. 
	// Hi
	//Hello, Soy soup	
	
	DC_Motor _motor1;
	DC_Motor _motor2;
	DC_Motor _motor3;
	DC_Motor _motor4;
	DriversStation2 _driversStation;
	Dashboard _dashboard;
	DataLogger _dataLogger;
	LogData _logData;
	

	public void robotInit() 
	{	
		// Write jar (build) date and time to the dashboard. 
		Utilities.WriteBuildInfoToDashboard();
		
		_motor1 = new DC_Motor(RobotMap.MOTOR_ADDRESS, "MTR 1");
		_motor2 = new DC_Motor(RobotMap.MOTOR2_ADDRESS, "MTR 2");
		_motor3 = new DC_Motor(RobotMap.MOTOR3_ADDRESS, "MTR 3");
		_motor4 = new DC_Motor(RobotMap.MOTOR4_ADDRESS, "MTR 4");
		_driversStation = new DriversStation2(RobotMap.DRIVERS_GAMEPAD, RobotMap.OPERATOR_GAMEPAD);
		_dashboard = new Dashboard();
			
	}
	
	public void autonomousInit() 
	{
		setupLogging("Auton");
	}


	public void autonomousPeriodic() 
	{
		LogData logData = new LogData();
		logData.Motor1Actual = 0;
		_dataLogger.WriteData(logData);
	}
	
	public void teleopInit() 
	{
		setupLogging("Teleop");
		
		_dashboard.readConfigValues();
	
		_motor1.set_brakeMode(_dashboard.get_isMotor1BrakeMode());
		_motor2.set_brakeMode(_dashboard.get_isMotor2BrakeMode());
		_motor3.set_brakeMode(_dashboard.get_isMotor3BrakeMode());
		_motor4.set_brakeMode(_dashboard.get_isMotor4BrakeMode());
		
		_motor1.set_latchMode(_dashboard.get_isMotor1LatchMode());
		_motor2.set_latchMode(_dashboard.get_isMotor2LatchMode());
		_motor3.set_latchMode(_dashboard.get_isMotor3LatchMode());
		_motor4.set_latchMode(_dashboard.get_isMotor4LatchMode());
		
		_motor1.set_scalingFactor(_dashboard.get_motor1CMDScalingFactor());
		_motor2.set_scalingFactor(_dashboard.get_motor2CMDScalingFactor());
		_motor3.set_scalingFactor(_dashboard.get_motor3CMDScalingFactor());
		_motor4.set_scalingFactor(_dashboard.get_motor4CMDScalingFactor());
		
		_motor1.set_reverseMode(_dashboard.get_isMotor1Reverse());
		_motor2.set_reverseMode(_dashboard.get_isMotor2Reverse());
		_motor3.set_reverseMode(_dashboard.get_isMotor3Reverse());
		_motor4.set_reverseMode(_dashboard.get_isMotor4Reverse());
	}
	
	public void teleopPeriodic() 
	{
		_driversStation.ReadCurrentScanCycleValues();
		// Motor 1: Set motor to a speed according to the modes chosen (disabled/analog and latch) 

		if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.DISABLED)
		 {
			 _motor1.MotorTurn(0.0);
		 }
		 else if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.ANALOG)
		 {
			 _motor1.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor1Joystick()));
		 }
		 else if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.DIGITAL)
		 {
		 	if (_motor1.get_latchMode()) 
		 	{
		 		if (isButtonJustPressed(_dashboard.get_motor1Button())) {
		 			_motor1.ToggleMotorTurn();
		 		}
		 	}
		 	else 
		 	{
		 		if (_driversStation.get_buttonCommand(_dashboard.get_motor1Button())) {
		 		{
		 			_motor1.MotorTurn(1.0);
		 		}
		 	}
		 		else {
		 			_motor1.MotorTurn(0.0);
		 		}
		 	}
	

			if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.DISABLED)
			 {
				 _motor1.MotorTurn(0.0);
			 }
			 else if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.ANALOG)
			 {
				 _motor1.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor1Joystick()));
			 }
			 else if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.DIGITAL)
			 {
			 	if (_motor1.get_latchMode()) 
			 	{
			 		if (isButtonJustPressed(_dashboard.get_motor1Button())) {
			 			_motor1.ToggleMotorTurn();
			 		}
			 	}
			 	else 
			 	{
			 		if (_driversStation.get_buttonCommand(_dashboard.get_motor1Button())) {
			 		{
			 			_motor1.MotorTurn(1.0);
			 		}
			 	}
			 		else {
			 			_motor1.MotorTurn(0.0);
			 		}
			 	}
		
	
		}
}
		
		// Motor 2: Set motor to a speed according to the modes chosen (disabled/analog and latch)
				if(_dashboard.get_motor2ModeChoice() == MODE_CHOICE.DISABLED)
				{
					_motor2.MotorTurn(0.0);
				}
				else if(_dashboard.get_motor2ModeChoice() == MODE_CHOICE.ANALOG)
				{
					_motor2.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor2Joystick()));
				}
				else if(_dashboard.get_motor2ModeChoice() == MODE_CHOICE.DIGITAL)
			 		{
					if (_motor2.get_latchMode()) 
					{
						if (isButtonJustPressed(_dashboard.get_motor2Button())) {
			 			_motor2.ToggleMotorTurn();
					}
			 	}
			 	else 
			 	{
			 		if (_driversStation.get_buttonCommand(_dashboard.get_motor2Button())) {
			 		{
			 			_motor2.MotorTurn(1.0);
			 		}
			 	}
			 		else {
			 			_motor2.MotorTurn(0.0);
			 		}
			 	}
		
				if(_dashboard.get_motor2ModeChoice() == MODE_CHOICE.DISABLED)
				 {
					 _motor2.MotorTurn(0.0);
				 }
				 else if(_dashboard.get_motor2ModeChoice() == MODE_CHOICE.ANALOG)
				 {
					 _motor2.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor2Joystick()));
				 }
				 else if(_dashboard.get_motor2ModeChoice() == MODE_CHOICE.DIGITAL)
				 {
				 	if (_motor2.get_latchMode()) 
				 	{
				 		if (isButtonJustPressed(_dashboard.get_motor2Button())) {
				 			_motor2.ToggleMotorTurn();
				 		}
				 	}
				 	else 
				 	{
				 		if (_driversStation.get_buttonCommand(_dashboard.get_motor2Button())) {
				 		{
				 			_motor2.MotorTurn(1.0);
				 		}
				 	}
				 		else {
				 			_motor2.MotorTurn(0.0);
				 		}
				 	}
			
		
			}
		}
				
		// Motor 3: Set motor to a speed according to the modes chosen (disabled/analog and latch)

				if(_dashboard.get_motor3ModeChoice() == MODE_CHOICE.DISABLED)
				 {
					 _motor3.MotorTurn(0.0);
				 }
				 else if(_dashboard.get_motor3ModeChoice() == MODE_CHOICE.ANALOG)
				 {
					 _motor3.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor3Joystick()));
				 }
				 else if(_dashboard.get_motor3ModeChoice() == MODE_CHOICE.DIGITAL)
				 {
				 	if (_motor3.get_latchMode()) 
				 	{
				 		if (isButtonJustPressed(_dashboard.get_motor3Button())) {
				 			_motor3.ToggleMotorTurn();
				 		}
				 	}
				 	else 
				 	{
				 		if (_driversStation.get_buttonCommand(_dashboard.get_motor3Button())) {
				 		{
				 			_motor3.MotorTurn(1.0);
				 		}
				 	}
				 		else {
				 			_motor3.MotorTurn(0.0);
				 		}
				 	}
			
				 	if(_dashboard.get_motor3ModeChoice() == MODE_CHOICE.DISABLED)
					 {
						 _motor3.MotorTurn(0.0);
					 }
					 else if(_dashboard.get_motor3ModeChoice() == MODE_CHOICE.ANALOG)
					 {
						 _motor3.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor3Joystick()));
					 }
					 else if(_dashboard.get_motor3ModeChoice() == MODE_CHOICE.DIGITAL)
					 {
					 	if (_motor3.get_latchMode()) 
					 	{
					 		if (isButtonJustPressed(_dashboard.get_motor3Button())) {
					 			_motor3.ToggleMotorTurn();
					 		}
					 	}
					 	else 
					 	{
					 		if (_driversStation.get_buttonCommand(_dashboard.get_motor3Button())) {
					 		{
					 			_motor3.MotorTurn(1.0);
					 		}
					 	}
					 		else {
					 			_motor3.MotorTurn(0.0);
					 		}
					 	}
			
				}
		}
		
		// Motor 4: Set motor to a speed according to the modes chosen (disabled/analog and latch)
		
					if(_dashboard.get_motor4ModeChoice() == MODE_CHOICE.DISABLED)
					 {
						 _motor4.MotorTurn(0.0);
					 }
					 else if(_dashboard.get_motor4ModeChoice() == MODE_CHOICE.ANALOG)
					 {
						 _motor4.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor4Joystick()));
					 }
					 else if(_dashboard.get_motor4ModeChoice() == MODE_CHOICE.DIGITAL)
					 {
					 	if (_motor4.get_latchMode()) 
					 	{
					 		if (isButtonJustPressed(_dashboard.get_motor4Button())) {
					 			_motor4.ToggleMotorTurn();
					 		}
					 	}
					 	else 
					 	{
					 		if (_driversStation.get_buttonCommand(_dashboard.get_motor4Button())) {
					 		{
					 			_motor4.MotorTurn(1.0);
					 		}
					 	}
					 		else {
					 			_motor4.MotorTurn(0.0);
					 		}
					 	}
				

						if(_dashboard.get_motor4ModeChoice() == MODE_CHOICE.DISABLED)
						 {
							 _motor4.MotorTurn(0.0);
						 }
						 else if(_dashboard.get_motor4ModeChoice() == MODE_CHOICE.ANALOG)
						 {
							 _motor4.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor4Joystick()));
						 }
						 else if(_dashboard.get_motor4ModeChoice() == MODE_CHOICE.DIGITAL)
						 {
						 	if (_motor4.get_latchMode()) 
						 	{
						 		if (isButtonJustPressed(_dashboard.get_motor4Button())) {
						 			_motor4.ToggleMotorTurn();
						 		}
						 	}
						 	else 
						 	{
						 		if (_driversStation.get_buttonCommand(_dashboard.get_motor4Button())) {
						 		
						 			_motor4.MotorTurn(1.0);
						 		
						 	}
						 		else {
						 			_motor4.MotorTurn(0.0);
						 		}
						 	}
						 	
				
						}
		
			
		}
						
		UpdateDashboard();		
		
		_logData = new LogData();
		_logData.Motor1Actual = _motor1.get_ActualMotorSpeed();
		_logData.Motor1Command = _motor1.get_ScaledMotorCommand();
		_logData.Motor2Actual = _motor2.get_ActualMotorSpeed();
		_logData.Motor2Command = _motor2.get_ScaledMotorCommand();
		_logData.Motor3Actual = _motor3.get_ActualMotorSpeed();
		_logData.Motor3Command = _motor3.get_ScaledMotorCommand();
		_logData.Motor4Actual = _motor4.get_ActualMotorSpeed();
		_logData.Motor4Command = _motor4.get_ScaledMotorCommand();
		_dataLogger.WriteData(_logData);

	}
				
	public void testPeriodic() {
		setupLogging("test");
	}
	
	private void setupLogging(String mode)
	{
		Path path = Paths.get(RobotMap.LOG_FILE_PATH);
		
		_logData = new LogData();
		
			if (Files.exists(path))
			{
				try
				{
					DriverStation.reportWarning("Try Started", true);
					
					_dataLogger =  new DataLogger(RobotMap.LOG_FILE_PATH, mode);
					DriverStation.reportWarning("File Created", true);
					
					_dataLogger.WriteData(LogData.BuildTSVHeader());
					DriverStation.reportWarning("Writing Headers to File", true);
					
					_logData.LogFilePathName = _dataLogger.LogFilePathName;
					Date now = new Date();
					_logData.LoggingStartedDT = now.getTime();
					_logData.LastScanDT = now.getTime();
					_logData.IsLoggingEnabled = true;		
					DriverStation.reportWarning("File Time Stamped", true);
				}
				catch (IOException e)
				{
					e.printStackTrace();
					
					_dataLogger = null;
					_logData.IsLoggingEnabled = false;
					DriverStation.reportWarning("File Not Created", true);
				}
			}
			else //Make a method in here that looks for sda1, not sdb1
			{
				_dataLogger = null;
				_logData.LogFilePathName = "";
				_logData.IsLoggingEnabled = false;
				DriverStation.reportWarning("USB Not Found", true);
			}
		}
		
	public void UpdateDashboard()
	{
		_motor1.UpdateDashboard();
		_motor2.UpdateDashboard();
		_motor3.UpdateDashboard();
		_motor4.UpdateDashboard();
	}
	private boolean isButtonJustPressed (DIGITAL_MODE_BUTTON button)
	{
		switch (button)
		{
		case DRIVER_BLUE_X: 
			return _driversStation.get_isDriverButtonXJustPressed();
		case DRIVER_GREEN_A:
			return _driversStation.get_isDriverButtonAJustPressed();
		case DRIVER_RED_B:
			return _driversStation.get_isDriverButtonBJustPressed();
		case DRIVER_YELLOW_Y:
			return _driversStation.get_isDriverButtonYJustPressed();
		case OPERATOR_BLUE_X:
			return _driversStation.get_isOperatorButtonXJustPressed();
		case OPERATOR_GREEN_A:
			return _driversStation.get_isOperatorButtonAJustPressed();
		case OPERATOR_RED_B:
			return _driversStation.get_isOperatorButtonBJustPressed();
		case OPERATOR_YELLOW_Y:
			return _driversStation.get_isOperatorButtonYJustPressed();
		
		default:
			return false;
	
		}
	}
	
	/*public void FooBar()
	{
		_driversStation.ReadCurrentScanCycleValues();
		
		DoSomethingToMotor(_motor1);
		DoSomethingToMotor(_motor2);
		DoSomethingToMotor(_motor3);
		DoSomethingToMotor(_motor4);
	}
	
	private void DoSomethingToMotor(DC_Motor thisMotor)
	{

		if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.DISABLED)
		 {
			thisMotor.MotorTurn(0.0);
		 }
		 else if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.ANALOG)
		 {
			 thisMotor.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor1Joystick()));
		 }
		 else if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.DIGITAL)
		 {
		 	if (_motor1.get_latchMode()) 
		 	{
		 		if (isButtonJustPressed(_dashboard.get_motor1Button())) {
		 			_motor1.ToggleMotorTurn();
		 		}
		 	}
		 	else 
		 	{
		 		if (_driversStation.get_buttonCommand(_dashboard.get_motor1Button())) {
		 		{
		 			_motor1.MotorTurn(1.0);
		 		}
		 	}
		 		else {
		 			_motor1.MotorTurn(0.0);
		 		}
		 	}
	

			if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.DISABLED)
			 {
				 _motor1.MotorTurn(0.0);
			 }
			 else if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.ANALOG)
			 {
				 _motor1.MotorTurn(_driversStation.get_motorCommand(_dashboard.get_motor1Joystick()));
			 }
			 else if(_dashboard.get_motor1ModeChoice() == MODE_CHOICE.DIGITAL)
			 {
			 	if (_motor1.get_latchMode()) 
			 	{
			 		if (isButtonJustPressed(_dashboard.get_motor1Button())) {
			 			_motor1.ToggleMotorTurn();
			 		}
			 	}
			 	else 
			 	{
			 		if (_driversStation.get_buttonCommand(_dashboard.get_motor1Button())) {
			 		{
			 			_motor1.MotorTurn(1.0);
			 		}
			 	}
			 		else {
			 			_motor1.MotorTurn(0.0);
			 		}
			 	}
		
	
		}
}
	}
	
	*/
	
}

