package com.muebleria.entitys;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Muebles")
public class MuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String medida;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private BigDecimal precio;

    @ManyToMany
    @JoinTable(
            name = "productos_categorias",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoriaEntity> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "mueble", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ImagenesEntity> imagenes = new ArrayList<>();

    public MuebleEntity(Integer id, String nombre, String medida, String descripcion, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.medida = medida;
        this.descripcion = descripcion;
        this.precio = precio;

    }



    public MuebleEntity() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CategoriaEntity> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaEntity> categorias) {
        this.categorias = categorias;
    }

    public List<ImagenesEntity> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenesEntity> imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "MuebleEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", medida='" + medida + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", categorias=" + categorias +
                ", imagenes=" + imagenes +
                '}';
    }
}
