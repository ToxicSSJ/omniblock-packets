package net.omniblock.packets.network.structure.packet;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;
import net.omniblock.packets.object.external.ServerType;

import java.lang.reflect.Field;

public class RemoveSystemServerPacket extends MessagePacket {

	protected String servertype;

	public RemoveSystemServerPacket() {
		super(PacketType.SERVER_REMOVE_SYSTEM);
	}

	public RemoveSystemServerPacket setServer(ServerType servertype){

		this.servertype = servertype.toString();
		return this;
	}

	@Override
	public PacketSocketData<RemoveSystemServerPacket> build(){

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

		return new PacketSocketData<RemoveSystemServerPacket>(this, this.getClass());
	}

}
