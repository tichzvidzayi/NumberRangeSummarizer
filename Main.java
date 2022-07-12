//package numberrangesummarizer;

import java.util.Collection;

public class Main {
	public static void main(String[] args) {
		Summerizer summarizer = new Summerizer();
		Collection<Integer> col = summarizer.collect("1,4,5,6,9,10,11,20,23,24,25,36,37,39,46,57");
		System.out.print(summarizer.summarizeCollection(col));
	}
}