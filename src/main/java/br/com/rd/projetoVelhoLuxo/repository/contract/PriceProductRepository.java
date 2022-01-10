package br.com.rd.projetoVelhoLuxo.repository.contract;

import br.com.rd.projetoVelhoLuxo.model.embeddable.PriceProductKey;
import br.com.rd.projetoVelhoLuxo.model.entity.PriceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceProductRepository extends JpaRepository <PriceProduct, PriceProductKey>,
                                                PriceProductRepositoryCustom {
    PriceProduct findByPriceProductKeyProductsId(Long id);
    List<PriceProduct> findByOrderByPriceAsc();
    List<PriceProduct> findByOrderByPriceDesc();
    List<PriceProduct> findByOrderBySalePriceDesc();
}
