public class Door {
    private boolean door_closed;
    private boolean door_locked;

    public Door(){
        this.door_closed=true;
        this.door_locked=true;
    }

    public void open_close_door() {this.door_closed=!door_closed;}
    public boolean isClosed_door() {return this.door_closed;}

    public void lock_unlock_door() {this.door_locked=!door_locked;}
    public boolean isLocked_door() {return this.door_locked;}
}
