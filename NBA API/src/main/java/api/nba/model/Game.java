package api.nba.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String homeTeam;
    private String awayTeam;
    private int homePoints;
    private int awayPoints;
    private LocalDate date;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getHomeTeam(){
        return this.homeTeam;
    }

    public void setHomeTeam(String homeTeam){
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam(){
        return this.awayTeam;
    }

    public void setAwayTeam(String awayTeam){
        this.awayTeam = awayTeam;
    }

    public int getHomePoints(){
        return this.homePoints;
    }

    public void setHomePoints(int homePoints){
        this.homePoints = homePoints;
    }

    public int getAwayPoints(){
        return this.awayPoints;
    }

    public void setAwayPoints(int awayPoints){
        this.awayPoints = awayPoints;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

}
