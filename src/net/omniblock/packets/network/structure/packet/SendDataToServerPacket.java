package net.omniblock.packets.network.structure.packet;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;

import java.lang.reflect.Field;

public class SendDataToServerPacket extends MessagePacket {

	private String data;

	public SendDataToServerPacket(){
		super(PacketType.SERVER_SEND_TO_DATA);
	}


	public SendDataToServerPacket setData(String data){

		this.data = data;
		return this;
	}

	@Override
	public PacketSocketData<SendDataToServerPacket> build(){

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

		return new PacketSocketData<SendDataToServerPacket>(this, this.getClass());
	}
}
