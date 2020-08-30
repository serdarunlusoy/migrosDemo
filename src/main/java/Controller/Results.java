package Controller;

public enum Results {
    SUCCESS("Record created for courier with id : %s and store with id : %s"),
    NO_STORE("No store found nearby that location"),
    TIME_ERROR("Error the courier with id %s has been near the store %s sooner than the given interval %s ms"),
    ERROR("Unknown Error");

    private String message;

    Results(String message){
    this.message=message;
    }
    String getMessage(){return this.message;}
}
