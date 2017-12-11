package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class ResposeInformationPacket extends MessagePacket {
	
	private static final long serialVersionUID = -17175846882541468L;
	
	protected String informationkey;
	
	protected String infopreset;
	protected String infovalue;
	
	public ResposeInformationPacket() {
		super(PacketType.RESPOSE_INFORMATION);
	}
	
	public ResposeInformationPacket setInformationKey(String informationkey){
		
		this.informationkey = informationkey;
		return this;
		
	}
	
	public ResposeInformationPacket setInformationPreset(String informationpreset){
		
		this.infopreset = informationpreset;
		return this;
		
	}
	
	public ResposeInformationPacket setInformationValue(String informationvalue){
		
		this.infovalue = informationvalue;
		return this;
		
	}
	
	@Override
	public PacketSocketData<ResposeInformationPacket> build(){
		
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
		
		return new PacketSocketData<ResposeInformationPacket>(this, this.getClass());
		
	}
	
}
