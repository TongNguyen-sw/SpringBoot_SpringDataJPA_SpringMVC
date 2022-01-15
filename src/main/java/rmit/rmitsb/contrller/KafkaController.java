//package rmit.rmitsb.contrller;
//
//
//
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.*;
//import rmit.rmitsb.model.Job;
//
//@RestController
//@RequestMapping(value = "/kafka")
//public class KafkaController {
//
//
//    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
////    private static final String TOPIC = "users";
//
//
//
//    @Autowired
//    private KafkaTemplate<String, Job> kafkaTemplate; //producers
//
////    @Autowired
////    private Producer producer;
//
////    @PostMapping(value = "/publish")
////    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
////        logger.info(String.format("#### -> Producing message -> %s", message));
////
////        this.kafkaTemplate.send(TOPIC, message);
////
////        return "Success";
////
////    }
//
//    @PostMapping(value = "/job/publish")
//    public String sendMessageToKafkaTopic(@RequestBody Job job) {
//        logger.info(String.format("#### -> Producing message -> %s", job.toString()));
//        this.kafkaTemplate.send("job", job);
//        return "Success";
//
//    }
//
//
//}
