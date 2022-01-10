package br.com.rd.projetoVelhoLuxo.service;

import br.com.rd.projetoVelhoLuxo.model.dto.DeliveryDTO;
import br.com.rd.projetoVelhoLuxo.model.entity.Delivery;
import br.com.rd.projetoVelhoLuxo.repository.contract.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public DeliveryDTO addEntrega(DeliveryDTO entrega) {
        Delivery newDelivery = this.dtoToBusiness(entrega);
        newDelivery = deliveryRepository.save(newDelivery);
        return this.businessToDto(newDelivery);
    }

    public List<DeliveryDTO> findAllEntrega() {
        List<Delivery> allList = deliveryRepository.findAll();
        return this.listToDto(allList);
    }

    private List<DeliveryDTO> listToDto(List<Delivery> list) {
        List<DeliveryDTO> listDto = new ArrayList<DeliveryDTO>();
        for (Delivery e : list) {
            listDto.add(this.businessToDto(e));
        }
        return listDto;
    }

    public DeliveryDTO searchEntregaById(Long id) {
        Optional<Delivery> op = deliveryRepository.findById(id);

        if (op.isPresent()) {
            return businessToDto(op.get());
        }
        return null;
    }

    public DeliveryDTO updateById(DeliveryDTO dto, Long id) {
        Optional<Delivery> op = deliveryRepository.findById(id);

        if (op.isPresent()) {
            Delivery obj = op.get();

            if (dto.getDescricao() != null) {
                obj.setDescricao(dto.getDescricao());
            }

            deliveryRepository.save(obj);
            return businessToDto(obj);
        }
        return null;
    }


    public void deleteById(Long id){
        if(deliveryRepository.existsById(id)){
            deliveryRepository.deleteById(id);
        }
    }

    private Delivery dtoToBusiness(DeliveryDTO dto){
        Delivery business = new Delivery();
        business.setDescricao(dto.getDescricao());
        return business;
    }

    private DeliveryDTO businessToDto(Delivery business){
        DeliveryDTO dto = new DeliveryDTO();
        dto.setId(business.getId());
        dto.setDescricao(business.getDescricao());
        return dto;
    }
}