package ru.kpfu.itis.mustafin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.mustafin.models.Section;
import ru.kpfu.itis.mustafin.models.SportsClub;
import ru.kpfu.itis.mustafin.repositories.SectionRepository;
import ru.kpfu.itis.mustafin.services.SectionService;

import java.util.List;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

    private SectionRepository repository;

    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository){
        this.repository = sectionRepository;
    }

    @Override
    public Section addSection(Section section) {
        return repository.saveAndFlush(section);
    }

    @Override
    public List<Section> getAll() {
        return repository.findAll();
    }

    @Override
    public Section getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Section> getIfTeachersExist(long clubId) {
        return repository.findSectionsByClub(clubId);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
