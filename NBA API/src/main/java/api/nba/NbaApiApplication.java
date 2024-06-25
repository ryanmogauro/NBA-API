package api.nba;
import api.nba.service.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class NbaApiApplication implements CommandLineRunner{

	private final DataParser dataParser;

	@Autowired
    public NbaApiApplication(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    public static void main(String[] args) {
		SpringApplication.run(NbaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Replace with your actual CSV file path
		String filepath = "/Users/ryan/Desktop/nbaData/games.csv";
		dataParser.csvToDb(filepath);
	}


}
