package database;

import java.io.IOException;
import java.sql.ResultSet;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class DataSearch extends SimpleTagSupport {
	private String sql;

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			ResultSet rs = DbConnection.search("SELECT "+sql+" FROM customer");
			getJspContext().getOut().print("Successful !");
			Result.setRs(rs);
		} catch (Exception e) {
			getJspContext().getOut().print("UnSuccessful !");
			e.printStackTrace();
		}
	}

}
