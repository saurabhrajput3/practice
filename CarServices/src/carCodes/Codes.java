package carCodes;

public class Codes {
    public int BS01;
    public int EF01;
    public int CF01;
    public int BF01;
    public int GF01;

    public void setValues(int bs,int ef,int cf,int bf,int gf){
        this.BS01=bs;
        this.EF01=ef;
        this.CF01=cf;
        this.BF01=bf;
        this.GF01=gf;
    }
    public int getValues(String c){
        return switch (c) {
            case "BS01" -> this.BS01;
            case "EF01" -> this.EF01;
            case "CF01" -> this.CF01;
            case "BF01" -> this.BF01;
            case "GF01" -> this.GF01;
            default -> 0;
        };
    }
}
