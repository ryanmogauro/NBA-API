package api.nba.repository;
import api.nba.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {
    List<Game> findByHomeTeam(String homeTeam);
}


