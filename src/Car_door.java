public class Car_door extends Door{
    private boolean window_closed;

    public Car_door(){
        super();
        this.window_closed=true;
    }

    public void open_close_window() {this.window_closed=!window_closed;}
    public boolean isClosed_window() {return this.window_closed;}
}
