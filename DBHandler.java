package com.example.sdaproj;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBHandler {

    public boolean NewUser(user obj) {
        boolean validation = false;

        try {
            System.out.println("inside DB");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");


            System.out.println("inside DB");

            String un = obj.getUsername();
            String  pw = obj.getPassword();
            String mn = obj.getMemberName();

            //  Date date = Date.valueOf(obj.getdob().now());
            String dob_str = obj.getdob();


            Date date=Date.valueOf(dob_str);
            System.out.println("printing date inside db fuction ");
            System.out.println(date);

            String sql = "INSERT INTO members (member_name,username,dob,passwords) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql);

            //statement.setInt(1,7);
            statement.setString(1, mn);
            statement.setString(2, un);
            statement.setString(3,dob_str);
            // statement.setDate(4, date);
            statement.setString(4,pw);

            int flag = statement.executeUpdate();
            if(flag > 0)
            {
                System.out.println("Inserted");
                validation = true;
                return  validation;
            }
            con.close();
        } catch (Exception e){
            System.out.println("Error Connecting to database");
            //validation = false;
            return  validation;
        }
        //return false;
        return validation;
    }

    public boolean validateUser(user obj) {
        boolean validation = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            String un = obj.getUsername();
            String  pw = obj.getPassword();

            String sql = "select m_id, username,passwords from members where username=? and passwords=?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, un);
            statement.setString(2, pw);



           // System.out.println(statement);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                String _username = rs.getString("username");
                //System.out.println(rs.getString("username"));
                String _password = rs.getString("passwords");

                int m_id = rs.getInt("m_id");
                // System.out.println(_username);

                if(obj.getUsername().equals(_username) ){
                    if(obj.getPassword().equals(_password))
                    {
                        System.out.println("log In Successful");
                        validation = true;
                        System.out.println(m_id);
                        Helper memory_obj = Helper.getInstance();
                        memory_obj.setCurrentID(m_id);
                        return validation;

                    }
                    else{
                        System.out.println("password incorrect");
                        return validation;
                    }
                }
                else if (obj.getUsername().equals(_username)==false){
                    System.out.println("Username or password incorrect");
                    return validation;
                }
            }
        }
        catch (Exception e){
            System.out.println("Error Connecting to database");
        }
        return false;
    }

    public void  taskCreation(tasks obj){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            System.out.println("insidr task db");

            obj.display();

            PreparedStatement stm= con.prepareStatement("select proj_ID from project where projName = ?");
            stm.setString(1, obj.getProj_Name());
            ResultSet set = stm.executeQuery();

          //  ResultSet set = stm.executeQuery("select proj_ID from project where projName = \'"+ obj.getProj_Name()  +"\'");
            // System.out.println("after project query");

            System.out.println("ran query 1");
            set.next();
            int pi = set.getInt("proj_ID");
            System.out.println(pi);


            PreparedStatement stm2= con.prepareStatement("select m_id from members where member_name = ?");
            stm2.setString(1, obj.getMember_name());
            ResultSet set2 = stm2.executeQuery();

            System.out.println("ran query 2");
            set2.next();

            int mi=0;

          //  while (set2.next()) {
               // int p_id = set.getInt("proj_ID");
                 mi = set2.getInt("m_id");
                System.out.println(mi);
           // }


            String sql = "INSERT INTO tasks (taskName, taskDeadline, taskDesc, m_id, member_name,proj_name,proj_ID) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
           // statement.setInt(4, 2);
            statement.setString(1, obj.getTask_Name());
            statement.setString(2, obj.getTask_Deadline());
            statement.setString(3, obj.getTask_Desc());
            statement.setInt(4, 12);
            statement.setString(5, obj.getMember_name());
            statement.setString(6, obj.getProj_Name());
            statement.setInt(7, pi);

            int flag = statement.executeUpdate();
            if(flag > 0)
            {
                System.out.println("Inserted");
            }


            con.close();

        }catch (Exception e) {
            System.out.println(e);
        }
    }




