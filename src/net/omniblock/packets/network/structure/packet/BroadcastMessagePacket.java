package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class BroadcastMessagePacket extends MessagePacket {
	
	private static final long serialVersionUID = -4419552402282905396L;
	
	protected String message;
	
	public BroadcastMessagePacket() {
		super(PacketType.BROADCAST_MESSAGE);
	}
	
	public BroadcastMessagePacket setMessage(String message){
		
		this.message = message;
		return this;
		
	}
	
	@Override
	public PacketSocketData<BroadcastMessagePacket> build(){
		
		for(Field f : this.getClass().getDeclaredFields()){
			
			f.setAccessible(true);
			
			try {
				
				if(f.get(this) == null){
					
					throw new UnsupportedOperationException("El campo '" + f.getName() + "' no ha sido definido en el paquete " + this.getClass().getName());
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			continue;
			
		}
		
		return new PacketSocketData<BroadcastMessagePacket>(this, this.getClass());
		
	}
	
}
