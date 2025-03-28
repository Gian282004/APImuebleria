package com.muebleria.entitys;

import jakarta.persistence.*;

@Entity
@Table (name = "imagenes")

public class ImagenesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_imagen;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mueble_id", nullable = false)
    private MuebleEntity mueble;

    @Column ( name = "url",  nullable = false)
    private String imagenURL;

    ///constructor

    public ImagenesEntity(Integer id_imagen, MuebleEntity mueble, String imagenURL) {
        this.id_imagen = id_imagen;
        this.mueble = mueble;
        this.imagenURL = imagenURL;
    }

    public ImagenesEntity() {
    }

    public Integer getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Integer id_imagen) {
        this.id_imagen = id_imagen;
    }

    public MuebleEntity getMueble() {
        return mueble;
    }

    public void setMueble(MuebleEntity mueble) {
        this.mueble = mueble;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }


}