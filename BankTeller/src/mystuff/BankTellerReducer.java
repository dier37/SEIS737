package mystuff;	
// cc BankTellerReducer Reducer for maximum temperature example
	// vv BankTellerReducer
	import java.io.IOException;

	import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
	
	
public class BankTellerReducer 
	  extends Reducer<Text, IntWritable, Text, IntWritable> {
	  
	 int totalAll=0;
	
	  //@Override
	//key is the name, mapwritable are the values 
	  public void reduce(Text key, Iterable<IntWritable> values,
	      Context context)
	      throws IOException, InterruptedException {
	    
	    int totalValue = 0;
	    
/*	    for (IntWritable value : values) {
	      maxValue = Math.max(maxValue, valdue.get());
	    }*/

	    for (IntWritable value : values) {
	    	totalValue += value.get();
	    	totalAll+= value.get();
	    }
	    
	    //standard key length
	    String blanks = new String(new char[20 - key.getLength()]).replace("\0", " ");
	    Text myKey = new Text(key + blanks);
	    
	    context.write(new Text(myKey), new IntWritable(totalValue));
	  	      
	  	  
	  }
	  @Override
	  protected void cleanup(Context context) throws IOException, InterruptedException {
		  
	    context.write(new Text ("Total Cash:" + "\t"+"\t"+"\t" ) , new IntWritable(totalAll));
	    
	    
	  }
	  
	  @Override
	  protected void setup(Context context) throws IOException, InterruptedException {
		  
	    context.write(new Text ("Customer Name:" + "\t" + "\t" + "\t" + "Cash Collected") , null);
	    
	  }
	  
	}

