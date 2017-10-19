package net.omniblock.packets;

import org.bukkit.plugin.java.JavaPlugin;

import net.omniblock.packets.object.external.SystemType;

/**
 * 
 * Clase principal del sistema de paquetes
 * en la cual se debe ejecutar el metodo 
 * principal con sus argumentos para comprobar
 * el estado y el uso de esta libreria.
 * 
 * @author zlToxicNetherlz
 *
 */
public class OmniPackets extends JavaPlugin {

	protected static SystemType SYSTEM_TYPE = null;
	
	protected static boolean STARTED = false;
	protected static boolean DEBUG = false;
	
	/**
	 * 
	 * Con este metodo se inicializa el sistema de desbloqueo
	 * de paquetes con el fin de que dichos paquetes se puedan
	 * empezar a utilizar tanto el lector, como el escritor.
	 * 
	 * @param type El tipo de sistema sobre el cual corre la libreria.
	 */
	public static void setupSystem(SystemType type){
		
		STARTED = true;
		SYSTEM_TYPE = type;
		return;
		
	}
	
	/**
	 * 
	 * Con este metodo se puede definir la variable DEBUG
	 * que en base a esta se verificará por medio de una
	 * bifurcacion el envio de mensajes debug.
	 * 
	 * @param debug activar o desactivar el debug.
	 */
	public static void setDebug(boolean debug){
		
		DEBUG = debug;
		return;
		
	}
	
	/**
	 * 
	 * ¿Se inicializó el sistema correctamente?
	 * 
	 * @return <strong>true</strong> si el sistema se inicializó correctamente.
	 */
	public static boolean isStarted(){
		return STARTED;
	}
	
	/**
	 * 
	 * ¿Esta debug activado?
	 * 
	 * @return <strong>true</strong> si el debug se encuentra activado.
	 */
	public static boolean useDebug(){
		return DEBUG;
	}
	
}