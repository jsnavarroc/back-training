package co.jsnvarroc.orders.configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;

public class AwsConfiguration {
    @Bean
    public AmazonS3 s3Client(){
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.DEFAULT_REGION)
                .build();
    }
}
