package Car;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
 */
@SuppressWarnings("serial")
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;

	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
		x=x1;
		y=y1;
		car1 = new Car(x, y, this);
		carQueue = queue;
	}
	public void startAnimation()
	{
		class AnimationRunnable implements Runnable
		{
			public void run()
			{
				try
				{
					for(int i=0; i<10; i++)
					{
						direction = carQueue.deleteQueue();

						//Up
						if(direction == 0){
							
							if(!(y < 0 && y >300)){
								y = y + 20;
							}
						}
						
						//Down
						if (direction == 1){

							if(!(y > 300 && y < 0)){
								y = y - 10;
							}
						}
						
						//Right
						if (direction == 3){
							
							if( x <200){
								x = x + 20;
							}
						}
						
						//Left
						if (direction == 2){

							if((x >0)){
								x = x - 10;
							}
						}			
						
						repaint();
						Thread.sleep(delay*1000);

					}
				}
				catch (InterruptedException exception)
				{

				}
				finally
				{

				}
			}
		}

		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}

	public void paintComponent(Graphics g)
	{  
		Graphics2D g2 = (Graphics2D) g;

		car1.draw(g2,x,y);    
	}
}