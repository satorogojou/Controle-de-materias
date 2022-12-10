package ifrn.pi.controle.materiais.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

public class Materiais {
	
	@id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	private String quantidade;
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
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
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
				+ horário + "]";
	}
	
	
}
