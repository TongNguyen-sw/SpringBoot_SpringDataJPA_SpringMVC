//package rmit.rmitsb.engine;
//
//
//
////import rmit.rmitsb.model.Sensor;
////import rmit.rmitsb.repository.SensorDBRepo;
////import rmit.rmitsb.service.SensorRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//
//import java.io.IOException;
//
//@Service
//public class Consumer {
//
//    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
//
//    @Autowired
//    private SensorDBRepo sensorDBRepo;
//
//    @Autowired
//    private SensorRepository sensorRepository;
//
//    @KafkaListener(topics = "sensor", groupId = "group_id")
//    public void consume(Sensor sensor) throws IOException {
//        logger.info(String.format("#### -> Consumed message -> %s", sensor.toString()));
//        this.sensorRepository.save(sensor);
//        sensorDBRepo.save(sensor);
//        logger.info(String.format("#### -> ID message -> %s", sensor.getId()));
//    }
//}
