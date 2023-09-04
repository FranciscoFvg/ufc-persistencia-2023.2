import java.io.*;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista3
 * 
 * 1. Crie uma aplicação em Java que recebe via linha de comando: (1) o nome
 * de um arquivo CSV; (2) o delimitador usado para separar os campos do arquivo;
 * (3) uma lista de nomes das colunas do arquivo CSV que serão processados.
 * Considere que o arquivo CSV (1) deva ter um cabeçalho com os nomes das colunas
 * em sua primeira linha e que não tenha internamente colunas com Strings contendo
 * o mesmo caractere usado como delimitador (2). A aplicação deve exibir a soma e
 * a média das colunas selecionadas em (3), caso tenham dados numéricos. Se não
 * tiverem dados numéricos, somente exibir que aquela coluna não é numérica. Não
 * usar bibliotecas externas para resolver esta questão (usar Java puro).
 * Sugere-se navegar apenas uma única vez em cada linha do arquivo CSV.
 * Fazer a aplicação de modo que ela possa processar arquivos CSV extremamente
 * grandes, mesmo que não caibam na memória RAM. Dica: usar o método split
 * da classe String para separar os valores das colunas em cada linha do arquivo CSV.
 * 
 * Command line to run:
 * java Q1.java ../../assets/teste.csv ";" "coluna 1" "coluna 2" "coluna 3"
 * 
 */

public class Q1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));) {
            String line = br.readLine();

            String[] columns = line.split(args[1]);
            int[] columnsIndex = new int[args.length - 2];

            float[] sum = new float[args.length - 2];

            for (int i = 2; i<args.length;i++){
                for (int j = 0; j<columns.length;j++){
                    if (columns[j].equals(args[i])){
                        columnsIndex[i-2] = j;
                    }
                }
            }
            line = br.readLine();
            int lineCount = 0;
            do{
                String[] tempLineValues = line.split(args[1]);
                for (int i = 0; i<columnsIndex.length;i++){
                    float value = 0f;
                    try {
                        value = Float.parseFloat(tempLineValues[columnsIndex[i]]);

                        if (sum[i] != 0.0001f){
                            sum[i] += value;
                        }
                    } catch (Exception e) {
                        if (!tempLineValues[columnsIndex[i]].equals("")) {
                            System.out.println("Erro na coluna: '" + columns[columnsIndex[i]] + "', valor: " + tempLineValues[columnsIndex[i]]);
                            sum[i] = 0.0001f;
                        }
                    }
                }
                line = br.readLine();
                lineCount++;
            }while(line != null);

            for(int i = 0; i<sum.length;i++){
                if(sum[i] != 0.0001f){
                    System.out.println(sum[i]);
                    System.out.println(sum[i]/lineCount);
                }else{
                    System.out.println(columns[columnsIndex[i]] + " nao e numerica");
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}