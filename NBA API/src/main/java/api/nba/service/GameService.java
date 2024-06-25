package api.nba.service;
import api.nba.repository.GameRepo;
import api.nba.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
@Service
public class GameService {

    @Autowired
    private GameRepo gameRepository;

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Game getGamesById(Long id){
        return gameRepository.findById(id).orElse(null);
    }

    public void SaveGame(Game game){
        gameRepository.save(game);
    }

    public List<Game> getGamesByHomeTeam(String team){return gameRepository.findByHomeTeam(team);}

    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }

}
