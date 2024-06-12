package ElementoMultimediale;

/*public class ElementoMultimediale {
    private String title;
    private String formato;


    public ElementoMultimediale(String title, String formato) {
        this.title = title;
        this.formato = formato;

    }


    public String getTitleAndFormat() {
        return title+formato;
    }

}*/

public  class ElementoMultimediale {
    private String title;
    private double durata;


    public ElementoMultimediale(String title, double durata) {
        this.title = title;
        this.durata = durata;

    }


    public double getDurata() {
        return durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



