package JP2.sesstion1;

public class Moto<X,Y> {
    X soKhung;
    Y soMay;

    public Moto(){

    }

    public Moto(X soKhung, Y soMay) {
        this.soKhung = soKhung;
        this.soMay = soMay;
    }

    public X getSoKhung() {
        return soKhung;
    }

    public void setSoKhung(X soKhung) {
        this.soKhung = soKhung;
    }

    public Y getSoMay() {
        return soMay;
    }

    public void setSoMay(Y soMay) {
        this.soMay = soMay;
    }

    public <T> void showInfor(T x){
        System.out.println(x);
    }
}
