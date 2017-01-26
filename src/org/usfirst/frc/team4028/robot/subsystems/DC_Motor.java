package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.constants.Enums.CMD_LATCH_MODE;
import org.usfirst.frc.team4028.robot.constants.Enums.REVERSE_CHOICE;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DC_Motor 
{

	private CANTalon _motor;
	private double _scalingFactor = 1.0;
	private String _motorName;
	private boolean _isLatchModeEnabled;
	private double _scaleMotorCommand;
	private boolean _isReverseMode;
	
	
	
	public DC_Motor (int CANTalonAddress, String motorName)
	{
		_motor= new CANTalon(CANTalonAddress);
		
		_motor.ConfigFwdLimitSwitchNormallyOpen(true);
		_motor.ConfigRevLimitSwitchNormallyOpen(true);
		_motor.enableLimitSwitch(false, false);
		
		_isReverseMode = false;
		
		_motorName = motorName;
	}
	
	
	public void UpdateDashboard ()
	{
		double actualMotorSpeed = _motor.get();
		SmartDashboard.putNumber(_motorName + " VBUS Percentage", actualMotorSpeed);
	}
	
	public double get_ScaledMotorCommand ()
	{
		return _scaleMotorCommand;
	}
	
	public double get_ActualMotorSpeed ()
	{
		double actualMotorSpeed = _motor.get();
		return actualMotorSpeed;
	}
	
	//Handles analog mode and digital mode (not latching)
	public void MotorTurn (double motorCommand)
	{
		double directionFactor = -1;
		
		if (_isReverseMode)
		{
			directionFactor =1;
		}
		
		_scaleMotorCommand = motorCommand * _scalingFactor * directionFactor;
		_motor.set(_scaleMotorCommand);
		System.out.println(_scaleMotorCommand);
		
		
	}
	
	// Handles digital mode (latching)
	public void ToggleMotorTurn()
	{
		// if motor is running, stop it 
		if (_motor.get() < 0.0 || _motor.get() > 0.0)
		{
			MotorTurn(0.0);
		}
		// else start it
		else 
		{
			MotorTurn(1.0);
		}
		
	}
	
	public void set_brakeMode(boolean isBrakeModeOn)
	{
		_motor.enableBrakeMode(isBrakeModeOn);
		
	}
	
	public void set_latchMode (CMD_LATCH_MODE latchMode)
	{
		switch (latchMode)
		{
			case UNDEFINED: 
				_isLatchModeEnabled = false;	 
				break;
		
			case DISABLED:
				_isLatchModeEnabled = false;
				break;
		
			case ENABLED:
				_isLatchModeEnabled = true;
				break;
	
		}
	}
	
	public boolean get_latchMode()
	{
		return _isLatchModeEnabled;
	}
	
	public void set_scalingFactor(double scalingFactor)
	{
		_scalingFactor = scalingFactor;

	}
	
	public void set_reverseMode(REVERSE_CHOICE isReverseMode)
	{
		switch (isReverseMode)
		{
		case REVERSE:
			_isReverseMode = true;
			break;
		
		default:
			_isReverseMode = false;
			break;
		}
		
	}
	
	
	
}
