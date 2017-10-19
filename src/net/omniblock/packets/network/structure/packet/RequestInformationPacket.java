package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class RequestInformationPacket extends MessagePacket {
	
	private static final long serialVersionUID = -6519638133157751879L;
	
	protected String servername;
	
	protected String infokey;
	protected String infovalue;
	
	public RequestInformationPacket() {
		super(PacketType.REQUEST_INFORMATION);
	}
	
	public RequestInformationPacket setServername(String servername){
		
		this.servername = servername;
		return this;
		
	}
	
	public RequestInformationPacket setInformationKey(String infokey){
		
		this.infokey = infokey;
		return this;
		
	}
	
	public RequestInformationPacket setInformationValue(String infovalue){
		
		this.infovalue = infovalue;
		return this;
		
	}
	
	@Override
	public PacketSocketData<RequestInformationPacket> build(){
		
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
		
		return new PacketSocketData<RequestInformationPacket>(this, this.getClass());
		
	}
	
}
