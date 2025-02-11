package week6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/taxCalculator2")
public class taxCalculator2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            // Retrieve income and tax rate from request
            double income = Double.parseDouble(request.getParameter("income"));
            double taxRate = Double.parseDouble(request.getParameter("taxrate"));
            
            // Calculate tax
            double tax = (taxRate / 100) * income;
            
            // HTML content with embedded CSS
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Tax Calculator</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f0f8ff; margin: 0; padding: 20px; }");
            out.println("h1 { text-align: center; color: #333; }");
            out.println(".form-container { width: 300px; margin: 0 auto; padding: 20px; border: 2px solid #ccc; border-radius: 8px; background-color: #ffffff; }");
            out.println("label { font-size: 16px; color: #333; }");
            out.println("input[type=\"number\"] { width: 100%; padding: 8px; margin: 10px 0; border-radius: 4px; border: 1px solid #ccc; }");
            out.println("input[type=\"submit\"] { width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }");
            out.println("input[type=\"submit\"]:hover { background-color: #45a049; }");
            out.println(".result { margin-top: 20px; text-align: center; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            // Generated HTML content showing the results
            out.println("<h1>Tax Calculator - Result</h1>");
            out.println("<div class=\"result\">");
            out.println("<p><strong>Income: </strong>$" + income + "</p>");
            out.println("<p><strong>Tax Rate: </strong>" + taxRate + "%</p>");
            out.println("<p><strong>Calculated Tax: </strong>$" + tax + "</p>");
            out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
            
        } catch (NumberFormatException e) {
            out.println("<p>Error: Invalid input. Please enter valid numeric values.</p>");
        }
    }
}