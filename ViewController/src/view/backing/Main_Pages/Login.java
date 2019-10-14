package view.backing.Main_Pages;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.util.Map;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;


import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichLink;
import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.jdbc.driver.OracleDriver;

public class Login {

    // generating static variables to use in different scopes
    private static String role_master_id;
    private static String user_master_id;
    private static String member_reg_id;
    private static String sessUName;


    /////////////////////////////////////////

    private RichInputText it1;
    private RichInputText it2;
    private RichLink l1;
    private RichPanelFormLayout panel_form_layout;
    private RichButton gen;
    private RichSpacer s7;


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }
     

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }
    

    public void setL1(RichLink l1) {
        this.l1 = l1;
    }

    public RichLink getL1() {
        return l1;
    }

    ///////////////////////////////////////////

    public String showMessage(String msgs) {
        String messageText = msgs;
        FacesMessage fm = new FacesMessage(messageText);
        /**
             * set the type of the message.
             * Valid types: error, fatal,info,warning
             */
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
        return null;
    }

    // creating generic database connection
    public static Connection getConnection() throws SQLException {
        String username = "emfp";
        String password = "emfp";
        String thinConn = "jdbc:oracle:thin:@192.168.1.3:1521:orcl";
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection(thinConn, username, password);
        conn.setAutoCommit(false);
        return conn;
    }

    // session value storing function
    public static void storeOnSession(String key, Object object) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        sessionState.put(key, object);
    }
    
    // session value getting function
    public static String getFromSession(String vari) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        return (String) sessionState.get(vari);
    }

    //user logging in
    public String login_action() {
        // Add event code here...
        //SETTING VALUE PROGRAMMATICALLY IN PASSWORD FIELD,,,,ONLY TESTING
        //  //          it2.setValue("bla bla bla");
        String username = this.getIt1().getValue().toString();
        String password = this.getIt2().getValue().toString();

        sessUName = username;
        storeOnSession("sessUName", sessUName);
        System.out.println("value for session..............." + sessUName);

        System.out.println(".......................................................................");
        System.out.println(".......................................................................");
        System.out.println("Entered username is : " + username + "....and password is : " + password);
        System.out.println(".......................................................................");
        System.out.println(".......................................................................");


        Connection conn;

        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset =
                stmt.executeQuery("SELECT * FROM mmp_user_master where mmp_user_master_name = '" + username +
                                  "' and mmp_user_master_pwd = '" + password + "'");

            if (rset.next()) {
                //                conn.close();
                //getting data against column from table
                role_master_id = (rset.getString("mmp_role_master_id")).toString();
                user_master_id = (rset.getString("mmp_user_master_id")).toString();
                member_reg_id = (rset.getString("member_reg_id")).toString();
                //Storing value in session username from input text field and role_master_id from DB

                System.out.println(".........MMP_User Name stored in session is :..." + username + "...");
                //System.out.println(".........MMP_User Password stored in session is :..." + password + "...");
                System.out.println(".........MMP_User Role stored in session is :..." + role_master_id + "...");
                System.out.println(".........MMP_User Master ID stored in session is :..." + user_master_id + "...");
                System.out.println(".........Member Registration ID stored in session is :..." + member_reg_id + "...");

                //Redirecting to home page after successfull authentication
                //System.out.println("....... here we go /// you are redirecting now to DASHBOARD ......");
                //                return "good";
//                get_module_view_rights();
                                
                storeOnSession("sessUID", role_master_id);                
                storeOnSession("sessMemID", member_reg_id);
                
                conn.close();
                return "/faces/Main_Pages/Dashboard.jsf?faces-redirect=true";
                //return "cool";
            } else {
                showMessage("Wrong Login Credentials");
                conn.close();
                System.out.println("........wrong login credentials........");
                //return "/faces/Main_Pages/Login.jsf?faces-redirect=true";
                return "false";
            }


        } catch (SQLException e) {
            System.out.println(e);
        }

        return role_master_id;
        //        return "/faces/Main_Pages/Dashboard.jsf?faces-redirect=true";
        //        return "good";
    }

    //Logout > session cleared and session variable cleared
    public String logout_action() {
        System.out.println("logout called");
        sessUName = "";
        role_master_id = "";
        storeOnSession("sessUName", "");
        storeOnSession("sessUID", "");
        //        return "good";
        return "/faces/Main_Pages/Login.jsf?faces-redirect=true";
    }

