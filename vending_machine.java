//Candy Machine Program

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab_9 extends JFrame
{
   private static final int WIDTH = 600; //dialog box width
   private static final int HEIGHT = 600; //dialog box height

        //Instance variables
   private CashRegister cashRegister = new CashRegister();
   private Dispenser candy = new Dispenser(100, 50);
   private Dispenser chips = new Dispenser(100, 65);
   private Dispenser gum = new Dispenser(75, 45);
   private Dispenser cookies = new Dispenser(100, 85);

   private JLabel headingMainL;
   private JLabel selectionL;

   private JButton exitB, candyB, chipsB, gumB, cookiesB;
   private ButtonHandler pbHandler;

   public lab_9()
   {
      setTitle("Candy Machine");      //set the window title
      setSize(WIDTH, HEIGHT);         //set the window size

      Container pane  = getContentPane();  //get the container
      pane.setLayout(new GridLayout(7,1));//set the pane layout

      pbHandler = new ButtonHandler();  //instantiate listener
                                         //object

      headingMainL =
               new JLabel("WELCOME TO JARED'S CANDY SHOP",
                          SwingConstants.CENTER); //instantiate
                                              //the first label
      selectionL = new JLabel("To Make a Selection, "
                            + "Click on the Product Button",
                      SwingConstants.CENTER); //instantiate
                                             //the second label

      pane.add(headingMainL); //add the first label to the pane
      pane.add(selectionL);  //add the second label to the pane

      candyB = new JButton("Candy");  //instantiate the candy
                                      //button
      candyB.addActionListener(pbHandler);   //register the
                                             //listener to the
                                             //candy button
      chipsB = new JButton("Chips");  //instantiate the chips
                                      //button
      chipsB.addActionListener(pbHandler);  //register the
                                            //listener to the
                                            //chips button
      gumB = new JButton("Gum");  //instantiate the gum button
      gumB.addActionListener(pbHandler);  //register the
                                  //listener to the gum button

      cookiesB = new JButton("Cookies");   //instantiate the
                                           //cookies button
      cookiesB.addActionListener(pbHandler); //register the
                              //listener to the cookies button

      exitB = new JButton("Exit");//instantiate the exit button
      exitB.addActionListener(pbHandler); //register the
                                 //listener to the exit button

      pane.add(candyB);   //add the candy button to the pane
      pane.add(chipsB);   //add the chips button to the pane
      pane.add(gumB);     //add the gum button to the pane
      pane.add(cookiesB); //add the cookies button to the pane
      pane.add(exitB);    //add the exit button to the pane

      setVisible(true);     //show the window and its contents
      setDefaultCloseOperation(EXIT_ON_CLOSE);

   } //end constructor

          //class to handle button events
   private class ButtonHandler implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
          if (e.getActionCommand().equals("Exit"))
              System.exit(0);
          else if (e.getActionCommand().equals("Candy"))
              sellProduct(candy, "Candy");
          else if (e.getActionCommand().equals("Chips"))
              sellProduct(chips, "Chips");
          else if (e.getActionCommand().equals("Gum"))
              sellProduct(gum, "Gum");
          else if (e.getActionCommand().equals("Cookies"))
              sellProduct(cookies, "Cookies");
      }
   }

        //Method to sell a product
	   private void sellProduct(Dispenser product,
   
                            String productName)
   {
     int coinsInserted = 0;
     int price;
     int coinsRequired;
     int change = 0;

     String str;

     if (product.getCount() > 0)
     {
        price = product.getProductCost();
        coinsRequired = price - coinsInserted;
        


        while (coinsRequired > 0)
        {
            str = JOptionPane.showInputDialog("To buy "
                                  + productName
                                  + " please insert "
                                  + coinsRequired + " cents");
            try{coinsInserted = coinsInserted
                            + Integer.parseInt(str);
            } catch (Exception ex1)
            {JOptionPane.showInputDialog("Try again. (Incorrect input. An integer is required.)\n" +
            "To buy " + productName + " please insert "+ coinsRequired + " cents");
            }
            coinsRequired = price - coinsInserted;
            
        }
        change = coinsInserted - price;
        cashRegister.acceptAmount(coinsInserted - change);
        product.makeSale();

        if (coinsInserted > price) {
        	JOptionPane.showMessageDialog(null, "Please pick up "
                    + "your "
                    + productName + " and enjoy\n" +
                    "Your change is " + change + " cents\n" +
                     "Thank you, Come again!",
                    null, JOptionPane.PLAIN_MESSAGE);	
        }
        else JOptionPane.showMessageDialog(null, "Please pick up "
                               + "your "
                               + productName + " and enjoy",
                                "Thank you, Come again!",
                               JOptionPane.PLAIN_MESSAGE);
     }
     else           //dispenser is empty
        JOptionPane.showMessageDialog(null, "Sorry "
                               + productName
                               + " is sold out\n" +
                               "Make another selection",
                               "Thank you, Come again!",
                               JOptionPane.PLAIN_MESSAGE);
   }//end sellProduct


   public static void main(String[] args)
   {
        lab_9 candyShop = new lab_9();
   }
}

//class Dispenser

class Dispenser
{
  private int numberOfItems;   //this variable stores the number of items in the dispenser
                              
  private int cost;    //this variable stores the cost of an item

      /*Default constructor to set the cost and number of
      *items to the default values
      */
  public Dispenser()
  {
       numberOfItems = 50;
       cost = 50;
  }

      //Constructor with parameters to set the cost and number
      //of items in the dispenser specified by the user
  public Dispenser(int setNoOfItems, int setCost)
  {
       if (setNoOfItems >= 0)
           numberOfItems = setNoOfItems;
       else
           numberOfItems = 50;

       if (setCost >= 0)
           cost = setCost;
       else
           cost = 50;
  }

      //Method to show the number of items in the dispenser
  public int getCount()
  {
       return numberOfItems;
  }

      //Method to show the cost of the item
  public int getProductCost()
  {
       return cost;
  }

      //Method to reduce the number of items by 1
  public void makeSale()
  {
      numberOfItems--;
  }
}
//class cashRegister

class CashRegister
{
  private int cashOnHand;   //variable to store the cash
                            //in the register

      //Default constructor to set the cash
      //in the register to 500 cents
      //Postcondition: cashOnHand = 500
  public CashRegister()
  {
      cashOnHand = 500;
  }

      /*Constructor with parameters to set the cash in
      *the register to a specific amount
      */
  public CashRegister(int cashIn)
  {
     if (cashIn >= 0)
           cashOnHand = cashIn;
     else
        cashOnHand = 500;
  }

      //Method to show the current amount in the cash register              
  public int currentBalance()
  {
       return cashOnHand;
  }

      /*This method receives amount deposited by
      *the customer and updates the amount in the register
      */
  public void acceptAmount(int amountIn)
  {
       cashOnHand = cashOnHand + amountIn;
  }
}
