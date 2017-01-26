package org.usfirst.frc.team4028.robot;

import java.time.Instant;
import java.util.Date;

public class LogData {
	
	public double Motor1Command;
	public double Motor1Actual;
	public double Motor2Command;
	public double Motor2Actual;
	public double Motor3Command;
	public double Motor3Actual;
	public double Motor4Command;
	public double Motor4Actual;

	public String LogFilePathName = "";
	public boolean IsLoggingEnabled;					
	
	public long LoggingStartedDT;
	public long LastScanDT;
	
	public static String BuildTSVHeader() {
		StringBuilder sb = new StringBuilder();
		sb.append("Motor1Command" + "\t");
		sb.append("Motor1Actual" + "\t");
		sb.append("Motor2Command" + "\t");
		sb.append("Motor2Actual" + "\t");
		sb.append("Motor3Command" + "\t");
		sb.append("Motor3Actual" + "\t");
		sb.append("Motor4Command" + "\t");
		sb.append("Motor4Actual" + "\t");
		return sb.toString();
	}
	
	public String BuildTSVData() {
		StringBuilder sb = new StringBuilder();
		sb.append(Motor1Command + "\t");
		sb.append(Motor1Actual + "\t");
		sb.append(Motor2Command + "\t");
		sb.append(Motor2Actual + "\t");
		sb.append(Motor3Command + "\t");
		sb.append(Motor3Actual + "\t");
		sb.append(Motor4Command + "\t");
		sb.append(Motor4Actual + "\t");
		return sb.toString();
	}
}
