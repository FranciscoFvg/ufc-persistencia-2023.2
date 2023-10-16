package dsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import dsp.dao.ProdutoDAO;
import dsp.dao.ProdutoJDBCDAO;
import dsp.entity.Produto;

public class Principal {

	public static void main(String[] args) {
		ProdutoDAO baseProdutos = new ProdutoJDBCDAO();
		String menu = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por Codigo\n3 - Remover por Codigo\n4 - Exibir por" +
				" id\n5 - Exibir por Codigo\n6 - Exibir todos\n7 - Exibir todos que contém determinada descrição" +
				"\n8 - Exibir todos com preços menores ou iguais a um determinado\n9 - Exibir produtos com modificação em um intervalo de tempo\n0 - Sair";
		char opcao = '0';
		do {
			try {
				Produto pr;
				String codigo;
				opcao = JOptionPane.showInputDialog(menu).charAt(0);
				switch (opcao) {
				case '1':     // Inserir
					pr = new Produto();
					obterProduto(pr);
					baseProdutos.save(pr);
					break;
				case '2':     // Atualizar por codigo
					codigo = JOptionPane.showInputDialog("Digite o Código do produto a ser alterado");
					pr = baseProdutos.findByCodigo(codigo);
					obterProduto(pr);
					baseProdutos.save(pr);
					break;
				case '3':     // Remover por codigo
					codigo = JOptionPane.showInputDialog("Digite o Código do produto a ser removido");
					pr = baseProdutos.findByCodigo(codigo);
					if (pr != null) {
						baseProdutos.delete(pr.getId());
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o produto não foi encontrado.");
					}
					break;
				case '5':     // Exibir por codigo
					codigo = JOptionPane.showInputDialog("Digite o Código do produto a ser exibido");
					pr = baseProdutos.findByCodigo(codigo);
					listaProduto(pr);
					break;
				case '4':     // Exibir por id
					int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
					pr = baseProdutos.find(id);
					listaProduto(pr);
					break;
				case '6':     // Exibir todos
					listaProdutos(baseProdutos.find());
					break;
				case '7':     // Exibir todos que contem determinada descricao
					String descricao = JOptionPane.showInputDialog("Descricao");
					listaProdutos(baseProdutos.findByDescricao(descricao));
					break;
				case '8':     // Exibir todos com preços menores ou iguais a um determinado
					float preco = Float.parseFloat(JOptionPane.showInputDialog("Preco"));
					listaProdutos(baseProdutos.findByPreco(preco));
					break;
				case '9':     // Exibir produtos com modificação em um intervalo de tempo
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String dataInicial = JOptionPane.showInputDialog("Data inicial (dd/MM/yyyy)");
					String dataFinal = JOptionPane.showInputDialog("Data final (dd/MM/yyyy)");
					listaProdutos(baseProdutos.findByDataUltimaEntrada(sdf.parse(dataInicial), sdf.parse(dataFinal)));
				case '0':     // Sair
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			}
		} while(opcao != '0');
	}
	
	public static void obterProduto(Produto pr) throws ParseException {
		String codigo = JOptionPane.showInputDialog("Codigo", pr.getCodigo());
		String descricao = JOptionPane.showInputDialog("Descricao", pr.getDescricao());
		float preco = Float.parseFloat(JOptionPane.showInputDialog("Preco", String.valueOf(pr.getPreco())));
		int qtdEstoque = Integer.parseInt(JOptionPane.showInputDialog("QtdEstoque", String.valueOf(pr.getQtdEstoque())));
		pr.setCodigo(codigo);
		pr.setDescricao(descricao);
		pr.setPreco(preco);
		pr.setQtdEstoque(qtdEstoque);
	}

	public static void listaProdutos(List<Produto> produtos) {
		StringBuilder listagem = new StringBuilder();
		for(Produto pr : produtos) {
			listagem.append(pr).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum produto encontrado" : listagem);
	}

	public static void listaProduto(Produto pr) {
		JOptionPane.showMessageDialog(null, pr == null ? "Nenhum produto encontrado" : pr);
	}
	
}
