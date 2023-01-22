package io.github.sabilaed.vaadinoauth2.application.ui.views.login;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;

@Route("login")
@AnonymousAllowed
public class LoginView extends VerticalLayout {
    /**
     * URL that Spring uses to connect to Google services
     */
    private static final String OAUTH_URL = "/oauth2/authorization/google";

    public LoginView() {
        Anchor loginLink = new Anchor(OAUTH_URL, "Login with Google");
        Style loginLinkStyle = loginLink.getStyle();
        loginLinkStyle.set("font", "calibri");
        loginLinkStyle.set("font-size", "small");

        // Set router-ignore attribute so that Vaadin router doesn't handle the login
        // request
        loginLink.getElement().setAttribute("router-ignore", true);
        LoginForm login = new LoginForm();
        login.setAction("login");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Icon googleIcon = new Icon(VaadinIcon.GOOGLE_PLUS_SQUARE);

        horizontalLayout.add(loginLink, googleIcon);

        add(login, horizontalLayout);

        getStyle().set("padding", "200px");
        setAlignItems(FlexComponent.Alignment.CENTER);
    }
}