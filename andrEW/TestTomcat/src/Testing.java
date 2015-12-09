

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
    
    public void drawCar(Graphics2D g, int frameX, int frameY) {    	
        g.setColor(Color.BLUE);
        g.fillRect(frameX, frameY, 100, 30);
        g.setColor(Color.BLACK); // body
        g.fillOval(frameX + 15, frameY + 20, 15, 15); // wheel
        g.fillOval(frameX + 60, frameY + 20, 15, 15); // wheel
        g.fillRect(frameX + 15, frameY - 20, 60, 20); // top
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
    			for(int j=0;j<20;j++)
    			{
    				BufferedImage image = new BufferedImage(600,300, BufferedImage.TYPE_INT_ARGB);
                	Graphics2D g = image.createGraphics();
                	//drawFrame(g,i);
                	drawCar(g, i, j);
                	e.addFrame(image);
                	//e.addFrame(image2); 
                	g.dispose();
    			}
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
