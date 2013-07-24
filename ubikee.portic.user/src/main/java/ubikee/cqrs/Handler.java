package ubikee.cqrs;

/**
 * 
 * @author ernesto
 *
 * @param <T>
 */
public interface Handler {

	/**
	 * 
	 * @return
	 */
    String getMessageType();
    
    /**
     * 
     * @param message
     */
    void handleMessage(String message);
    
}
