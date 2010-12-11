package net.praqma.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamGobbler extends Thread
{
    InputStream is;
    public StringBuffer sres;
    public List<String> lres;
    
    
    StreamGobbler( InputStream is )
    {
        this.is = is;
        lres = new ArrayList<String>();
        sres = new StringBuffer();
    }
    
    public void run( )
    {
		try
		{
			InputStreamReader isr = new InputStreamReader( is );
			BufferedReader br = new BufferedReader( isr );
			String line = null;
			
			while( ( line = br.readLine() ) != null )
			{
				sres.append( line );
				lres.add( line );
			}
			
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			
//			final byte[] buf = new byte[1024];
//			int length;
//            while ((length = is.read(buf)) > 0) {
//                bos.write(buf, 0, length);
//            }
		}
		catch ( IOException ioe )
		{
			ioe.printStackTrace();
		}
	}
}
