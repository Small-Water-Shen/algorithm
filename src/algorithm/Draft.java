package algorithm;

import java.awt.*;
import java.awt.event.*;
/*
 * e = 1/0! + 1/1! + 1/ ! +1/3! +1/4! +1/5! + ...+ 1/n! 
 * 
 *
 */


public class Draft{
	
	public static void clear() throws AWTException{
		Robot robot = new Robot();
		//��Ϣ����
		robot.delay(2000);
		//��������Ҽ�
		robot.mousePress(MouseEvent.BUTTON3_MASK);
		robot.mouseRelease(MouseEvent.BUTTON3_MASK);
		//����R
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
	}
	
	public static void main(String [] args){
//		clear();
		int n = 99;
		String t = String.valueOf(n);
		for(int i=0;i<t.length();i++)
			System.out.println(((int)(t.charAt(i))));
    } 
}