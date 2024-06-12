public class Rettangolo {
    private  double h;
    private  double l;


    /*COSTRUTTORE*/
    public Rettangolo(double h,double l) {
        this.h = h;
        this.l = l;
    }
   /*METODO PER PERIMETRO*/
    public  double getCalcoloPerimetro(){
        return 2*(h + l);
    }

    /*METODO PER AREA*/
    public  double getCalcoloArea(){
        return h*l;
    }


    public void stampaRettangolo(){
        double perimetro = getCalcoloPerimetro();
        double area = getCalcoloArea();
        System.out.println("Il perimetro è: "+perimetro);
        System.out.println("L'area è: "+area);
    }

    public  void stampaDueRettangoli(Rettangolo rettangolo1, Rettangolo rettangolo2){
        double perimetro1 = rettangolo1.getCalcoloPerimetro();
        double area1 = rettangolo1.getCalcoloArea();

        double perimetro2 = rettangolo2.getCalcoloPerimetro();
        double area2 = rettangolo2.getCalcoloArea();

//SOMMO AREA E PERIMETRO DEI DUE RETTANGOLI
        double perimetroTotale = perimetro1 + perimetro2;
        double areaTotale = area1 + area2;
        System.out.println("La somma dei perimetri è: "+perimetroTotale);
        System.out.println("La somma delle area è: "+areaTotale);


    }


    }
