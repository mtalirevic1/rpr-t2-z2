package ba.unsa.etf.rpr.tutorijal02;


public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean imaPocetna;
    private boolean imaKrajnja;

    public Interval(double pocetnaTacka,double krajnjaTacka, boolean imaPocetna, boolean imaKrajnja){
        if(pocetnaTacka>krajnjaTacka) throw new IllegalArgumentException("Interval nije validan");
        this.pocetnaTacka=pocetnaTacka;
        this.krajnjaTacka=krajnjaTacka;
        this.imaPocetna=imaPocetna;
        this.imaKrajnja=imaKrajnja;

    }

    public Interval(){
        this.pocetnaTacka=0;
        this.krajnjaTacka=0;
        this.imaPocetna=false;
        this.imaKrajnja=false;

    }

    public boolean isIn(double v) {
        if(imaPocetna==true && imaKrajnja==true){
            if(v>=pocetnaTacka && v<=krajnjaTacka)
                return true;
            else
                return false;
        }
        else if(imaPocetna==false && imaKrajnja==true) {
            if (v > pocetnaTacka && v <= krajnjaTacka)
                return true;
            else
                return false;
        }
        else if(imaPocetna==false && imaKrajnja==false) {
            if (v > pocetnaTacka && v < krajnjaTacka)
                return true;
            else
                return false;
        }
        else if(imaPocetna==true && imaKrajnja==false) {
            if (v >= pocetnaTacka && v < krajnjaTacka)
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean isNull() {
        if(this.pocetnaTacka==0 && this.krajnjaTacka==0 && this.imaPocetna==false && this.imaKrajnja==false)
            return true;
        else
            return false;
    }


    public static Interval intersect(Interval i1, Interval i2){
        if((i1.krajnjaTacka<i2.pocetnaTacka && i1.pocetnaTacka<i2.pocetnaTacka) || (i2.krajnjaTacka<i1.pocetnaTacka && i2.pocetnaTacka<i1.pocetnaTacka))
            return new Interval();
        else if((i1.krajnjaTacka<i2.krajnjaTacka && i1.pocetnaTacka>i2.pocetnaTacka))
            return new Interval(i1.pocetnaTacka,i1.krajnjaTacka,i1.imaPocetna,i1.imaKrajnja);
        else if((i2.krajnjaTacka<i1.krajnjaTacka && i2.pocetnaTacka>i1.pocetnaTacka))
            return new Interval(i2.pocetnaTacka,i2.krajnjaTacka,i2.imaPocetna,i2.imaKrajnja);
        else if(i1.pocetnaTacka<i2.pocetnaTacka && i1.krajnjaTacka>i2.krajnjaTacka)
            return new Interval(i2.pocetnaTacka,i1.krajnjaTacka,i2.imaPocetna,i1.imaKrajnja);
        else if(i2.pocetnaTacka<i1.pocetnaTacka && i2.krajnjaTacka>i1.krajnjaTacka)
            return new Interval(i1.pocetnaTacka,i2.krajnjaTacka,i1.imaPocetna,i2.imaKrajnja);
        else if(i1.pocetnaTacka==i2.pocetnaTacka && i1.krajnjaTacka==i2.krajnjaTacka)
            return new Interval(i1.pocetnaTacka,i1.krajnjaTacka,i1.imaPocetna || i2.imaPocetna,i1.imaKrajnja || i2.imaKrajnja);
    }

    public Interval intersect(Interval i){
        return intersect(*this,i);
    }
}
