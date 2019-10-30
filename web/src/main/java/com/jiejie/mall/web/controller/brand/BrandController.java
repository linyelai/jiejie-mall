package com.jiejie.mall.web.controller.brand;

import com.jiejie.mall.web.controller.brand.request.AddBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.UpdateBrandWebRequest;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    @PostMapping("/brand")
    public CommonWebResponse<Boolean> addBrand(@RequestBody AddBrandWebRequest webResquest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;
    }
    @PutMapping("/brand")
    public CommonWebResponse<Boolean> updateBrand(@RequestBody UpdateBrandWebRequest webResquest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;
    }

}
