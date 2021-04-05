import java.util.*;

class Item{
    static int Code;//stores the itemcode
    String Name;//stores the name
    float Rate;//stores the price
    int Quantity;//stores the qty
    void getName(){//takes input of name of the item
        System.out.print("Enter Name Of the Item: ");
        Scanner Sc=new Scanner(System.in);
        Name=Sc.nextLine();
        Sc.close();
    }
    void getRate(){//takes input of rate of the item
        System.out.print("Enter Rate Of the Item: ");
        Scanner Sc=new Scanner(System.in);
        Rate=Sc.nextFloat();
        Sc.close();
    }
    void getQuantity(){//take input of the quantity of item
        System.out.print("Enter Quantity Of the Item: ");
        Scanner Sc=new Scanner(System.in);
        Quantity=Sc.nextInt();
        Sc.close();
    }
    Item(){//constructor generating code
        Code++;
    }
    void displayItem(){
        System.out.println("Item Code: "+ Code);
        System.out.println("Item Rate: "+ Rate);
        System.out.println("Item Name: "+ Name);
        System.out.println("Item Quantity: "+ Quantity);
    }
}

class ItemList {//item list class contains item array
    Item I[]=new Item[50];
    static int i;
    public void addItem(){//adds item  to list
        I[i].getName();
        I[i].getRate();
        I[i++].getQuantity();
    }

    public void changeRate(int code){//updates price of the item in the list
        Scanner sc=new Scanner(System.in);
        for(Item J: I ){
            if(Item.Code==code)
                J.Rate=sc.nextFloat();
        }
        sc.close();
    }

    public void updateStock(int code,int qty){//updates quantity

        for(Item J: I ){
            if(Item.Code==code)
                J.Quantity=qty;
        }

    }

    public boolean stockAvailable(int code){//notifies whether stock is available or not
        return (I[i].Quantity!=0 && Item.Code==code);
    }

    public void showDetails(int code){//shows details of the item
        for(Item J: I ){
            if(Item.Code==code)
                J.displayItem();
        }
    }

    public void itemsMoreThan(float price){//shows all item more than a certain price
        for(Item J: I ){
            if(J.Rate>price)
                J.displayItem();
            System.out.println("\n");
        }
    }

    public void itemIssueOrReturn(int code){
        Scanner sc=new Scanner(System.in);
        char ch=sc.next().charAt(0);
        for(Item J: I ){
            if(Item.Code==code && ch=='i'|| ch=='I')
                J.Quantity--;
            if(Item.Code==code && ch=='r'|| ch=='R')
                J.Quantity++;
        }
        sc.close();
    }

}

class shopkeeper{
    ItemList Il=new ItemList();

    void Interface(int choice){
        Scanner sc=new Scanner(System.in);
        int Icode;
        float Rate;

        System.out.println("4.Stock Available for Item");
        System.out.println("5.Show Details");
        System.out.println("6.Items More Than Price Entered");
        System.out.println("7.Issue or Return Item");
        switch(choice){

            case 4:
                System.out.println("Enter Item Code:");
                Icode=sc.nextInt();
                System.out.println(Il.stockAvailable(Icode));
                break;
            case 5:
                System.out.println("Enter Item Code:");
                Icode=sc.nextInt();
                Il.showDetails(Icode);
                break;
            case 6:
                System.out.println("Enter Item Rate:");
                Rate=sc.nextFloat();
                Il.itemsMoreThan(Rate);
                break;
            case 7:
                System.out.println("Enter Item Code:");
                Icode=sc.nextInt();
                Il.itemIssueOrReturn(Icode);
                break;
        }
        sc.close();
    }

}

class SEO{
    ItemList Il=new ItemList();

    void Interface(int choice){
        Scanner sc=new Scanner(System.in);
        int Icode,Qty;
        float Rate;
        switch(choice){
            case 1:
                Il.addItem();
                break;
            case 2:
                System.out.println("Enter Item Code:");
                Icode=sc.nextInt();
                Il.changeRate(Icode);
                break;
            case 3:
                System.out.println("Enter Item Code:");
                Icode=sc.nextInt();
                Qty=sc.nextInt();
                Il.updateStock(Icode,Qty);
            case 4:
                System.out.println("Enter Item Code:");
                Icode=sc.nextInt();
                System.out.println(Il.stockAvailable(Icode));
                break;
            case 5:
                System.out.println("Enter Item Code:");
                Icode=sc.nextInt();
                Il.showDetails(Icode);
                break;
            case 6:
                System.out.println("Enter Item Rate:");
                Rate=sc.nextFloat();
                Il.itemsMoreThan(Rate);
                break;
            case 7:
                System.out.println("Enter Item Code:");
                Icode=sc.nextInt();
                Il.itemIssueOrReturn(Icode);
                break;
        }
        sc.close();
    }

}

class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        SEO SE=new SEO();
        System.out.println("1.Add Item");
        System.out.println("2.Update Price");
        System.out.println("3.Update Stock");
        System.out.println("4.Stock Available for Item");
        System.out.println("5.Show Details");
        System.out.println("6.Items More Than Price Entered");
        System.out.println("7.Issue or Return Item");
        choice=sc.nextInt();
        SE.Interface(choice);

        shopkeeper S=new shopkeeper();
        System.out.println("4.Stock Available for Item");
        System.out.println("5.Show Details");
        System.out.println("6.Items More Than Price Entered");
        System.out.println("7.Issue or Return Item");

        choice=sc.nextInt();
        S.Interface(choice);

        sc.close();
    }
}