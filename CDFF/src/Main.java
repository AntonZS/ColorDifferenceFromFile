import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		HashMap<String,Double> map = new HashMap<String, Double>();
		Color color1 = createColor(76, 54, 34);
		String nameOfFile = getNameOfFile();
		BufferedReader rf = new BufferedReader(new InputStreamReader(new  FileInputStream(nameOfFile)));
		String line;
		while((line = rf.readLine())!=null){
			String[] lm = line.split("\r\n");
			Color color2 = createColor(Double.parseDouble(lm[1]), Double.parseDouble(lm[2]),Double.parseDouble(lm[3]));
			double dE = Color.colorDifference(color1, color2);
			map.put(lm[0], dE);
		}
		LinkedHashMap<String, Double> lmap =sortirovka(map);
		for(Map.Entry<String, Double> entry: lmap.entrySet()){
			System.out.println(entry.getKey()+ " "+entry.getValue());
		}

	}

	private static LinkedHashMap<String, Double> sortirovka(HashMap<String, Double> map)
	{List list = new ArrayList(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>(){

				@Override
				public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2)
				{
					return e1.getValue().compareTo(e2.getValue());
				}
			});
		LinkedHashMap<String, Double> result = new LinkedHashMap<String, Double>();
		for (Map.Entry<String, Double> entry: list)
		{
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	private static String getNameOfFile()
	{
		String s = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			s = reader.readLine();
		}
		catch (IOException e)
		{}
		return s;
	}
	public static Color createColor(double l, double a, double b){
		Color color = new Color(l, a, b);
		return color;
	}
}
