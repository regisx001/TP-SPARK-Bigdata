java -jar target/stream-1.0-SNAPSHOT.jar

sudo docker cp target/stream-1.0-SNAPSHOT.jar spark-master:/root/stream-1.jar   


<!-- run in cluster -->

spark-submit --master local stream-1.jar



<!-- ML PART -->

PYSPARK_PYTHON=./venv/bin/python spark-submit pipeline.py