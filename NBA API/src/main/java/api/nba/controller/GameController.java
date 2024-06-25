package api.nba.controller;
import api.nba.model.Game;
import java.util.List;
import api.nba.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    public GameController(GameService gs) {
        this.gameService = gs;
    }

    @GetMapping
    public List<Game> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/id")
    public ResponseEntity<Game> getGameById(@PathVariable Long id){
        Game game = gameService.getGamesById(id);
        return game != null ? ResponseEntity.ok(game) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Game> deleteGame(@PathVariable Long id){
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/homeTeam/{homeTeam}")
    public List<Game> getGamesByHomeTeam(@PathVariable String homeTeam) {
        return gameService.getGamesByHomeTeam(homeTeam);
    }



}
