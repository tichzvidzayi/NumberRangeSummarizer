 import org.junit.Test; 

 /*
  *  ASSUMPTIONS
Test cases were tricky to test for the CLI without setting up the JUnit in Eclipse for example
However here is what I sought to achieve;

1 - A test fails if there is a mixture if strings/text and numbers
2 - A Summarizer class is supposed to trim() trailing space e.g. "5 " and convert it to an integer 5
     Therefore test cases with stings with trailing spaces should PASS.
3 - If the test case has a single digit its supposed to pass and return the digit.
4 - Empty or Null strings are supposed to fail.
5 - The test should fail if the input is of type double or floating, bool. Only integers should be accepted.
6 - The integer size should not exceed the 4 bytes limit (2,147,483,647 to 2,147,483,647)
  */
public class SummarizerTest {

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
		assertEquals("Input should contain only intergers", exception.getMessage());
	}

	@Test
	public void emptystring() {
		input = "4.5 , 6.4, 9, 10, 11.0 , 12.23";
		NumberFormatException exception =  assertThrows(NumberFormatException.class, ()-> {
			summarizer.collect(input);
		});
		assertEquals("Input string should be convertable to integers and cannot be of type floating point /double", exception.getMessage());
	}

    @Test
	public void emptystring() {
		input = "";
		NumberFormatException exception =  assertThrows(NumberFormatException.class, ()-> {
			summarizer.collect(input);
		});
		assertEquals("Input string cannot be a NULL string", exception.getMessage());
	}

	@Test
	public void singleDigit() {
		input = "8";
		Collection<Integer> output = summarizer.collect(input);
		populate(input);
		assertEquals(expectedCollection, output);
		
	}
	
	@Test
	public void unsorted() {
		input = "13,2,3,5,7,30,20,21,22,50,11,12,10,13,4,23";
		Collection<Integer> output = summarizer.collect(input);
		populate("2,3,4,5,7,10,11,12,13,20,21,22,23,50");
		assertEquals(expectedCollection, output);
		
	}

	@Test
	public void duplicates() {
		input = "2,3,3,5,6,6,7,8,9,9,9,9,13";
		Collection<Integer> output = summarizer.collect(input);
		populate("2,3,5,6,7,8,9,13");
		assertEquals(expectedCollection, output);
		
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
