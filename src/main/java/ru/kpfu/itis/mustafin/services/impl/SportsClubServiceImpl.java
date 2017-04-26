package ru.kpfu.itis.mustafin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.mustafin.models.SportsClub;
import ru.kpfu.itis.mustafin.repositories.SportsClubRepository;
import ru.kpfu.itis.mustafin.services.SportsClubService;

import java.util.List;

@Service
@Transactional
public class SportsClubServiceImpl implements SportsClubService {

    private final SportsClubRepository repository;

    @Autowired
    public SportsClubServiceImpl(SportsClubRepository sportsClubRepository){
        this.repository = sportsClubRepository;
    }

    @Override
    public SportsClub addSportsClub(SportsClub sportsClub) {
        return repository.saveAndFlush(sportsClub);
    }

    @Override
    public List<SportsClub> getAll() {
        return repository.findAll();
    }

    @Override
    public SportsClub getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<SportsClub> getByCityId(long cityId) {
        return repository.findByCity_Id(cityId);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
