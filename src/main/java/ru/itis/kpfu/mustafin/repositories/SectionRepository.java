package ru.itis.kpfu.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kpfu.mustafin.models.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
