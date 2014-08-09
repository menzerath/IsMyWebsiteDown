package eu.menzerath.imwd;

import eu.menzerath.util.Helper;
import eu.menzerath.util.Messages;
import eu.menzerath.util.Updater;
import org.fusesource.jansi.Ansi;

public class ConsoleApplication {
    private String url;
    private int interval;
    private boolean createLog;

    /**
     * Validate the values, save them and run the checker
     *
     * @param url       URL to check
     * @param interval  Interval to check
     * @param createLog Create a logfile or not
     */
    public ConsoleApplication(String url, String interval, boolean createLog) {
        Main.sayHello();

        if (Helper.validateUrlInput(url) && Helper.validateIntervalInput(Helper.parseInt(interval))) {
            this.url = url;
            this.interval = Helper.parseInt(interval);
            this.createLog = createLog;
            run();
        } else {
            System.out.println(new Ansi().bold().fg(Ansi.Color.RED).a("Error: ").fg(Ansi.Color.DEFAULT).a(Messages.INVALID_PARAMETERS).reset());
            System.exit(1);
        }
    }

    /**
     * This is the main-method which will take the values from the preferences and start directly.
     */
    private void run() {
        // Run the update-check
        updateCheck();

        // Display the used values
        System.out.println(new Ansi().bold().a(Messages.CONSOLE_START).boldOff());
        System.out.println("URL:      " + url);
        System.out.println("Interval: " + interval + "s");
        System.out.println("Log-File: " + createLog + "\n");

        // Create the Checker and go!
        Checker checker = new Checker(0, url, interval, true, true, createLog, true, false);
        checker.startTesting();
    }

    /**
     * An update-check for the "ConsoleApplication": If there is an update available, it will show an url to get the update.
     */
    private void updateCheck() {
        Ansi a = new Ansi();

        Updater myUpdater = new Updater();
        if (myUpdater.getServerVersion().equalsIgnoreCase("Error")) {
            System.out.println(a.fg(Ansi.Color.RED).a(Messages.UPDATE_ERROR).reset() + "\n");
        } else if (myUpdater.getServerVersion().equals("SNAPSHOT")) {
            System.out.println(a.fg(Ansi.Color.RED).a(Messages.UPDATE_SNAPSHOT).reset() + "\n");
        } else if (myUpdater.isUpdateAvailable()) {
            System.out.println(a.fg(Ansi.Color.RED).bold().a(Messages.UPDATE_AVAILABLE.replace("%version", myUpdater.getServerVersion())).reset());
            System.out.println(Messages.UPDATE_AVAILABLE_CHANGES.replace("%changes", myUpdater.getServerChangelog()) + "\n");
        }
    }
}