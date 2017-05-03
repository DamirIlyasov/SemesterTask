package com.ilyasov.controller;

import com.ilyasov.model.Schedule;
import com.ilyasov.service.CityService;
import com.ilyasov.service.ScheduleService;
import com.ilyasov.service.ServiceTypeService;
import com.ilyasov.service.WorkersService;
import com.ilyasov.util.CityForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class MainController {


    private final CityService cityService;
    private final ServiceTypeService serviceTypeService;
    private final WorkersService workersService;
    private final ScheduleService scheduleService;

    @Autowired
    public MainController(ScheduleService scheduleService,WorkersService workersService,CityService cityService, ServiceTypeService serviceTypeService) {
        this.cityService = cityService;
        this.scheduleService = scheduleService;
        this.serviceTypeService = serviceTypeService;
        this.workersService = workersService;
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("cities",cityService.getAllCities());
        return "home";
    }
    @RequestMapping("/home/{cityId}")
    public String getServices(Model model, @PathVariable("cityId") Long cityId){
        model.addAttribute("services",serviceTypeService.getAllServicesByCity(cityService.getCityById(cityId)));
        model.addAttribute("url","/home/"+cityId+"/");
        return "services";
    }

    @RequestMapping("/home/{cityId}/{serviceId}")
    public String getWorkers(Model model, @PathVariable("serviceId") Long serviceId,
                             @PathVariable("cityId") Long cityId){
        model.addAttribute("workers", workersService.getWorkersByServiceType(serviceTypeService.findOneById(serviceId)));
        model.addAttribute("url","/home/"+cityId+"/"+serviceId+"/");
        return "workers";
    }
    @RequestMapping("home/{cityId}/{serviceId}/{workerId}")
    public String getSchedule(Model model, @PathVariable("workerId") Long workerId){
        List schedules = scheduleService.findAllByWorker(workersService.findOneById(workerId));
        model.addAttribute("schedules", schedules);
        return "schedule";
    }


}
