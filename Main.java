import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		NetflixOriginal[] shows = new NetflixOriginal[2];

		shows[0] = instantiateFromInput(keyboard);
		System.out.println(shows[0]);

		shows[1] = instantiateFromInput(keyboard);
		System.out.println(shows[1]);

		
	}
	//** STATIC METHODS **//
	public static NetflixOriginal instantiateFromInput(Scanner inputScanner)
	{
		// LCVs for the loops
		boolean contRating = true;
		boolean contGenre = true;

		// intialize params as null to avoid errors
		String name = "";
		String stringRating = "";
		Double starRating = 0.0;
		String genre = "";

		// Store the genres in a new array for conveniency
		String[] genreList = NetflixOriginal.VALID_GENRES;

		System.out.println("Enter the name of the netflix original:");
		name = inputScanner.nextLine();

		System.out.println("Enter the rating of the netflix original");
		while (contRating)
		{

			starRating = inputScanner.nextDouble();
			if (starRating < 0.0 || starRating > 5.0)
			{
				System.out.println("Please enter a value between 0 and 5");
				contRating = true;
			}
			else
			{
				contRating = false;
			}
		}
		inputScanner.nextLine(); //Clear the buffer
		
		System.out.println(starRating);

		System.out.println("Enter the genre of the netflix original:");
		
		while (contGenre) // Loop until the user enters a valid genre
		{
			genre = inputScanner.nextLine();

			// Check input against every valid genre
			for (int item = 0; item < genreList.length; item++)
			{
				// If any are correct, set the LCV to false
				if (genre.equalsIgnoreCase(genreList[item]))
				{
					contGenre = false;
				}
			}

			if (contGenre) // If the check failed
			{
				System.out.println("Please enter one of the following genres:");

				// Print every genre in the array
				for (int item = 0; item < genreList.length; item++)
				{
					System.out.print(genreList[item]);

					// Only print a comma if it isn't the last item
					if (item < genreList.length - 1)
					{
						System.out.print(", ");
					}
				}
				System.out.println(); // print a newline
			}
		}

		return new NetflixOriginal(name, starRating, genre);


	}
}