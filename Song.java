/**
the Song class creates song objects with title, minutes, and seconds
**/     

public class Song {

   //instance varibles
   private String songName;
   private int min;
   private int sec;

   /**
   Song constructor
      
   @param name the name of the song
   @param minutes the minutes in a song
   @param seconds the seconds left in the song
   **/     
   public Song(String name, int minutes, int seconds)
   {
      songName = name;
      min = minutes;
      sec = seconds;
   }


   /**
   default constructor for Song
   **/     
   public Song()
   {
      songName = "error";
      min = 0;
      sec = 0;
   }


   /**
   getSong method 
      
   @return the name of the song
   **/     
   public String getSong()
   {
      return songName;
   }


   /**
   getMins method 
      
   @return the number of minutes in a song
   **/     
   public int getMins()
   {
      return min;
   }
   
   
   
   /**
   getSecss method 
      
   @return the leftover seconds in a song
   **/     
   public int getSecs()
   {
      return sec;
   }

}