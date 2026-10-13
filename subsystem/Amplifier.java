package subsystem;

public class Amplifier {
    private boolean on = false;
    private int volume = 0;

    public void on() {
        on = true;
        System.out.println("Amplifier: on");
    }

    public void off() {
        on = false;
        System.out.println("Amplifier: off");
    }

    public void setVolume(int volume) {
        if (!on) {
            throw new IllegalStateException("Amplifier is off");
        }
        this.volume = volume;
        System.out.println("Amplifier: volume set to " + volume);
    }

    public boolean isOn() {
        return on;
    }
}
