package es.altair.pruebaSpring.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accesos")
public class Acceso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_acceso", nullable=false)
	private long id_acceso;
	
	@Column(name="codigo_acceso", nullable=false)
	private String codigo_acceso;
	
	@Column(name="descipcion_acceso", nullable=false)
	private String descripcion;

	public long getId_acceso() {
		return id_acceso;
	}

	public void setId_acceso(long id_acceso) {
		this.id_acceso = id_acceso;
	}

	public String getCodigo_acceso() {
		return codigo_acceso;
	}

	public void setCodigo_acceso(String codigo_acceso) {
		this.codigo_acceso = codigo_acceso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Acceso() {
		super();
	}

	public Acceso(long id_acceso, String codigo_acceso, String descripcion) {
		super();
		this.id_acceso = id_acceso;
		this.codigo_acceso = codigo_acceso;
		this.descripcion = descripcion;
	}
}