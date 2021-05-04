package final_project

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark._
import org.apache.spark.rdd.RDD
import org.apache.spark.graphx._
import org.apache.spark.storage.StorageLevel
import org.apache.log4j.{Level, Logger}

object main{
	
	def ComputeRandomMatching(g_in: Graph[Int, Int]): Graph[Int, Int] = {
		// val rdd1 = g_in.repartition(10)
		// val rrd2 = rdd1.mapPartitions(rdd1.filter(rdd1(1)!=rdd2(1)))
		
		// e = edges
		// v = vertices
		// while e
		// for random edge
			// if both vertices in v:
				// remove both vertices in edge from v
				// add edge to output
			// remove edge from e
		// return output in form of graph
		return g_in			//To compile
	}
	
	
	
	
	
	/*Main from Project 3 edited for our use*/
	def main(args: Array[String]) {

		val conf = new SparkConf().setAppName("final_project")
		val sc = new SparkContext(conf)
		val spark = SparkSession.builder.config(conf).getOrCreate()

		if(args.length != 2) {
			println("Usage: final_project graph_path output_path")
			sys.exit(1)
		}
		val startTimeMillis = System.currentTimeMillis()
		val edges = sc.textFile(args(0)).map(line => {val x = line.split(","); Edge(x(0).toLong, x(1).toLong, 1)} )
		println("==================================")
		for(i <- edges.collect){
			println(i)
		}
		println("==================================")
		val g = Graph.fromEdges[Int, Int](edges, 0, edgeStorageLevel = StorageLevel.MEMORY_AND_DISK, vertexStorageLevel = StorageLevel.MEMORY_AND_DISK)
		val g2 = ComputeRandomMatching(g)

		val endTimeMillis = System.currentTimeMillis()
		val durationSeconds = (endTimeMillis - startTimeMillis) / 1000
		println("==================================")
		println("Program completed in " + durationSeconds + "s.")
		println("==================================")

		val g2df = spark.createDataFrame(g2.vertices)
		g2df.coalesce(1).write.format("csv").mode("overwrite").save(args(1))

	}
}