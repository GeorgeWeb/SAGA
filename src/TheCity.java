import java.awt.Color;
import java.awt.Graphics2D;
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
 * Servlet implementation class Testing
 */
@WebServlet("/TheCity")
public class TheCity extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheCity() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private final int carXOffset = 135;
    private final int carYOffset = 210;
    
    private int frameTimer = 0;
    
    private Color windowColor = null;
    
    public void setAntialising(Graphics2D g)
    {
    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
    }
    
    public void drawRoad(Graphics2D g)
    {
    	setAntialising(g);
    	
        g.setColor(Color.GRAY);
        g.fillRect(0, 240, 500, 30);
    }
    
    public void drawClouds(Graphics2D g)
    {
    	setAntialising(g);
    	
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
    
    public void drawBlockType1(Graphics2D g, Color color)
    {
    	setAntialising(g);
    	
    	//block
    	g.setColor(Color.DARK_GRAY);
        g.fillRect(30, 100, 120, 140);
        //windows
        g.setColor(color);
        g.fillRect(50, 120, 20, 20);
    	g.fillRect(80, 120, 20, 20);
    	g.fillRect(110, 120, 20, 20);
    	g.fillRect(50, 150, 20, 20);
    	g.fillRect(80, 150, 20, 20);
    	g.fillRect(110, 150, 20, 20);
    	g.fillRect(50, 180, 20, 20);
    	g.fillRect(80, 180, 20, 20);
    	g.fillRect(110, 180, 20, 20);
    	
    }
    
    public void drawBlockType2(Graphics2D g, Color color)
    {
    	setAntialising(g);
    	
    	//block
    	g.setColor(Color.DARK_GRAY);
        g.fillRect(180, 80, 100, 160);
        //windows
        g.setColor(color);
        g.fillRect(200, 100, 20, 20);
    	g.fillRect(240, 100, 20, 20);
    	g.fillRect(200, 140, 20, 20);
    	g.fillRect(240, 140, 20, 20);
    	g.fillRect(200, 180, 20, 20);
    	g.fillRect(240, 180, 20, 20);
    }
    
    public void drawBlockType3(Graphics2D g, Color color)
    {
    	setAntialising(g);
    	
    	//block
    	g.setColor(Color.DARK_GRAY);
        g.fillRect(310, 130, 140, 110);
    	//windows
    	g.setColor(color);
    	g.fillRect(330, 150, 20, 20);
    	g.fillRect(370, 150, 20, 20);
    	g.fillRect(410, 150, 20, 20);
    	g.fillRect(330, 180, 20, 20);
    	g.fillRect(370, 180, 20, 20);
    	g.fillRect(410, 180, 20, 20);
    }
    
    public void drawTree(Graphics2D g, int topXOffset, int bodyXOffset)
    {
    	setAntialising(g);
    	
    	// tree top
        g.setColor(new Color(0, 153, 76));
        g.fillRect(topXOffset + 100, 160, 40, 40);
        // tree body
        g.setColor(new Color(139, 69, 19));
        g.fillRect(bodyXOffset, 200, 10, 40);
    }
    
    public void drawBackground(Graphics2D g, Color color)
    {
    	setAntialising(g);
    	
        g.setColor(color);
        g.fillRect(0, 0, 500, 270);
    }
    
    public void drawCar1(Graphics2D g, int frame, Color color)
    {
    	setAntialising(g);
    	
        g.setColor(color); // main body
        g.fillRect(frame + 40 - carXOffset, carYOffset, 90, 25);
        g.setColor(Color.GRAY); // top body
        g.fillRect(frame + 60 - carXOffset, carYOffset - 20, 50, 20);
        g.setColor(Color.BLACK); // wheels
        g.fillRect(frame + 55 - carXOffset, carYOffset + 17, 15, 15); // wheel
        g.fillRect(frame + 100 - carXOffset, carYOffset + 17, 15, 15); // wheel
    }
    
    public void drawCar2(Graphics2D g, int frame, Color color) 
    {
    	setAntialising(g);
    	
        g.setColor(color); // main body
        g.fillRect(frame + 40 - carXOffset * 7, carYOffset, 90, 25);
        g.setColor(Color.BLACK); // top body
        g.fillRect(frame + 60 - carXOffset * 7, carYOffset - 20, 50, 20);
        g.setColor(Color.BLACK); // wheels
        g.fillRect(frame + 55 - carXOffset * 7, carYOffset + 17, 15, 15);
        g.fillRect(frame + 100 - carXOffset * 7, carYOffset + 17, 15, 15);
    }
    
    public void drawCar3(Graphics2D g, int frame, Color color) 
    {
    	setAntialising(g);
    	
        g.setColor(color); // main body
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
    	
    	try
    	{
    		if(req.getParameter("c1") == null || req.getParameter("c2") == null || req.getParameter("c3") == null || req.getParameter("speed1") == null || req.getParameter("daytime") == null)
    		{
    			res.setContentType("text/html");
    			PrintWriter out = res.getWriter();
    			
    			out.println("<form>");
    			out.println("Car 1 - color: <input name='c1' value='FFFF00' /><br/>");
    			out.println("Car 2 - color: <input name='c2' value='FF0000' /><br/>");
    			out.println("Car 3 - color: <input name='c3' value='0000FF' /><br/><br/>");
    			
    			out.println("Car 1 - speed: <input name='speed1' value='3' /><br/><br/>");
    			
    			out.println("Day: <input type='radio' name='daytime' value='99CCFF' />");
    			out.println("Night: <input type='radio' name='daytime' value='000033' />");
    			
    			out.println("<br/><br/><input type='submit' />");
    			out.println("</form>");
    			
    		}
    		else
    		{
    			if(Integer.parseInt(req.getParameter("speed1")) > 5)
    			{
    				res.setContentType("text/html");
        			PrintWriter out = res.getWriter();

        			out.println("<form>");
        			out.println("Car 1 - color: <input name='c1' value='FFFF00' /><br/>");
        			out.println("Car 2 - color: <input name='c2' value='FF0000' /><br/>");
        			out.println("Car 3 - color: <input name='c3' value='0000FF' /><br/><br/>");
        			
        			out.println("<h3 style='color:#FF0000;'>Speed value cannot be more than 5</h3>");
        			out.println("Car 1 - speed: <input name='speed1' value='3' /><br/><br/>");
        			
        			out.println("Day: <input type='radio' name='daytime' value='99CCFF' />");
        			out.println("Night: <input type='radio' name='daytime' value='000033' />");
        			
        			out.println("<br/><br/><input type='submit' />");
        			out.println("</form>");
    			}
    			else
    			{
    				res.setContentType("image/gif");
        			
            		AnimatedGifEncoder e = new AnimatedGifEncoder();
            		
            		e.start(res.getOutputStream());
            		
            		if(Integer.parseInt(req.getParameter("speed1")) == 1)
            			frameTimer = 330;
            		else if(Integer.parseInt(req.getParameter("speed1")) == 2)
            			frameTimer = 210;
            		else if(Integer.parseInt(req.getParameter("speed1")) == 3)
            			frameTimer = 150;
            		else if(Integer.parseInt(req.getParameter("speed1")) == 4)
            			frameTimer = 125;
            		else if(Integer.parseInt(req.getParameter("speed1")) == 5)
            			frameTimer = 100;
            		
            		for(int i = 0; i < frameTimer; i++)
            		{
            			BufferedImage image = new BufferedImage(500,270, BufferedImage.TYPE_INT_ARGB);
            			
                    	Graphics2D g = image.createGraphics();
                    	
                    	Color bgColor = new Color(Integer.parseInt(req.getParameter("daytime"), 16));
                    	
                    	drawBackground(g, bgColor);
                    	drawRoad(g);
                    	drawClouds(g);
                    	
                    	if("99CCFF".equalsIgnoreCase(req.getParameter("daytime")))
                    		windowColor = bgColor;
                    	else windowColor = Color.YELLOW;
                    	
                    	drawBlockType1(g, windowColor);
                    	drawBlockType2(g, windowColor);
                    	drawBlockType3(g, windowColor);
                    	
                    	drawTree(g, -15, 100);
                    	drawTree(g, 85, 200);
                    	drawTree(g, 185, 300);
                    	drawTree(g, 285, 400);
                    	
                    	Color c1 = new Color(Integer.parseInt(req.getParameter("c1"), 16));
                    	Color c2 = new Color(Integer.parseInt(req.getParameter("c2"), 16));
                    	Color c3 = new Color(Integer.parseInt(req.getParameter("c3"), 16));
                    	
                    	int speed1 = Integer.parseInt(req.getParameter("speed1"));
                    	
                    	g.translate(i*speed1, 0);
                    	drawCar1(g, i, c1);            	
                    	g.translate(i*10, 0);
                    	drawCar2(g, i, c2);
                    	g.translate(i*5, 0);
                    	drawCar3(g, i, c3);
                    	
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