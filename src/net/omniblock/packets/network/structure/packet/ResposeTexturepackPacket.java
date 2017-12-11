package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class ResposeTexturepackPacket extends MessagePacket {
	
	private static final long serialVersionUID = -17175845882541468L;
	
	protected String resourcetype;
	
	public ResposeTexturepackPacket() {
		super(PacketType.RESPOSE_TEXTUREPACK);
	}
	
	public ResposeTexturepackPacket setResourcetype(String resourcetype){
		
		this.resourcetype = resourcetype;
		return this;
		
	}
	
	@Override
	public PacketSocketData<ResposeTexturepackPacket> build(){
		
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
		
		return new PacketSocketData<ResposeTexturepackPacket>(this, this.getClass());
		
	}
	
}
