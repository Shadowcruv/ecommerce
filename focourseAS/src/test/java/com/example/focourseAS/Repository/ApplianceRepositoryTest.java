package com.example.focourseAS.Repository;

import com.example.focourseAS.Entity.Appliance;
import com.example.focourseAS.Service.ApplianceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplianceRepositoryTest {

    @Autowired
    private ApplianceService applianceService;

    @Autowired
    private ApplianceRepository applianceRepository;

    @Test
    public void save(){
      Appliance Item1 = new Appliance("Refrigerator CSE11","electronics",
                130000,1);
        applianceService.save(Item1);

    }
    @Test
    public void saveChoseDate(){
        Appliance Item1 = new Appliance("Refrigerator CSE33","electronics",
                130000,2);
        applianceService.saveAltered(Item1,LocalDate.of(2023,03,11));

    }


    @Test
    public void getTotalUnitsSoldMonth(){
        List<Appliance> iu = applianceRepository.filterByFEB();
        Iterator<Appliance> iterator = iu.iterator();
        while (iterator.hasNext()) {
            Appliance item = iterator.next();
            System.out.println("items :" + item);
        }
    }

    @Test
    public void getTotalUnitsgSoldMonth(){
        List<Appliance> iu = applianceRepository.findAll();
        Iterator<Appliance> iterator = iu.iterator();
        while (iterator.hasNext()) {
            Appliance item = iterator.next();
            System.out.println("items :" + item);
        }
    }

    @Test
    public void getAllList(){
        List<Appliance> iu = applianceRepository.findAll();
        System.out.println("items Filtered :" + iu);
    }

    @Test
    public void getFilteredList(){

        List<Appliance> iu = applianceService.getTenRecordsEachFiltered("electronics",null,
                "electronics",
                  LocalDate.of(2023,03,18),LocalDate.of(2023,04,11),
                0);
        System.out.println("items Filtered :" + iu);
    }

}





