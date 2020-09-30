package modelo;

/**
 * 
 */
public class Batallon {
	
	/**
     * Debe crear 3 grupos de 5 un total de 15 enemigos
     */
    private Nave[] enemigos;
    private int filas = 3;
    private int enemigosPorFila = 5;
    private float velocidad = 1.0f;
    private float distanciaEntreNaves = 0.2f;
    private float distanciaEntreFilas = 0.2f;
    
    public Batallon(Mapa mapa, float velocidad) {
    	this.velocidad = velocidad;
    	enemigos = new Nave[enemigosPorFila * filas];
    	for(int i = 0; i < filas; i++) 
    	{
    		for(int j = 0; j < enemigosPorFila; j++) 
    		{
    			enemigos[j + (5*i)] = new Nave(( ( j + 1 ) * (distanciaEntreNaves + 1) ), 50 + (i * (distanciaEntreFilas + 1)), mapa);
    		}
    	}
    }

    /**
     * @return
     */
    public void moverBatallon() {
        if(enemigos[0].xRelativo() + velocidad <= 0 || enemigos[enemigosPorFila - 1].xRelativo() + velocidad >= enemigos[enemigosPorFila - 1].mapa.devolverArea().devolverAncho()) 
        {
        	velocidad = -velocidad; 
        	for(Nave n:enemigos) { n.posicionRelativa(n.xRelativo(), n.yRelativo() - Math.abs(velocidad)); }
        }
        else { for(Nave n:enemigos) { n.posicionRelativa(n.xRelativo() + velocidad, n.yRelativo()); } }
    }

    /**
     * @return
     */
    public Nave[] devolverNaves() { return enemigos; }

    /**
     * @return
     */
    public int enemigosRestantes() {
        int cantidad = 0;
    	for(int i = 0; i < 15; i++) { if(enemigos[i].conseguirEstado()) { cantidad++; } }
        return cantidad;
    }
}