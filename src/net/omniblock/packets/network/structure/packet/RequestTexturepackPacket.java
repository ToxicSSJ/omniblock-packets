package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class RequestTexturepackPacket extends MessagePacket {
	
	private static final long serialVersionUID = -6519638133157751872L;
	
	protected String servername;
	protected String playername;
	
	public RequestTexturepackPacket() {
		super(PacketType.REQUEST_TEXTUREPACK);
	}
	
	public RequestTexturepackPacket setPlayername(String playername){
		
		this.playername = playername;
		return this;
		
	}
	
	public RequestTexturepackPacket setServername(String servername){
		
		this.servername = servername;
		return this;
		
	}
	
	@Override
	public PacketSocketData<RequestTexturepackPacket> build(){
		
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
		
		return new PacketSocketData<RequestTexturepackPacket>(this, this.getClass());
		
	}
	
}
