package com.muebleria.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column ( name = "nombre",  nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "categorias")  // La relación ya se maneja en MuebleEntity
    private List<MuebleEntity> muebles;

    public CategoriaEntity(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CategoriaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MuebleEntity> getMuebles() {
        return muebles;
    }

    public void setMuebles(List<MuebleEntity> muebles) {
        this.muebles = muebles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
