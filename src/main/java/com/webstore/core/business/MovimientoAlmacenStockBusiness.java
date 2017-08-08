package com.webstore.core.business;

import com.webstore.core.entity.MovimientoAlmacenStockEntity;
import com.webstore.core.repository.AlmacenRepository;
import com.webstore.core.repository.EmpleadoRepository;
import com.webstore.core.repository.MovimientoAlmacenStockRepository;
import com.webstore.core.repository.StockRepository;
import com.webstore.rest.request.MovimientoAlmacenStockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovimientoAlmacenStockBusiness {
    private MovimientoAlmacenStockRepository movimientoAlmacenStockRepository;
    private AlmacenRepository almacenRepository;
    private EmpleadoRepository empleadoRepository;
    private StockRepository stockRepository;

    @Autowired
    public MovimientoAlmacenStockBusiness(
            MovimientoAlmacenStockRepository movimientoAlmacenStockRepository,
            AlmacenRepository almacenRepository,
            EmpleadoRepository empleadoRepository,
            StockRepository stockRepository
    ) {
        this.movimientoAlmacenStockRepository = movimientoAlmacenStockRepository;
        this.almacenRepository = almacenRepository;
        this.empleadoRepository = empleadoRepository;
        this.stockRepository  = stockRepository;
    }

    public void altaMovimientoAlmacenStock(MovimientoAlmacenStockRequest movimientoAlmacenStockRequest) throws Exception {
        if(!almacenRepository.exists(movimientoAlmacenStockRequest.getiIdAlmacenDestino())){
            throw new Exception("El almacen de destino no existe");
        }
        if(!almacenRepository.exists(movimientoAlmacenStockRequest.getiIdAlmacenOrigen())){
            throw new Exception("El almacen de origen no existe");
        }
        if(!empleadoRepository.exists(movimientoAlmacenStockRequest.getiIdEmpleado())){
            throw new Exception("El empleado solicitado no existe");
        }
        if(!stockRepository.exists(movimientoAlmacenStockRequest.getcSkuStock())){
            throw new Exception("El almacen de destino no existe");
        }
        MovimientoAlmacenStockEntity movimientoAlmacenStockEntity = new MovimientoAlmacenStockEntity();
        movimientoAlmacenStockEntity.setiIdAlmacenDestino(movimientoAlmacenStockRequest.getiIdAlmacenDestino());
        movimientoAlmacenStockEntity.setiIdAlmacenOrigen(movimientoAlmacenStockRequest.getiIdAlmacenOrigen());
        movimientoAlmacenStockEntity.setiIdEmpleado(movimientoAlmacenStockRequest.getiIdEmpleado());
        movimientoAlmacenStockEntity.setcSkuStock(movimientoAlmacenStockRequest.getcSkuStock());
        movimientoAlmacenStockRepository.save(movimientoAlmacenStockEntity);
    }
}
