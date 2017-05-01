import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.kpfu.itis.mustafin.models.Section;
import ru.kpfu.itis.mustafin.models.SportsClub;
import ru.kpfu.itis.mustafin.models.Teacher;
import ru.kpfu.itis.mustafin.repositories.TeacherRepository;
import ru.kpfu.itis.mustafin.services.TeacherService;
import ru.kpfu.itis.mustafin.services.impl.TeacherServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeacherServiceTest {

    final private TeacherRepository TEACHER_REP = mock(TeacherRepository.class);
    final private TeacherService teacherService = new TeacherServiceImpl(TEACHER_REP);
    private Teacher teacher;

    @Before
    public void initTeacher() {
        teacher = new Teacher();
    }

    @Test
    public void getByFullNameReturnsCorrectTeacher() {
        teacher.setFullName("Казань");
        when(TEACHER_REP.getByFullName("Казань")).thenReturn(teacher);
        Teacher testTeacher = teacherService.getByName("Казань");
        Assert.assertEquals(teacher, testTeacher);
    }

    @Test
    public void getAllReturnCorrectCities() {
        List<Teacher> teachers = new ArrayList<>();
        teacher.setFullName("Марсель Мустафин");
        teacher.setId((long) 1);
        teachers.add(0, teacher);
        when(TEACHER_REP.findAll()).thenReturn(teachers);
        List<Teacher> testCities = teacherService.getAll();
        Assert.assertEquals(teachers, testCities);
    }

    @Test
    public void addCityReturnsSameCity() {
        teacher.setFullName("Марсель Мустафин");
        when(TEACHER_REP.saveAndFlush(teacher)).thenReturn(teacher);
        Teacher testTeacher = teacherService.addTeacher(teacher);
        Assert.assertEquals(teacher, testTeacher);
    }

    @Test
    public void getBySportsClubAndSectionReturnsCorrectTeacher() {
        SportsClub sportsClub = new SportsClub();
        sportsClub.setName("Maximus");
        sportsClub.setId((long) 1);
        Section section = new Section();
        section.setName("Футбол");
        section.setId((long) 2);
        teacher.setSportsClub(sportsClub);
        teacher.setSection(section);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(0, teacher);
        when(TEACHER_REP.findBySportsClubIdAndSectionId((long) 1, (long) 2)).thenReturn(teachers);
        List<Teacher> testTeachers = teacherService.getBySportsClubAndSection((long) 1, (long) 2);
        Assert.assertEquals(teachers, testTeachers);
    }
}
