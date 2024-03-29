package xagh.technical_test.aldeamo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.AllArgsConstructor;
import xagh.technical_test.aldeamo.application.ports.CreateInitialDataPort;

@SpringBootApplication
@AllArgsConstructor
public class AldeamoApplication {

	@Autowired
	private final CreateInitialDataPort createInitialDataPort;

	public static void main(String[] args) {
		SpringApplication.run(AldeamoApplication.class, args);
	}

	// Application event that execute once on appication starts that validate
	// database data.
	@EventListener(ApplicationReadyEvent.class)
	public void ExecuteOnceOnApplicationStarts() {
		createInitialDataPort.createStacks();
	}

}
