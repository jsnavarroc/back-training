/*
package co.jsnvarroc.orders.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticSearchConfiguration {

    @Bean
    @Profile({"dev","prod"})
    public Client elasticSearch()throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        return new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(localhost,9300));
    }
}
*/
