class Armazenador{
    public static int TAMANHO_MINIMO = 10;
    public static int TAMANHO_MAXIMO = 100;

    // Atributos
    private int vet[];
    private int limite;

    // Metodos
    // construtores
    public Armazenador(){
        this(TAMANHO_MINIMO);
    }
    public Armazenador(int qtos){
        if (qtos<TAMANHO_MINIMO) qtos= TAMANHO_MINIMO;
        if (qtos>TAMANHO_MAXIMO) qtos= TAMANHO_MAXIMO;

        vet = new int[qtos];
        limite = 0;
    }

    public void armazenar(int elemento) throws Exception{
        if (this.limite == vet.length) 
              throw new Exception("Armazenador está cheio!");

        vet[this.limite] = elemento;
        this.limite++;
    }

    public void descartar(int elemento){
        for (int i=0; i<this.limite; i++){
            if (vet[i] == elemento ){
                // delocar os elemento
                for (int j=i; j<this.limite-1; j++){
                    vet[j] = vet[j+1];
                }
                // decrementar o limite
                this.limite--;
            }
        }
    }

    public void ordenar(){
        for (int lento=0; lento<limite-1; lento++){ // verdinho do desenho
            for (int rapido=lento+1; rapido<limite; rapido++){ // marrom do desenho
                // perceber se os valores estão em ordem inversa
                if (vet[lento]>vet[rapido]){
                    // trocando os valores de posição
                    int aux = vet[lento];
                    vet[lento] = vet[rapido];
                    vet[rapido] = aux;
                }
            }
        }
    }

    public int menorValor(){
        ordenar();
        return vet[0];
    }
    public int maiorValor(){
        ordenar();
        return vet[limite];
    }
    public double mediaDeValor(){
        int soma = 0;
        int media = 0;
        for(int i=0; i<limite; i++){
            soma = soma + vet[i];
        }
        media = soma / vet.length;
        return media;
    }
    public int qtosPares(){
        int ehPar = 0;
        for(int i=0; i<limite; i++){
            
            if(i % 2 == 0){
                ehPar++;
            }
        }
        
        return ehPar;
    }
    public int qtosImpares(){
        int ehImpar = 0; 
        for(int i = 0; i<limite; i++){

            if(i % 2 != 0){
                ehImpar++;
            }
        }
        return ehImpar;
    }

    public String toString(){
        String retorno="[";
        for (int i=0; i<this.limite; i++){
            retorno = retorno + " " + vet[i];
        }
        return retorno+" ]\nUtilizados " + 
                        this.limite + "/" + 
                        vet.length;
    }

}
