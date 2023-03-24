package com.example.focourseAS.Service;

import com.example.focourseAS.Entity.Appliance;
import com.example.focourseAS.Repository.ApplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ApplianceService {

    private final ApplianceRepository applianceRepository;

    @Autowired
    public ApplianceService(ApplianceRepository applianceRepository) {
        this.applianceRepository = applianceRepository;
    }

    //saves an item with the current date
    public void save(Appliance appliance){
        appliance.setDateEntered(LocalDate.now());
        appliance.setTotalPrice(appliance.getPricePerUnit() * appliance.getQuantity());
        applianceRepository.save(appliance);
    }

    //saves item with a chosen date
    public void saveAltered(Appliance appliance, LocalDate localDate){
        appliance.setDateEntered(localDate);
        appliance.setTotalPrice(appliance.getPricePerUnit() * appliance.getQuantity());
        applianceRepository.save(appliance);
    }

    //Getting 10 records each, input the page (remember ist page starts from 0)
    public List<Appliance> getTenRecordsEach(int page){
        Pageable First10pages = PageRequest.of(page,10);
       return applianceRepository.findAll(First10pages).getContent();
    }

    //Getting 10 records each filtered by the user
    public List<Appliance> getTenRecordsEachFiltered(String first, String second, String third,
                                                     LocalDate date, LocalDate anotherDate, int page){
        Pageable First10pages = PageRequest.of(page,2);

       return applianceRepository.filterList(first, second, third, date, anotherDate,First10pages).getContent();

     //   return applianceRepository.findAll(First10pages).getContent();

    }

    //Edit or Update a record
    public Appliance updateAppliance(Long id, Appliance appliance){
        Appliance  retrievedAppliance = applianceRepository.findById(id).
                orElseThrow(()->new IllegalStateException("No such record Exists"));
        retrievedAppliance.setQuantity(appliance.getQuantity());
        retrievedAppliance.setTotalPrice(appliance.getQuantity() * appliance.getPricePerUnit());
        retrievedAppliance.setDateEntered(LocalDate.now());
        retrievedAppliance.setApplianceName(appliance.getApplianceName());
        retrievedAppliance.setCategory(appliance.getCategory());

        return applianceRepository.save(retrievedAppliance);
    }


    //  Getting Total Sales in the database
    public double getTotalSales(){
        List<Appliance> iu = applianceRepository.findAll();
        Iterator<Appliance> iterator = iu.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            Appliance name = iterator.next();
            sum = sum + name.getTotalPrice();
        }
        return sum;
    }

    //Getting the total of all the units in the dataBase
    public Long getTotalUnitsSold(){
        List<Appliance> iu = applianceRepository.findAll();
        Iterator<Appliance> iterator = iu.iterator();
        Long sum = 0L;
        while (iterator.hasNext()) {
            Appliance item = iterator.next();
            sum = sum + item.getQuantity();
        }
        return sum;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  DASHBOARD  DASHBOARD   DASHBOARD  DASHBOARD  DASHBOARD  DASHBOARD  DASHBOARD  DASHBOARD  DASHBOARD  //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getting the total of all the units in the dataBase between dates
    public Long getTotalUnitsSoldMonthly(LocalDate date, LocalDate anotherDate){
        List<Appliance> iu = applianceRepository.filterByDate(date, anotherDate);
        Iterator<Appliance> iterator = iu.iterator();
        Long sum = 0L;
        while (iterator.hasNext()) {
            Appliance item = iterator.next();
            sum = sum + item.getQuantity();
        }
        return sum;
    }

    //Total units in the dataBase for any month that will show on the dashboard
    public Long dashboardTotalUnitsPerMonth(){
        int month = LocalDate.now().getMonthValue();
        int year  = LocalDate.now().getYear();

        Long sum = getTotalUnitsSoldMonthly(LocalDate.of(year,month,01),
                LocalDate.of(year,month,LocalDate.now().lengthOfMonth()));
        return sum;
    }

    //Getting the total of all the sales in the dataBase between dates
    public double getTotalSalesSoldMonthly(LocalDate date, LocalDate anotherDate){
        List<Appliance> iu = applianceRepository.filterByDate(date, anotherDate);
        Iterator<Appliance> iterator = iu.iterator();
        double sum = 0L;
        while (iterator.hasNext()) {
            Appliance item = iterator.next();
            sum = sum + item.getTotalPrice();
        }
        return sum;
    }

    //Total Sales in the dataBase for any month that will show on the dashboard
    public double dashboardTotalSalesPerMonth(){
        int month = LocalDate.now().getMonthValue();
        int year  = LocalDate.now().getYear();

        double sum = getTotalSalesSoldMonthly(LocalDate.of(year,month,01),
                LocalDate.of(year,month,LocalDate.now().lengthOfMonth()));
        return sum;
    }







}
