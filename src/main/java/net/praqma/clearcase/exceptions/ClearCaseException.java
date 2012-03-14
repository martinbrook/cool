package net.praqma.clearcase.exceptions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import net.praqma.util.debug.Logger;

public class ClearCaseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5325867242379727760L;
	
	protected List<String> information = new ArrayList<String>();


	public ClearCaseException() {
		super();
	}

	public ClearCaseException( String s ) {
		super( s );
	}
	
	public ClearCaseException( Exception e ) {
		super( e );
	}
	
	public ClearCaseException( String s, Exception e ) {
		super( s, e );
	}

	
	public void addInformation( String info ) {
		information.add( info );
	}
	
	public List<String> getInformation() {
		return information;
	}
	
	public String getInformationAsString() {
		StringBuffer sb = new StringBuffer();
		for( String info : information ) {
			sb.append( info );
			sb.append( System.getProperty( "line.separator" ) );
		}
		
		return sb.toString();
	}
	
	public void printInformation( PrintStream stream ) {
		for( String info : information ) {
			stream.println( info );
		}
	}
	
	public void print( PrintStream out ) {
		out.println( this.getMessage() );
		this.printInformation( out );
		if( this.getCause() != null ) {
			out.println( this.getCause().getMessage() );
		}
	}

}