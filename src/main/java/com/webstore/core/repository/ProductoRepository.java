package com.webstore.core.repository;

import com.webstore.core.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {
    @Query(value = "SELECT * FROM webstore.producto LIMIT ?1", nativeQuery = true)
    List<ProductoEntity> findProductosLimit(Integer limit);

    @Query(value = "SELECT * FROM webstore.producto p " +
            "join webstore.tipo_producto t on p.I_ID_TIPO=t.ID " +
            "join webstore.subtipo_producto s on p.I_ID_SUBTIPO=s.ID " +
            "where (LOWER(p.C_NOMBRE) like CONCAT('%', LOWER(?1), '%') " +
            "or LOWER(p.C_DESCRIPCION) like CONCAT('%', LOWER(?1), '%') " +
            "or LOWER(p.C_MARCA) like CONCAT('%', LOWER(?1), '%') " +
            "or LOWER(s.C_DESCRIPCION) like CONCAT('%', LOWER(?1), '%') " +
            "or LOWER(t.C_DESCRIPCION) like CONCAT('%', LOWER(?1), '%'))",nativeQuery = true)
    List<ProductoEntity> buscarProductos(String cadena);
}
