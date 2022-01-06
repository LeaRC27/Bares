package com.example.bares;

import com.example.bares.models.Bar;
import com.example.bares.repository.BarRepository;
import javax.validation.ConstraintViolationException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BaresRepositoryTest {
      
    @Autowired
    private BarRepository userRepository;

    @Test
    @Order(1)
    public void testSave() {
      Bar bar = new Bar();
      bar.setNombre("Bar1");
      bar.setDomicilio("Italia 5496");
      bar.setPuntuacion(2);
      bar.setEmail("bar1@gmail.com");
      bar.setTel("03416884826");
      bar.setCuit("20308510361");
      bar.setHorario("8 a 16");
      bar.setEstacionamiento(false);
      userRepository.save(bar);
      Assert.assertNotNull(userRepository.findById(1L));
    }

    @Test
    @Order(2)
    public void testSaveAndFindAll() {
        Bar bar = new Bar();
        bar.setNombre("Bar2");
        bar.setDomicilio("Italia 5496");
        bar.setPuntuacion(3);
        bar.setEmail("bar1@gmail.com");
        bar.setTel("03416884826");
        bar.setCuit("20308510362");
        bar.setHorario("8 a 16");
        bar.setEstacionamiento(false);
        userRepository.save(bar);
        Iterable<Bar> findAll = userRepository.findAll();
        assertThat(findAll).hasSize(2);               

    }
    
    @Test
    @Order(3)
    public void testDeleteAndFindAll(){
        userRepository.deleteById(1L);
        assertThat(userRepository.findById(1L)).isEmpty();
        Iterable<Bar> findAll = userRepository.findAll();
        assertThat(findAll).hasSize(1);
    }    
        
    @Test
    @Order(4)
    public void testErrorPuntuacionOutOfRange() {
        Bar bar = new Bar();
        bar.setNombre("Bar1");
        bar.setDomicilio("Italia 5496");
        bar.setPuntuacion(6);
        bar.setEmail("bar1@gmail.com");
        bar.setTel("03416884826");
        bar.setCuit("20308510361");
        bar.setHorario("8 a 16");
        bar.setEstacionamiento(false);
        assertThatThrownBy(() -> userRepository.save(bar))
                .isInstanceOf(ConstraintViolationException.class);
    }
    
    @Test
    @Order(5)
    public void testSaveWithCuilInUse(){
        Bar bar = new Bar();
        bar.setNombre("Bar1");
        bar.setDomicilio("Italia 5496");
        bar.setPuntuacion(2);
        bar.setEmail("bar1@gmail.com");
        bar.setTel("03416884826");
        bar.setCuit("20308510362");
        bar.setHorario("8 a 16");
        bar.setEstacionamiento(false);
        //userRepository.save(bar);
        assertThatThrownBy(() -> userRepository.save(bar))
                .isInstanceOf(DataIntegrityViolationException.class);
        
    }
    
}

