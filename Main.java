

import java.util.Collection;

public class Main {
	public static void main(String[] args) {
	  //NumberSummarizer summarizer = new NumberSummarizer();
		Summerizer summarizer = new Summerizer();
		Collection<Integer> ints = summarizer.collect("7,8,12,13,14,15,21,22,23,24,31");
		System.out.println(summarizer.summarizeCollection(ints));
	}
}