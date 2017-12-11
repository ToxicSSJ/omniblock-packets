package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class BroadcastTitlePacket extends MessagePacket {
	
	private static final long serialVersionUID = 5109513499747534001L;
	
	protected String title;
	protected String subtitle;
	
	public BroadcastTitlePacket() {
		super(PacketType.BROADCAST_TITLE);
	}
	
	public BroadcastTitlePacket setTitle(String title){
		
		this.title = title;
		return this;
		
	}
	
	public BroadcastTitlePacket setSubtitle(String subtitle){
		
		this.subtitle = subtitle;
		return this;
		
	}
	
	@Override
	public PacketSocketData<BroadcastTitlePacket> build(){
		
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
		
		return new PacketSocketData<BroadcastTitlePacket>(this, this.getClass());
		
	}
	
}

