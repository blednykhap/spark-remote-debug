# Spark remote debug

1. Add user 
    ```
    sudo useradd tonny
    ```
2. Add HDFS-user home directory
    ```
    sudo -u hdfs hdfs dfs -mkdir /user/tonny
    ```
3. Change permission for the HDFS-directory
    ```
    sudo -u hdfs hdfs dfs -chown tonny /user/tonny
    ```
4. Create jars directory
    ```
    sudo -u tonny hdfs dfs -mkdir /user/tonny/jars
    ```
5. Add jars to home directory
    ```
    sudo -u tonny hdfs dfs -put /usr/lib/spark/jars/* /user/tonny/jars/
    ```
6. Add following dependency
    ```
    "org.apache.spark" %% "spark-yarn" % "2.3.1"
    "org.apache.spark" %% "spark-sql" % "2.3.1"
    ```
7. Use following snippet of code

    ```
    val spark = SparkSession.builder()
      .appName("Remote Debug")
      .master("yarn")
      .config("spark.hadoop.fs.defaultFS", "hdfs://192.168.231.144:8020")
      .config("spark.hadoop.yarn.resourcemanager.address", "192.168.231.144:8050") // :8032
      .config("spark.yarn.jars", "hdfs://192.168.231.144:8020/user/Sinoptik/jars/*.jar")
      .getOrCreate()
    ```
