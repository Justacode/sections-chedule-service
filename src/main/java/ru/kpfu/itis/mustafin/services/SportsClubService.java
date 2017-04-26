package ru.kpfu.itis.mustafin.services;

import ru.kpfu.itis.mustafin.models.SportsClub;

import java.util.List;

public interface SportsClubService {

    SportsClub addSportsClub(SportsClub sportsClub);

    List<SportsClub> getAll();

    SportsClub getById(long id);

    List<SportsClub> getByCityId(long cityId);

    void delete(long id);
}
