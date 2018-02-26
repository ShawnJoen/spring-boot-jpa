package com.idea.example;

import com.idea.example.domain.City;
import com.idea.example.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*lombok
* @Slf4j 内置日志门面 可以直接通过变量log使用
* */
@Slf4j
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value="hello")
    public String hello(){
        return "hello";
    }

//http://localhost:8080/api/findByCityNameLikeAndIdGreaterThan?cityName=%E8%99%B9%E5%8F%A3&id=10
    @RequestMapping(value = "api/findByCityNameLikeAndIdGreaterThan", method = RequestMethod.GET)
    public @ResponseBody
    List<City> findByCityNameLikeAndIdGreaterThan(@RequestParam(value = "cityName", required = true) String cityName,
                                                  @RequestParam(value = "id", required = true) Long id) {
        return cityService.findByCityNameLikeAndIdGreaterThan(cityName, id);
    }
//http://localhost:8080/api/findCityNameLike22?cityName=%E8%99%B9%E5%8F%A3
    @RequestMapping(value = "api/findCityNameLike22", method = RequestMethod.GET)
    public @ResponseBody
    List<City> findCityNameLike22(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityNameLike22(cityName);
    }
//http://localhost:8080/api/findByCityNameLikeAndDescriptionIs?cityName=%E8%99%B9%E5%8F%A3%E5%8C%BA7&description=%E5%8C%BA7
    @RequestMapping(value = "api/findByCityNameLikeAndDescriptionIs", method = RequestMethod.GET)
    public @ResponseBody
    List<City> findByCityNameLikeAndDescriptionIs(@RequestParam(value = "cityName", required = true) String cityName,
                                                  @RequestParam(value = "description", required = true) String description) {
        return cityService.findByCityNameLikeAndDescriptionIs(cityName, description);
    }
//http://localhost:8080/api/findById22?id=10
    @RequestMapping(value = "api/findById22", method = RequestMethod.GET)
    public @ResponseBody
    City findById22(@RequestParam(value = "id", required = true) Long id) {
        return cityService.findById22(id);
    }
//http://localhost:8080/api/deleteIsId33?id=7
    @RequestMapping(value = "api/deleteIsId33", method = RequestMethod.GET)
    public @ResponseBody
    int deleteIsId33(@RequestParam(value = "id", required = true) Long id) {
        return cityService.deleteIsId33(id);
    }
//http://localhost:8080/api/deleteInIds22?ids=5,13,20,19
    @RequestMapping(value = "api/deleteInIds22", method = RequestMethod.GET)
    public @ResponseBody
    int deleteInIds22(@RequestParam(value = "ids", required = true) String ids) {
        return cityService.deleteInIds22(ids);
    }
//http://localhost:8080/api/updateSetCityNameAndDescriptionInId?cityName=虹口区99&description=区66&id=4
    @RequestMapping(value = "api/updateSetCityNameAndDescriptionInId", method = RequestMethod.GET)
    public @ResponseBody
    int updateSetCityNameAndDescriptionInId(@RequestParam(value = "cityName", required = true)String cityName,
                                            @RequestParam(value = "description", required = true)String description,
                                            @RequestParam(value = "id", required = true)Long id) {
        return cityService.updateSetCityNameAndDescriptionInId(cityName, description, id);
    }
//http://localhost:8080/api/createCity?cityName=深圳&description=一线城市&provinceId=0
    @RequestMapping(value = "api/createCity", method = RequestMethod.GET)
    public @ResponseBody
    Long createCity(@RequestParam(value = "cityName", required = true)String cityName,
                                            @RequestParam(value = "description", required = true)String description,
                                            @RequestParam(value = "provinceId", required = true)Long provinceId) {
        return cityService.createCity(cityName, description, provinceId);
    }
//http://localhost:8080/api/createCitys
    @RequestMapping(value = "api/createCitys", method = RequestMethod.GET)
    public @ResponseBody
    int createCitys() {
        return cityService.createCitys();
    }
}
