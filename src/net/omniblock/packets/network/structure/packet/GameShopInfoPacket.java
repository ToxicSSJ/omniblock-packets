package net.omniblock.packets.network.structure.packet;

import net.omniblock.packets.network.structure.MessagePacket;
import net.omniblock.packets.network.structure.data.PacketSocketData;
import net.omniblock.packets.network.structure.type.PacketType;
import net.omniblock.packets.object.external.ServerType;

import java.lang.reflect.Field;

public class GameShopInfoPacket extends MessagePacket {

	protected String servertype;
	protected String section;

	public GameShopInfoPacket() {
		super(PacketType.GAME_SHOP_INFO);
	}

	public GameShopInfoPacket setServer(ServerType servertype){

		this.servertype = servertype.toString();
		return  this;
	}

	public GameShopInfoPacket setSection(String section){

		this.section = section;
		return this;
	}


	@Override
	public PacketSocketData<GameShopInfoPacket> build(){

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

		return new PacketSocketData<GameShopInfoPacket>(this, this.getClass());

	}
}
