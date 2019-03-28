/** 
 * Started by M. Moussavi
 * March 2015
 * Completed by: Michael Jeremy Olea
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Reads the .ser file and prints it
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since March 24th, 2019
 */
public class ReadRecord {
    
    /**
     * Input stream to read from file
     */
    private ObjectInputStream input;
    
    /**
     *  opens an ObjectInputStream using a FileInputStream
     * @param name the name of the file
     */
    private void readObjectsFromFile(String name)
    {
        MusicRecord record ;
        
        try
        {
            input = new ObjectInputStream(new FileInputStream( name ) );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
        
        /* The following loop is supposed to use readObject method of
         * ObjectInputSteam to read a MusicRecord object from a binary file that
         * contains several reords.
         * Loop should terminate when an EOFException is thrown.
         */
        
        try
        {
            while ( true )
            {
                try {
                    record = (MusicRecord) input.readObject();
                    System.out.printf("%d %s %s%10.2f\n", record.getYear(), record.getSongName(), record.getSingerName(), record.getPurchasePrice());
                } catch(EOFException e) {
                    break;
                }
            }  
        } catch(IOException e) {
            System.err.println("Error..." + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
    
    /**
     * The main method
     * @param args Command line arguments
     */
    public static void main(String [] args)
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("mySongs.ser");
    }
}