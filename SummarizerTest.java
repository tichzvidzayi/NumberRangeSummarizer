import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SummarizerTest {

	@Test
	void test() {
		//fail("Not yet implemented");
	}
    	
	public void populate(String input) {
		String[] numbers = input.split(",");
		for (String str : numbers) {
			this.expectedCollection.add(Integer.parseInt(str));
		}
	}

    @Test
	public void mixedinput_Words_Numbers() {
		input = "1,3,Java,7,8,12,Gradle,14,15,21,22,23,JDK,31";
		NumberFormatException exception =  assertThrows(NumberFormatException.class, ()-> {
			summarizer.collect(input);
		});
		assertEquals("Input string contains non-digits or is empty", exception.getMessage());
	}

	@Test
	public void singleDigit() {
		input = "8";
		Collection<Integer> output = summarizer.collect(input);
		populate(input);
		assertEquals(expectedCollection, output);
		clear();
	}
	
	@Test
	public void unsorted() {
		input = "13,2,3,5,7,30,20,21,22,50,11,12,10,13,4,23";
		Collection<Integer> output = summarizer.collect(input);
		populate("2,3,4,5,7,10,11,12,13,20,21,22,23,50");
		assertEquals(expectedCollection, output);
		clear();
	}

	@Test
	public void duplicates() {
		input = "2,3,3,5,6,6,7,8,9,9,9,9,13";
		Collection<Integer> output = summarizer.collect(input);
		populate("2,3,5,6,7,8,9,13");
		assertEquals(expectedCollection, output);
		clear();
	}

	@Test
	public void summarizeCollection_test2() {
		input = "1,3,4,5,7,10,11,12,34,37,40,41,42,43,44";
		Collection<Integer> output = summarizer.collect(input);
		assertEquals("1, 3-5, 7, 10-12, 34, 37,40-44", summarizer.summarizeCollection(output));
	}



	@Test
	public void summarizeCollection_test2() {
		input = "5,6,7";
		Collection<Integer> output = summarizer.collect(input);
		assertEquals("5-7", summarizer.summarizeCollection(output));
	}

	@Test
	public void summarizeCollection_test2() {
		input = "4,5,6,7, 100,101,102,103,1001,1002,1003";
		Collection<Integer> output = summarizer.collect(input);
		assertEquals("4-7, 100-103, 1001-1003", summarizer.summarizeCollection(output));
	}



}
