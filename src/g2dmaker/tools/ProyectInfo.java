package g2dmaker.tools;

import java.util.HashMap;
import java.util.Map;

public class ProyectInfo {
	
	private static final Map<String, String> info = new HashMap<String, String>();
	
	public static String get(String name) {
		return info.get(name);
	}
	
	public static int getInt(String name) {
		try {
			return Integer.parseInt(info.get(name));
		}catch(NumberFormatException e) {
			return -1;
		}
	}
	
	public static double getDouble(String name) {
		try {
			return Double.parseDouble(info.get(name));
		}catch(NumberFormatException n) {
			return -1;
		}
	}
	
	public static void setInfo() {
		String content = ResourcesLoader.readFileTextOnResourcesFolder("/proyect.g2dmaker");
		final String[] parts = content.split(",");
		content = null;
		for(String part : parts) {
			 String[] var = part.split("=");
			 info.put(var[0], var[1]);
		}
	}
	
	public static void setInfo(String[][] info) {
		for(int i = 0; i < info.length; i++) {
			ProyectInfo.info.put(info[i][0], info[i][1]);
		}
	}

}
