package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class ResposeActionExecutorPacket extends MessagePacket {
	
	private static final long serialVersionUID = -8960362610429016566L;
	
	protected String response;
	
	public ResposeActionExecutorPacket() {
		super(PacketType.RESPOSE_ACTION_EXECUTOR);
	}
	
	public ResposeActionExecutorPacket setResponse(String response){
		
		this.response = response;
		return this;
		
	}
	
	@Override
	public PacketSocketData<ResposeActionExecutorPacket> build(){
		
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
		
		return new PacketSocketData<ResposeActionExecutorPacket>(this, this.getClass());
		
	}
	
}
