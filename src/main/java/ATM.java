import java.sql.*;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        System.out.println("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int money = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
            Statement statement = conn.createStatement();
            String sql = "select  money from info where id = '"+s+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                money = resultSet.getInt("money");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("***欢迎使用***");
        System.out.println("当前余额：" + money);
        System.out.println("1：取钱");
        System.out.println("2: 存钱");
        System.out.println("3:算利息");
        System.out.println("请选择功能");

        int i = scanner.nextInt();

        switch (i){
            case 1:
                System.out.println("请输入金额");
                int x =scanner.nextInt();
                if(money >= x){
                    System.out.println("取出"+x);
                    money -= x;
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
                        Statement statement = conn.createStatement();
                        String sql = "update info set money =" +money +" where id = "+s;
                        int l = statement.executeUpdate(sql);
                        if(l==1){
                            System.out.println("剩余"+money);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("充值有优惠哦");
                }
                break;

            case 2:
                System.out.println("请输入金额");
                int y =scanner.nextInt();
                money += y;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
                    Statement statement = conn.createStatement();
                    String sql = "update info set money =" +money +" where id = "+s;
                    int l = statement.executeUpdate(sql);
                    if(l==1){
                        System.out.println("充值成功，余额"+money);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                System.out.println("请输入存取年份");
                int z =scanner.nextInt();
                while(z>0){
                    money *= 2;
                    z--;
                }
                System.out.println("到期余额："+ money);
        }
    }
}
