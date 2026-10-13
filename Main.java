import facade.HomeTheaterFacade;
import subsystem.Amplifier;
import subsystem.DvdPlayer;
import subsystem.Lights;
import subsystem.PopcornPopper;
import subsystem.Projector;
import subsystem.Screen;

public class Main {
    public static void main(String[] args) {
        // creating subsystem objects (setup only, the client then uses the facade)
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new Amplifier(), new DvdPlayer(), new Projector(),
                new Screen(), new Lights(), new PopcornPopper());

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();

        System.out.println();
        try {
            homeTheater.watchMovie("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
