package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class PlayerSendTitlePacket extends MessagePacket {
	
	private static final long serialVersionUID = -7356826274866878895L;
	
	protected String playername;
	
	protected String title;
	protected String subtitle;
	
	public PlayerSendTitlePacket() {
		super(PacketType.PLAYER_SEND_TITLE);
	}
	
	public PlayerSendTitlePacket setPlayername(String playername){
		
		this.playername = playername;
		return this;
		
	}
	
	public PlayerSendTitlePacket setTitle(String title){
		
		this.title = title;
		return this;
		
	}
	
	public PlayerSendTitlePacket setSubtitle(String subtitle){
		
		this.subtitle = subtitle;
		return this;
		
	}
	
	@Override
	public PacketSocketData<PlayerSendTitlePacket> build(){
		
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
		
		return new PacketSocketData<PlayerSendTitlePacket>(this, this.getClass());
		
	}
	
}
