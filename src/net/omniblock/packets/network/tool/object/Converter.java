package net.omniblock.packets.network.tool.object;

public interface Converter<T> {

	Object parseObject(T param);


}
