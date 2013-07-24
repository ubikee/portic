package ubikee.messaging;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;
import ubikee.cqrs.Handler;
import ubikee.cqrs.MessageHandlingException;

/**
 * Message Bus Redis based implementation
 * 
 * @author ernesto
 *
 */
public class BusRedis implements Bus {

	private JedisPool pool;
	private Map<String, Handler> handlers;
	
	public BusRedis() {
		 pool = new JedisPool(new JedisPoolConfig(), "localhost");
		 handlers = new HashMap<String, Handler>();
		 new Thread(new BusListener(pool,handlers)).start();
	}

	public void publish(String channel, Object message) throws MessageHandlingException {
		Jedis jedis = pool.getResource();
		try {
			jedis.publish(channel, message.toString());
		} finally {
			pool.returnResource(jedis);
		}
	}

	public void subscribe(String channel, Handler handler) {
		handlers.put(channel, handler);
	}

	class BusListener extends JedisPubSub implements Runnable {

		JedisPool pool;
		private Map<String, Handler> handlers;
		
		/**
		 * @constructor
		 * @param pool
		 */
		public BusListener(JedisPool pool, Map<String, Handler> handlers) {
			this.pool = pool;
			this.handlers = handlers;
		}

		public void run() {
			Jedis jedis = pool.getResource();
			try {
				jedis.subscribe(this, "ALL","KUL");
			} finally {
				pool.returnResource(jedis);
			}
		}
		
		@Override
		public void onMessage(String channel, String message) {
			this.handlers.get(channel).handleMessage(message);
		}

		@Override
		public void onPMessage(String pattern, String channel, String message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSubscribe(String channel, int subscribedChannels) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onUnsubscribe(String channel, int subscribedChannels) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPUnsubscribe(String pattern, int subscribedChannels) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPSubscribe(String pattern, int subscribedChannels) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
