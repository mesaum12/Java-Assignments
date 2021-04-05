package java_assignments;

import java.util.ArrayList;
import java.util.Scanner;

class Item
{
    private static int entry_order=0;
    private String item_name,item_code;
    private float rate;
    private int qty_avl;
    Item()
    {
        qty_avl=0;
    }
    public void setItemDetails()
    {
        System.out.print("Enter the name of the item:");
        Scanner sc=new Scanner(System.in);
        item_name=sc.nextLine();
        System.out.print("Enter the price of the item:");
        rate=sc.nextFloat();
        System.out.print("Enter the quantity to be added:");
        qty_avl=sc.nextInt();
        entry_order++;
        Integer it=entry_order;
        String str;
        if(entry_order<10)
            str="00"+it.toString();
        else if (entry_order<100)
            str="0"+it.toString();
        else
            str=it.toString();
        item_code=item_name.substring(0,3).toUpperCase()+str;
    }
    public String getItem_name()
    {
        return item_name;
    }
    public void changeItemRate(float new_rate)
    {
        rate=new_rate;
    }
    public int getQty_avl()
    {
        return qty_avl;
    }
    public void setQty_avl(int qty)
    {
        qty_avl=qty;
    }
    public float getRate()
    {
        return rate;
    }
    public String toString()
    {
       return ("Name:"+item_name+"\nItemCode:"+item_code+"\nPrice:"+rate+"\nQtyAvl:"+qty_avl);
    }
}
class ItemOperations
{
    private ArrayList<Item>Itemlist;//creating  a private itemlist
     ItemOperations()
     {
       Itemlist=new ArrayList<Item>();//creating the list using the constructor
     }
   class Shopkeeper
   {
       public void displayPrice()
       {
           Scanner sc=new Scanner(System.in);
           System.out.print("Enter the name of the item to display the price of it:");
           String str=sc.nextLine();
           for(Item x:Itemlist)
           {
               if(x.getItem_name().equals(str))
               {
                   System.out.println("The price of the item is:"+x.getRate());
                   return;
               }
           }
           System.out.println("The item is not found in the list");
       }
       public void qty_available()
       {
           Scanner sc=new Scanner(System.in);
           System.out.print("Enter the name of the item to display the quantity available:");
           String str=sc.nextLine();
           for(Item x:Itemlist)
           {
               if(x.getItem_name().equals(str))
               {
                   System.out.println("The quantity of the product you entered is"+x.getQty_avl());
                   return;
               }
           }
           System.out.println("The product you entered is not found in the list");
       }
       public void issueOrReceiveItem()
       {
           System.out.print("1.Issue\n2.Receive Item\nEnter your choice:");
           Scanner sc=new Scanner(System.in);
           int choice;
           String itemName;
           choice=sc.nextInt();
           if(choice==1 || choice==2)
           {
               Item it=new Item();
               System.out.print("Enter the name of the item to be issued or received:");
               sc.nextLine();
               itemName=sc.nextLine();
               int quantity;
               boolean flag=false;
               for(Item x:Itemlist)
               {
                   if(x.getItem_name().equals(itemName))
                   {
                       System.out.print("Enter the quantity of the item to be ");
                       if(choice==1) System.out.print("issued:");
                       else System.out.println("received:");
                       quantity=sc.nextInt();
                       if(choice==1 && quantity>x.getQty_avl())
                           System.out.println("Sorry the quantity is less than your need");
                       else if(choice==1)x.setQty_avl(x.getQty_avl()-quantity);
                       else x.setQty_avl(x.getQty_avl()+quantity);
                       flag=true;
                       break;
                   }
               }
               if(!flag)
                   System.out.println("The item is not found in the list");
           }
           else
               System.out.println("Please enter a valid choice");

       }
       public int itemPriceComparison(float price)
       {
           int count=0;
           for(Item x:Itemlist)
           {
               if(x.getRate()>price)
                   count++;
           }
           return count;
       }
       public void displayItem()
       {
           for(Item x:Itemlist)
               System.out.println(x+"\n");
       }
       //The inner class for having the limited number of operations of the system
       class StockEntryOperator
       {

           public void addItem()
           {
               Item it=new Item();
               it.setItemDetails();
               boolean flag=false;
               for(Item x:Itemlist)
               {
                   if(x.getItem_name().equals(it.getItem_name()))
                       flag=true;
               }
               if(!flag)
                   Itemlist.add(it);
               else System.out.println("Item already exists in the list");
           }
           public void changeRate()
           {
               System.out.print("Enter the name of the item whose rate is to be changed:");
               Scanner sc=new Scanner(System.in);
               String itemName;
               itemName=sc.nextLine();
               boolean flag=false;
               for(Item x:Itemlist)
               {
                   if(x.getItem_name().equals(itemName))
                   {
                       System.out.print("Enter the new rate of the item:");
                       float new_rate;
                       new_rate=sc.nextFloat();
                       x.changeItemRate(new_rate);
                       flag=true;
                       break;
                   }
               }
               if(!flag)
                   System.out.println("The item doesn't exist in the list");
           }

       }
   }
}
//class containing the main method
public class Assign2 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        float price;
        //creating instances for the operations
        ItemOperations it_op=new ItemOperations();
        ItemOperations.Shopkeeper SK=it_op.new Shopkeeper();
        ItemOperations.Shopkeeper.StockEntryOperator SEO=SK.new StockEntryOperator();
        int choice;
        //The operations to be performed inside a while loop
        while(true)
        {
            System.out.println("1.Add an item in the list");
            System.out.println("2.Change rate of an existing item");
            System.out.println("3.Issue or receive item");
            System.out.println("4.Display the price for an item");
            System.out.println("5.Display the quantity available for a particular item");
            System.out.println("6.Get number of items costing more than a particular price");
            System.out.println("7.Display the item list");
            System.out.println("8.Exit ");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            if(choice==8)
                break;
            switch (choice)
            {
                case 1:
                    SEO.addItem();
                    break;
                case 2:
                    SEO.changeRate();
                    break;
                case 3:
                    SK.issueOrReceiveItem();
                    break;
                case 4:
                      SK.displayPrice();
                      break;
                case 5:
                     SK.qty_available();
                     break;
                case 6:
                    System.out.print("Enter the price to compare with:");
                    price=sc.nextFloat();
                    System.out.println(SK.itemPriceComparison(price));
                    break;
                case 7:
                    SK.displayItem();
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }
}
