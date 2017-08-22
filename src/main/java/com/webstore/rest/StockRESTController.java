package com.webstore.rest;

import com.webstore.core.business.StockBusiness;
import com.webstore.core.entity.StockEntity;
import com.webstore.rest.request.PagoRequest;
import com.webstore.rest.request.StockRequest;
import com.webstore.rest.response.GenerarPagoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/generarPago", method = RequestMethod.POST)
    public GenerarPagoResponse generarPago(@RequestBody PagoRequest pagoRequest) throws Exception {
        return stockBusiness.generarPago(pagoRequest);
    }
}
