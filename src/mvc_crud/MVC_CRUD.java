
package mvc_crud;

import controlador.ControladorPersona;
import javax.swing.JOptionPane;
import modelo.ConsultaPersona;
import modelo.Persona;
import vista.VistaPersona;


public class MVC_CRUD {

    
    public static void main(String[] args) {
        VistaPersona vista = new VistaPersona();
        Persona persona = new Persona();
        ConsultaPersona modelo = new ConsultaPersona();
        ControladorPersona controlador = new ControladorPersona(vista, persona, modelo);
        
        controlador.iniciar();
        vista.setVisible(true);    
        
    }
    
}
