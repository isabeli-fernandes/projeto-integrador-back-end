package br.com.rd.projetoVelhoLuxo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "tb_tipo_entrega")
@Data
public class Delivery {

    @Id
    @Column(name = "cl_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "cl_descricao")
    private String descricao;
}
