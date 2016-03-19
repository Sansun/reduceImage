package com.image.thumbnail;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReduseSize {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ReduseSize rs = new ReduseSize();
		
		
		BufferedImage bimg = rs.loadImage("./res/20150920_134931.jpg");
		
	    bimg = rs.resize(bimg, 0, 0);
	    
	    ImageIO.write(bimg, "jpg", new File("./res/20150920_134931_tnail.jpg"));
		

	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {  
        int w = img.getWidth();  
        int h = img.getHeight();  
        BufferedImage dimg = dimg = new BufferedImage(w/2, h/2, img.getType());  
        Graphics2D g = dimg.createGraphics();  
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
        g.drawImage(img, 0, 0, w/2, h/2, 0, 0, w, h, null);  
        g.dispose();  
        return dimg;  
    }  
	
	
	
	public static BufferedImage loadImage(String ref) {  
        BufferedImage bimg = null;  
        try {  
  
            bimg = ImageIO.read(new File(ref));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return bimg;  
    }  
}
