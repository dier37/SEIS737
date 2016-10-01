package mystuff;


// vv Bank Teller
	import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import org.apache.hadoop.conf.*;
	
public class BankTeller extends Configured implements Tool{
	
	// cc Bank Teller


	  public int run(String[] args) throws Exception {

	    if (args.length != 2) {
	      System.err.println("Usage: BankTeller <input path> <output path>");
	      System.exit(-1);
	    }
	    
	    Job job = new Job(getConf());
	    job.setJarByClass(BankTeller.class);
	    job.setJobName("Bank Teller");

	    
	    //testing changes!now this works
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    job.setMapperClass(BankTellerMapper.class);
	    job.setReducerClass(BankTellerReducer.class);

	    
	       // the map output is IntWritable
       job.setMapOutputKeyClass(Text.class);
       job.setMapOutputValueClass(IntWritable.class);
	    
       
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    
	    return (job.waitForCompletion(true) ? 0 : 1);
	  }

	  public static void main(String[] args) throws Exception {
	    int res = ToolRunner.run(new Configuration(), new BankTeller(), args);
	    System.exit(res);
	  }
	}
	// ^^ Bank Teller