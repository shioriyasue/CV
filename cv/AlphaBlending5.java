
import java.awt.*;


public class AlphaBlending5 {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0, int x, int y) { 

		double a = 0.5;

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;

		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
		
				if(y <= i  && i < height1+y && x <= j && j < width1+x) {
					Color color0 = input0.getColor(j-x, i-y);
					if(color0.getRed() == 0) {
				
						Color color1 = input1.getColor(j-x, i-y);
						Color color2 = input2.getColor(j ,i);
						int colorR = (int)(a*color1.getRed() + (1.0-a)*color2.getRed());
						int colorG = (int)(a*color1.getGreen() + (1.0-a)*color2.getGreen());
						int colorB = (int)(a*color1.getBlue() + (1.0-a)*color2.getBlue());
						Color color3 = new Color(colorR,colorG,colorB);
						output.setColor(j, i, color3);
						isProcessed = true;
					}
					
				}

				if(i < height2 && j < width2) {
					if(isProcessed == false) {
						
						Color color2 = input2.getColor(j, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		return output;

	}

}
