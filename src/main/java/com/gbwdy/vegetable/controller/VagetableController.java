package com.gbwdy.vegetable.controller;

import com.gbwdy.vegetable.service.VegetableService;
import com.gbwdy.vegetable.util.UploadUtil;
import com.gbwdy.vegetable.vo.Vegetable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 */
@Controller
public class VagetableController {

    private String filePath;
    @Resource
    VegetableService vegetableService;

    @RequestMapping(value = "/findVegetableByCode",method = RequestMethod.GET)
    public String findVegetableByCode(@RequestParam("code") String code, Model model){
        Vegetable vegetable = vegetableService.findVegetableByCode(code);
        model.addAttribute("vegetable",vegetable);
        return "detail";
    }
    @RequestMapping(value = "/addVegetable",method = RequestMethod.POST)
    public String addVegetable(@RequestParam("photo") MultipartFile file, @RequestParam("name") String name, @RequestParam("code")String code,
                               @RequestParam("birthday") Date birthday, @RequestParam("time") Date time, @RequestParam("product") String product,
                               @RequestParam("checker") String checker, @RequestParam("plantingHistory") String plantingHistory, @RequestParam("place") String place,
                               @RequestParam("price") double price,HttpServletRequest request,Model model)throws  Exception{
        String image = uploadImg(file,request);
        Vegetable vegetable = new Vegetable();
        vegetable.setChecker(checker);
        vegetable.setBirthday(birthday);
        vegetable.setCode(code);
        vegetable.setImage(image);
        vegetable.setName(name);
        vegetable.setPlantingHistory(plantingHistory);
        vegetable.setProduct(product);
        vegetable.setPrice(price);
        vegetable.setPlace(place);
        vegetable.setTime(time);
        System.out.println(vegetable.getBirthday());;
        vegetableService.addVegetable(vegetable);
        model.addAttribute("vegetable",vegetable);
        return "detail";
    }


    public String uploadImg( MultipartFile file,
                     HttpServletRequest request) throws Exception {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String newFileName = UploadUtil.getRandomFileName(fileName);
        if(filePath == null || filePath.equals("")){
            filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        }
        String key = UploadUtil.uploadFile(file.getBytes(),filePath,newFileName);
        if(key==null){
            return null;
        }
        //返回json
        return key;
    }
}
