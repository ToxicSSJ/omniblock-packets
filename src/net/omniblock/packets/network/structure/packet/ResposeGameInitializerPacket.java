package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class ResposeGameInitializerPacket extends MessagePacket {
	
	private static final long serialVersionUID = -5596804265606537108L;
	
	protected String gamepreset;
	protected String data;
	
	public ResposeGameInitializerPacket() {
		super(PacketType.RESPOSE_GAME_INITIALIZER);
	}
		
	public ResposeGameInitializerPacket setData(String data){
		
		this.data = data;
		return this;
		
	}
	
	public ResposeGameInitializerPacket setGamepreset(String gamepreset){
		
		this.gamepreset = gamepreset;
		return this;
		
	}
	
	@Override
	public PacketSocketData<ResposeGameInitializerPacket> build(){
		
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
		
		return new PacketSocketData<ResposeGameInitializerPacket>(this, this.getClass());
		
	}
	
}
