package date;

public class Date {
	public static String dateByWords(int a, int b, int c){
		String wordsdata = "";
		String day = "";
		String month = "";
		String year = "";
		switch (a) 
		{
			case 1: day = "First "; break;
			case 2: day = "Second "; break;
			case 3: day = "Third "; break;
			case 4: day = "4st "; break;
			case 5: day = "5st "; break;
			case 6: day = "6st "; break;
			case 7: day = "7st "; break;
			case 8: day = "8st "; break;
			case 9: day = "9st "; break;
			case 10: day = "10st "; break;
			case 11: day = "11st "; break;
			case 12: day = "12st "; break;
			case 13: day = "13st "; break;
			case 14: day = "14st "; break;
			case 15: day = "15st "; break;
			case 16: day = "16st "; break;
			case 17: day = "17st "; break;
			case 18: day = "18st "; break;
			case 19: day = "19st "; break;
			case 20: day = "20st "; break;
			case 21: day = "21st "; break;
			case 22: day = "22st "; break;
			case 23: day = "23st "; break;
			case 24: day = "24st "; break;
			case 25: day = "25st "; break;
			case 26: day = "26st "; break;
			case 27: day = "27st "; break;
			case 28: day = "28st "; break;
			case 29: day = "29st "; break;
			case 30: day = "30st "; break;
			default: throw new IllegalArgumentException();
		}
//		System.out.print(day);
		switch (b) 
		{
			case 1: month = "of January "; break;
			case 2: month = "of Februart "; break;
			case 3: month = "of Marth "; break;
			case 4: month = "of April "; break;
			case 5: month = "of May "; break;
			case 6: month = "of June "; break;
			case 7: month = "of July "; break;
			case 8: month = "of August "; break;
			case 9: month = "of September "; break;
			case 10: month = "of October "; break;
			case 11: month = "of November "; break;
			case 12: month = "of December "; break;
			default: throw new IllegalArgumentException();
		}
//		System.out.print(month);
		switch (c) 
		{
			case 2014: year = "twenty fourteen"; break;
			case 2013: year = "twenty 3teen"; break;
			default: throw new IllegalArgumentException();
		}
//		System.out.print(year);
		wordsdata = day + month + year;
		System.out.print(wordsdata);
		return wordsdata;
	
	}
}

