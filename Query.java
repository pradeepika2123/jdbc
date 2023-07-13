import java.sql.*;
import java.util.Scanner;

public class Query
{
    public static void selectQuery(String name) throws ClassNotFoundException, SQLException
    {
        String url="jdbc:mysql://localhost:3306/bank";
        String username="root";
        String password="root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver classLoading");
        Connection con= DriverManager.getConnection(url,username,password);

        PreparedStatement ps=con.prepareStatement("select c_amount from customers where c_name=?;");
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();
        //while(rs.next())
        //{
           // System.out.println(rs.getInt("c_amount"));
       // }


//        Statement s=con.createStatement();
//        ResultSet rs=s.executeQuery("select * from customers ");

        while(rs.next())
       {            System.out.println(rs.getInt("c_accNo")+" "+rs.getInt("c_pin")+" "+
                    rs.getString("c_name")+" "+rs.getInt("c_amount")+" "+
                    rs.getString("c_pan")+" "+rs.getInt("c_adhar")+" "+
                    rs.getString("c_phone")+" "+rs.getString("c_address" )+" "+rs.getInt("branch_id")+" "+
                    rs.getString("acc_type"));
        }
    }

    public static void insertQuery(int c_accNo,int c_pin,String c_name,int c_amount,String c_pan,int c_adhar,String c_phone,String c_address,int branch_id,String acc_type) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver classLoading");
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = con.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, c_accNo);
        ps.setInt(2, c_pin);
        ps.setString(3, c_name);
        ps.setInt(4, c_amount);
        ps.setString(5, c_pan);
        ps.setInt(6, c_adhar);
        ps.setString(7, c_phone);
        ps.setString(8, c_address);
        ps.setInt(9, branch_id);
        ps.setString(10,acc_type);


        int row = ps.executeUpdate();
        if (row > 0)
        {
            System.out.println("values are inserted");
        } else
        {
            System.out.println("values are not inserted");
        }
    }

    public static void updateCustomers(int id,int pin,String phone) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver classLoading");
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = con.prepareStatement("update customers set c_pin=?,c_phone=? where branch_id=?;");
        ps.setInt(1,pin);
        ps.setString(2,phone);
        ps.setInt(3,id);
        int row=ps.executeUpdate();
        if(row>0)
        {
            System.out.println("values are updated successfully");
        }
        else
        {
            System.out.println("values are not updates successfully");
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //select
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the name");
        String name=sc.next();
        System.out.println("balance amount");

        selectQuery(name);




        //insert

        //Scanner sc=new Scanner(System.in);

        System.out.println("enter the c_accNo");
        int c_accNo=sc.nextInt();

        System.out.println("enter the c_pin");
        int c_pin=sc.nextInt();

        System.out.println("enter the c_name");
        String c_name=sc.next();

        System.out.println("enter the acc_balance");
        int c_amount=sc.nextInt();

        System.out.println("enter the acc_type");
        String acc_type=sc.next();

        System.out.println("enter the c_panNo");
        String c_pan=sc.next();

        System.out.println("enter the c_adhar");
        int c_adhar=sc.nextInt();

        System.out.println("enter the c_contact");
        String c_phone=sc.next();

        System.out.println("enter the c_address");
        String c_address=sc.next();

        System.out.println("enter the b_id");
        int branch_id=sc.nextInt();

        insertQuery(c_accNo, c_pin,c_name,c_amount,c_pan,c_adhar,c_phone,c_address,branch_id,acc_type);

        //update

        //Scanner sc=new Scanner(System.in);

       // System.out.println("enter the id");
        // String id=sc.next();

        //System.out.println("enter the pin number");
        //int pin=sc.nextInt();

        //System.out.println("enter the phone number");
        //String phone=sc.next();

        //updateCustomers(id,pin,phone);

    }

}