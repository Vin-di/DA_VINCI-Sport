public class Door {
    private boolean door_closed;

    public Door(){this.door_closed=true;}

    public void open_close_door() {this.door_closed=!door_closed;}
    public boolean isClosed_door() {return this.door_closed;}
}
