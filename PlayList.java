import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


/** The PLayList Class creats PlayList ArrayLists with 
    Song objects.                                  
**/
public class PlayList extends Song
{


//instance variables 
   private ArrayList<Song> title = new ArrayList<>();
   private String arrayName;
   
   
   /**
      Constructor
      @param listName the name of the playlist
      
   **/
   public PlayList(String listName) 
   {
    
      ArrayList<Song> title = new ArrayList<>();
      arrayName = listName;
    
   }
   
   
   
   
   
   /**
      getName method
      @return the name of the playlist
   **/
   public String getName()
   {
      return arrayName;
   }
   
   
   
   /**
      addSong method (from user specification)
      @param songName the name of the song
      @param minutes the number of minutes in the song
      @param seconds the number of seconds in the song
   **/
   public void addSong(String songName, int minutes, int seconds)
   {
   
   
      //create the song object from the parameters
      Song buffer = new Song(songName, minutes, seconds);
      
      //capitalize the title of the song to negate case discrepancies
      String bufferName = buffer.getSong().toUpperCase();
      
      //set counter to zero and boolean to false
      int k = 0;
      boolean alreadyAdded = false;
      
      
      //loop that continues while the index is < size and the song is not yet added
      while (k < (title.size()) && alreadyAdded == false)
      {
      
         //takes the song name at index k and capitalizes it
         String pulledSong = title.get(k).getSong().toUpperCase();
         
         
         // decides if the song already exists in the playlist
         if (pulledSong.equals(bufferName))
         {
            alreadyAdded = true;
         }
        
         k++;
      } 
      
      //adds song if it does not yet exist
      if (alreadyAdded == false)
      {      
         title.add(buffer);
      }
   }



   /**
      addSongs method (from an external file)
      
      @param fileName the name of the file containing songs
      @return whether or not the file sucessfully opened
   **/
   public boolean addSongs(String fileName)
   {   
      Scanner scan = null;
        
      try //open the try block for FNFE
      { 
      
         //open the file, declare scanner, set endFile to false
         scan = new Scanner(new File(fileName));
         boolean endFile = false;
         
         
         
         while(!endFile) //continues until the end of the file 
         {
            try //try block for mismatch exception or no such element
            {
            
                //scan in line and read through it with new delimiter
               String line = scan.nextLine();
               Scanner read = new Scanner(line);
               read.useDelimiter("/");
               
               //scan in name, minutes, and seconds on the scanned line
               String scannedName = read.next();           
               int scannedMin     = read.nextInt();
               int scannedSec     = read.nextInt();
               
               
               //print the results
               System.out.print("Name:    " + scannedName + "\n" +
                                "Minutes: " + scannedMin + "\n" +
                                "Seconds: " + scannedSec + "\n" + "ADDED SUCCESSFULLY" +
                                "\n-----------------------------------\n");
            
             
             //add to the playlist if no errors
               title.add(new Song(scannedName, scannedMin, scannedSec));
            
            }
            
            catch(InputMismatchException e)  // handle when data is N/A
            {
               String error = scan.nextLine();  //consume the error and return to see where error is occurring
               System.out.print( " ERROR (cause): " + error + "\n");
              
            }
            
            catch(NoSuchElementException e) // handle when no more data in file
            {
               endFile = true;  //nothing in file set endFile
            }
            
         } //close try block
                  
         //close and return true
         scan.close();
         return true;
         
      }// close loop
            
      //return false if no file found
      catch (FileNotFoundException e)
      {
        System.out.println("THERE IS NO FILE BRETHREN");
         return false;
      }
   
      
   }// close FNFE try

    
   /**
      getPlayingTime method (no arguments)
      
      @return the duration of the entire playlist
   **/    
   public double getPlayingTime()
   {
    //local variables
      double totalSeconds = 0;
      int k = 0;
      
      //loop that terminates at the end of the playlist
      while (k < (title.size()))
      {
         //stores the minutes * 60 plus seconds
         totalSeconds += title.get(k).getMins() * 60 + title.get(k).getSecs();

         k++;
         
      }
      
      //returns the number of seconds/60
      double playTime = totalSeconds/60;
      
      return playTime;
   
   }
   

   /**
      getPlayingTime method 
      
      @param song the title of the requested song
      @return the duration of the requested song
   **/       
   public double getPlayingTime(String song)
   {
   
      //local variables
      String searchName = song.toUpperCase();
      int k = 0;
      boolean found = false;
      double playTime = 0;
      
      
      while (k < (title.size()) && found == false)
      {
         // turns the song at index k to uppercsase
         String pulledSong = title.get(k).getSong().toUpperCase();
         
         //exit loop if the song is found
         if (pulledSong.equals(searchName))
         {
            double playTimeSec = title.get(k).getMins()*60 + title.get(k).getSecs();
   
            playTime = playTimeSec/60;
            
            found = true;  
         }
      
         k++;
      } 
       
      return playTime;
   }
   








   /**
      longestSong method 
      
      @return the title of the longest song in the playlist
   **/       
   public String longestSong()
   {
      //local variables 
      int k = 0;
      int returnIndex = 0;
      int longestTime = 0;
      int time = 0;
      
      
      //reads through the playlist  
      while (k < (title.size()))
      {
       
         time = title.get(k).getMins() * 60 + title.get(k).getSecs();
        
        //replaces the longest song 
         if (time > longestTime)
         {
            longestTime = time;
            returnIndex = k;
         }
        
         k++;
      }  
            
      return title.get(returnIndex).getSong();
   }

   /**
      removeSong method 
      
      @return whether or not the song was successfully removed
   **/       
   public boolean removeSong(String song)
   {
      String tryRemove = song.toUpperCase();
      int k = 0;
        
      while (k < (title.size()))
      {
         String pulledSong = title.get(k).getSong().toUpperCase();
        
         if (pulledSong.equals(tryRemove))
         {
            title.remove(k);
            return true;
         }
        
         k++;
      }        
   
      return false;
   }


   /**
      songList method 
      
      @return a list of all the songs in a playlist
   **/       
   public String songList()
   {
      String allSongs = "\n";
      int k = 0;
      while (k < title.size())
      {
         allSongs  += title.get(k).getSong() + "\n";
         
         k++;
      }
      return allSongs;
   }
   
   /**
      toString method 
      
      @return the name, total playing time, and list of songs in a playlist
   **/       
   public String toString()
   {
   
      String songlist;
      int k = 0;
      return 
         "Playlist: " + getName() + "\n" +
         "Total Time: " + String.format("%.2f", getPlayingTime()) + "\n" + 
         "\nSong List" +
        ("\n--------------\n") + songList();
   }


}





















