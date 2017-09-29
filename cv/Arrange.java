
import java.awt.*;


public class Arrange {

	static MyImage execute(MyImage input1, MyImage input2, int x, int y) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		//int width  = (width1  > width2)  ? width1  : width2;
		//int height = (height1 > height2) ? height1 : height2;
	
		MyImage output = new MyImage(width2, height2);

		for(int i = 0; i < height2; i++) {
			for(int j = 0; j < width2; j++) {
				boolean isProcessed = false;
				Color color2 = input2.getColor(j, i);

				if(y <= i && i < height1+y){
					if(x <= j && j < width1+x){
						Color color1 = input1.getColor(j-x, i-y);
						if(color1.getRed() > 0){
						output.setColor(j, i, color1);
						isProcessed = true;
						}	
					}
					
				}

				if(isProcessed == false) {	
					output.setColor(j, i, color2);
				}
			}
		}

		return output;

	}

}
