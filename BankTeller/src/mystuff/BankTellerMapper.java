package mystuff;

// cc BankTellerMapper Mapper for maximum temperature example
// vv BankTellerMapper
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.MapWritable;;

public class BankTellerMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {

  private static final int MISSING = 9999;
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
	  
    String line = value.toString();
    
    Integer total = 0;
    String Name = null;
            
    //get name
    if (line.matches("(.*),(.*)"))
    	Name = line.substring(0, line.indexOf(","));
    
    //get line without name and comma
    String noName = line.substring(Name.length()+1);

    //recommended approach over string tokenizer, per java documentation
    //https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html
    //splits by space
    String[] result = noName.split("\\s");
        
    //iterates over results and adds it up
    for (String val : result){
    	total += Integer.parseInt(val);
    }
    
    // need to pass name and map to context
    if (Name != null)
    	context.write(new Text(Name), new IntWritable (total));
    
    
/*    int airTemperature;
    
    if (line.charAt(87) == '+') { // parseInt doesn't like leading plus signs
      airTemperature = Integer.parseInt(line.substring(88, 92));
    } else {
      airTemperature = Integer.parseInt(line.substring(87, 92));
      String quality = line.substring(92, 93);
    if (airTemperature != MISSING && quality.matches("[01459]")) {
      context.write(new Text(Name), new IntWritable(airTemperature));
        }*/
    /*    for (int x=0; x<result.length; x++)
    {
    	if (mapTeller.containsKey(result[x]))
        {
    		mapTeller.put(result[x], mapTeller.get(result[x]) + 1);
        }else
        {
        	mapTeller.put(result[x], 1);
        }
    }*/
    
    /*    IntWritable tmpInt;
     MapWritable mapTeller = new MapWritable();
    for (String val : result){
        tmpInt = (IntWritable) mapTeller.get(new Text(val));

        if(tmpInt == null) {
            tmpInt = new IntWritable(0);
            // create a copy of val Text object
            mapTeller.put(new Text(val), tmpInt);
        }

        // update the IntWritable wrapped int value
        tmpInt.set(tmpInt.get() + 1);
        // Note: you don't need to re-insert the IntWritable into the map
    }*/
  }
}
// ^^ BankTellerMapper
