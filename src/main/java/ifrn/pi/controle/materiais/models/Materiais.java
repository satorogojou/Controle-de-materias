package ifrn.pi.controle.materiais.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Materiais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String material;
	private Number quantidade;
	@DateTimeFormat(pattern = "yyyy-MM-dds")
	private LocalDate data;
	private LocalTime horário;
	private LocalTime horariodevolução;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Number getQuantidade() {
		return quantidade;
	}
	public LocalTime getHorariodevolução() {
		return horariodevolução;
	}
	public void setHorariodevolução(LocalTime horariodevolução) {
		this.horariodevolução = horariodevolução;
	}
	public void setQuantidade(Number quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHorário() {
		return horário;
	}
	public void setHorário(LocalTime horário) {
		this.horário = horário;
	}
	
	@Override
	public String toString() {
		return "Materiais [id=" + id + ", quantidade=" + quantidade + ",horariodevolução="+ horariodevolução + " data=" + data + ", horário="
				+ horário + ", material=" + material + "]";
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
