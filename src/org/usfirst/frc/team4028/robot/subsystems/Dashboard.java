package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.constants.Enums.ANALOG_MODE_JOYSTICK;
import org.usfirst.frc.team4028.robot.constants.Enums.CMD_LATCH_MODE;
import org.usfirst.frc.team4028.robot.constants.Enums.DIGITAL_MODE_BUTTON;
import org.usfirst.frc.team4028.robot.constants.Enums.MODE_CHOICE;
import org.usfirst.frc.team4028.robot.constants.Enums.REVERSE_CHOICE;
import org.usfirst.frc.team4028.robot.constants.LogitechF310;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	// Motor One Choosers
	SendableChooser _motor1BrakeModeChooser;
	SendableChooser _motor1JoystickChooser;
	SendableChooser _motor1ScalingChooser;
	SendableChooser _motor1ButtonChooser;
	SendableChooser _motor1ModeChooser;
	SendableChooser _motor1LatchChooser;
	SendableChooser _motor1ReverseChooser;
	
	// Motor Two Choosers
	SendableChooser _motor2BrakeModeChooser;
	SendableChooser _motor2JoystickChooser;
	SendableChooser _motor2ScalingChooser;
	SendableChooser _motor2ButtonChooser;
	SendableChooser _motor2ModeChooser;
	SendableChooser _motor2LatchChooser;
	SendableChooser _motor2ReverseChooser;
	
	// Motor Three Choosers
	SendableChooser _motor3BrakeModeChooser;
	SendableChooser _motor3JoystickChooser; 
	SendableChooser _motor3ScalingChooser; 
	SendableChooser _motor3ButtonChooser;
	SendableChooser _motor3ModeChooser;
	SendableChooser _motor3LatchChooser;
	SendableChooser _motor3ReverseChooser;
	
	// Motor Four Choosers
	SendableChooser _motor4BrakeModeChooser; 
	SendableChooser _motor4JoystickChooser; 
	SendableChooser _motor4ScalingChooser;
	SendableChooser _motor4ButtonChooser;
	SendableChooser _motor4ModeChooser;
	SendableChooser _motor4LatchChooser;
	SendableChooser _motor4ReverseChooser;
	
	// Motor One Variables
	private boolean _motor1BrakeModeChoice;
	private ANALOG_MODE_JOYSTICK _motor1JoystickNumber;
	private double _motor1ScalingValue;
	private DIGITAL_MODE_BUTTON _motor1ButtonNumber;
	private MODE_CHOICE _motor1ModeChoice; 
	private double _motor1Percentage;
	private CMD_LATCH_MODE _motor1LatchMode;
	private REVERSE_CHOICE _motor1ReverseChoice;
	
	// Motor Two Variables
	private ANALOG_MODE_JOYSTICK _motor2JoystickNumber;
	private double _motor2ScalingValue;
	private boolean _motor2BrakeModeChoice;
	private DIGITAL_MODE_BUTTON _motor2ButtonNumber;
	private MODE_CHOICE _motor2ModeChoice;
	private CMD_LATCH_MODE _motor2LatchMode;
	private REVERSE_CHOICE _motor2ReverseChoice;
	
	// Motor Three Variables
	private boolean _motor3BrakeModeChoice;
	private ANALOG_MODE_JOYSTICK _motor3JoystickNumber;
	private double _motor3ScalingValue;
	private DIGITAL_MODE_BUTTON _motor3ButtonNumber;
	private MODE_CHOICE _motor3ModeChoice;
	private CMD_LATCH_MODE _motor3LatchMode;
	private REVERSE_CHOICE _motor3ReverseChoice;
	
	// Motor Four Variables
	private boolean _motor4BrakeModeChoice;
	private ANALOG_MODE_JOYSTICK _motor4JoystickNumber;
	private double _motor4ScalingValue;
	private DIGITAL_MODE_BUTTON _motor4ButtonNumber; 
	private MODE_CHOICE _motor4ModeChoice; 
	private CMD_LATCH_MODE _motor4LatchMode;
	private REVERSE_CHOICE _motor4ReverseChoice;
	
	public Dashboard ()
	{
	System.out.println("Top of method");
	
		// Options for MOTOR ONE: Analog/Digital, Brake Mode, Joystick Choice, Button Choice, and Scaling Factor 
		_motor1LatchChooser = new SendableChooser();
		
		_motor1LatchChooser.addDefault("Disabled(1)", CMD_LATCH_MODE.DISABLED);
		_motor1LatchChooser.addObject("Enabled", CMD_LATCH_MODE.ENABLED);
		
		SmartDashboard.putData("Motor 1 Latch Mode", _motor1LatchChooser);
		
		_motor1ReverseChooser = new SendableChooser();
		
		_motor1ReverseChooser.addObject("Forward(1)", REVERSE_CHOICE.FORWARD);
		_motor1ReverseChooser.addObject("Reverse", REVERSE_CHOICE.REVERSE);
		
		SmartDashboard.putData("Motor 1 Reverse", _motor1ReverseChooser);
		
		_motor1ModeChooser = new SendableChooser();
		
		_motor1ModeChooser.addObject("Disabled(1)", MODE_CHOICE.DISABLED);
		_motor1ModeChooser.addObject("Analog", MODE_CHOICE.ANALOG);
		_motor1ModeChooser.addObject("Digital", MODE_CHOICE.DIGITAL);
		
		SmartDashboard.putData("Motor 1 Mode Choice", _motor1ModeChooser);
		
		_motor1BrakeModeChooser = new SendableChooser();
		
		_motor1BrakeModeChooser.addObject("On (1)", true);
		_motor1BrakeModeChooser.addObject("Off", false);
		
		SmartDashboard.putData("Motor 1 Brake Mode", _motor1BrakeModeChooser);
		 
		_motor1JoystickChooser = new SendableChooser();
		
		_motor1JoystickChooser.addObject("Driver Left Y Axis (1)", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_Y_AXIS);
		_motor1JoystickChooser.addObject("Driver Left X Axis", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_X_AXIS);
		_motor1JoystickChooser.addObject("Driver Right Y Axis", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_Y_AXIS);
		_motor1JoystickChooser.addObject("Driver Right X Axis", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_X_AXIS);
		_motor1JoystickChooser.addObject("Operator Left Y Axis", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_Y_AXIS);
		_motor1JoystickChooser.addObject("Operator Left X Axis", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_X_AXIS);
		_motor1JoystickChooser.addObject("Operator Right Y Axis", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_Y_AXIS);
		_motor1JoystickChooser.addObject("Operator Right X Axis", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_X_AXIS);
		
		SmartDashboard.putData("Motor 1 Joystick", _motor1JoystickChooser);
		
		_motor1ButtonChooser = new SendableChooser();
		
		_motor1ButtonChooser.addObject("Driver Green A (1)", DIGITAL_MODE_BUTTON.DRIVER_GREEN_A);
		_motor1ButtonChooser.addObject("Driver Red B", DIGITAL_MODE_BUTTON.DRIVER_RED_B);
		_motor1ButtonChooser.addObject("Driver Blue X", DIGITAL_MODE_BUTTON.DRIVER_BLUE_X);
		_motor1ButtonChooser.addObject("Driver Yellow Y", DIGITAL_MODE_BUTTON.DRIVER_YELLOW_Y);
		_motor1ButtonChooser.addObject("Operator Green A", DIGITAL_MODE_BUTTON.OPERATOR_GREEN_A);
		_motor1ButtonChooser.addObject("Operator Red B", DIGITAL_MODE_BUTTON.OPERATOR_RED_B);
		_motor1ButtonChooser.addObject("Operator Blue X", DIGITAL_MODE_BUTTON.OPERATOR_BLUE_X);
		_motor1ButtonChooser.addObject("Operator Yellow Y", DIGITAL_MODE_BUTTON.OPERATOR_YELLOW_Y);
		
		SmartDashboard.putData("Motor 1 Button", _motor1ButtonChooser);
		 
		_motor1ScalingChooser = new SendableChooser();
				
		_motor1ScalingChooser.addObject("10% (1)", 0.1);
		_motor1ScalingChooser.addObject("25%", 0.25);
		_motor1ScalingChooser.addObject("50%", 0.5);
		_motor1ScalingChooser.addObject("75%", 0.75);
		_motor1ScalingChooser.addObject("Full power", 1.0);
				
		SmartDashboard.putData("Motor 1 Scaling Factor", _motor1ScalingChooser);
		
		// Options for MOTOR TWO: Analog/Digital, Brake Mode, Joystick Choice, Button Choice and Scaling Factor
		
		_motor2LatchChooser = new SendableChooser();
		
		_motor2LatchChooser.addDefault("Disabled(2)", CMD_LATCH_MODE.DISABLED);
		_motor2LatchChooser.addObject("Enabled", CMD_LATCH_MODE.ENABLED);
		
		SmartDashboard.putData("Motor 2 Latch Mode", _motor2LatchChooser);
		
		_motor2ReverseChooser = new SendableChooser();
		
		_motor2ReverseChooser.addObject("Forward(2)", REVERSE_CHOICE.FORWARD);
		_motor2ReverseChooser.addObject("Reverse", REVERSE_CHOICE.REVERSE);
		
		SmartDashboard.putData("Motor 2 Reverse", _motor2ReverseChooser);
		
		_motor2ModeChooser = new SendableChooser();
		
		_motor2ModeChooser.addObject("Disabled(2)", MODE_CHOICE.DISABLED);
		_motor2ModeChooser.addObject("Analog", MODE_CHOICE.ANALOG);
		_motor2ModeChooser.addObject("Digital", MODE_CHOICE.DIGITAL);
		
		SmartDashboard.putData("Motor 2 Mode Choice", _motor2ModeChooser);
		
		_motor2BrakeModeChooser = new SendableChooser();
		
		_motor2BrakeModeChooser.addObject("On (2)", true);
		_motor2BrakeModeChooser.addObject("Off", false);
		
		SmartDashboard.putData("Motor 2 Brake Mode", _motor2BrakeModeChooser);
	
		_motor2JoystickChooser = new SendableChooser();
		
		_motor2JoystickChooser.addObject("Driver Left Y Axis (2)", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_Y_AXIS);
		_motor2JoystickChooser.addObject("Driver Left X Axis", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_X_AXIS);
		_motor2JoystickChooser.addObject("Driver Right Y Axis", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_Y_AXIS);
		_motor2JoystickChooser.addObject("Driver Right X Axis", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_X_AXIS);
		_motor2JoystickChooser.addObject("Operator Left Y Axis", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_Y_AXIS);
		_motor2JoystickChooser.addObject("Operator Left X Axis", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_X_AXIS);
		_motor2JoystickChooser.addObject("Operator Right Y Axis", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_Y_AXIS);
		_motor2JoystickChooser.addObject("Operator Right X Axis", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_X_AXIS);
		
		SmartDashboard.putData("motor2Joystick", _motor2JoystickChooser);
		
		_motor2ButtonChooser = new SendableChooser();
		
		_motor2ButtonChooser.addObject("Driver Green A (2)", DIGITAL_MODE_BUTTON.DRIVER_GREEN_A);
		_motor2ButtonChooser.addObject("Driver Red B", DIGITAL_MODE_BUTTON.DRIVER_RED_B);
		_motor2ButtonChooser.addObject("Driver Blue X", DIGITAL_MODE_BUTTON.DRIVER_BLUE_X);
		_motor2ButtonChooser.addObject("Driver Yellow Y", DIGITAL_MODE_BUTTON.DRIVER_YELLOW_Y);
		_motor2ButtonChooser.addObject("Operator Green A", DIGITAL_MODE_BUTTON.OPERATOR_GREEN_A);
		_motor2ButtonChooser.addObject("Operator Red B", DIGITAL_MODE_BUTTON.OPERATOR_RED_B);
		_motor2ButtonChooser.addObject("Operator Blue X", DIGITAL_MODE_BUTTON.OPERATOR_BLUE_X);
		_motor2ButtonChooser.addObject("Operator Yellow Y", DIGITAL_MODE_BUTTON.OPERATOR_YELLOW_Y);
		
		SmartDashboard.putData("Motor 2 Button", _motor2ButtonChooser);
		
		_motor2ScalingChooser = new SendableChooser();

		_motor2ScalingChooser.addObject("10% (2)", 0.1);
		_motor2ScalingChooser.addObject("25%", 0.25);
		_motor2ScalingChooser.addDefault("50%", 0.5);
		_motor2ScalingChooser.addObject("75%", 0.75);
		_motor2ScalingChooser.addObject("Full power", 1.0);
		
		SmartDashboard.putData("Motor 2 Scaling Factor", _motor2ScalingChooser);
		
		// Options for MOTOR THREE: Latch Mode, Brake Mode, Joystick Choice, and Scaling Factor
		
		_motor3LatchChooser = new SendableChooser();
		
		_motor3LatchChooser.addDefault("Disabled(3)", CMD_LATCH_MODE.DISABLED);
		_motor3LatchChooser.addObject("Enabled", CMD_LATCH_MODE.ENABLED);
		
		SmartDashboard.putData("Motor 3 Latch Mode", _motor3LatchChooser);
		
		_motor3ReverseChooser = new SendableChooser();
		
		_motor3ReverseChooser.addObject("Forward(3)", REVERSE_CHOICE.FORWARD);
		_motor3ReverseChooser.addObject("Reverse", REVERSE_CHOICE.REVERSE);
		
		SmartDashboard.putData("Motor 3 Reverse", _motor3ReverseChooser);
		
		_motor3ModeChooser = new SendableChooser();
		
		_motor3ModeChooser.addObject("Disabled(3)", MODE_CHOICE.DISABLED);
		_motor3ModeChooser.addObject("Analog", MODE_CHOICE.ANALOG);
		_motor3ModeChooser.addObject("Digital", MODE_CHOICE.DIGITAL);
		
		SmartDashboard.putData("Motor 3 Mode Choice", _motor3ModeChooser);
		
		_motor3BrakeModeChooser = new SendableChooser();
		
		_motor3BrakeModeChooser.addObject("On (3)", true);
		_motor3BrakeModeChooser.addObject("Off", false);
		
		SmartDashboard.putData("Motor 3 Brake Mode", _motor3BrakeModeChooser);
		
		_motor3JoystickChooser = new SendableChooser();
		
		_motor3JoystickChooser.addObject("Driver Left Y Axis (3)", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_Y_AXIS);
		_motor3JoystickChooser.addObject("Driver Left X Axis", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_X_AXIS);
		_motor3JoystickChooser.addObject("Driver Right Y Axis", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_Y_AXIS);
		_motor3JoystickChooser.addObject("Driver Right X Axis", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_X_AXIS);
		_motor3JoystickChooser.addObject("Operator Left Y Axis", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_Y_AXIS);
		_motor3JoystickChooser.addObject("Operator Left X Axis", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_X_AXIS);
		_motor3JoystickChooser.addObject("Operator Right Y Axis", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_Y_AXIS);
		_motor3JoystickChooser.addObject("Operator Right X Axis", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_X_AXIS);
		
		SmartDashboard.putData("Motor 3 Joystick", _motor3JoystickChooser);
		
		_motor3ButtonChooser = new SendableChooser();
		
		_motor3ButtonChooser.addObject("Driver Green A (3)", DIGITAL_MODE_BUTTON.DRIVER_GREEN_A);
		_motor3ButtonChooser.addObject("Driver Red B", DIGITAL_MODE_BUTTON.DRIVER_RED_B);
		_motor3ButtonChooser.addObject("Driver Blue X", DIGITAL_MODE_BUTTON.DRIVER_BLUE_X);
		_motor3ButtonChooser.addObject("Driver Yellow Y", DIGITAL_MODE_BUTTON.DRIVER_YELLOW_Y);
		_motor3ButtonChooser.addObject("Operator Green A", DIGITAL_MODE_BUTTON.OPERATOR_GREEN_A);
		_motor3ButtonChooser.addObject("Operator Red B", DIGITAL_MODE_BUTTON.OPERATOR_RED_B);
		_motor3ButtonChooser.addObject("Operator Blue X", DIGITAL_MODE_BUTTON.OPERATOR_BLUE_X);
		_motor3ButtonChooser.addObject("Operator Yellow Y", DIGITAL_MODE_BUTTON.OPERATOR_YELLOW_Y);
		
		SmartDashboard.putData("Motor 3 Button", _motor3ButtonChooser);
		
		_motor3ScalingChooser = new SendableChooser();

		_motor3ScalingChooser.addObject("10% (3)", 0.1);
		_motor3ScalingChooser.addObject("25%", 0.25);
		_motor3ScalingChooser.addObject("50%", 0.5);
		_motor3ScalingChooser.addObject("75%", 0.75);
		_motor3ScalingChooser.addObject("Full power", 1.0);
		
		SmartDashboard.putData("Motor 3 Scale Factor", _motor3ScalingChooser);
		
		// Options for MOTOR FOUR: Brake Mode, Joystick Choice, and Scaling Factor
		
		_motor4LatchChooser = new SendableChooser();
		
		_motor4LatchChooser.addDefault("Disabled(4)", CMD_LATCH_MODE.DISABLED);
		_motor4LatchChooser.addObject("Enabled", CMD_LATCH_MODE.ENABLED);
		
		SmartDashboard.putData("Motor 4 Latch Mode", _motor4LatchChooser);
		
		_motor4ReverseChooser = new SendableChooser();
		
		_motor4ReverseChooser.addObject("Forward(4)", REVERSE_CHOICE.FORWARD);
		_motor4ReverseChooser.addObject("Reverse", REVERSE_CHOICE.REVERSE);
		
		SmartDashboard.putData("Motor 4 Reverse", _motor4ReverseChooser);
		
		_motor4ModeChooser = new SendableChooser();
		
		_motor4ModeChooser.addObject("Disabled(4)", MODE_CHOICE.DISABLED);
		_motor4ModeChooser.addObject("Analog", MODE_CHOICE.ANALOG);
		_motor4ModeChooser.addObject("Digital", MODE_CHOICE.DIGITAL);
		
		SmartDashboard.putData("Motor 4 Mode Choice", _motor4ModeChooser);
		
		_motor4BrakeModeChooser = new SendableChooser();
		
		_motor4BrakeModeChooser.addObject("On (4)", true);
		_motor4BrakeModeChooser.addObject("Off", false);
		
		SmartDashboard.putData("Motor 4 Brake Mode", _motor4BrakeModeChooser);
		
		_motor4JoystickChooser = new SendableChooser();
		
		_motor4JoystickChooser.addObject("Driver Left Y Axis (4)", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_Y_AXIS);
		_motor4JoystickChooser.addObject("Driver Left X Axis", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_X_AXIS);
		_motor4JoystickChooser.addObject("Driver Right Y Axis", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_Y_AXIS);
		_motor4JoystickChooser.addObject("Driver Right X Axis", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_X_AXIS);
		_motor4JoystickChooser.addObject("Operator Left Y Axis", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_Y_AXIS);
		_motor4JoystickChooser.addObject("Operator Left X Axis", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_X_AXIS);
		_motor4JoystickChooser.addObject("Operator Right Y Axis", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_Y_AXIS);
		_motor4JoystickChooser.addObject("Operator Right X Axis", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_X_AXIS);
		
		SmartDashboard.putData("Motor 4 Joystick", _motor4JoystickChooser);
		
		_motor4ButtonChooser = new SendableChooser();
		
		_motor4ButtonChooser.addObject("Driver Green A (4)", DIGITAL_MODE_BUTTON.DRIVER_GREEN_A);
		_motor4ButtonChooser.addObject("Driver Red B", DIGITAL_MODE_BUTTON.DRIVER_RED_B);
		_motor4ButtonChooser.addObject("Driver Blue X", DIGITAL_MODE_BUTTON.DRIVER_BLUE_X);
		_motor4ButtonChooser.addObject("Driver Yellow Y", DIGITAL_MODE_BUTTON.DRIVER_YELLOW_Y);
		_motor4ButtonChooser.addObject("Operator Green A", DIGITAL_MODE_BUTTON.OPERATOR_GREEN_A);
		_motor4ButtonChooser.addObject("Operator Red B", DIGITAL_MODE_BUTTON.OPERATOR_RED_B);
		_motor4ButtonChooser.addObject("Operator Blue X", DIGITAL_MODE_BUTTON.OPERATOR_BLUE_X);
		_motor4ButtonChooser.addObject("Operator Yellow Y", DIGITAL_MODE_BUTTON.OPERATOR_YELLOW_Y);
		
		SmartDashboard.putData("Motor 4 Button", _motor4ButtonChooser);
		
		_motor4ScalingChooser = new SendableChooser();
		
		_motor4ScalingChooser.addObject("10% (4)", 0.1);
		_motor4ScalingChooser.addObject("25%", 0.25);
		_motor4ScalingChooser.addObject("50%", 0.5);
		_motor4ScalingChooser.addObject("75%", 0.75);
		_motor4ScalingChooser.addObject("Full power", 1.0);
		
		SmartDashboard.putData("Motor 4 Scale Factor", _motor4ScalingChooser);
		
		System.out.println("Bottom of method");
		
	}
	
	
	public void readConfigValues()
	{
		_motor1BrakeModeChoice = (boolean)_motor1BrakeModeChooser.getSelected();
		_motor1JoystickNumber = (ANALOG_MODE_JOYSTICK)_motor1JoystickChooser.getSelected();
		_motor1ScalingValue = (double)_motor1ScalingChooser.getSelected();
		_motor1ButtonNumber = (DIGITAL_MODE_BUTTON)_motor1ButtonChooser.getSelected();
		_motor1ModeChoice = (MODE_CHOICE)_motor1ModeChooser.getSelected();
		_motor1LatchMode = (CMD_LATCH_MODE)_motor1LatchChooser.getSelected();
		_motor1ReverseChoice = (REVERSE_CHOICE)_motor1ReverseChooser.getSelected();
		
		_motor2BrakeModeChoice = (boolean)_motor2BrakeModeChooser.getSelected();
		_motor2JoystickNumber = (ANALOG_MODE_JOYSTICK)_motor2JoystickChooser.getSelected();
		_motor2ScalingValue = (double)_motor2ScalingChooser.getSelected();
		_motor2ButtonNumber = (DIGITAL_MODE_BUTTON)_motor2ButtonChooser.getSelected();
		_motor2ModeChoice = (MODE_CHOICE)_motor2ModeChooser.getSelected();
		_motor2LatchMode = (CMD_LATCH_MODE)_motor2LatchChooser.getSelected();
		_motor2ReverseChoice = (REVERSE_CHOICE)_motor2ReverseChooser.getSelected();
		
		_motor3BrakeModeChoice = (boolean)_motor3BrakeModeChooser.getSelected();
		_motor3JoystickNumber = (ANALOG_MODE_JOYSTICK)_motor3JoystickChooser.getSelected();
		_motor3ScalingValue = (double)_motor3ScalingChooser.getSelected();
		_motor3ButtonNumber = (DIGITAL_MODE_BUTTON)_motor3ButtonChooser.getSelected();
		_motor3ModeChoice = (MODE_CHOICE)_motor3ModeChooser.getSelected();
		_motor3LatchMode = (CMD_LATCH_MODE)_motor3LatchChooser.getSelected();
		_motor3ReverseChoice = (REVERSE_CHOICE)_motor3ReverseChooser.getSelected();
		
		_motor4BrakeModeChoice = (boolean)_motor4BrakeModeChooser.getSelected();
		_motor4JoystickNumber = (ANALOG_MODE_JOYSTICK)_motor4JoystickChooser.getSelected();
		_motor4ScalingValue = (double)_motor4ScalingChooser.getSelected();
		_motor4ButtonNumber = (DIGITAL_MODE_BUTTON)_motor4ButtonChooser.getSelected();
		_motor4ModeChoice = (MODE_CHOICE)_motor4ModeChooser.getSelected();
		_motor4LatchMode = (CMD_LATCH_MODE)_motor4LatchChooser.getSelected();
		_motor4ReverseChoice = (REVERSE_CHOICE)_motor4ReverseChooser.getSelected();


	}
	
	
	public double get_motor1CMDScalingFactor()
	{
		return _motor1ScalingValue;
	}
	
	public double get_motor2CMDScalingFactor()
	{
		return _motor2ScalingValue;
		
	}
	
	public double get_motor3CMDScalingFactor()
	{
		return _motor3ScalingValue;
	}
	
	public double get_motor4CMDScalingFactor()
	{
		return _motor4ScalingValue;
	}
	
	public boolean get_isMotor1BrakeMode()
	{
		return _motor1BrakeModeChoice;
		
	}
	
	public boolean get_isMotor2BrakeMode()
	{
		return _motor2BrakeModeChoice;
		
	}
	
	public boolean get_isMotor3BrakeMode()
	{
		return _motor3BrakeModeChoice;
		
	}
	
	public boolean get_isMotor4BrakeMode()
	{
		return _motor4BrakeModeChoice;
		
	}
	
	public ANALOG_MODE_JOYSTICK get_motor1Joystick()
	{
		return _motor1JoystickNumber;
		
	}
	
	public ANALOG_MODE_JOYSTICK get_motor2Joystick()
	{
		return _motor2JoystickNumber;
		
	}
	
	public ANALOG_MODE_JOYSTICK get_motor3Joystick()
	{
		return _motor3JoystickNumber;
		
	}
	
	public ANALOG_MODE_JOYSTICK get_motor4Joystick()
	{
		return _motor4JoystickNumber;
		
	}
	
	public DIGITAL_MODE_BUTTON get_motor1Button()
	{
		return _motor1ButtonNumber;
	}
	
	
	public DIGITAL_MODE_BUTTON get_motor2Button()
	{
		return _motor2ButtonNumber;
	}
	
	public DIGITAL_MODE_BUTTON get_motor3Button()
	{
		return _motor3ButtonNumber;
	}
	
	public DIGITAL_MODE_BUTTON get_motor4Button()
	{
		return _motor4ButtonNumber;
	}
	
	public MODE_CHOICE get_motor1ModeChoice()
	{
		return _motor1ModeChoice;
	}
	
	public MODE_CHOICE get_motor2ModeChoice()
	{
		return _motor2ModeChoice;
	}
	
	public MODE_CHOICE get_motor3ModeChoice()
	{
		return _motor3ModeChoice;
	}
	
	public MODE_CHOICE get_motor4ModeChoice()
	{
		return _motor4ModeChoice;
	}
	
	public CMD_LATCH_MODE get_isMotor1LatchMode()
	{
		return _motor1LatchMode; 
	}
	
	public CMD_LATCH_MODE get_isMotor2LatchMode()
	{
		return _motor2LatchMode;
	}
	
	public CMD_LATCH_MODE get_isMotor3LatchMode()
	{
		return _motor3LatchMode;
	}
	
	public CMD_LATCH_MODE get_isMotor4LatchMode()
	{
		return _motor4LatchMode;
	}
	
	public REVERSE_CHOICE get_isMotor1Reverse()
	{
		return _motor1ReverseChoice;
	}
	
	public REVERSE_CHOICE get_isMotor2Reverse()
	{
		return _motor2ReverseChoice;
	}
	
	public REVERSE_CHOICE get_isMotor3Reverse()
	{
		return _motor3ReverseChoice;
	}
	
	public REVERSE_CHOICE get_isMotor4Reverse()
	{
		return _motor4ReverseChoice;
	}

}




