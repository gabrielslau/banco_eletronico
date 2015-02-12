package pb.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public abstract class AppMB implements Serializable {

	private static final long serialVersionUID = 1192504063426767776L;
	private ExternalContext externalContext;

	public AppMB() {
		super();
	}

	/**
	 * Redireciona para outra página da aplicação
	 * @param page Nome da página a redirecionar (a extensão .xhtml é atribuida automaticamente)
	 */
	public void redirect(String page, String extension) {
		if(extension.isEmpty()){
			extension = ".jsf";
		}
		externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect(externalContext.getRequestContextPath() + "/" + page + extension);
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

	/**
	 * Redireciona para outra página da aplicação
	 * @param page Nome da página a redirecionar (a extensão .xhtml é atribuida automaticamente)
	 */
	public void redirect(String page) {
		this.redirect(page, "");
	}
}
