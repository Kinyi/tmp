package kinyi.hmbbs;

import java.io.IOException;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

/**
 * 批量导入到HBase中的hmbbs_logs表，格式为：
 * 27.19.74.143:20130530173820:100366040 column=cf:date, timestamp=1425434802229, value=20130530173820
 * 如果想要仔细查询，如要具体查询某个ip时，需要用get语句，但是rowkey加入了随机数，因此不可能知道rowkey
 * 解决方案：1.使用过滤器
 * 		   scan 'hmbbs_logs',{FILTER=>("PrefixFileter('27.19.74.143:20130530173820')")}
 * 		   scan 'hmbbs_logs',{STARTROW=>'27.19.74.143:20130530173820',STOPROW=>'27.19.74.143:20130530173821'}
 * 		 2.用Java代码的startrow和stoprow指定范围查询(没验证)
 */

public class HBaseBatchImport {

	private static final String INPUT_PATH = "hdfs://hadoop0:9000/kinyi/hmbbs_logs";

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		conf.set("hbase.zookeeper.quorum", "hadoop0");
		conf.set(TableOutputFormat.OUTPUT_TABLE, "hmbbs");
		conf.set("dfs.socket.timeout", "180000");
		
		Job job = new Job(conf, HBaseBatchImport.class.getSimpleName());
		job.setJarByClass(HBaseBatchImport.class);
		FileInputFormat.setInputPaths(job, new Path(INPUT_PATH));
		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReducer.class);
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputFormatClass(TableOutputFormat.class);
		job.waitForCompletion(true);
	}
	
	public static class MyMapper extends Mapper<LongWritable, Text, LongWritable, Text>{
		@Override
		protected void map(LongWritable key, Text value,
				Mapper<LongWritable, Text, LongWritable, Text>.Context context)
				throws IOException, InterruptedException {
			context.write(key, value);
		}
	}
	
	public static class MyReducer extends TableReducer<LongWritable, Text, NullWritable>{
		@Override
		protected void reduce(LongWritable k2, Iterable<Text> v2s,
				Reducer<LongWritable, Text, NullWritable, Writable>.Context context)
				throws IOException, InterruptedException {
			for (Text v2 : v2s) {
				String[] parse = new LogParser().parse(v2.toString());
				Put put = new Put(Bytes.toBytes(parse[0]+":"+parse[1]+":"+new Random().nextInt()));
				put.add(Bytes.toBytes("cf"), Bytes.toBytes("ip"), Bytes.toBytes(parse[0]));
				put.add(Bytes.toBytes("cf"), Bytes.toBytes("date"), Bytes.toBytes(parse[1]));
				put.add(Bytes.toBytes("cf"), Bytes.toBytes("url"), Bytes.toBytes(parse[2]));
				put.add(Bytes.toBytes("cf"), Bytes.toBytes("status"), Bytes.toBytes(parse[3]));
				put.add(Bytes.toBytes("cf"), Bytes.toBytes("traffic"), Bytes.toBytes(parse[4]));
				
				context.write(NullWritable.get(), put);
			}
		}
	}
}
