package com.webstore.rest;

import com.webstore.core.business.StockBusiness;
import com.webstore.rest.request.StockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "stock")
public class StockRESTController {
    private StockBusiness stockBusiness;

    @Autowired
    public StockRESTController(
            StockBusiness stockBusiness
    ) {
        this.stockBusiness = stockBusiness;
    }

    @RequestMapping(value = "/altaStock", method = RequestMethod.POST)
    public void altaStock(@RequestBody StockRequest stockRequest) throws Exception {
        stockBusiness.altaProducto(stockRequest);
    }
}
