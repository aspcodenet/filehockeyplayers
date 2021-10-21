package se.systementor;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        HockeyDatabase db = new HockeyDatabase();
        db.run();
        
        System.out.println("Hello World!");
    }
}
