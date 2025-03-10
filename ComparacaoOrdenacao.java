import java.util.Random;

public class ComparacaoOrdenacao {

public static void main(String[] args) {
int tamanhoVetor = 160000;
int[] vetorOriginal = gerarVetorAleatorio(tamanhoVetor);

// Bubble Sort
int[] vetorBubble = vetorOriginal.clone();
System.out.println("Bubble Sort:");
medirTempo(vetorBubble, "Bubble Sort");

// Insertion Sort
int[] vetorInsertion = vetorOriginal.clone();
System.out.println("\nInsertion Sort:");
medirTempo(vetorInsertion, "Insertion Sort");

// Quick Sort
int[] vetorQuick = vetorOriginal.clone();
System.out.println("\nQuick Sort:");
medirTempo(vetorQuick, "Quick Sort");
}

public static int[] gerarVetorAleatorio(int tamanho) {
int[] vetor = new int[tamanho];
Random random = new Random();
for (int i = 0; i < tamanho; i++) {
vetor[i] = random.nextInt(10000); // Números aleatórios entre 0 e 9999
}
return vetor;
}

public static void medirTempo(int[] vetor, String nomeAlgoritmo) {
long inicio = System.nanoTime();
if (nomeAlgoritmo.equals("Bubble Sort")) {
bubbleSort(vetor);
} else if (nomeAlgoritmo.equals("Insertion Sort")) {
insertionSort(vetor);
} else if (nomeAlgoritmo.equals("Quick Sort")) {
quickSort(vetor, 0, vetor.length - 1);
}
long fim = System.nanoTime();
double tempoExecucao = (fim - inicio) / 1000000.0;
double tempoSegundos = tempoExecucao / 1000.0;
System.out.println("Tempo de execução: " + tempoExecucao + " ms (" + tempoSegundos + " s)");
}

public static void bubbleSort(int[] vetor) {
int n = vetor.length;
for (int i = 0; i < n - 1; i++) {
for (int j = 0; j < n - i - 1; j++) {
if (vetor[j] > vetor[j + 1]) {
// Troca os elementos
int temp = vetor[j];
vetor[j] = vetor[j + 1];
vetor[j + 1] = temp;
}
}
}
}

public static void insertionSort(int[] vetor) {
int n = vetor.length;
for (int i = 1; i < n; ++i) {
int chave = vetor[i];
int j = i - 1;

while (j >= 0 && vetor[j] > chave) {
vetor[j + 1] = vetor[j];
j = j - 1;
}
vetor[j + 1] = chave;
}
}

public static void quickSort(int[] vetor, int baixo, int alto) {
if (baixo < alto) {
int pi = particao(vetor, baixo, alto);

quickSort(vetor, baixo, pi - 1);
quickSort(vetor, pi + 1, alto);
}
}

public static int particao(int[] vetor, int baixo, int alto) {
int pivô = vetor[alto];
int i = (baixo - 1);
for (int j = baixo; j < alto; j++) {
if (vetor[j] < pivô) {
i++;

int temp = vetor[i];
vetor[i] = vetor[j];
vetor[j] = temp;
}
}

int temp = vetor[i + 1];
vetor[i + 1] = vetor[alto];
vetor[alto] = temp;

return i + 1;
}
}