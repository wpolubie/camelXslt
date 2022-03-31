package com.example.cameltutorial;

import org.apache.camel.builder.RouteBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder  {

    @Value("${map}")
    private String map;
    @Value("${from}")
    private String from;
    @Value("${to}")
    private String to;

    public String getMap() {
        return "xslt-saxon:file://" + map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getFrom() {
        return "file://" + from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return "file://" + to;
    }

    public void setTo(String to) {
        this.to = to;
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        setFrom(String.valueOf(args.getOptionValues("from")));
//        setTo(String.valueOf(args.getOptionValues("to")));
//        setMap(String.valueOf(args.getOptionValues("map")));
//// premium
//        System.out.println(String.valueOf(args.getOptionValues("from")));
//        System.out.println(String.valueOf(args.getOptionValues("to")));
//        System.out.println(String.valueOf(args.getOptionValues("map")));
//    }

    @Override
    public void configure() throws Exception {
        from(getFrom())
                .log("file ${header.CamelFileName} from ${header.CamelFilePath} at ${date:now:yyyyMMddHHmm}")
                .to(getMap())
                .log("running map ${header.CamelFileName} with file ${header.CamelFileName} at ${date:now:yyyyMMddHHmm} ")
                .to(getTo());
    }



}
