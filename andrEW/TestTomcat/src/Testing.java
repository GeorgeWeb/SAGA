
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testing
 */
@WebServlet("/Testing")
public class Testing extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testing() {
        super();
        // TODO Auto-generated constructor stub
    }
    final int carXOffset = 135;
    final int carYOffset = 210;
    
    public void drawRoad(Graphics2D g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(0, 240, 500, 30);
    }
    
    public void drawClouds(Graphics2D g)
    {
    	//Cloud1
    	g.setColor(Color.WHITE);
    	g.fillRect(18, 25 + 20, 30, 10);
    	g.fillRect(40, 15 + 20, 40, 20);
    	g.fillRect(72, 22 + 20, 30, 13);
        g.fillRect(10, 35 + 20, 100, 10);
        
        //Cloud2
        g.setColor(Color.WHITE);
    	g.fillRect(18 + 120, 25 + 50, 30, 10);
    	g.fillRect(40 + 120, 15 + 50, 40, 20);
    	g.fillRect(72 + 120, 22 + 50, 30, 13);
        g.fillRect(10 + 120, 35 + 50, 100, 10);
        
        //Cloud3
        g.setColor(Color.WHITE);
    	g.fillRect(18 + 240, 25, 30, 10);
    	g.fillRect(40 + 240, 15, 40, 20);
    	g.fillRect(72 + 240, 22, 30, 13);
        g.fillRect(10 + 240, 35, 100, 10);
        
        //Cloud4
        g.setColor(Color.WHITE);
    	g.fillRect(18 + 360, 25 + 70, 30, 10);
    	g.fillRect(40 + 360, 15 + 70, 40, 20);
    	g.fillRect(72 + 360, 22 + 70, 30, 13);
        g.fillRect(10 + 360, 35 + 70, 100, 10);
    }
    
    public void drawBlockType1(Graphics2D g)
    {
    	g.setColor(Color.DARK_GRAY);
        g.fillRect(30, 100, 120, 140);
    }
    
    public void drawBlockType2(Graphics2D g)
    {
    	g.setColor(Color.DARK_GRAY);
        g.fillRect(180, 80, 100, 160);
    }
    
    public void drawBlockType3(Graphics2D g)
    {
    	g.setColor(Color.DARK_GRAY);
        g.fillRect(310, 130, 140, 110);
    }
    
    public void drawTree(Graphics2D g, int topXOffset, int bodyXOffset)
    {
    	// tree top
        g.setColor(new Color(0, 153, 76));
        g.fillRect(topXOffset + 100, 160, 40, 40);
        // tree body
        g.setColor(new Color(139, 69, 19));
        g.fillRect(bodyXOffset, 200, 10, 40);
    }
    
    public void drawBackground(Graphics2D g)
    {
        g.setColor(new Color(153, 204, 255));
        g.fillRect(0, 0, 500, 270);
    }
    
    public void drawCar1(Graphics2D g, int frame) 
    {
        g.setColor(Color.YELLOW); // main body
        g.fillRect(frame + 40 - carXOffset, carYOffset, 90, 25);
        g.setColor(Color.GRAY); // top body
        g.fillRect(frame + 60 - carXOffset, carYOffset - 20, 50, 20);
        g.setColor(Color.BLACK); // wheels
        g.fillRect(frame + 55 - carXOffset, carYOffset + 17, 15, 15); // wheel
        g.fillRect(frame + 100 - carXOffset, carYOffset + 17, 15, 15); // wheel
    }
    
    public void drawCar2(Graphics2D g, int frame) 
    {
        g.setColor(Color.RED); // main body
        g.fillRect(frame + 40 - carXOffset * 7, carYOffset, 90, 25);
        g.setColor(Color.BLACK); // top body
        g.fillRect(frame + 60 - carXOffset * 7, carYOffset - 20, 50, 20);
        g.setColor(Color.BLACK); // wheels
        g.fillRect(frame + 55 - carXOffset * 7, carYOffset + 17, 15, 15);
        g.fillRect(frame + 100 - carXOffset * 7, carYOffset + 17, 15, 15);
    }
    
    public void drawCar3(Graphics2D g, int frame) 
    {
        g.setColor(Color.BLUE); // main body
        g.fillRect(frame + 40 - carXOffset * 10, carYOffset, 90, 25);
        g.setColor(Color.BLACK); // top body
        g.fillRect(frame + 60 - carXOffset * 10, carYOffset - 20, 50, 20);
        g.setColor(Color.BLACK); // wheels
        g.fillRect(frame + 55 - carXOffset * 10, carYOffset + 17, 15, 15);
        g.fillRect(frame + 100 - carXOffset * 10, carYOffset + 17, 15, 15);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
    	res.setContentType("image/gif");
    	
    	try
    	{
    		AnimatedGifEncoder e = new AnimatedGifEncoder();
    		
    		e.start(res.getOutputStream());
    		//e.setDelay(1000);   // frames per sec

    		for(int i = 0; i < 150; i++)
    		{    			
    			BufferedImage image = new BufferedImage(500,270, BufferedImage.TYPE_INT_ARGB);
    			
            	Graphics2D g = image.createGraphics();
            	
            	drawBackground(g);
            	drawRoad(g);
            	drawClouds(g);
            	
            	drawBlockType1(g);
            	drawBlockType2(g);
            	drawBlockType3(g);
            	
            	drawTree(g, -5, 100);
            	drawTree(g, 85, 200);
            	drawTree(g, 185, 300);
            	
            	g.translate(i*3, 0);
            	drawCar1(g, i);            	
            	g.translate(i*10, 0);
            	drawCar2(g, i);
            	g.translate(i*5, 0);
            	drawCar3(g, i);
            	e.addFrame(image);

            	g.dispose();
    		}
    		
            e.finish();
        }
    	catch(Exception e)
    	{
    		System.err.println(e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
