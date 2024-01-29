public class Security_belt{
    private boolean belt_fastened;

    public Security_belt() {this.belt_fastened=false;}

    public void belt_fastened_unfastened() {this.belt_fastened=!belt_fastened;}
    public boolean isFastened() {return this.belt_fastened;}
}