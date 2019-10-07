/**
 * 
 */
package it.unicam.cs.pa.connect4.factories;

import java.util.HashMap;

import java.util.Map;

/**
 * Responsibility : This class create a map in which collect the factories of each type of player. 
 * Thanks to this class we can obtain the correct factory by passing a string that identify uniquely it. 
 * This class uses the singleton pattern in order to let her the only source of creation for his objects. 
 * In addition is useful because we can use the instance of this class in a static context. 
 * 
 * @author Paoloni
 */

public class PlayerRegistry {

	/**
	 * the instance of this class.
	 */
	private static PlayerRegistry instance;
	
	/**
	 * the map used to store the couple (String, PlayerFactory).
	 */
	private Map<String,PlayerFactory> registry;
	
	private PlayerRegistry() {
		this.registry = new HashMap<String, PlayerFactory>();
		init();
	}
	
	/**
	 * Initializes the content of the map.
	 */
	private void init() {
		register("bot", new BotPlayerFactory());
		register("interactive", new InteractivePlayerFactory());
		register("strategic", new StrategicPlayerFactory());
	}

	/**
	 * 
	 * @return the instance of <code>PlayerRegistry</code>
	 */
	public static PlayerRegistry getInstance() {
		if (instance == null) {
			instance = new PlayerRegistry();
		}
		return instance;
	}

	/**
	 * Returns the correct factory based on the string passed as argument.
	 * 
	 * @param name the string in order to obtain the correct factory.
	 * @return <code>PlayerFactory</code> the correct factory.
	 */
	public PlayerFactory getPlayer(String name) {
		return registry.get(name);
	}

	/**
	 * Registers a new factory with his related string in the map.
	 * 
	 * @param name the string to be registered.
	 * @param playerFactory the factory to be registered.
	 */
	private void register( String name , PlayerFactory factory ) {
		this.registry.put(name, factory);	
	}
	
}
