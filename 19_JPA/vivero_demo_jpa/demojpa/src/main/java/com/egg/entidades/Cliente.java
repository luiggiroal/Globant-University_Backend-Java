package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;
    @Column(name = "apellido_contacto")
    private String apellidoContacto;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "codigo_cliente")
    private int codigoCliente;
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Column(name = "fax")
    private String fax;
//    @Column(name = "id_empleado")
//    private int idEmpleado;
    @Column(name = "limite_credito")
    private double limiteCredito;
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "nombre_contacto")
    private String nombreContacto;
    @Column(name = "pais")
    private String pais;
    @Column(name = "region")
    private String region;
    @Column(name = "telefono")
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

//    public int getIdEmpleado() {
//        return idEmpleado;
//    }

//    public void setIdEmpleado(int idEmpleado) {
//        this.idEmpleado = idEmpleado;
//    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
