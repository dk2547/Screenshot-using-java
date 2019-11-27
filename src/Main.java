import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Main {
public static void main(String[] args) throws AWTException, IOException, InterruptedException {
	int n=1;
	while (true) {
		n++;
		getScreenShot(Integer.toString(n));
		Thread.sleep(5000);
	}

}

static void getScreenShot(String filename) throws AWTException, IOException{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    GraphicsEnvironment ge =  GraphicsEnvironment.getLocalGraphicsEnvironment(); 
	GraphicsDevice gd=ge.getDefaultScreenDevice();
	Robot r= new Robot(gd);
BufferedImage bi=	r.createScreenCapture(new Rectangle((int) screenSize.getWidth(),(int) screenSize.getHeight()));
File outputfile = new File(filename+".jpg");
ImageIO.write(bi, "jpg", outputfile);	
System.out.println(r.toString());
}
}
