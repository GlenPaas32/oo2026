package ee.gpaas.projekt.service;

import ee.gpaas.projekt.entity.Athlete;
import ee.gpaas.projekt.entity.Result;
import ee.gpaas.projekt.repository.AthleteRepository;
import ee.gpaas.projekt.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private PointsCalculatorService pointsCalculatorService;

    public Athlete createAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }
    public Integer getTotalPoints(Long id) {
        Athlete athlete = getAthleteById(id);
        return athlete.getResults().stream().
                mapToInt(Result::getPoints)
                .sum();
    }
    public Athlete getAthleteById(Long athleteId) {
        return athleteRepository.findById(athleteId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Sportlast ei leitud ID-ga: " + athleteId
                ));
    }

    public Result addResult(Long athleteId, Result result) {
        Athlete athlete = getAthleteById(athleteId);

        if (result.getDiscipline() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Spordiala peab olema määratud");
        }

        if (result.getResultValue() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tulemus peab olema suurem kui 0");
        }

        int points = pointsCalculatorService.calculatePoints(result);
        result.setPoints(points);

        result.setAthlete(athlete);
        athlete.getResults().add(result);

        return resultRepository.save(result);
    }

}