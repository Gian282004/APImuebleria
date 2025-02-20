package com.muebleria.entitys;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "payer")
public class PayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_payer;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "payer", cascade = CascadeType.ALL)
    private List<HistorialEntity> historial;

    public PayerEntity() {}

    public PayerEntity(Integer id_payer ,String name, String email, String phone) {
        this.id_payer=id_payer;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId_payer() {
        return id_payer;
    }

    public void setId_payer(Integer id_payer) {
        this.id_payer = id_payer;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}