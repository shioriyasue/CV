import java.awt.*;


public class Chromakey2 {

	static MyImage execute(MyImage input, KMeans kmeans) {

		int width = input.width;
		int height = input.height;
		MyImage output = new MyImage(width, height);

		for(int i = 0, ii = 0; i < height; i++) {
			for(int j = 0; j < width; j++, ii++) {
				
				if(kmeans.idarray[ii] == 9)
					output.setColor(j, i, Color.white);
				else if(kmeans.idarray[ii] == 5)
					output.setColor(j, i, Color.white);
				else 
					output.setColor(j, i, Color.black);
			}	
		}
	
		return output;

	}
}
