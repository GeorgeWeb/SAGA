import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Galaxy
 */
@WebServlet("/Galaxy")
public class Galaxy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Galaxy() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void setAntialising(Graphics2D g)
    {
    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
    }
    
    public void drawBackground(Graphics2D g)
    {
    	setAntialising(g);
    	
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 1300, 600);
    }
    
    public void drawSun(Graphics2D g)
    {
    	setAntialising(g);
    	
    	g.setColor(Color.YELLOW);
    	g.fillOval(-180, 100, 350, 350);
    }
    
    public void drawMercury(Graphics2D g)
    {
    	setAntialising(g);
    	
    	g.setColor(new Color(255, 153, 51));
    	g.fillOval(200, 280, 40, 40);
    }
    
    public void drawVenus(Graphics2D g)
    {
    	setAntialising(g);
    	g.setColor(new Color(255, 82, 18));
    	g.fillOval(270, 250, 100, 100);
    }
    
    public void drawEarth(Graphics2D g)
    {
    	setAntialising(g);
    	
    	int w = 890, h = 600;
    	int r = 50;

    	g.setColor(new Color(44, 94, 21));
    	g.fillArc(w/2-r,h/2-r,2*r,2*r,0,-180);
    	g.setColor(new Color(56, 65, 137));
    	g.fillArc(w/2-r,h/2-r,2*r,2*r,0,180);
    	g.fillArc(w/2-r,h/2-r/2,r,r,0,-180);
    	g.setColor(new Color(44, 94, 21));
    	g.fillArc(w/2,h/2-r/2,r,r,0,180);
    }
    
    public void drawMars(Graphics2D g)
    {
    	setAntialising(g);
    	
    	g.setColor(new Color(247, 20, 12));
    	g.fillOval(520, 265, 75, 75);
    }
    
    public void drawJupiter(Graphics2D g)
    {
    	setAntialising(g);
    	
    	g.setColor(new Color(185, 197, 217));
    	g.fillOval(680, 235, 130, 130);
    }
    
    public void drawSaturn(Graphics2D g)
    {
    	setAntialising(g);
    	
    	g.setColor(new Color(246,198,87));
    	g.fillOval(825, 290, 200, 30);
    	g.setColor(Color.BLACK);
    	g.fillOval(840, 300, 160, 10);
    	g.setColor(new Color(246,198,87));
    	g.fillOval(880, 260, 90, 90);
    	
    }
    
    public void drawUranus(Graphics2D g)
    {
    	setAntialising(g);
    	
    	g.setColor(new Color(204,242,243));
    	g.fillOval(1050, 260, 90, 90);
    }
    
    public void drawNeptune(Graphics2D g)
    {
    	setAntialising(g);
    	
    	g.setColor(new Color(66,102,255));
    	g.fillOval(1170, 260, 95, 95);
    }
    public void drawStar(Graphics2D g, int frame, int amount, float size, Color color)
    {
    	setAntialising(g);
    	
    	int r = 20;
    	
		Polygon star = new Polygon
		(
			new int[]{ 0, 22, 95, 36, 59, 0, -59, -36, -95, -22},
			new int[]{ -100, -31, -31, 12, 81, 38, 81, 12, -31, -31}
			,10
		);
		for(int a = 0; a < amount + 1; a++)
		{
			g.translate(100, 20);
			g.setColor(color);
			g.translate(a + 10 * frame, a + 10 * frame);
			g.scale(r / size, r / size);
			g.fillPolygon(star);
			g.scale(size / r, size / r);
			g.translate(-frame + a * 10, -frame + a * 10);
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("image/gif");
    	
    	try
    	{
    		if(req.getParameter("color") == null || req.getParameter("size") == null || req.getParameter("amount") == null)
    		{
    			res.setContentType("text/html");
    			PrintWriter out = res.getWriter();
    			
    			out.println("<form>");

    			out.println("<strong>Stars color:</strong><br>");
    			out.println("White: <input type='radio' name='color' value='FFFFFF' /> | ");
    			out.println("Yellow: <input type='radio' name='color' value='FFFF00' /> | ");
    			out.println("Red: <input type='radio' name='color' value='FF0000' /> | ");
    			out.println("Blue(*new): <input type='radio' name='color' value='00688B' /><br/><br/>");
    			
    			out.println("<strong>Stars size:</strong> <br>");
    			out.println("Tiny(*new): <input type='radio' name='size' value='250' /> | ");
    			out.println("Small: <input type='radio' name='size' value='200' /> | ");
    			out.println("Medium: <input type='radio' name='size' value='150' /> | ");
    			out.println("Large: <input type='radio' name='size' value='100' /><br/><br/>");
    			
    			out.println("<strong>Stars amount: </strong><input name='amount' value='10' style='width:23px;' maxlength='2' /><br/><br/>");

    			out.println("<br/><input type='submit' />");
    			
    			out.println("</form>");
    		}
    		else
    		{
    			if(Integer.parseInt(req.getParameter("amount")) > 30)
    			{
    				res.setContentType("text/html");
        			PrintWriter out = res.getWriter();

        			out.println("<form>");

        			out.println("<strong>Stars color:</strong><br>");
        			out.println("White: <input type='radio' name='color' value='99CCFF' /> | ");
        			out.println("Yellow: <input type='radio' name='color' value='000033' /> | ");
        			out.println("Red: <input type='radio' name='color' value='000033' /> | ");
        			out.println("Blue(*new): <input type='radio' name='color' value='000033' /><br/><br/>");
        			
        			out.println("<strong>Stars size:</strong> <br>");
        			out.println("Tiny(*new): <input type='radio' name='size' value='50' /> | ");
        			out.println("Small: <input type='radio' name='size' value='200' /> | ");
        			out.println("Medium: <input type='radio' name='size' value='150' /> | ");
        			out.println("Large: <input type='radio' name='size' value='100' /><br/><br/>");
        			
        			out.println("<h3 style='color:#FF0000'>The stars amount value cannot be more than 30</h3>");
        			out.println("<strong>Stars amount: </strong><input name='amount' value='10' style='width:23px;' maxlength='2' /><br/><br/>");

        			out.println("<br/><input type='submit' />");
        			
        			out.println("</form>");        			
    			}
    			else
    			{
		    		AnimatedGifEncoder e = new AnimatedGifEncoder();
		    		
		    		e.start(res.getOutputStream());
		
		    		for(int i = 0; i < 70; i++)
		    		{
		    			BufferedImage image = new BufferedImage(1300, 600, BufferedImage.TYPE_INT_ARGB);
		    			
		            	Graphics2D g = image.createGraphics();
		            	
		            	drawBackground(g);
		            	
		            	drawMercury(g);
		            	drawVenus(g);
		            	drawEarth(g);
		            	drawMars(g);
		            	drawSun(g);
		            	drawJupiter(g);
		            	drawSaturn(g);
		            	drawUranus(g);
		            	drawNeptune(g);
		            	int amount = Integer.parseInt(req.getParameter("amount"));
		            	float size = Float.parseFloat(req.getParameter("size"));
		            	Color color = new Color(Integer.parseInt(req.getParameter("color"), 16));
		            	drawStar(g, i, amount, size, color);
		            	
		            	e.addFrame(image);
		
		            	g.dispose();
		    		}
		    		
		            e.finish();
    			}
    		}
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
