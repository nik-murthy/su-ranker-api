package com.suranker.api.Controller;


import com.suranker.api.Constants;
import com.suranker.api.Entity.Suburbs;
import com.suranker.api.Service.SuburbService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SuburbRankerController {

    @Autowired
    SuburbService suburbService;

/*    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value="/api/v1/suburbs")
    @ResponseBody*/
    /*public List<Suburbs> getSuburbs(@RequestParam(defaultValue = "All") String state,
                                    @RequestParam(defaultValue = "1") int pageNo,
                                    @RequestParam int mmp,
                                    @RequestParam(defaultValue = "house") String type) {
*/

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value="/api/v1/suburbs")
    @ResponseBody
    public List<Suburbs> getSuburbs(@RequestParam(defaultValue = Constants.defaultStateSelection) String state,
                                    @RequestParam(defaultValue = Constants.defaultPageNo) String pageNo,
                                    @RequestParam(required = false) String mmp,
                                    @RequestParam(defaultValue = Constants.propertyTypeHouse) String type) {

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(Constants.stateParameter, state);
        paramMap.put(Constants.pageNumberParameter, pageNo);
        if(!StringUtils.isBlank(mmp)) {
            paramMap.put(Constants.maximumMedianPriceParameter, mmp);
        }
        paramMap.put(Constants.propertyTypeParameter, type);

        return suburbService.getSuburbs(paramMap);
    }
}
