package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.constants.Enums.ANALOG_MODE_JOYSTICK;
import org.usfirst.frc.team4028.robot.constants.Enums.DIGITAL_MODE_BUTTON;
import org.usfirst.frc.team4028.robot.constants.LogitechF310;

import edu.wpi.first.wpilibj.Joystick;

public class DriversStation2 {
	
	public DriverStationInputs _currentValues;
	public DriverStationInputs _previousValues;
	
	private Joystick _driverGamepad;
	private Joystick _operatorGamepad;


	public DriversStation2 (int driverGamePad, int operatorGamePad)
	{
		_driverGamepad = new Joystick(driverGamePad);
		_operatorGamepad = new Joystick(operatorGamePad);
		
	}


	
	public double get_motorCommand(ANALOG_MODE_JOYSTICK joystickNumber)
	{
		switch (joystickNumber)
		{
			case DRIVER_LEFT_X_AXIS:
				return _driverGamepad.getRawAxis(LogitechF310.LEFT_X_AXIS);
		
			case DRIVER_LEFT_Y_AXIS:
				return _driverGamepad.getRawAxis(LogitechF310.LEFT_Y_AXIS);
				
			case DRIVER_RIGHT_X_AXIS:
				return _driverGamepad.getRawAxis(LogitechF310.RIGHT_X_AXIS);
				
			case DRIVER_RIGHT_Y_AXIS:
				return _driverGamepad.getRawAxis(LogitechF310.RIGHT_Y_AXIS);
			
			case OPERATOR_LEFT_X_AXIS:
				return _operatorGamepad.getRawAxis(LogitechF310.LEFT_X_AXIS);
		
			case OPERATOR_LEFT_Y_AXIS:
				return _operatorGamepad.getRawAxis(LogitechF310.LEFT_Y_AXIS);

			case OPERATOR_RIGHT_X_AXIS:
				return _operatorGamepad.getRawAxis(LogitechF310.RIGHT_X_AXIS);
			
			case OPERATOR_RIGHT_Y_AXIS:
				return _operatorGamepad.getRawAxis(LogitechF310.RIGHT_Y_AXIS);
				
			default: 
				return 0.0;
			
			
		}

	}
	
	public boolean get_buttonCommand(DIGITAL_MODE_BUTTON buttonNumber)
	{
		switch (buttonNumber)
		{
		case DRIVER_GREEN_A:
			return _driverGamepad.getRawButton(LogitechF310.GREEN_BUTTON_A);
		
		case DRIVER_BLUE_X:
			return _driverGamepad.getRawButton(LogitechF310.BLUE_BUTTON_X);
			
		case DRIVER_RED_B:
			return _driverGamepad.getRawButton(LogitechF310.RED_BUTTON_B);
		
		case DRIVER_YELLOW_Y:
			return _driverGamepad.getRawButton(LogitechF310.YELLOW_BUTTON_Y);
			
		case OPERATOR_BLUE_X: 
			return _operatorGamepad.getRawButton(LogitechF310.BLUE_BUTTON_X);
			
		case OPERATOR_GREEN_A:
			return _operatorGamepad.getRawButton(LogitechF310.GREEN_BUTTON_A);
		
		case OPERATOR_RED_B:
			return _operatorGamepad.getRawButton(LogitechF310.RED_BUTTON_B);
			
		case OPERATOR_YELLOW_Y:
			return _operatorGamepad.getRawButton(LogitechF310.YELLOW_BUTTON_Y);
			
		default:
			return false;
			
		}
	}
	
	
		

	
	public void ReadCurrentScanCycleValues()
	{
		_previousValues = null;
		
		if (_currentValues != null)
		{
			_previousValues = _currentValues;
		}
		
		_currentValues = new DriverStationInputs (_driverGamepad, _operatorGamepad);
		
		if (_previousValues == null)
		{
			_previousValues = _currentValues;
		}
	}
	
