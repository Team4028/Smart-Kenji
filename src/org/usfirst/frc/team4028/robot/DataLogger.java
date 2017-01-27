
package org.usfirst.frc.team4028.robot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.DriverStation;

public class DataLogger {

	private PrintWriter _writer;

    // constructor, open a new timestamped log file in the target directory
    public DataLogger(String parentFolder, String fileSuffix) throws IOException 
    {
    	SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		outputFormatter.setTimeZone(TimeZone.getTimeZone("US/Eastern")); 
		String newDateString = outputFormatter.format(new Date());
    	 
		DriverStation.reportWarning("Data Logger 1", true);
		
    	// build the new filename
    	String fileName = newDateString + "_" + fileSuffix + ".tsv";
    	// build the full file path name
    	this.LogFilePathName = parentFolder + File.separator + fileName;
    	
    	DriverStation.reportWarning("Data Logger 2:" + this.LogFilePathName, true);
    	
        _writer = new PrintWriter(new BufferedWriter(new FileWriter(this.LogFilePathName, true)));
    }

    // Property containing Full PathName to log file
    public String LogFilePathName; 
    
    // Write a string to the file
    public void WriteData(String textToLog) 
    {        
        _writer.print("StartDetaMS" + "\t" + "LastScanDeltaMS" + "\t" +textToLog);
        _writer.flush();
    }

    // Write a structured data object to the log file
    public void WriteData(LogData dataToLog) 
    {
    	TimeUnit timeUnit = TimeUnit.MILLISECONDS;
       	Date now = new Date();
       	
    	long startDeltaDiffInMillies = now.getTime() - dataToLog.LoggingStartedDT;
        long startDeltaTimestamp = timeUnit.convert(startDeltaDiffInMillies,TimeUnit.MILLISECONDS);
        
    	long lastScanDeltaDiffInMillies = now.getTime() - dataToLog.LastScanDT;
        long lastScanDeltaTimestamp = timeUnit.convert(lastScanDeltaDiffInMillies,TimeUnit.MILLISECONDS);
        
        _writer.print(startDeltaTimestamp + "\t" + lastScanDeltaTimestamp + "\t" + dataToLog.BuildTSVData());
        _writer.flush();
    }
    
    // close the file
    public void close() 
    {
    	_writer.close();
    }
}
