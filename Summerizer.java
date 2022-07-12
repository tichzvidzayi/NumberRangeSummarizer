//package numberrangesummarizer;
// Commented out package name because the class are all in the same folder
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Summerizer implements NumberRangeSummarizer
{
/*Author : Tich Zvidzayi
 * This class implements the NumberRangeSummarizer interface.
 * The purpose of the Summerizer class is to output a summerised range output e.g
 * Input : 1,4,5,6,9,10,11,20,23,24,25,36,37,39,46,57
 * Output :  1, 4-6, 9-11, 20, 23-25, 36-37, 39, 46, 57
 * 
 */


  public Collection<Integer> collect(String input) 
  {
		Collection<Integer> col = new HashSet<>();
    String[] nums = input.split(",");
		
		for (int i = 0; i < nums.length; i++)
     {
			try 
      {

				col.add(Integer.parseInt(nums[i]));
			} 
      catch (NumberFormatException ex) 
      {
				throw new NumberFormatException("Could not parse some text as integers");
			}
		}
      /*
         Assumming that the set might not be sorted in ascending order.
         The TreeSet automatically sorts the HashSet 'col' in ascending order.
      */
    Set<Integer> sortedSet = new TreeSet<Integer>(col);

    return sortedSet;
  
	}

public String summarizeCollection (Collection<Integer> inp)

{
  int current =-1;
  int previous = -1;
  Boolean issequential =false;

  inp = new TreeSet<>(inp);
  StringBuilder result = new StringBuilder("");
  Iterator<Integer> ite = inp.iterator();

   if( ite.hasNext() )
   {
    previous =ite.next(); 
   }
   else
   {
       return result.toString();
   }
   
  result.append(previous);


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
          result.append("-").append(previous);
          issequential = false;
        }
        result.append(", ").append(current);

   }
    previous = current;

}

if(issequential)
{
    result.append("-").append(previous);

}

return result.toString();

}


}