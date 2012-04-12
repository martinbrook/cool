package net.praqma.clearcase.util.setup;

import java.io.File;
import java.io.IOException;

import net.praqma.clearcase.exceptions.ClearCaseException;
import net.praqma.clearcase.ucm.entities.Version;
import net.praqma.clearcase.util.setup.EnvironmentParser.Context;

import org.w3c.dom.Element;

public class AddElementTask extends AbstractTask {

	@Override
	public void parse( Element e, Context context ) throws ClearCaseException {
		File file = new File( e.getAttribute( "file" ) );
		
		if( !file.exists() ) {
			try {
				file.createNewFile();
			} catch( IOException e1 ) {
				throw new ClearCaseException( e1 );
			}
		}
		
		Version.addToSourceControl( file, file.isDirectory(), context.path );
	}

}