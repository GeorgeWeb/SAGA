

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
public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testing() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    final int carY = 210;
    
    public void drawRoad(Graphics2D g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(0, 240, 500, 30);
    }
    
    public void drawTree(Graphics2D g)
    {
    	// tree top
        g.setColor(Color.GREEN);
        g.fillRect(0, 160, 30, 20);
        // tree body
        g.setColor(new Color(139, 69, 19));
        g.fillRect(0, 200, 10, 40);
    }
    
    public void drawBackground(Graphics2D g)
    {
        g.setColor(new Color(153, 204, 255));
        g.fillRect(0, 0, 500, 270);
    }
    
    public void drawCar(Graphics2D g, int frame) 
    {
        g.setColor(Color.YELLOW); // main body
        g.fillRect(frame + 40, carY, 90, 25);
        g.setColor(Color.GRAY); // top body
        g.fillRect(frame + 60, carY - 20, 50, 20);
        g.setColor(Color.BLACK); // wheels
        g.fillRect(frame + 55, carY + 17, 15, 15); // wheel
        g.fillRect(frame + 100, carY + 17, 15, 15); // wheel
        g.translate(frame + 250, frame + 250);
    }
    
    public void moveRider(Graphics g, int frame)
    {
    	g.translate(frame + 250, frame + 250);
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
    		e.setDelay(10);   // frames per sec
            
    		

			// create RIDER
    		URL url = new URL("http://i.share.pho.to/72dbe770_o.png");
    		Image img = ImageIO.read(url);
    		
    		for(int i = 0; i<300; i++)
    		{    			
    			BufferedImage image = new BufferedImage(500,270, BufferedImage.TYPE_INT_ARGB);
    			//BufferedImage rider = (BufferedImage) img;
    			
            	Graphics2D g = image.createGraphics();
            	//Graphics g2 = rider.getGraphics();
            	
            	drawBackground(g);
            	drawRoad(g);
            	drawCar(g, i);
            	//moveRider(g2, i);
            	
            	e.addFrame(image);
            	//e.addFrame(rider);
            	
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
