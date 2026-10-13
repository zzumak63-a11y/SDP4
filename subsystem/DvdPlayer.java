package subsystem;

public class DvdPlayer {
    private boolean on = false;
    private String movie;

    public void on() {
        on = true;
        System.out.println("DVD Player: on");
    }

    public void off() {
        on = false;
        System.out.println("DVD Player: off");
    }

    public void play(String movie) {
        if (!on) {
            throw new IllegalStateException("DVD Player is off");
        }
        this.movie = movie;
        System.out.println("DVD Player: playing \"" + movie + "\"");
    }

    public void stop() {
        System.out.println("DVD Player: stopped \"" + movie + "\"");
        movie = null;
    }
}
