//package numberrangesummarizer;

import java.util.Collection;

public class Main {
	public static void main(String[] args) {
		Summerizer summarizer = new Summerizer();
		Collection<Integer> col = summarizer.collect("1,4,5,6,9,10,11,12,13,20,23,24,25,36,37,39,40,41,46,57,58,59,60,1000,1001,1008");
		System.out.println(summarizer.summarizeCollection(col));
	}
}