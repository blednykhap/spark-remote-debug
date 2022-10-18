package org.sinoptik

import org.apache.spark.sql.SparkSession

object test_debug {

  def main(args: Array[String]): Unit = {

    println("========== Spark Remote Debug (start) ==========")

    val spark = SparkSession.builder()
      .appName("Remote Debug")
      .master("yarn")
      .config("spark.hadoop.fs.defaultFS", "hdfs://192.168.231.144:8020")
      .config("spark.hadoop.yarn.resourcemanager.address", "192.168.231.144:8050") // :8032
      .config("spark.yarn.jars", "hdfs://192.168.231.144:8020/user/Sinoptik/jars/*.jar")
      //.config("spark.hadoop.yarn.application.classpath", "$HADOOP_COMMON_HOME/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HIVE_HOME/*,$HIVE_HOME/*,$HIVE_HOME/lib/*")
      //.config("yarn.application.classpath", "$HADOOP_CONF_DIR,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*")
      .config("hive.metastore.uris", "thrift://192.168.231.146:9083")
      //.config("hive.metastore.warehouse.dir", "hdfs://192.168.231.146:8020/apps/hive/warehouse")
      .enableHiveSupport()
      .getOrCreate()

    println("========== Spark Remote Debug (finish) ==========")

  }

}
