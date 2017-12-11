package net.omniblock.packets.network.structure.packet;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

public class RequestActionExecutorPacket extends MessagePacket {

	private static final long serialVersionUID = -4746310989694981658L;
	
	protected String requestaction;
	protected String args;
	
	protected int requesterport;
	
	public RequestActionExecutorPacket() {
		super(PacketType.REQUEST_ACTION_EXECUTOR);
	}
	
	public RequestActionExecutorPacket setRequesterPort(int requesterport){
		
		this.requesterport = requesterport;
		return this;
		
	}
	
	public RequestActionExecutorPacket setRequestAction(String requestaction){
		
		this.requestaction = requestaction;
		return this;
		
	}
	
	public RequestActionExecutorPacket setArgs(String...args){
		
		this.args = StringUtils.join(args, ',');
		return this;
		
	}
	
	@Override
	public PacketSocketData<RequestActionExecutorPacket> build(){
		
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
		
		return new PacketSocketData<RequestActionExecutorPacket>(this, this.getClass());
		
	}
	
}
