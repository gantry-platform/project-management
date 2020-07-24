package kr.co.inslab.bootstrap;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

@Component
public class RestTemplateBean {
    @Bean
    public RestTemplate restTemplate() {

        OkHttp3ClientHttpRequestFactory crf = null;

        try {
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .connectionPool(new ConnectionPool(30, 10, TimeUnit.MINUTES))
                    .build();
            crf = new OkHttp3ClientHttpRequestFactory(okHttpClient);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new RestTemplate(crf);
    }
}
