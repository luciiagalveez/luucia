package ufv.dis.luciia;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ufv.dis.luciia.Inventario;
import ufv.dis.luciia.Producto;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	Inventario inventario = new Inventario();
    	
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField nombre = new TextField();
        nombre.setCaption("Type your name here:");
        
        final TextField cat = new TextField();
        cat.setCaption("Type your category here:");
        
        final TextField precio = new TextField();
        precio.setCaption("Type your price here:");
        
        final TextField EAN = new TextField();
        EAN.setCaption("Type your ean13 here:");
        


        Button button = new Button("Click Me");
        button.addClickListener(e -> {

        	Producto p = new Producto(nombre.getValue(), cat.getValue(), Float.parseFloat(precio.getValue()), EAN.getValue());
        	inventario.addProducto(p);
        	
        });
        
        layout.addComponents(nombre, button);
        layout.addComponents(cat, button);
        layout.addComponents(precio, button);
        layout.addComponents(EAN, button);
        
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
