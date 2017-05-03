package com.ilyasov.controller;

import com.ilyasov.model.City;
import com.ilyasov.model.Schedule;
import com.ilyasov.model.ServiceType;
import com.ilyasov.model.Worker;
import com.ilyasov.service.CityService;
import com.ilyasov.service.ScheduleService;
import com.ilyasov.service.ServiceTypeService;
import com.ilyasov.service.WorkersService;
import com.ilyasov.util.CityForm;
import com.ilyasov.util.ScheduleForm;
import com.ilyasov.util.ServiceForm;
import com.ilyasov.util.WorkerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private final CityService cityService;
    private final ServiceTypeService serviceTypeService;
    private final WorkersService workersService;
    private final ScheduleService scheduleService;

    @Autowired
    public AdminController(ScheduleService scheduleService, WorkersService workersService, CityService cityService, ServiceTypeService serviceTypeService) {
        this.cityService = cityService;
        this.serviceTypeService = serviceTypeService;
        this.workersService = workersService;
        this.scheduleService = scheduleService;
    }

    @RequestMapping("/deletecity/{cityId}")
    public String deleteCity(@PathVariable("cityId") Long cityId) {
        cityService.delete(cityService.getCityById(cityId));
        return "redirect:/admin";
    }

    @RequestMapping("/deleteservice/{serviceId}")
    public String deleteService(@PathVariable("serviceId") Long serviceId) {
        serviceTypeService.delete(serviceTypeService.findOneById(serviceId));
        return "redirect:/admin";
    }

    @RequestMapping("/deleteworker/{workerId}")
    public String deleteWorker(@PathVariable("workerId") Long workerId) {
        workersService.delete(workersService.findOneById(workerId));
        return "redirect:/admin";
    }

