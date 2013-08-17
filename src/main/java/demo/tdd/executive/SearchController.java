package demo.tdd.executive;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.Tomcat;

@SuppressWarnings("serial")
@WebServlet(name = "MyServlet", urlPatterns = { "/search/memory" })
public class SearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream out = resp.getOutputStream();

		Display display = new Display();
		Catalog catalog = new Catalog(new HashMap<String, String>() {
			{
				put("1234", "100");
				put("123", "200");
			}
		});
		Sale sale = new Sale(display, catalog);
		sale.seachByBarcode(req.getParameter("barcode"));

		out.write(("<h1>" + display.getText() + "</h1>").getBytes());
		out.flush();
		out.close();
	}
}
