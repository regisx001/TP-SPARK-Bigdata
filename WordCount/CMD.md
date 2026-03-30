sudo docker cp target/wordcount-1.0.jar spark-master:/root/wordcount-1.jar   
sudo docker cp src/main/resources/loremipsum.txt spark-master:/root/input/loremipsum.txt

cd /root
spark-submit --master local wordcount-1.jar input/loremipsum.txt output
