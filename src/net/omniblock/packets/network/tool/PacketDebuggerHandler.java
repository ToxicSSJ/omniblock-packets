package net.omniblock.packets.network.tool;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.omniblock.packets.OmniPackets;

/**
 * 
 * Esta clase es la encargada de tener los metodos
 * principales para el manejo general de los Paquetes
 * de Omniblock Network.
 * 
 * @author zlToxicNetherlz
 */
public class PacketDebuggerHandler {

	/**
	 * 
	 * Con este metodo se podrá enviar un mensaje a la consola
	 * tipo debug para poder manejar cualquier tipo de entrada,
	 * procesamiento y salida de datas.
	 * 
	 * @param message El mensaje debug que se desea enviar.
	 * @param level El nivel de debug del que se desea reportar.
	 */
	public void sendMessage(String message, Level level){
		
		if(OmniPackets.useDebug()) Logger.getLogger("OmniPackets").log(level, message);
		return;
		
	}
	
}
