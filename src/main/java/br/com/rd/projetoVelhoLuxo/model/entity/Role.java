package br.com.rd.projetoVelhoLuxo.model.entity;

//import javax.persistence.*;
//import java.util.Collection;
//
//@Entity
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//    @ManyToMany(mappedBy = "roles")
//    private Collection<MyUser> users;
//
//    @ManyToMany
//    @JoinTable(
//            name = "roles_privileges",
//            joinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "privilege_id", referencedColumnName = "id"))
//    private Collection<Privilege> privileges;
//}