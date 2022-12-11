package ifrn.pi.controle.materiais.models;

import java.time.LocalDate;
import java.time.LocalTime;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Materiais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	private String material;
	private Number quantidade;
	@DateTimeFormat(pattern = "yyyy-MM-dds")
	private LocalDate data;
	private LocalTime horário;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Number getQuantidade() {
		return quantidade;
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
		return "Materiais [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", data=" + data + ", horário="
				+ horário + ", material=" + material + "]";
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
