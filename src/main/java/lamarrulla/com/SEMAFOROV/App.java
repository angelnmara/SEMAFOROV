package lamarrulla.com.SEMAFOROV;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lamarrulla.com.SEMAFOROV.NetClientGet;
/**
 * Hello world!
 *
 */
public class App 
{	
	static NetClientGet netClientGet = new NetClientGet();
    public static void main( String[] args )
    {    	
    	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    	executor.scheduleAtFixedRate(helloRunnable, 0, 60, TimeUnit.SECONDS);
    }
    static Runnable helloRunnable = new Runnable() {
	    public void run() {
	        System.out.println("GetDatos");	    
	        netClientGet.getLocation();
	    }
	};
}
