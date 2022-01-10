package br.com.rd.projetoVelhoLuxo.model.embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class UserAddressCompositeKey implements Serializable {
    @Column (name="cl_id_usuario")
    private Long idUser;
    @Column(name="cl_id_endereco")
    private Long idAddress;


}
