import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.reducer;

public class TransportReducer extends<IntWritable, LongWritable, IntWritable, LongWritable> {
    public void reduce(IntWritable key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long totalpatronage = 0; 

        for (LongWritable value : values) {
            totalpatronage += value.get();
        }

        context.write(key, new LongWritable(totalpatronage));
    }
}