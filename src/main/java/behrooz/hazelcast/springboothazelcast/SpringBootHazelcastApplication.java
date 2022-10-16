package behrooz.hazelcast.springboothazelcast;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
@EnableCaching
public class SpringBootHazelcastApplication {
	private final Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHazelcastApplication.class, args);
	}

	@SneakyThrows
	@PostConstruct
	private void postConstruct() {
		String protocol = "https";
		if (Objects.isNull(environment.getProperty("server.ssl.key-store"))) {
			protocol = "http";
		}
		String port = environment.getProperty("server.port");
		String appName = environment.getProperty("spring.application.name");
		String url = protocol.concat("://localhost:").concat(port).concat("/swagger-ui.html");

		log.info("\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}\n\t"
						+ "External: \t{}://{}:{}\n\t"
						+ "Profile(s): \t{}\n----------------------------------------------------------",
				appName, url, protocol,
				InetAddress.getLocalHost().getHostAddress(), port, environment.getActiveProfiles());


        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(new String[]{"bash", "-c", "google-chrome ".concat(url)});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
