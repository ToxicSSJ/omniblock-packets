package net.omniblock.packets.network.tool.console.drawer;

import java.io.*;
import net.omniblock.packets.network.tool.console.Console;

public class ConsoleDrawer {

	protected Boolean draw = true;
	
	public ConsoleDrawer() { }
	
	public void printDraw(String name) {
		
		if(name != null) {
			
			String extension = getExtension(name);
			if(extension != "") {
				if(extension.equalsIgnoreCase(".draw")) {
					
					try {
						
						DrawLoader draw = new DrawLoader(name);
						
						DrawReader.DrawUtils.displayDraw(draw.getDraw(), new DrawReader() {
							
							@Override
							public void read(String text) {
								
								Console.WRITTER.printLine(text + "&r", true, false);
								return;
								
							}
							
						});
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					return;
					
				}
			}

			Console.WRITTER.printError("El archivo " + name + " no posee una extensión valida (.draw)");
			return;
			
		}
		
	}
	
	private String getExtension(String path) {
		
		String extension = "";

		int i = path.lastIndexOf('.');
		extension = path.substring(i);
		
		return extension;
		
	}
	
	public static interface DrawReader {
		
		public void read(String text);
		
		public static class DrawUtils {
			
			public static void displayDraw(InputStream stream, DrawReader reader) throws FileNotFoundException, IOException {
				
				try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
					
				    String line;
				    while ((line = br.readLine()) != null) {
				       reader.read(line);
				    }
				}
			}
		}
	}
}
