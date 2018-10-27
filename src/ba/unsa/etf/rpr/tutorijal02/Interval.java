package ba.unsa.etf.rpr.tutorijal02;


public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean imaPocetna;
    private boolean imaKrajnja;

    public Interval(double pocetnaTacka,double krajnjaTacka, boolean imaPocetna, boolean imaKrajnja){
        if(pocetnaTacka>krajnjaTacka) throw new IllegalArgumentException("Interval nije validan");
        this.setPocetnaTacka(pocetnaTacka);
        this.setKrajnjaTacka(krajnjaTacka);
        this.setImaPocetna(imaPocetna);
        this.setImaKrajnja(imaKrajnja);

    }

    public Interval(){
        this.setPocetnaTacka(0);
        this.setKrajnjaTacka(0);
        this.setImaPocetna(false);
        this.setImaKrajnja(false);

    }

    public boolean isIn(double v) {
        if(isImaPocetna() ==true && isImaKrajnja() ==true){
            if(v>= getPocetnaTacka() && v<= getKrajnjaTacka())
                return true;
            else
                return false;
        }
        else if(isImaPocetna() ==false && isImaKrajnja() ==true) {
            if (v > getPocetnaTacka() && v <= getKrajnjaTacka())
                return true;
            else
                return false;
        }
        else if(isImaPocetna() ==false && isImaKrajnja() ==false) {
            if (v > getPocetnaTacka() && v < getKrajnjaTacka())
                return true;
            else
                return false;
        }
        else if(isImaPocetna() ==true && isImaKrajnja() ==false) {
            if (v >= getPocetnaTacka() && v < getKrajnjaTacka())
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean isNull() {
        if(this.getPocetnaTacka() ==0 && this.getKrajnjaTacka() ==0 && this.isImaPocetna() ==false && this.isImaKrajnja() ==false)
            return true;
        else
            return false;
    }


    public static Interval intersect(Interval i1, Interval i2){
        if((i1.getKrajnjaTacka() < i2.getPocetnaTacka() && i1.getPocetnaTacka() < i2.getPocetnaTacka()) || (i2.getKrajnjaTacka() < i1.getPocetnaTacka() && i2.getPocetnaTacka() < i1.getPocetnaTacka()))
            return new Interval();
        if((i1.getKrajnjaTacka() < i2.getKrajnjaTacka() && i1.getPocetnaTacka() > i2.getPocetnaTacka()))
            return new Interval(i1.getPocetnaTacka(), i1.getKrajnjaTacka(), i1.isImaPocetna(), i1.isImaKrajnja());
        if((i2.getKrajnjaTacka() < i1.getKrajnjaTacka() && i2.getPocetnaTacka() > i1.getPocetnaTacka()))
            return new Interval(i2.getPocetnaTacka(), i2.getKrajnjaTacka(), i2.isImaPocetna(), i2.isImaKrajnja());
        if(i1.getPocetnaTacka() < i2.getPocetnaTacka() && i1.getKrajnjaTacka() < i2.getKrajnjaTacka())
            return new Interval(i2.getPocetnaTacka(), i1.getKrajnjaTacka(), i2.isImaPocetna(), i1.isImaKrajnja());
        if(i2.getPocetnaTacka() < i1.getPocetnaTacka() && i2.getKrajnjaTacka() < i1.getKrajnjaTacka())
            return new Interval(i1.getPocetnaTacka(), i2.getKrajnjaTacka(), i1.isImaPocetna(), i2.isImaKrajnja());
        if(i1.getPocetnaTacka() == i2.getPocetnaTacka() && i1.getKrajnjaTacka() == i2.getKrajnjaTacka())
            return new Interval(i1.getPocetnaTacka(), i1.getKrajnjaTacka(), i1.isImaPocetna() || i2.isImaPocetna(), i1.isImaKrajnja() || i2.isImaKrajnja());
        return new Interval(5,5,false,false);
    }

    public Interval intersect(Interval i){
        return intersect(this,i);
    }

    public String toString(){
        if(isNull()==true)
            return "()";
        else if(this.isImaPocetna()==true && this.isImaKrajnja()==true)
            return "["+getPocetnaTacka()+","+getKrajnjaTacka()+"]";
        else if(this.isImaPocetna()==false && this.isImaKrajnja()==true)
            return "("+getPocetnaTacka()+","+getKrajnjaTacka()+"]";
        else if(this.isImaPocetna()==false && this.isImaKrajnja()==false)
            return "("+getPocetnaTacka()+","+getKrajnjaTacka()+")";
        else if(this.isImaPocetna()==true && this.isImaKrajnja()==false)
            return "["+getPocetnaTacka()+","+getKrajnjaTacka()+")";
        return "";
    }

    public boolean equals(Interval i){
        if(this.getPocetnaTacka()==i.getPocetnaTacka() && this.getKrajnjaTacka()==i.getKrajnjaTacka() && this.isImaPocetna()==i.isImaPocetna() && this.isImaKrajnja()==i.isImaKrajnja())
            return true;
        else
            return false;
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isImaPocetna() {
        return imaPocetna;
    }

    public void setImaPocetna(boolean imaPocetna) {
        this.imaPocetna = imaPocetna;
    }

    public boolean isImaKrajnja() {
        return imaKrajnja;
    }

    public void setImaKrajnja(boolean imaKrajnja) {
        this.imaKrajnja = imaKrajnja;
    }
}
