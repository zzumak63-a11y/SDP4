package facade;

import subsystem.Amplifier;
import subsystem.DvdPlayer;
import subsystem.Lights;
import subsystem.PopcornPopper;
import subsystem.Projector;
import subsystem.Screen;


public class HomeTheaterFacade {
    private static final int DEFAULT_VOLUME = 5;
    private static final int DIM_LEVEL = 10;

    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private Screen screen;
    private Lights lights;
    private PopcornPopper popper;

    private boolean movieStarted = false;

    public HomeTheaterFacade(Amplifier amplifier, DvdPlayer dvdPlayer, Projector projector,
                             Screen screen, Lights lights, PopcornPopper popper) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        if (movie == null || movie.isEmpty()) {
            throw new IllegalArgumentException("Movie name must not be empty");
        }
        System.out.println("--- Get ready to watch a movie ---");
        try {
            popper.on();
            popper.pop();
            lights.dim(DIM_LEVEL);
            screen.down();
            projector.on();
            projector.wideScreenMode();
            amplifier.on();
            amplifier.setVolume(DEFAULT_VOLUME);
            dvdPlayer.on();
            dvdPlayer.play(movie);
            movieStarted = true;
        } catch (IllegalStateException e) {
            System.out.println("Error while starting the movie: " + e.getMessage());
            System.out.println("Rolling back...");
            endMovie();
        }
    }

    public void endMovie() {
        System.out.println("--- Shutting movie theater down ---");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.off();
        movieStarted = false;
    }

    public boolean isMovieStarted() {
        return movieStarted;
    }
}
