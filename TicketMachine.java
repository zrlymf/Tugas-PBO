import java.util.Scanner;

// Main class
public class Main
{
    public static void main(String[] args)
    {
        int Money;
        int Adult;
        int Children;
        int Destination;
        String DestinationName = "";
        boolean Success;
        
        Scanner input = new Scanner(System.in);
        
        TicketMachine mtObj = new TicketMachine();
        
        //Tampilan menu ticket
        System.out.println("");
        System.out.println("WELCOME TO THE NUSANTARA TRAIN");
        System.out.println("1. " + mtObj.stationObj1.GetName());
        System.out.println("Price");
        System.out.println("Adult : " + mtObj.stationObj1.GetPriceAdult());
        System.out.println("Children : " + mtObj.stationObj1.GetPriceChild());
        System.out.println("");
        System.out.println("2. " + mtObj.stationObj2.GetName());
        System.out.println("Price");
        System.out.println("Adult : " + mtObj.stationObj2.GetPriceAdult());
        System.out.println("Children : " + mtObj.stationObj2.GetPriceChild());
        System.out.println("");
        System.out.println("3. " + mtObj.stationObj3.GetName());
        System.out.println("Price");
        System.out.println("Adult : " + mtObj.stationObj3.GetPriceAdult());
        System.out.println("Children : " + mtObj.stationObj3.GetPriceChild());
        System.out.println("");
        System.out.println("4. " + mtObj.stationObj4.GetName());
        System.out.println("Price");
        System.out.println("Adult : " + mtObj.stationObj4.GetPriceAdult());
        System.out.println("Children : " + mtObj.stationObj4.GetPriceChild());
        System.out.println("");
        System.out.println("5. " + mtObj.stationObj5.GetName());
        System.out.println("Price");
        System.out.println("Adult : " + mtObj.stationObj5.GetPriceAdult());
        System.out.println("Children : " + mtObj.stationObj5.GetPriceChild());
        System.out.println("");
        
        //Tampilan input
        System.out.println("Please select your destination station (select 1 -5)");
        Destination = input.nextInt();
        
        //Error handler
        while(Destination <= 0 || Destination >= 6)
        {
            System.out.println("Error, please reselect your destination station ");
            Destination = input.nextInt();
        }
        
        switch(Destination)
        {
            case 1:
            {
                DestinationName = mtObj.stationObj1.GetName();
            }
            break;
            
            case 2:
            {
                DestinationName = mtObj.stationObj2.GetName();
            }
            break;
            
            case 3:
            {
                DestinationName = mtObj.stationObj3.GetName();
            }
            break;
            
            case 4:
            {
                DestinationName = mtObj.stationObj4.GetName();
            }
            break;
            
            case 5:
            {
                DestinationName = mtObj.stationObj5.GetName();
            }
        }
        
        System.out.println("Please enter your money");
        Money = input.nextInt();
        System.out.println("Enter the number of passengers");
        System.out.println("Adult :");
        Adult = input.nextInt();
        System.out.println("Children :");
        Children = input.nextInt();
        
        mtObj.Input(Money, Adult, Children);
        Success = mtObj.BuyTicket(Destination);
        
        if(Success)
        {
            //Transaksi berhasil
            System.out.println("Transaction Successful");
            System.out.println("");
            System.out.println("=====================================");
            System.out.println("Start : Stasiun Jakarta");
            System.out.println("Destination : " + DestinationName);
            System.out.println("Total ticket price : " + mtObj.GetMoney());
            System.out.println("Your balance : " + mtObj.GetChange());
            System.out.println("=====================================");
        }
        else
        {
            //Transaksi gagal
            System.out.println("Transaction Failed");
            System.out.println("Please try again");
        }
        
    }
}

// TicketMachine class
class TicketMachine
{
    //Deklarasi Objek Destination
    Trip stationObj1 = new Trip("Stasiun Surabaya");
    Trip stationObj2 = new Trip("Stasiun Jogja");
    Trip stationObj3 = new Trip("Stasiun Bandung");
    Trip stationObj4 = new Trip("Stasiun Semarang");
    Trip stationObj5 = new Trip("Stasiun Malang");
    
    private int MoneySpend;
    private int Change;
    private int Grown;
    private int Child;
    
    //Constructor set database
    public TicketMachine()
    {
        stationObj1.SetInfo(320,270);
        stationObj2.SetInfo(270,240);
        stationObj3.SetInfo(50,30);
        stationObj4.SetInfo(250,210);
        stationObj5.SetInfo(320,270);
    }
    
    //Input
    public void Input(int funds, int grown, int child)
    {
        MoneySpend = funds;
        Grown = grown;
        Child = child;
    }
    
    //Check keberhasilan transaksi
    public boolean BuyTicket(int choice)
    {
        boolean success = false;
        if(Enaugh(choice, Grown, Child))
        {
            MoneySpend -= Change;
            success = true;
        }
        return success;
    }
    
    public int GetMoney()
    {
        return MoneySpend;
    }
    
    public int GetChange()
    {
        return Change;
    }
    
    //Cek cukup atau tidaknya uang
    public boolean Enaugh(int choice, int grown, int child)
    {
        boolean Enaugh = false;
        switch(choice)
        {
            case 1:
            {
                if(MoneySpend >=(stationObj1.GetPriceAdult()*grown + stationObj1.GetPriceChild()*child))
                {
                    Change = MoneySpend - (stationObj1.GetPriceAdult()*grown + stationObj1.GetPriceChild()*child);
                    
                    Enaugh = true;
                }
            }
            break;
            case 2:
            {
                if(MoneySpend >=(stationObj2.GetPriceAdult()*grown + stationObj2.GetPriceChild()*child))
                {
                    Change = MoneySpend - (stationObj2.GetPriceAdult()*grown + stationObj2.GetPriceChild()*child);
                    
                    Enaugh = true;
                }
            }
            break;
            case 3:
            {
                if(MoneySpend >=(stationObj3.GetPriceAdult()*grown + stationObj3.GetPriceChild()*child))
                {
                    Change = MoneySpend - (stationObj3.GetPriceAdult()*grown + stationObj3.GetPriceChild()*child);
                    
                    Enaugh = true;
                }
            }
            break;
            case 4:
            {
                if(MoneySpend >=(stationObj4.GetPriceAdult()*grown + stationObj4.GetPriceChild()*child))
                {
                    Change = MoneySpend - (stationObj4.GetPriceAdult()*grown + stationObj4.GetPriceChild()*child);
                    
                    Enaugh = true;
                }
            }
            break;
            case 5:
            {
                if(MoneySpend >=(stationObj5.GetPriceAdult()*grown + stationObj5.GetPriceChild()*child))
                {
                    Change = MoneySpend - (stationObj5.GetPriceAdult()*grown + stationObj5.GetPriceChild()*child);
                    
                    Enaugh = true;
                }
            }
            break;
        }
        return Enaugh;
    }
}

// Trip class
class Trip
{
    private String Stasiun;
    private int HargaDewasa;
    private int HargaAnakAnak;
    
    //Struct destination
    public Trip(String nama)
    {
        Stasiun = nama;
        HargaDewasa = 0;
        HargaAnakAnak = 0;
    }
    
    public void SetInfo(int hd, int ha)
    {
        HargaDewasa = hd;
        HargaAnakAnak = ha;
    }
    
    public int GetPriceAdult()
    {
        return HargaDewasa;
    }
    
    public int GetPriceChild()
    {
        return HargaAnakAnak;
    }
    
    public String GetName()
    {
        return Stasiun;
    }
}
