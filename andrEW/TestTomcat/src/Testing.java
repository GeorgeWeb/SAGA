

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

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

    static void drawFrame(Graphics2D g, int frame)
    {
    	  g.setColor(Color.green);
    	  g.fillRect(0,0,150,100);
    	  g.setColor(Color.red);
    	  g.fillRect(50,8*frame-20,20,50);
	}
    
    public static int xpos = 500;
    
    static void animateString()
    {
    	Graphics2D g2;
    	g2.drawString("ZDR Andrew :)", xpos, 30);
    	xpos--;
    	if(xpos < -200)
    	{
    		xpos = 500;
    	}
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
    		e.setDelay(300);   // 1 frame per sec
            
    		for (int i=0;i<20;i++)
            {
            	BufferedImage image = new BufferedImage(150,100, BufferedImage.TYPE_INT_ARGB);
            	BufferedImage image2 = new BufferedImage(650,100, BufferedImage.TYPE_INT_ARGB);
            	Graphics2D g = image.createGraphics();
            	drawFrame(g,i);
            	animateString();
            	e.addFrame(image);
            	e.addFrame(image2);
            	//e.addFrame(image2); 
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
