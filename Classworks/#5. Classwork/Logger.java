public class Logger {
    private final static Logger instance;
       static{
    	   instance = new Logger();
    }

    private Logger() {

    }

    public static Logger getLogger() {
        return instance;
    }

    private String prefix = "MESSAGE";

    public void log(String text) {
        System.out.println(this.prefix + " " + text);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}