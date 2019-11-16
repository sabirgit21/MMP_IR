package view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ImageServlet", urlPatterns = { "/imageservlet" })
public class ImageServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // File name is being passed by parameter on a servlet
        String path = "D:\\CloudMMP\\ViewController\\src\\META-INF\\resources\\user_data\\farmerImages\\";
        String var0 = "";
        try {
            if(!request.getParameter("imageNameParam").isEmpty()){
                var0 = (request.getParameter("imageNameParam"));
        //                   var0 = "74198car.png";
            }else{
                var0 = "no_image.jpg";
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Image servlet called '''''''''''''''''''''''''");
        //System.out.println(System.getProperty("user.dir"));
        //System.out.println(Paths.get("").toAbsolutePath().toString());
        System.out.println(path+var0);
        response.setContentType(CONTENT_TYPE);
            OutputStream os = response.getOutputStream();
            InputStream inputStream = null;
            try {
                var0.replaceAll("\\s+","");
            File outputFile = new File(path,var0);
            inputStream = new FileInputStream(outputFile);
            BufferedInputStream in = new BufferedInputStream(inputStream);
            int b;
            byte[] buffer = new byte[10240];
            while ((b = in.read(buffer, 0, 10240)) != -1) {
            os.write(buffer, 0, b);
            }

            } catch (Exception e) {

            System.out.println(e);
            }
            finally {
            if (os != null) {
            os.close();
            }
            if (inputStream != null) {
            inputStream.close();
            }

            }
    }
}
