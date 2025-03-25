import java.io.IOException; 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TransportMapper extends Mapper<LongWritable, Text, IntWritable, LongWritable> {
    private IntWritable year = new IntWritable();
    private LongWritable patronage = new LongWritable();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split(",");

        if (fields.length == 2 && !fields[0].equals("YR")) {
            year.set(Integer.parseInt(fields[0]));
            patronage.set(Long.parseLong(fields[1]));
            context.write(year, patronage);
        }
    }
}