/*
    public  void todo(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");



            Helper memory_obj = Helper.getInstance();
            //memory_obj.setCurrentID(3);

            Statement stm = con.createStatement();
            int id = memory_obj.getCurrentID();
            ResultSet set = stm.executeQuery("select taskName, member_name,taskDeadline from tasks where m_id=\'"+id +"\'");

            while (set.next()) {
                String tName = set.getString("taskName");
                System.out.println(tName);
                String mName = set.getString("member_name");
                System.out.println(mName);
                String dl = set.getString("taskDeadline");
                System.out.println(dl);
            }
            System.out.println("dummy");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


 */
    public void projectCreation(Project obj)//,ArrayList<Member> member_arr)
    {
        Helper memory_obj = Helper.getInstance();
        ArrayList<members> member_arr = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            String sql = "INSERT INTO project (projDeadline,projDesc, projName ) VALUES (?,?,?)";
            PreparedStatement statement1 = con.prepareStatement(sql);

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date myDate = formatter.parse(obj.getProjDeadline());
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

            System.out.println(obj.getProjName());
           // System.out.println(obj.getProj_Team());
            System.out.println(obj.getProjDeadline());
            System.out.println(obj.getProjDesc());

           // statement1.setInt(1, 2);//hard
            statement1.setDate(1, sqlDate);
            statement1.setString(2, obj.getProjDesc());
            statement1.setString(3, obj.getProjName());
            String pn = obj.getProjName();



            int flag = statement1.executeUpdate();
            if(flag > 0)
            {
                System.out.println("Inserted");
               //
            }

            Statement stm = con.createStatement();
            ResultSet set = stm.executeQuery("select proj_ID from project where projName = \'"+ pn +"\'");
            System.out.println("after project query");

            while (set.next())
            {
                int p_id = set.getInt("proj_ID");
                String sql3 = "INSERT INTO teamleader (m_id, proj_ID) VALUES (?,?)";
                System.out.println("leader query ran");
                PreparedStatement statement3 = con.prepareStatement(sql3);

                System.out.println(memory_obj.getCurrentID());
                System.out.println(p_id);

                //statement3.setInt(1,1); //auto increment

                statement3.setInt(1,memory_obj.getCurrentID());
                statement3.setInt(2, p_id);


                int flag1 = statement3.executeUpdate();
                if(flag1 > 0)
                {
                    System.out.println("leader made.");
                }
            }

            String sql2 = "Insert into team ( m_id, L_id,proj_ID ) values(?,?,?)";
            PreparedStatement statement2 = con.prepareStatement(sql2);

            System.out.println(obj.getProj_Team().size());

            for (int counter = 0 ; counter< obj.getProj_Team().size() ; counter++) {
                String memberName = obj.getProj_Team().get(counter).getMember_name();
                System.out.println(memberName);
                String projName = obj.getProjName();
                System.out.println(projName);
                String sql3 = "select m_id from members where member_name = \'" + memberName +"\' ";
                String sql4 = "select * from project where projName = \'" + projName +"\' ";

                Statement statement3 = con.createStatement();
                Statement statement4 = con.createStatement();
                int member_ID = 0, project_ID = 0;

                ResultSet set2 = statement4.executeQuery(sql4);
                while (set2.next()) {
                    project_ID = set2.getInt("proj_ID");
                }

                ResultSet set3 = statement3.executeQuery(sql3);
                while (set3.next()) {
                    member_ID = set3.getInt("m_id");
                }

                statement2.setInt(3, project_ID);
                statement2.setInt(1, member_ID);
                statement2.setInt(2, memory_obj.getCurrentID());

                int flag2 = statement2.executeUpdate();
                if (flag2 > 0) {
                    System.out.println("Team Inserted");
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
//        return member_arr;
    }




    public boolean checkMember(String nameInput)
    {
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            Statement stm = con.createStatement();
            ResultSet set = stm.executeQuery("select member_name from members ");
            while (set.next())
            {
                String mName = set.getString("member_name");
                //System.out.println(mName);
                if(mName.compareTo(nameInput) == 0)
                {
                    flag = true;
                    System.out.println("Match :)");
                }
            }
            con.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
        //System.out.println(flag);
        return flag;
    }

    public members getMember(String NameInput)
    {
        members obj = new members();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            String sql = "select m_id, member_name, dob from members where member_name = \'" + NameInput +"\' ";
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next())
            {
                int member_id = set.getInt("m_id");
                String mName = set.getString("member_name");
                //System.out.println(mName);
                java.util.Date birthDate = set.getDate("dob");

                // System.out.println(birthDate);

                obj.setMember_name(mName);
                obj.setDob("2001-10-10");
                System.out.println(obj.getMember_name());
                System.out.println(obj.getDob());
            }
            con.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println(obj.getMember_name());
        System.out.println(obj.getDob());
        return obj;
    }


    public members getMember(int IDInput)
    {
        members obj = new members();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            String sql = "select m_id, member_name, dob from members where m_id = " + IDInput +" ";
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next())
            {
                //System.out.println(":)");
                int member_id = set.getInt("m_id");
                String mName = set.getString("member_name");
                //System.out.println(member_id);
                //System.out.println(mName);
                java.util.Date birthDate = set.getDate("dob");
                //System.out.println(birthDate);

                obj.setMember_name(mName);
                obj.setDob("2001-10-10");
            }
            con.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }

        return obj;
    }


    public Project projectDetails()
    {
        Helper memory_obj = Helper.getInstance();
        Project proj= new Project();
        ArrayList<members> obj = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

           // System.out.println(memory_obj.getProj().getProjName());


            Statement stm2 = con.createStatement();
            ResultSet set2 = stm2.executeQuery("select  proj_ID from project where projName = \'" + memory_obj.getProj().getProjName() + "\' ");
            while (set2.next())
            {
                int p_id = set2.getInt("proj_ID");
                //System.out.println(p_id);

                Statement stm = con.createStatement();
                ResultSet set = stm.executeQuery("select proj_ID, projName, projDesc,ProjDeadline from project where proj_ID = \'"+ p_id+"\'");
                while (set.next())
                {
                    String pName = set.getString("projName");
                    String pDeadline = set.getString("projDeadline");
                    String pDesc = set.getString("projDesc");

                    proj.setProjName(pName);
                    proj.setProjDeadline(pDeadline);
                    proj.setProjDesc(pDesc);
                }

                String str = "select m_id from team where proj_ID = \'"+ p_id+"\'";
                Statement stm1 = con.createStatement();
                ResultSet set1 = stm1.executeQuery(str);
                while (set1.next())
                {
                    int memberID = set1.getInt("m_id");

                    obj.add(getMember(memberID));
                    proj.setProjTeam(obj);
                }

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        proj.display();
        return proj;
    }


    // For Leader Dashboard  Page
    public ArrayList<Project> showProject()
    {
        ArrayList<Project> proj_list = new ArrayList<>();
        Helper memory_obj = Helper.getInstance();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            String sql = "select proj_ID from teamleader where m_id = " + memory_obj.getCurrentID() ;

            Statement stm2 = con.createStatement();
            ResultSet set2 = stm2.executeQuery(sql);
            while (set2.next())
            {
                int proj_id = set2.getInt("proj_ID");
                Statement stm = con.createStatement();
                ResultSet set = stm.executeQuery("select proj_ID, projName, projDesc,projDeadline from project where proj_ID = "+ proj_id);
                while (set.next())
                {
                    String pName = set.getString("projName");
                    String pDeadline = set.getString("projDeadline");
                    String pDesc = set.getString("projDesc");

                    Project proj= new Project();
                    proj.setProjName(pName);
                    proj.setProjDeadline(pDeadline);
                    proj.setProjDesc(pDesc);

                    proj_list.add(proj);
                }
            }
            con.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return proj_list;
    }


    public ArrayList<String> showAnnouncement()
    {
        ArrayList<String> announcement_arr = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            String sql = "select announcement, member_name from announcement";

            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next())
            {
                String announcement_str = set.getString("announcement");
                String announcer_str = set.getString("member_name");
                String mainAnnouncement ="";

                //System.out.println(announcement_str);
                //System.out.println(announcer_str);

                mainAnnouncement += "[   ";
                mainAnnouncement += announcer_str;
                mainAnnouncement += "    ]  \" ";
                mainAnnouncement += announcement_str;
                mainAnnouncement += " \" ";

                //System.out.println(mainAnnouncement);

                announcement_arr.add(mainAnnouncement);
            }
            con.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return announcement_arr;
    }


    // For Announcement Creation Page.
    public void createAnnouncement(Announcement obj)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            String sql = "INSERT INTO announcement ( announcement, member_name ) VALUES (?,?)";
            PreparedStatement statement1 = con.prepareStatement(sql);

         //   statement1.setInt(1,4 );

            statement1.setString(1,obj.getAnnouncement_str() );
            statement1.setString(2,obj.getAnnouncerName() );

            int flag = statement1.executeUpdate();
            if(flag > 0)
            {
                System.out.println("Announcement Inserted in DB.");
            }

            con.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
