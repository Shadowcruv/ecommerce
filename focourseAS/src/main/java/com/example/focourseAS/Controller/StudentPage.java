package com.example.focourseAS.Controller;

import com.example.focourseAS.Entity.Appliance;
import com.example.focourseAS.Service.ApplianceService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/generalpage")
@RestController
public class StudentPage {

    private final ApplianceService applianceService;

    public StudentPage(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    //url for getting ten records each from database
    @GetMapping("/gettenrecordseach/{page}")
    public List<Appliance> urlGetTenRecordsEach(@PathVariable int page){
        return applianceService.getTenRecordsEach(page);
    }

    //No complete
    @GetMapping("/tenrecordseach/{page}")
    public List<Appliance> urlGetTenRecordsfiltered(@RequestParam String first, @RequestParam String second,
                                                    @RequestParam String third,
                                                    @RequestParam LocalDate date, @RequestParam LocalDate anotherDate,
                                                    @PathVariable int page){

        return applianceService.getTenRecordsEachFiltered(first, second, third, date, anotherDate, page);
    }

    //No complete
    @GetMapping("/unitssoldbtwndates")
    public Long urlGetTotalUnitsSoldMonthly(@RequestParam LocalDate date, @RequestParam LocalDate anotherDate){
        return applianceService.getTotalUnitsSoldMonthly(date, anotherDate);
    }

    //No complete
    @GetMapping("/salessoldbtwdates")
    public double getTotalSalesSoldMonthly(@RequestParam LocalDate date, @RequestParam LocalDate anotherDate){
        return applianceService.getTotalSalesSoldMonthly(date, anotherDate);
    }

    //url for gettng dashboard total units per month
    @GetMapping("/unitscurrentmonth")
    public Long urlDashboardTotalUnitsPerMonth(){
        return applianceService.dashboardTotalUnitsPerMonth();
    }

    //url for gettng dashboard total units per month
    @GetMapping("/salescurrentmonth")
    public double dashboardTotalSalesPerMonth(){
        return applianceService.dashboardTotalSalesPerMonth();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////POST MAPPING/////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // url save an appliance
    @PostMapping("/save")
    public void saveAppliance( @RequestBody Appliance appliance){
        applianceService.save(appliance);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////PUT MAPPING//////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Update a record
    @PutMapping("/updaterecord/{id}")
    public Appliance updateARecord(@PathVariable Long id, @RequestBody Appliance appliance){
        return applianceService.updateAppliance(id, appliance);
    }

    @GetMapping("/profile")
    public String getProfile(){
        return "Student Profile";
    }

    @GetMapping("/about")
    public String getAboutFocourse(){
        return "About Focourse app";
    }
}
