package javabeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import connpackage.BookCrudOpeation;

@ManagedBean
@SessionScoped
public class ConnectionStatusBean {
	private String status;

	public ConnectionStatusBean() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
