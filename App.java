import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.*;

import java.time.LocalDate;






public class App extends JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "A1208abhyudaya@";


    private Connection conn;

    private Statement stmt;

    JTextArea ta1;

    int username ;
    public App() {

        try {

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            stmt = conn.createStatement();

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS ITLibrary");
            stmt.executeUpdate("use ITLibrary");
            createTables(stmt);

        } catch (SQLException e) {

            e.printStackTrace();

        }
        JFrame HF = new JFrame();
        // Set JFrame properties

        HF.setTitle("Homepage");

        HF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HF.setSize(700, 700);

        HF.setLocationRelativeTo(null);



        // Create JPanel

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.setBounds(10,500,700,200);

        JPanel panel3 = new JPanel();

        panel3.setLayout(null);

        panel3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel3.setBounds(10,10,700,500);



        //Create label

        JLabel label = new JLabel("IT Library");
        label.setFont(new Font("Arial", Font.BOLD, 72));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBounds(180,200,500,100);
        panel3.add(label);



        // Create buttons

        JButton admin = new JButton("Admin Login");

        JButton student = new JButton("Student Login");

        JButton signup = new JButton("Student SignUp");


        

        // Add action listeners to buttons

        admin.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                

                if (showLoginDialog()) {

                        HF.dispose();

                        JFrame F1 = new JFrame();

                        // Set JFrame properties

                        F1.setTitle("IT Library");

                        F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        F1.setSize(700, 700);

                        F1.setLocationRelativeTo(null);



                        // Create JPanel

                        JPanel panel1 = new JPanel();

                        panel1.setLayout(new FlowLayout());

                        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                        panel1.setBounds(10,500,700,200);

                        JPanel panel2 = new JPanel();

                        panel2.setLayout(null);

                        panel2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                        panel2.setBounds(10,10,700,400);



                        //Create text area

                        ta1=new JTextArea();
                        
                        ta1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                        ta1.setBounds(0,0, 700,500);



                        // Create buttons

                        JButton uploadButton = new JButton("Upload Book Details");

                        JButton h_Button = new JButton("Book History");

                        JButton p_Button = new JButton("Pending Books");

                        JButton viewButton = new JButton("View Books");

                        

                        // Add action listeners to buttons

                        uploadButton.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                                uploadBooks();

                            }

                        });



                        h_Button.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                                bookHistory();

                            }

                        });



                        p_Button.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                                pending();

                            }

                        });



                        viewButton.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                                viewBooks();

                            }

                        });



                        // Add buttons to the panel

                        panel1.add(uploadButton);

                        panel1.add(h_Button);
                        panel1.add(p_Button);

                        panel1.add(viewButton);

                        panel2.add(ta1);

                        // Add panel to the JFrame

                        F1.add(panel1);

                        F1.add(panel2);



                        // Set the JFrame visible

                        F1.setVisible(true);
                        }
    

            }

        });



        student.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                 if (showLoginDialog()) {

                        HF.dispose();

                        JFrame F2 = new JFrame();

                        // Set JFrame properties

                        F2.setTitle("Student Homepage");

                        F2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        F2.setSize(700, 700);

                        F2.setLocationRelativeTo(null);



                        // Create JPanel

                        JPanel panel1 = new JPanel();

                        panel1.setLayout(new FlowLayout());

                        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                        panel1.setBounds(10,500,700,200);

                        JPanel panel2 = new JPanel();

                        panel2.setLayout(null);

                        panel2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                        panel2.setBounds(10,10,700,400);



                        //Create text area

                        ta1=new JTextArea();
                        
                        ta1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                        ta1.setBounds(0,0, 700,500);



                        // Create buttons

                        JButton borrowButton = new JButton("Borrow Book");

                        JButton browseButton = new JButton("Browse By Category");

                        JButton returnButton = new JButton("Return Book");

                        JButton viewButton = new JButton("View All Books");

                        

                        // Add action listeners to buttons

                        borrowButton.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                               borrow();

                            }

                        });



                        browseButton.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                                browseBooks();

                            }

                        });



                        returnButton.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                               returnBooks();

                            }

                        });



                        viewButton.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                               viewBooks();

                            }

                        });



                        // Add buttons to the panel

                        panel1.add(borrowButton);

                        panel1.add(browseButton);

                        panel1.add(returnButton);

                        panel1.add(viewButton);

                        panel2.add(ta1);

                        // Add panel to the JFrame

                        F2.add(panel1);

                        F2.add(panel2);



                        // Set the JFrame visible

                        F2.setVisible(true);
                        }
    

            

            }

        });

        signup.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                signUp();

            }

        });



        // Add buttons to the panel

        panel.add(admin);

        panel.add(student);

        panel.add(signup);



        // Add panel to the JFrame

        HF.add(panel);
        HF.add(panel3);
        



        // Set the JFrame visible

        HF.setVisible(true);
        
    }   



    private void createTables(Statement stmt) throws SQLException {

        // Create tables if they don't exist

        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (" +

                "regno INT PRIMARY KEY ," +

                "password VARCHAR(50))");



        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS books (" +

                "uid INT PRIMARY KEY," +

                "name VARCHAR(25)," +

                "status INT," +

                "category VARCHAR(25))" );



        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS history (" +

                "slno INT PRIMARY KEY AUTO_INCREMENT," +

                "fine INT," +

                "borrow_date DATE," +

                "return_date DATE," +

                "h_uid INT," +

                "FOREIGN KEY (h_uid) REFERENCES books(uid)," +

                "h_regno INT," +

                "FOREIGN KEY (h_regno) REFERENCES students(regno))");

    }

    private void viewBooks() {

        try {

            // Retrieve product details from 'books' table

            ResultSet productResult = stmt.executeQuery("SELECT * FROM books");



            StringBuilder productsInfo = new StringBuilder();

            productsInfo.append("UID\tName\t\t\tStatus\t\tCategory\n");

            productsInfo.append("--------------------------------------------------------------------------------------------------------------------------------------------------------\n");

            while (productResult.next()) {

                int uid = productResult.getInt("uid");

                String name = productResult.getString("name");

                int status = productResult.getInt("status");

                String category = productResult.getString("category");



                productsInfo.append(uid).append("\t");

                productsInfo.append(name).append("\t\t\t");
                if(status == 1){
                        productsInfo.append("Available\t\t");
                }
                else{
                        productsInfo.append("Not Available\t\t");
                }

                productsInfo.append(category).append("\n");
                

                productsInfo.append("--------------------------------------------------------------------------------------------------------------------------------------------------------\n");

            }



            if (productsInfo.length() > 0) {
                ta1.setText(productsInfo.toString());

            } else {

                JOptionPane.showMessageDialog(null, "No books available.");

            }

        } catch (SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Failed to view books.");

        }

    }

    private void uploadBooks() {

        JTextField uidField = new JTextField(10);

        JTextField catgField = new JTextField(10);

        JTextField b_nameField = new JTextField(10);




        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Book UID:"));

        panel.add(uidField);

        panel.add(new JLabel("Category:"));

        panel.add(catgField);

        panel.add(new JLabel("Book name:"));

        panel.add(b_nameField);



        int result = JOptionPane.showConfirmDialog(null, panel, "Upload Book Details",

                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {

            int bookUID = Integer.parseInt(uidField.getText());

            String category = catgField.getText();

            String b_name = b_nameField.getText();

            int stat = 1;

            try {

                // Insert product details into 'books' table

                PreparedStatement productStmt = conn.prepareStatement("INSERT INTO books (uid, name, status, category) VALUES (?, ?, ?, ?)");

                productStmt.setInt(1, bookUID);

                productStmt.setString(2, b_name);

                productStmt.setInt(3, stat);

                productStmt.setString(4, category);

                productStmt.executeUpdate();



                JOptionPane.showMessageDialog(null, "Book uploaded successfully!");

            } catch (SQLException e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(null, "Failed to upload Book.");

            }

        }

    }


    //sign up 
    private void signUp() {

        JTextField rnoField = new JTextField(10);

        JTextField pwdField = new JTextField(10);



        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Register Number:"));

        panel.add(rnoField);

        panel.add(new JLabel("Password:"));

        panel.add(pwdField);



        int result = JOptionPane.showConfirmDialog(null, panel, "Sign Up",

                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {

            String rno = rnoField.getText();

            String pwd = pwdField.getText();



            try {

                // Insert product details into 'students' table

                PreparedStatement productStmt = conn.prepareStatement("INSERT INTO students (regno, password) VALUES (?, ?)");

                productStmt.setString(1, rno);

                productStmt.setString(2, pwd);

                productStmt.executeUpdate();



                JOptionPane.showMessageDialog(null, "Sign Up successful!");

            } catch (SQLException e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(null, "Failed to sign up.");

            }

        }

    }

    private void browseBooks() {

        JTextField catgField = new JTextField(10);

        JPanel panel = new JPanel();

        String catgName = "";
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Category Name:"));

        panel.add(catgField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Browse by Category",

                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {

                 catgName = catgField.getText();
        }
         try {
        // Search the 'books' table for items based on category
        

            ResultSet productResult = stmt.executeQuery("SELECT * FROM books WHERE category = '" + catgName + "'");
        
            StringBuilder productsInfo = new StringBuilder();

            productsInfo.append("UID\t\tName\t\t\tStatus\t\tCategory\n");

            productsInfo.append("---------------------------------------------------------------------------------------------------------------------------------\n");

            while (productResult.next()) {

                int uid = productResult.getInt("uid");

                String name = productResult.getString("name");

                String category = productResult.getString("category");

                int status = productResult.getInt("status");

                productsInfo.append(uid).append("\t\t");

                productsInfo.append(name).append("\t\t\t");
                if(status == 1){
                        productsInfo.append("Available\t\t");
                }
                else{
                        productsInfo.append("Not Available\t\t");
                }

                productsInfo.append(category).append("\n");
                

                productsInfo.append("---------------------------------------------------------------------------------------------------------------------------------\n");

            }

            

            if (productsInfo.length() > 0) {
                ta1.setText(productsInfo.toString());

            } else {

                JOptionPane.showMessageDialog(null, "No  books in this category.");

            }
        
        }

        catch (SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Failed to find books.");

        }
     

    }



    private void borrow(){
        JTextField b_idField = new JTextField(10);

        JPanel panel = new JPanel();

        int b_id = 0;
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Book UID:"));

        panel.add(b_idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter book UID",

                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {

                 b_id = Integer.parseInt(b_idField.getText());
        }
        
         try {
            // Update the 'books' table for availability and 'history' table for dates
            ResultSet productResult = stmt.executeQuery("SELECT status FROM books WHERE uid = " + b_id);
            productResult.next();
            int status = productResult.getInt("status");
            if(status == 1){
                PreparedStatement productStmt = conn.prepareStatement("UPDATE books SET status = 0 WHERE uid = " + b_id);
                productStmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Borrowed successfully!");

                try {

                // Insert history details into 'history' table
                 
                Date date = Date.valueOf(LocalDate.now());
                PreparedStatement productStmt1 = conn.prepareStatement("INSERT INTO history (fine, borrow_date, return_date, h_uid, h_regno) VALUES (?, ?, ?, ?, ?)");

                productStmt1.setInt(1, 0);

                productStmt1.setDate(2, date);

                productStmt1.setString(3, null);

                productStmt1.setInt(4, b_id);

                productStmt1.setInt(5, username);

                productStmt1.executeUpdate();



                JOptionPane.showMessageDialog(null, "Book history updated successfully!");

            } catch (SQLException e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(null, "Failed to update Book history.");

            }
            }
            else{
                JOptionPane.showMessageDialog(null, "Book not available.");
            }
            
            
        }

        catch (SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Failed to borrow books.");

        }

         
    }

    private void returnBooks(){
        JTextField b_idField = new JTextField(10);

        JPanel panel = new JPanel();

        int b_id = 0;
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Book UID:"));

        panel.add(b_idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter book UID",

                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {

                 b_id = Integer.parseInt(b_idField.getText());
        }
        
         try {
            // Update the 'books' table for availability and 'history' table for dates
            ResultSet productResult = stmt.executeQuery("SELECT status FROM books WHERE uid = " + b_id);
            productResult.next();
            int status = productResult.getInt("status");
            if(status == 0){
                PreparedStatement productStmt = conn.prepareStatement("UPDATE books SET status = 1 WHERE uid = " + b_id);
                productStmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Returned successfully!");

                 try {

                // Insert history details into 'history' table
                 
                //Date date = Date.valueOf(LocalDate.now());
                PreparedStatement productStmt1 = conn.prepareStatement("UPDATE history SET return_date =CURRENT_TIMESTAMP WHERE h_uid = " + b_id);

                productStmt1.executeUpdate();



                JOptionPane.showMessageDialog(null, "Book history updated successfully!");

            } catch (SQLException e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(null, "Failed to update book history.");

            }
            }
            else{
                JOptionPane.showMessageDialog(null, "Book already returned.");
            }
            
            
        }

        catch (SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Failed to return books.");

        }

        
    }

    private void pending(){
    try{
     ResultSet productResult = stmt.executeQuery("SELECT * FROM history WHERE return_date IS NULL" );



            StringBuilder productsInfo = new StringBuilder();

            productsInfo.append("Sl no\tFine\tBorrowed Date\t\tReturn Date\tUID\tReg No\n");

            productsInfo.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

            while (productResult.next()) {

                int _slno = productResult.getInt("slno");
                int _fine = productResult.getInt("fine");
                Date _bdate = productResult.getDate("borrow_date");
                Date _rdate = productResult.getDate("return_date");
                int _huid = productResult.getInt("h_uid");
                int _hreg = productResult.getInt("h_regno");

                //calculate
                Date nowdate = Date.valueOf(LocalDate.now()); 
                long daydiff=(_bdate.getTime()-nowdate.getTime())/86400000;
                int dd=(int)daydiff;
                if(dd>14)
                {
                    _fine=(dd-14)*10;
                    PreparedStatement productStmt = conn.prepareStatement("UPDATE history SET fine = ? WHERE h_uid = ?");
                    productStmt.setInt(1,_fine);
                    productStmt.setInt(2,_huid);
                    productStmt.executeUpdate();
                }



                productsInfo.append(_slno).append("\t");
                productsInfo.append(_fine).append("\t");
                productsInfo.append(_bdate).append("\t\t");
                productsInfo.append(_rdate).append("\t");
                productsInfo.append(_huid).append("\t");
                productsInfo.append(_hreg).append("\n");

                productsInfo.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

            }



            if (productsInfo.length() > 0) {
                ta1.setText(productsInfo.toString());

            } else {

                JOptionPane.showMessageDialog(null, "Nothing is pending");

            }

        } catch (SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Failed to find pending books.");

        }

    }

    private void bookHistory() {

        try {

            // Retrieve book history from 'history' table

                JTextField search_idField = new JTextField(10);

                JPanel panel = new JPanel();

                panel.setLayout(new GridLayout(3, 2));

                panel.add(new JLabel("Book UID:"));

                panel.add(search_idField);

                String b_id = "";

                int result = JOptionPane.showConfirmDialog(null, panel, "Book History",

                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {

                    b_id = search_idField.getText();

                }

            ResultSet productResult = stmt.executeQuery("SELECT * FROM history WHERE h_uid = " + b_id);



            StringBuilder productsInfo = new StringBuilder();

            productsInfo.append("Sl no\tFine\tBorrowed Date\tReturn Date\tUID\tReg No\n");

            productsInfo.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

            while (productResult.next()) {

                int _slno = productResult.getInt("slno");
                int _fine = productResult.getInt("fine");
                Date _bdate = productResult.getDate("borrow_date");
                Date _rdate = productResult.getDate("return_date");
                int _huid = productResult.getInt("h_uid");
                int _hreg = productResult.getInt("h_regno");



                productsInfo.append(_slno).append("\t");
                productsInfo.append(_fine).append("\t");
                productsInfo.append(_bdate).append("\t");
                productsInfo.append(_rdate).append("\t");
                productsInfo.append(_huid).append("\t");
                productsInfo.append(_hreg).append("\n");

                productsInfo.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

            }



            if (productsInfo.length() > 0) {
                ta1.setText(productsInfo.toString());

            } else {

                JOptionPane.showMessageDialog(null, "No such book");

            }

        } catch (SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Failed to find book history.");

        }

    }

     private boolean showLoginDialog() {
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("UserID:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            username = Integer.parseInt(usernameField.getText());
            String password = new String(passwordField.getPassword());

            // Perform login authentication
            return authenticateUser(username, password);
        }

        return false;
    }

    private boolean authenticateUser(int username, String password) {
        // authentication 
        // Returns true if the username and password are valid, false otherwise
        try {
            //for admin login
            if(username == 98765 && password.equals("admin")){
                return true;
            }
            
            //for student login
            ResultSet productResult = stmt.executeQuery("SELECT * FROM students WHERE regno = " + username);
            if(productResult.next() == true){
                    String pass = productResult.getString("password");
                if(pass.equals(password)){
                    return true;
                }
                else{
                JOptionPane.showMessageDialog(null, "Incorrect password.");
                    return false;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid credentials.");
                return false;
            }
            
            
        }

        catch (SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Failed to login.");
            return false;
        }
        
    }


    public static void main (String[] args){

        new App();

    }

}