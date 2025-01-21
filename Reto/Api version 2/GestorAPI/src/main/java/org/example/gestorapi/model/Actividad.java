package org.example.gestorapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "actividades")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Lob
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @NotNull
    @Lob
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "fini", nullable = false)
    private LocalDate fini;

    @NotNull
    @Column(name = "ffin", nullable = false)
    private LocalDate ffin;

    @NotNull
    @Column(name = "hini", nullable = false)
    private LocalTime hini;

    @NotNull
    @Column(name = "hfin", nullable = false)
    private LocalTime hfin;

    @NotNull
    @Column(name = "prevista_ini", nullable = false)

    private Boolean previstaIni = false;

    @NotNull
    @Column(name = "transporte_req", nullable = false)
    private Boolean transporteReq = false;

    @Lob
    @Column(name = "coment_transporte")
    private String comentTransporte;

    @NotNull
    @Column(name = "alojamiento_req", nullable = false)
    private Boolean alojamientoReq = false;

    @Lob
    @Column(name = "coment_alojamiento")
    private String comentAlojamiento;

    @Lob
    @Column(name = "comentarios")
    private String comentarios;

    @NotNull
    @Lob
    @Column(name = "estado", nullable = false)
    private String estado;

    @Lob
    @Column(name = "coment_estado")
    private String comentEstado;

    @Lob
    @Column(name = "incidencias")
    private String incidencias;

    @Lob
    @Column(name = "url_folleto")
    private String urlFolleto;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "solicitante_id", nullable = false)
    private Profesor solicitante;

    @Column(name = "importe_por_alumno", precision = 5, scale = 2)
    private BigDecimal importePorAlumno;

    @Lob
    @Column(name="longitud")
    private String longitud;

    @Lob
    @Column(name="latitud")
    private String latitud;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFini() {
        return fini;
    }

    public void setFini(LocalDate fini) {
        this.fini = fini;
    }

    public LocalDate getFfin() {
        return ffin;
    }

    public void setFfin(LocalDate ffin) {
        this.ffin = ffin;
    }

    public LocalTime getHini() {
        return hini;
    }

    public void setHini(LocalTime hini) {
        this.hini = hini;
    }

    public LocalTime getHfin() {
        return hfin;
    }

    public void setHfin(LocalTime hfin) {
        this.hfin = hfin;
    }


    public Boolean getPrevistaIni() {
        return previstaIni;
    }

    public void setPrevistaIni(Boolean previstaIni) {
        this.previstaIni = previstaIni;
    }

    public Boolean getTransporteReq() {
        return transporteReq;
    }

    public void setTransporteReq(Boolean transporteReq) {
        this.transporteReq = transporteReq;
    }

    public String getComentTransporte() {
        return comentTransporte;
    }

    public void setComentTransporte(String comentTransporte) {
        this.comentTransporte = comentTransporte;
    }

    public Boolean getAlojamientoReq() {
        return alojamientoReq;
    }

    public void setAlojamientoReq(Boolean alojamientoReq) {
        this.alojamientoReq = alojamientoReq;
    }

    public String getComentAlojamiento() {
        return comentAlojamiento;
    }

    public void setComentAlojamiento(String comentAlojamiento) {
        this.comentAlojamiento = comentAlojamiento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentEstado() {
        return comentEstado;
    }

    public void setComentEstado(String comentEstado) {
        this.comentEstado = comentEstado;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public String getUrlFolleto() {
        return urlFolleto;
    }

    public void setUrlFolleto(String urlFolleto) {
        this.urlFolleto = urlFolleto;
    }

    public Profesor getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Profesor solicitante) {
        this.solicitante = solicitante;
    }

    public BigDecimal getImportePorAlumno() {
        return importePorAlumno;
    }

    public void setImportePorAlumno(BigDecimal importePorAlumno) {
        this.importePorAlumno = importePorAlumno;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
}