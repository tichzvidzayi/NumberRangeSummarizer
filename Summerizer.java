package numberrangesummarizer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import numberrangesummarizer.*;

public class Summerizer implements NumberRangeSummarizer
{

public Collection<Integer> collect(String inpt)

{  
   Collection<Integer> xs = new HashSet<>();
   String[] col = inpt.split(",");
   int n =0;
     for (int i = 0; i < col.length; i++)
     {
       try{
              n = Integer.parseInt(col[0]);
                
       }
       catch(NumberFormatException ex){
            throw new NumberFormatException("Could not convert input to an integer");

       }

       xs.add(n);
     }

     return xs;

}

public String summarizeCollection (Collection<Integer> inp)

{
  int current =-1;
  int previous = -1;
  Boolean issequential =false;

  inp = new TreeSet<>(inp);
  StringBuilder res = new StringBuilder("");

  Iterator<Integer> ite = inp.iterator();

   if( ite.hasNext() )
   {
    previous =ite.next(); 
   }
   else
       return res.toString();
   
res.append(previous);


while (ite.hasNext())

{
   current = ite.next(); 

   if(current== previous + 1 )
   {
    issequential = true;

   }

   else 
   {
          if (issequential)
        {
          res.append("-").append(previous);
          issequential = false;
        }
        res.append(", ").append(current);

   }
    previous = current;

}

if(issequential)
{
    res.append("-").append(previous);

}

return res.toString();

}



	public static void main(String[] args) {
		Summerizer summarizer = new Summerizer();
		Collection<Integer> inputs = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		System.out.println(summarizer.summarizeCollection(inputs));
	}


}