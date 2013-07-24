package ubikee.cqrs;

import org.junit.BeforeClass;
import org.junit.Test;

import ubikee.messaging.BusRedis;

public class BusRedisTest {

	private static BusRedis bus;
	
	@BeforeClass
	public static void setup() {
		bus = new BusRedis();
	}
	
	@Test
	public void test1() {
		
		bus.subscribe("ALL", new Handler() {
			
			public void handleMessage(String message) {
				System.out.println("ALL Handler : "+message);
				
			}
			
			public String getMessageType() {
				return null;
			}
		});
		
		
		bus.subscribe("KUL", new Handler() {
			
			public void handleMessage(String message) {
				System.out.println("KUL Handler : "+message);
				
			}
			
			public String getMessageType() {
				return null;
			}
		});
		
		
	}
}
