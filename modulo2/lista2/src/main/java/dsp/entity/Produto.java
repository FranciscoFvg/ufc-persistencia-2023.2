package dsp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto {
	private Integer id;
	private String codigo;
	private String descricao;
	private float preco;
	private int qtdEstoque;
	private Date dataUltimaEntrada;
}