//    @RequestMapping("/deleteschedule/{scheduleId}")
//    public String deleteSchedule(@PathVariable("scheduleId") Long scheduleId) {
//        scheduleService.delete(scheduleService.findOneById(scheduleId));
//        return "redirect:/admin";
//    }

    @RequestMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("cityForm", new CityForm());
        return "citiesadmin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String addCity(Model model, @ModelAttribute("cityForm") @Valid CityForm cityForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cities", cityService.getAllCities());
            model.addAttribute("cityForm", new CityForm());
            model.addAttribute("error", "Bad name!");
            return "citiesadmin";
        }
        City city = new City();
        city.setName(cityForm.getName());
        cityService.add(city);
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("cityForm", new CityForm());
        return "citiesadmin";
    }

    @RequestMapping("/admin/{cityId}")
    public String getServices(Model model, @PathVariable("cityId") Long cityId) {
        model.addAttribute("services", serviceTypeService.getAllServicesByCity(cityService.getCityById(cityId)));
        model.addAttribute("url", "/admin/" + cityId);
        model.addAttribute("serviceForm", new ServiceForm());
        return "servadmin";
    }

    @RequestMapping(value = "/admin/{cityId}", method = RequestMethod.POST)
    public String addService(Model model, @PathVariable("cityId") Long cityId, @ModelAttribute("serviceForm") @Valid ServiceForm serviceForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("services", serviceTypeService.getAllServicesByCity(cityService.getCityById(cityId)));
            model.addAttribute("url", "/admin/" + cityId);
            model.addAttribute("serviceForm", new ServiceForm());
            model.addAttribute("error", "Bad name of service!");
            return "servadmin";
        }

        ServiceType serviceType = new ServiceType();
        serviceType.setName(serviceForm.getName());
        serviceType.setCity(cityService.getCityById(cityId));
        serviceTypeService.add(serviceType);
        model.addAttribute("services", serviceTypeService.getAllServicesByCity(cityService.getCityById(cityId)));
        model.addAttribute("url", "/admin/" + cityId);
        model.addAttribute("serviceForm", new ServiceForm());
        return "servadmin";
    }

    @RequestMapping("/admin/{cityId}/{serviceId}")
    public String getWorkers(Model model, @PathVariable("cityId") Long cityId,
                             @PathVariable("serviceId") Long serviceId) {
        model.addAttribute("workerForm", new WorkerForm());
        model.addAttribute("workers", workersService.getWorkersByServiceType(serviceTypeService.findOneById(serviceId)));
        model.addAttribute("url", "/admin/" + cityId + "/" + serviceId);
        return "workersadmin";
    }

    @RequestMapping(value = "/admin/{cityId}/{serviceId}", method = RequestMethod.POST)
    public String addWorker(Model model, @PathVariable("cityId") Long cityId,
                            @PathVariable("serviceId") Long serviceId,
                            @ModelAttribute("workerForm") @Valid WorkerForm workerForm,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("workerForm", new WorkerForm());
            model.addAttribute("workers", workersService.getWorkersByServiceType(serviceTypeService.findOneById(serviceId)));
            model.addAttribute("url", "/admin/" + cityId + "/" + serviceId);
            model.addAttribute("error", "Incorrect Data!");
            return "workersadmin";
        }
        Worker worker = new Worker();
        worker.setName(workerForm.getName());
        worker.setAge(workerForm.getAge());
        worker.setCompanyName(workerForm.getCompanyName());
        worker.setRegalia(workerForm.getRegalias());
        worker.setCity(cityService.getCityById(cityId));
        worker.setServiceType(serviceTypeService.findOneById(serviceId));
        worker.setPhoneNumber(workerForm.getPhoneNumber());
        worker.setWorkExperience(workerForm.getWorkExperience());
        workersService.add(worker);
        model.addAttribute("workerForm", new WorkerForm());
        model.addAttribute("workers", workersService.getWorkersByServiceType(serviceTypeService.findOneById(serviceId)));
        model.addAttribute("url", "/admin/" + cityId + "/" + serviceId);
        return "workersadmin";
    }

    @RequestMapping("admin/{cityId}/{serviceId}/{workerId}")
    public String getSchedule(Model model, @PathVariable("workerId") Long workerId, @PathVariable("cityId") Long cityId,
                              @PathVariable("serviceId") Long serviceId) {
        List schedule = scheduleService.findAllByWorker(workersService.findOneById(workerId));
        model.addAttribute("schedules", schedule);
        model.addAttribute("scheduleForm", new ScheduleForm());
        model.addAttribute("url", "/admin/" + cityId + "/" + serviceId + "/" + workerId);
        return "scheduleadmin";
    }

    @RequestMapping(value = "admin/{cityId}/{serviceId}/{workerId}", method = RequestMethod.POST)
    public String replaceSchedule(Model model, @PathVariable("workerId") Long workerId, @PathVariable("serviceId") Long serviceId, @PathVariable("cityId") Long cityId, @ModelAttribute("scheduleForm") @Valid ScheduleForm scheduleForm) {
        List<Schedule> list = scheduleService.getAll();
        for ( Schedule schedule : list){
            if (schedule.getWorker().getId() == workerId){
                System.out.println("ASDASDASDASDASDASDASDASDASD");
                scheduleService.delete(workerId);
            } else {
                System.out.println("NENENENENENE");
            }
        }
        Schedule schedule1 = new Schedule();
        schedule1.setMonday(scheduleForm.getMonday());
        schedule1.setTuesday(scheduleForm.getTuesday());
        schedule1.setWednesday(scheduleForm.getWednesday());
        schedule1.setThursday(scheduleForm.getThursday());
        schedule1.setFriday(scheduleForm.getFriday());
        schedule1.setSaturday(scheduleForm.getSaturday());
        schedule1.setSunday(scheduleForm.getSunday());
        schedule1.setWorker(workersService.findOneById(workerId));
        if (schedule1.getMonday().equals("")) schedule1.setMonday("--");
        if (schedule1.getFriday().equals("")) schedule1.setFriday("--");
        if (schedule1.getSaturday().equals("")) schedule1.setSaturday("--");
        if (schedule1.getSunday().equals("")) schedule1.setSunday("--");
        if (schedule1.getThursday().equals("")) schedule1.setThursday("--");
        if (schedule1.getTuesday().equals("")) schedule1.setTuesday("--");
        if (schedule1.getWednesday().equals("")) schedule1.setWednesday("--");
        scheduleService.add(schedule1);
        model.addAttribute("schedules", scheduleService.findAllByWorker(workersService.findOneById(workerId)));
        model.addAttribute("scheduleForm", new ScheduleForm());
        model.addAttribute("url", "/admin/" + cityId + "/" + serviceId + "/" + workerId);
        return "scheduleadmin";
    }

}
