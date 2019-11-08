
import tdaarbolbb.*;

public class CalculadorMatricesOptimo implements ICalculadorMatricesOptimo {

    int[][] W;
    int[][] P;
    int[][] R;

    public CalculadorMatricesOptimo(int cantElem) {
        crearMatrices(cantElem);
    }

    @Override
    public void calcularMatrices(int cantElemento, int[] frecExito, int[] frecNoExito) {
        int i, j, k, kraiz, h;
        int min, pesoSubArboles;
        kraiz = 0;

        /*Paso 1 - h=0, wii=bi y pii=wii */
        for (i = 0; i <= cantElemento; i++) {
            W[i][i] = frecNoExito[i];
            P[i][i] = W[i][i];
        }

        //Paso 2 W   
        for (i = 0; i < cantElemento; i++) {
            for (j = i + 1; j <= cantElemento; j++) {
                W[i][j] = W[i][j - 1] + frecExito[j] + frecNoExito[j];
            }
        }

        //Paso 3 P
        for (i = 0; i < cantElemento; i++) {
            for (j = i + 1; j <= cantElemento; j++) {
                P[i][j] = W[i][j] + P[i][i] + P[j][j];
                R[i][j] = j;
            }
        }

        //Paso 4 P
        kraiz = 0;
        for (h = 2; h < cantElemento + 1; h++) {
            for (i = 0; i < cantElemento - h + 1; i++) {
                j = i + h;
                min = Integer.MAX_VALUE;

                for (k = i + 1; k <= j; k++) {
                    pesoSubArboles = P[i][k - 1] + P[k][j];
                    if (pesoSubArboles < min) {
                        min = pesoSubArboles;
                        kraiz = k;
                    }
                }

                P[i][j] = min + W[i][j];
                R[i][j] = kraiz;

            }
        }
    }

    /**
     *
     * @param i
     * @param j
     * @param Claves
     * @param frecClaves
     * @param elArbolBB
     */
    @Override
    public void armarArbolBinario(int i, int j, String[] Claves, TArbolBB elArbolBB) {
        int unaRaiz;
        if (i < j) {
            unaRaiz = this.R[i][j];
            TElementoAB unNodo = new TElementoAB(Claves[unaRaiz], Claves[unaRaiz]);
            elArbolBB.insertar(unNodo);
            armarArbolBinario(i, unaRaiz - 1, Claves, elArbolBB);
            armarArbolBinario(unaRaiz, j, Claves, elArbolBB);
        }
    }

    private void crearMatrices(int cantElem) {
        W = new int[cantElem + 1][cantElem + 1];
        P = new int[cantElem + 1][cantElem + 1];
        R = new int[cantElem + 1][cantElem + 1];
    }

}
