package week6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TaxCalculatorServlet")
public class TaxCalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        	//Sample tax calculator logic
      		//double income = 50000
      		//double tax = 0.1 * income; //10% tax

        double income = Double.parseDouble(request.getParameter("income"));
        double taxrate = Double.parseDouble(request.getParameter("taxrate"));
        
        //calculates the tax as 10%
        double tax = (taxrate/100) * income;
        

        out.println("<html><body>");
        out.println("<h1>Tax Calculator</h1>");
        out.println("<p>Income: $" + income + "</p>");
        out.println("<p>Calculated Tax: $" + tax + "</p>");
        out.println("</body></html>");
    }
}
