//package numberrangesummarizer;
// Commented out package name because the class are all in the same folder
import java.util.Collection;
//import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Summarizer implements NumberRangeSummarizer
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

				col.add(Integer.parseInt(nums[i].trim()));                       //Trims some extra spaces from input
			} 
      catch (NumberFormatException ex) 
      {
				throw new NumberFormatException("Could not parse some text as integers");
			}
		}

      /*
         Assumming that the set might not be sorted and we are required to sort the list in ASCENDING order.
         The TreeSet automatically sorts the HashSet 'col' in ascending order.
      */

    Set<Integer> sortedSet = new TreeSet<Integer>(col);

    return sortedSet;
  
	}

public String summarizeCollection (Collection<Integer> inp)

{ //Initiate variable
  int current =-1;
  int previous = -1;
  Boolean issequential =false;

  inp = new TreeSet<>(inp);
  StringBuilder result = new StringBuilder("");
  Iterator<Integer> ite = inp.iterator();

 /* Since we are looping sequential and we do not need to access elements using an array index
      we can use an iterator data structure
  */

   if( ite.hasNext() )              //if not the last element
   {
    previous =ite.next(); 
   }
   else
   {
       return result.toString();    // return the stringbuilder as a string
   }
   
  result.append(previous);


  while (ite.hasNext())            //whilst the list has more elements keep looping

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
{  // If sequential append a dash and previous
    result.append("-").append(previous);

}

return result.toString();

}


}