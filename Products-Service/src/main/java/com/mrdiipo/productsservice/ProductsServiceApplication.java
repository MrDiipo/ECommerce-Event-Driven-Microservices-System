package com.mrdiipo.productsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsServiceApplication.class, args);
    }

//    @Bean
//    public CommandRouter springCloudCommandRouter(@Autowired DiscoveryClient discoveryClient, Registration localServiceInstance) {
//        return SpringCloudCommandRouter.builder()
//                .discoveryClient((org.springframework.cloud.client.discovery.DiscoveryClient) discoveryClient)
//                .routingStrategy(new AnnotationRoutingStrategy())
//                .localServiceInstance((org.springframework.cloud.client.serviceregistry.Registration) localServiceInstance)
//                .build();
//    }
//    @Bean
//    public CommandBusConnector springHttpCommandBusConnector(
//            @Qualifier("localSegment") CommandBus localSegment,
//            RestOperations restOperations,
//            Serializer serializer) {
//        return SpringHttpCommandBusConnector.builder()
//                .localCommandBus(localSegment)
//                .restOperations(restOperations)
//                .serializer(serializer)
//                .build();
//    }
//    @Primary // to make sure this CommandBus implementation is used for autowiring
//    @Bean
//    public DistributedCommandBus springCloudDistributedCommandBus(
//            CommandRouter commandRouter,
//            CommandBusConnector commandBusConnector) {
//        return DistributedCommandBus.builder()
//                .commandRouter(commandRouter)
//                .connector(commandBusConnector)
//                .build();
//    }
}


