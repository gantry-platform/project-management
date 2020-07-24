package kr.co.inslab.bootstrap;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Component
public class RestTemplateBean {
    @Bean
    public RestTemplate restTemplate() {

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(30, 10, TimeUnit.MINUTES))
                .build();
        OkHttp3ClientHttpRequestFactory crf = new OkHttp3ClientHttpRequestFactory(client);

        return new RestTemplate(crf);
    }
}

