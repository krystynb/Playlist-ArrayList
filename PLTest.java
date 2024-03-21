/**
   Program to test the basic functionality of the PlayList.java class
   
   The expected output should include:
      The playlist "Classic Rock" has a total playing time of 5.13 minutes
      It includes the song "TAXMAN" with a playing time of 2.70 minutes
      Songs in file revolver.txt added successfully
      The playlist "Revolver" has a total playing time of 12.73 minutes
      It includes the song "TAXMAN" with a playing time of 2.70 minutes
      The longest song is "I'm Only Sleeping"
      The song "Taxman" was removed successfully
*/

public class PLTest 
{
   public static void main (String [] args)
	{
		PlayList a = new PlayList("Classic Rock");
      PlayList b = new PlayList("Revolver");
      
      a.addSong("TAXMAN",2,42);
      a.addSong("Here, There, and Everywhere",2,26); 
      System.out.printf("The playlist \"%s\" has a total playing time of %4.2f minutes\n", a.getName(), a.getPlayingTime());
      String song = "TAXMAN"; 
	   System.out.printf("It includes the song \"%s\" with a playing time of %4.2f minutes\n\n", song, a.getPlayingTime(song));
      
      if (b.addSongs("revolver.txt"))
         System.out.println("Songs in file revolver.txt added successfully");
      System.out.printf("The playlist \"%s\" has a total playing time of %5.2f minutes\n", b.getName(), b.getPlayingTime());
	   System.out.printf("It includes the song \"%s\" with a playing time of %4.2f minutes\n", song, b.getPlayingTime(song));
      System.out.printf("The longest song is \"%s\"\n", b.longestSong());
      if (b.removeSong("Taxman"))
         System.out.println("The song \"Taxman\" was removed successfully"); 
      System.out.println("\n" + b);   
   }
}
