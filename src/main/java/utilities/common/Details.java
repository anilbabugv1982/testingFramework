package utilities.common;

public class Details {
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String osName;

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

    public String getOsName() {

        if (osName == null) {
            if (isWindows()) {
                osName = "win";
            } else if (isMac()) {
                osName = "mac";
            } else if (isUnix()) {
                osName = "linux";
            } else if (isSolaris()) {
                osName = "solaris";
            } else {
                System.out.println("Your OS is not support!!");
                osName = "win";
            }
        }
        return osName;
    }
}
