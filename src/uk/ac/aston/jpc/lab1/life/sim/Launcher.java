package uk.ac.aston.jpc.lab1.life.sim;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        // 1: create a new World and assign it to w
        World w = oscillator();
        while (true) {
            // print out "----"
            // print out the World
            // 2: replace the current World with the next one
            System.out.println("----");
            System.out.println(w.toString());
            w = w.nextGeneration();
            // wait for half a second (500 milliseconds)
            Thread.sleep(500);
        }
    }

    public static World stillLife() {
        return new World(
                "    ",
                " xx ",
                " xx ",
                "    "
        );
    }

    public static World oscillator() {
        return new World(
                "     ",
                "     ",
                " xxx ",
                "     ",
                "     "
        );
    }
    public static World spaceship() {
        return new World(
                "       ",
                "  x    ",
                "   x   ",
                " xxx   ",
                "       ",
                "       ",
                "       ",
                "       "
        );
    }

    public static World rPentomino() {
        return new World(
                "           ",
                "           ",
                "     xx    ",
                "    xx     ",
                "     x     ",
                "           ",
                "           ",
                "           "
        );
    }
}