//    //page load all functions
//    public String checkSession(String pageName) {
//
//        //                //String checkRole = login_action();
//        //        System.out.println(checkRole);
//        page_name = pageName;
//        //Gettting user role master name by role master id
//        String Role_Name = get_user_role_master_name();
//        System.out.println("Role Name is : " + Role_Name);
//
//        //Gettting page id by page name
//        //String Page_Id = get_page_id();
//        //System.out.println("Page Id is : "+ Page_Id);
//
//        //Gettting role detail id by page id and role master id
//        String role_detail_pages_id = get_role_detail_pages_id();
//        System.out.println("Role Detail Id is : " + role_detail_pages_id);
//        System.out.println(role_master_id + "....Role Master ID");
//        System.out.println(page_name + "..........Page Name");
//
//        return "good";
//
//    }
//
//
//    //pge for module load all functions
//    public String checkmoduleSession(String moduleName) {
//
//        module_name = moduleName;
//
//        //                  //Gettting page id by page name
//        String Module_Id = get_module_menu_id();
//        System.out.println("Module Id is : " + Module_Id);
//
//        return module_view_rights;
//        //         return "Y";
//
//    }
//
//
//    //Gettting user role master name by role master id
//    public String get_user_role_master_name() {
//
//        Connection con_role;
//
//        try {
//            con_role = getConnection();
//            Statement stmt = con_role.createStatement();
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM MMP_role_master where MMP_role_master_id = '" + role_master_id + "'");
//
//            if (rset.next()) {
//
//                role_master_name = (rset.getString("role_master_name")).toString();
//
//                System.out.println(".........get_user_role_master_name.........function called");
//                System.out.println(".........Role Master ID is :..." + role_master_id + "...");
//                System.out.println(".........Role Master NAME is :..." + role_master_name + "...");
//
//                con_role.close();
//
//                return role_master_name;
//            } else {
//                System.out.println("........NO ROLE FOUND........");
//            }
//            con_role.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return role_master_name;
//        //        return "Super Admin";
//    }
//
//
//    //Gettting module id by module name
//    public String get_module_menu_id() {
//
//        Connection con_mod;
//
//        try {
//            con_mod = getConnection();
//            Statement stmt = con_mod.createStatement();
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM MMP_module_menu where MMP_module_menu_name = '" + module_name + "'");
//
//            if (rset.next()) {
//
//                module_menu_id = (rset.getString("module_menu_id")).toString();
//
//                System.out.println(".........get_module_menu_id.........function called");
//                System.out.println(".........Module ID is :..." + module_menu_id + "...");
//                System.out.println(".........Module NAME is :..." + module_name + "...");
//
//                con_mod.close();
//                get_role_detail_module_id();
//                return module_menu_id;
//
//            } else {
//                System.out.println("........NO Module FOUND........");
//            }
//            con_mod.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return module_menu_id;
//        //        return "1";
//    }
//
//    //Gettting role detail module id by module menu id and role master id
//    public String get_role_detail_module_id() {
//
//        Connection con_det;
//
//        try {
//            con_det = getConnection();
//            Statement stmt = con_det.createStatement();
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM tbl_role_detail_modules where module_menu_id = '" + module_menu_id +
//                                  "' and role_master_id = '" + role_master_id + "'");
//
//            if (rset.next()) {
//
//                role_detail_modules_id = (rset.getString("role_detail_modules_id")).toString();
//
//                System.out.println(".........get_role_detail_module_id.........function called");
//                System.out.println(".........Module Menu ID is :..." + module_menu_id + "...");
//                System.out.println(".........Role Master ID is :..." + role_master_id + "...");
//                System.out.println(".........Role Detail Module ID is :..." + role_detail_modules_id + "...");
//                con_det.close();
//
//                get_module_view_rights();
//                return role_detail_modules_id;
//            } else {
//                System.out.println("........NO ROLE DETAIL FOUND........");
//            }
//            con_det.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return role_detail_modules_id;
//        //        return "1";
//    }
//
//
//    //Gettting module view rights by role detail module id
//    public String get_module_view_rights() {
//
//        Connection con_mod_right;
//
//        try {
//            con_mod_right = getConnection();
//            Statement stmt = con_mod_right.createStatement();
//            //            ResultSet rset =
//            //                stmt.executeQuery("SELECT * FROM tbl_role_detail_modules where role_detail_modules_id = '" +
//            //                                  role_detail_modules_id + "'");
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM tbl_role_detail_modules where role_master_id = '" + role_master_id +
//                                  "'");
//            int counter = 0;
//
//            while (rset.next()) {
//                
//                counter++;
//                
//                String RDMID = rset.getString("Role_Detail_Modules_ID");
//                String RMID = rset.getString("Role_Master_ID");
//                String MMID = rset.getString("Module_Menu_ID");
//                String R_View = rset.getString("R_View");
//
//                System.out.println("Role_Detail_Modules_ID : " + RDMID);
//                System.out.println("Role_Master_ID : " + RMID);
//                System.out.println("Module_Menu_ID : " + MMID);
//                System.out.println("R_View : " + R_View);
//
//            }
//               System.out.println("Number of records in ResultSet: " + counter);
//
//
//            ////            int counter = 0;
//            ////            while(rset.next())
//            ////            {
//            ////              counter++;
//            ////            }
//            ////            System.out.println("Number of records in ResultSet: " + counter);
//            //            if (rset.next()) {
//            //
//            //                module_view_rights = (rset.getString("r_view")).toString();
//            //                counter++;
//            //
//            //                System.out.println(".........get_page_view_rights.........function called");
//            //                System.out.println(".........View Rights for Module Menu ID : " + role_detail_modules_id +
//            //                                   " against Role Master ID : " + role_master_id);
//            //                System.out.println(".........Your Module view rights is : " + module_view_rights);
//            //
//            //                con_mod_right.close();
//            //                return module_view_rights;
//            //            }
//            //            else {
//            //                System.out.println("........NO RIGHTS DATA FOUND........");
//            //            }
//
//
//            con_mod_right.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//
//        return module_view_rights;
//        //        return "Y";
//    }
//
//
//    //Gettting page id by page name
//    public String get_page_id() {
//
//        Connection con_pg;
//
//        try {
//            con_pg = getConnection();
//            Statement stmt = con_pg.createStatement();
//            ResultSet rset = stmt.executeQuery("SELECT * FROM tbl_pages where pages_name = '" + page_name + "'");
//
//            if (rset.next()) {
//
//                pages_id = (rset.getString("pages_id")).toString();
//
//                System.out.println(".........get_page_id.........function called");
//                System.out.println(".........Page ID is :..." + pages_id + "...");
//                System.out.println(".........Page NAME is :..." + page_name + "...");
//
//                con_pg.close();
//                return pages_id;
//
//            } else {
//                System.out.println("........NO PAGE FOUND........");
//            }
//            con_pg.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return pages_id;
//        //        return "1";
//    }
//
//
//    //Gettting role detail id by page id and role master id
//    public String get_role_detail_pages_id() {
//
//        Connection con_det;
//
//        try {
//            con_det = getConnection();
//            Statement stmt = con_det.createStatement();
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM tbl_role_detail_pages where pages_id = '" + pages_id +
//                                  "' and role_master_id = '" + role_master_id + "'");
//
//            if (rset.next()) {
//
//                role_detail_pages_id = (rset.getString("role_detail_pages_id")).toString();
//
//                System.out.println(".........get_role_detail_pages_id.........function called");
//                System.out.println(".........Page ID is :..." + pages_id + "...");
//                System.out.println(".........Role Master ID is :..." + role_master_id + "...");
//                System.out.println(".........Role Detail ID is :..." + role_detail_pages_id + "...");
//                con_det.close();
//
//                return role_detail_pages_id;
//            } else {
//                System.out.println("........NO ROLE DETAIL FOUND........");
//            }
//            con_det.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return role_detail_pages_id;
//        //        return "1";
//    }
//
//
//    //Gettting page view rights by role detail id
//    public String get_page_view_rights(String getPageName) {
//
//        page_name = getPageName;
//        get_page_id();
//        get_role_detail_pages_id();
//
//        Connection con_right;
//
//        try {
//            con_right = getConnection();
//            Statement stmt = con_right.createStatement();
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM tbl_role_detail_pages where role_detail_pages_id = '" +
//                                  role_detail_pages_id + "'");
//
//            if (rset.next()) {
//
//                view_rights = (rset.getString("r_view")).toString();
//
//
//                System.out.println(".........get_page_view_rights.........function called");
//                System.out.println(".........View Rights for Page ID : " + pages_id + " against Role Master ID : " +
//                                   role_master_id);
//                System.out.println(".........Your Page view rights is : " + view_rights);
//
//                con_right.close();
//
//                return view_rights;
//            } else {
//                System.out.println("........NO RIGHTS DATA FOUND........");
//            }
//            con_right.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return view_rights;
//        //        return "Y";
//    }
//
//    //Gettting add button view rights by role detail id
//    public String get_add_view_rights() {
//
//        Connection con_add;
//
//        try {
//            con_add = getConnection();
//            Statement stmt = con_add.createStatement();
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM tbl_role_detail_pages where role_detail_pages_id = '" +
//                                  role_detail_pages_id + "'");
//
//            if (rset.next()) {
//
//                add_rights = (rset.getString("r_add")).toString();
//
//                System.out.println(".........get_add_view_rights.........function called");
//                System.out.println(".........Add View Rights for Page ID : " + pages_id + " against Role Master ID : " +
//                                   role_master_id);
//                System.out.println(".........Your Add rights is : " + add_rights);
//
//                con_add.close();
//                return add_rights;
//            } else {
//                System.out.println("........NO RIGHTS DATA FOUND........");
//            }
//            con_add.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return add_rights;
//        //        return "Y";
//    }
//
//    //Gettting edit button view rights by role detail id
//    public String get_edit_view_rights() {
//
//        Connection con_edit;
//
//        try {
//            con_edit = getConnection();
//            Statement stmt = con_edit.createStatement();
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM tbl_role_detail_pages where role_detail_pages_id = '" +
//                                  role_detail_pages_id + "'");
//
//            if (rset.next()) {
//
//                edit_rights = (rset.getString("r_edit")).toString();
//
//                System.out.println(".........get_edit_view_rights.........function called");
//                System.out.println(".........Add View Rights for Page ID : " + pages_id + " against Role Master ID : " +
//                                   role_master_id);
//                System.out.println(".........Your Edit rights is : " + edit_rights);
//
//                con_edit.close();
//                return edit_rights;
//            } else {
//                System.out.println("........NO RIGHTS DATA FOUND........");
//            }
//            con_edit.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return edit_rights;
//        //        return "Y";
//    }
//
//    //Gettting delete button view rights by role detail id
//    public String get_delete_view_rights() {
//
//        Connection con_del;
//
//        try {
//            con_del = getConnection();
//            Statement stmt = con_del.createStatement();
//            ResultSet rset =
//                stmt.executeQuery("SELECT * FROM tbl_role_detail_pages where role_detail_pages_id = '" +
//                                  role_detail_pages_id + "'");
//
//            if (rset.next()) {
//
//                delete_rights = (rset.getString("r_delete")).toString();
//
//                System.out.println(".........get_delete_view_rights.........function called");
//                System.out.println(".........Add View Rights for Page ID : " + pages_id + " against Role Master ID : " +
//                                   role_master_id);
//                System.out.println(".........Your Delete rights is : " + delete_rights);
//
//                con_del.close();
//                return delete_rights;
//            } else {
//                System.out.println("........NO RIGHTS DATA FOUND........");
//            }
//            con_del.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return delete_rights;
//        //        return "Y";
//    }
//
//
//    //Gettting save button view rights > hard coded if add,edit or delete privilige found
//    public String get_save_view_rights() {
//
//        if (add_rights.equals("Y")) {
//            save_rights = "Y";
//            System.out.println("Save right due to add is : Y");
//        } else if (edit_rights.equals("Y")) {
//            save_rights = "Y";
//            System.out.println("Save right due to edit is : Y");
//        } else if (delete_rights.equals("Y")) {
//            save_rights = "Y";
//            System.out.println("Save right due to delete is : Y");
//        } else {
//            save_rights = "N";
//            System.out.println("Save right due to nothing is : N");
//        }
//
//        return save_rights;
//        //        return "Y";
//
//    }
//
//
////    public String main() {
////        int[][] myNumbers = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
////        for (int i = 0; i < myNumbers.length; ++i) {
////            for (int j = 0; j < myNumbers[i].length; ++j) {
////                System.out.println(myNumbers[i][j]);
////            }
////        }
////        return "good";
////    }
////
////    public String getArray() {
////        int twoDim[][] = new int[2][3];
////        twoDim[0][0] = 1;
////        twoDim[0][1] = 2;
////        twoDim[0][2] = 3;
////        twoDim[1][0] = 4;
////        twoDim[1][1] = 5;
////        twoDim[1][2] = 6;
////        System.out.println(twoDim[0][0] + " " + twoDim[0][1] + " " + twoDim[0][2]);
////        System.out.println(twoDim[1][0] + " " + twoDim[1][1] + " " + twoDim[1][2]);
////        return "good";
////    }
//
//    public String sess_module_id(String getModID) {
//        // Add event code here...
//        System.out.println("store module id now man" + getModID);
//        storeOnSession("sessModuleID", getModID);
//        
//        return null;
//    }

}
