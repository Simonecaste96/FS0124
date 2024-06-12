public class Persona {
    public String nome;
    public String cognome;
    public int eta;
    //private String nome;
    //private String cognome;
    //private int eta;



    //RICHIAMO ENUM
    public TipoLavoro tipoLavoro;

    /*Questa è una variabile di istanza che posso richiamare dove mi serve poichè lo definita static,
    cosi da aumentare il contatore ogni volta che creo un nuovo altrimenti senza static il contatore partirebbe
    sempre da 0.
    oggetto persona*/
    public static int contatore;


    //il nome de costruttore e sempre uguale al nome della classe
    public Persona(String nome, String cognome, int eta, TipoLavoro tipoLavoro){


        /*ora cerco di prendere nome all'interno del costruttore
        e cerco di associargli il valore di nome variabile di istanza che sta sopra
        utilizzo this per identificare la varibiale sopra, avrei potuto utilizzare anche un undescore_ su
        nome per evitare l'utilizzo di this nel parametro, ma per convenzione deve essere uguale*/

        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.tipoLavoro=tipoLavoro;
        this.contatore++;

        //questi parametri verrano poi presi nella classe UsoPersona.
    }
        public Persona(String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
        this.contatore++;
        }

}