	public boolean get_isDriverButtonAJustPressed()
	{
		return (_currentValues.get_isDriversButtonAPressed() && !_previousValues.get_isDriversButtonAPressed());
		
	}
	
	public boolean get_isDriverButtonBJustPressed()
	{
		return (_currentValues.get_isDriversButtonBPressed() && !_previousValues.get_isDriversButtonBPressed());
	}
	
	public boolean get_isDriverButtonXJustPressed()
	{
		return (_currentValues.get_isDriversButtonXPressed() && !_previousValues.get_isDriversButtonXPressed());
	}
	
	public boolean get_isDriverButtonYJustPressed()
	{
		return (_currentValues.get_isDriversButtonYPressed() && !_previousValues.get_isDriversButtonYPressed());
	}
	
	public boolean get_isOperatorButtonAJustPressed()
	{
		return (_currentValues.get_isOperatorsButtonAPressed() && !_previousValues.get_isOperatorsButtonAPressed());
	}
	
	
	public boolean get_isOperatorButtonBJustPressed()
	{
		return (_currentValues.get_isOperatorsButtonBPressed() && !_previousValues.get_isOperatorsButtonBPressed());
	}
	
	
	public boolean get_isOperatorButtonXJustPressed()
	{
		return (_currentValues.get_isOperatorsButtonXPressed() && !_previousValues.get_isOperatorsButtonXPressed());
	}
	
	public boolean get_isOperatorButtonYJustPressed()
	{
		return (_currentValues.get_isOperatorsButtonYPressed() && !_previousValues.get_isOperatorsButtonYPressed());
	}
	
	
	
	
	
	public final class DriverStationInputs 
	{
		private boolean isDriverButtonAPressed;
		private boolean isDriverButtonBPressed;
		private boolean isDriverButtonXPressed;
		private boolean isDriverButtonYPressed;
		private boolean isOperatorButtonAPressed;
		private boolean isOperatorButtonBPressed;
		private boolean isOperatorButtonXPressed;
		private boolean isOperatorButtonYPressed;

		public DriverStationInputs (Joystick driverGamepad, Joystick operatorGamepad)
		{
			isDriverButtonAPressed = driverGamepad.getRawButton(LogitechF310.GREEN_BUTTON_A);
			isDriverButtonBPressed = driverGamepad.getRawButton(LogitechF310.RED_BUTTON_B);
			isDriverButtonXPressed = driverGamepad.getRawButton(LogitechF310.BLUE_BUTTON_X);
			isDriverButtonYPressed = driverGamepad.getRawButton(LogitechF310.YELLOW_BUTTON_Y);
			isOperatorButtonAPressed = operatorGamepad.getRawButton(LogitechF310.GREEN_BUTTON_A);
			isOperatorButtonBPressed = operatorGamepad.getRawButton(LogitechF310.RED_BUTTON_B);
			isOperatorButtonXPressed = operatorGamepad.getRawButton(LogitechF310.BLUE_BUTTON_X);
			isOperatorButtonYPressed = operatorGamepad.getRawButton(LogitechF310.YELLOW_BUTTON_Y);
			
		}
		
		public boolean get_isDriversButtonAPressed()
		{
			return isDriverButtonAPressed;
		}
		
		public boolean get_isDriversButtonBPressed()
		{
			return isDriverButtonBPressed;
		}
		
		public boolean get_isDriversButtonXPressed()
		{
			return isDriverButtonXPressed;
		}
		
		public boolean get_isDriversButtonYPressed()
		{
			return isDriverButtonYPressed;
		}
		
		public boolean get_isOperatorsButtonAPressed()
		{
			return isOperatorButtonAPressed;
		}
		
		public boolean get_isOperatorsButtonBPressed()
		{
			return isOperatorButtonBPressed;
		}
		
		public boolean get_isOperatorsButtonXPressed()
		{
			return isOperatorButtonXPressed;
		}
		
		public boolean get_isOperatorsButtonYPressed()
		{
			return isOperatorButtonYPressed;
		}
	}
}
