package dsp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Produto {

	public Produto(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String codigo;
	private String descricao;
	private float preco;
	private int qtdEstoque;
	private Date dataUltimaEntrada;
}
