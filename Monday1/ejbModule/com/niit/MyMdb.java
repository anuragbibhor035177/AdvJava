package com.niit;

import java.awt.font.TextMeasurer;
import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.bean.Employee;

/**
 * Message-Driven Bean implementation class for: MyMdb
 */
@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(
						propertyName = "destinationType", 
						propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(
						propertyName = "destination", 
						propertyValue = "queue/MyQueue"),
						
		})
public class MyMdb implements MessageListener {

    /**
     * Default constructor. 
     */
    public MyMdb() {
        
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        
    	System.out.println("Hello from MyMdb");
    	try {
    		if(message instanceof TextMessage) {
    			System.out.println("Queue : I received a text message at "+new Date());
    			TextMessage msg = (TextMessage)message;
    			System.out.println("Message is :"+msg.getText());
    		}
    		else if (message instanceof ObjectMessage) {
				System.out.println("Queue : I received a text message at "+new Date());
				ObjectMessage msg = (ObjectMessage)message;
				Employee employee = (Employee)msg.getObject();
				System.out.println("Employee Details  ");
				System.out.println(employee.getId());
				System.out.println(employee.getName());
				System.out.println(employee.getDesignation());
				System.out.println(employee.getSalary());
				
			}
    		else {
    			System.out.println("Not a valid message for this Queue MDB");
			}
			
		} catch (JMSException e) {
			System.out.println("Errors are  "+e);
			e.printStackTrace();
		}
    }

}
