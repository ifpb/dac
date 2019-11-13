package br.edu.ifpb.dac.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.dac.controller.FormLoginBean;

public class JSFPhaseListener implements PhaseListener {

	public void afterPhase(PhaseEvent event) {
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    	
		FormLoginBean usuarioLogado = (FormLoginBean)session.getAttribute("formLoginBean");
		String view = event.getFacesContext().getViewRoot().getViewId();
		if ((usuarioLogado == null || usuarioLogado.getUsuarioLogado() == null) && !view.equals("/login.xhtml")) {
//				((HttpServletResponse)event.getFacesContext().getExternalContext().getResponse()).sendRedirect("login.jsf");
			FacesContext context = event.getFacesContext();
			context.getApplication().getNavigationHandler().handleNavigation(context, null, "login.xhtml");
		}
	}

	public void beforePhase(PhaseEvent event) {
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
