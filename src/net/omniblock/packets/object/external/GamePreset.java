package net.omniblock.packets.object.external;

public enum GamePreset {

	NONE,
	
	SKYWARS_MASK(ServerType.SKYWARS_GAME_SERVER, true, "mask"),
	
	SKYWARS_SOLO_NORMAL(ServerType.SKYWARS_GAME_SERVER, "solo", "normal"),
	SKYWARS_SOLO_INSANE(ServerType.SKYWARS_GAME_SERVER, "solo", "insane"),
	SKYWARS_SOLO_Z(ServerType.SKYWARS_GAME_SERVER, "solo" , "z"),
	
	SKYWARS_TEAM_NORMAL(ServerType.SKYWARS_GAME_SERVER, "teams", "normal"),
	SKYWARS_TEAM_INSANE(ServerType.SKYWARS_GAME_SERVER, "teams", "insane"),
	SKYWARS_TEAM_Z(ServerType.SKYWARS_GAME_SERVER, "teams", "z"),
	
	;
	
	private String[] initializeargs = new String[] { "none" };
	private ServerType servertype = ServerType.MAIN_LOBBY_SERVER;
	
	private boolean mask = false;
	
	GamePreset() { }
	
	GamePreset(ServerType servertype, String...args) {
		
		this.servertype = servertype;
		this.initializeargs = args;
		
	}
	
	GamePreset(ServerType servertype, boolean mask, String...args) {
		
		this.servertype = servertype;
		this.initializeargs = args;
		
		this.mask = mask;
		
	}
	
	public ServerType getServertype() {
		return servertype;
	}

	public void setServertype(ServerType servertype) {
		this.servertype = servertype;
	}
	
	public static GamePreset getGamePreset(String gamepresetkey) {
		
		return GamePreset.valueOf(gamepresetkey);
		
	}

	public boolean isMask(){
		return mask;
	}
	
	public String[] getInitializeArgs() {
		return initializeargs;
	}

	public String getInitializeArgsSTR() {
		return String.join("#", initializeargs);
	}
	
	public void setInitializeArgs(String[] initializeargs) {
		this.initializeargs = initializeargs;
	}
	
}
