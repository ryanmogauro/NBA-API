package api.nba.service;
import api.nba.model.Game;
import api.nba.repository.GameRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class DataParser {

    private final GameRepo gameRepo;

    @Autowired
    public DataParser(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Transactional
    public void csvToDb(String filepath) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(filepath));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        for (CSVRecord csvRecord : csvParser.getRecords()) {
            Game game = new Game();
            game.setId(Long.parseLong(csvRecord.get("id")));
            game.setHomeTeam(csvRecord.get("homeTeam"));
            game.setAwayTeam(csvRecord.get("awayTeam"));
            game.setHomePoints(Integer.parseInt(csvRecord.get("homePoints")));
            game.setAwayPoints(Integer.parseInt((csvRecord.get("awayPoints"))));

            gameRepo.save(game);
        }

        csvParser.close();
        reader.close();
    }
}
