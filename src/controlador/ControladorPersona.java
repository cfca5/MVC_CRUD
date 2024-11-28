
package controlador;

import com.mysql.cj.x.protobuf.MysqlxConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConsultaPersona;
import modelo.Persona;
import vista.VistaPersona;
import java.sql.*;
import javax.swing.JOptionPane;


public class ControladorPersona implements ActionListener {
    private VistaPersona vista;
    private Persona persona;
    private ConsultaPersona modelo;

    public ControladorPersona(VistaPersona vista, Persona persona, ConsultaPersona modelo) {
        this.vista = vista;
        this.persona = persona;
        this.modelo = modelo;
        vista.botonInsertar.addActionListener(this);
        vista.botonLimpiar.addActionListener(this);
        vista.botonSalir.addActionListener(this);
        vista.botonBuscar.addActionListener(this);
        vista.botonModificar.addActionListener(this);
        vista.botonEliminar.addActionListener(this);
        
    }
    
    public void iniciar(){
        vista.setTitle("CRUD-MVC");
        vista.setLocationRelativeTo(null);
        vista.cajaID.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.botonInsertar) {
            persona.setClave(vista.cajaClave.getText());
            persona.setNombre(vista.cajaNombre.getText());
            persona.setDomicilio(vista.cajaDomicilio.getText());
            persona.setCelular(vista.cajaCelular.getText());
            persona.setCorreo(vista.cajaCorreo.getText());
            persona.setFecha_nacimiento(Date.valueOf(vista.cajaFechaNacimiento.getText()));
            persona.setGenero((String) vista.comboGenero.getSelectedItem());
            
            if (modelo.insertar(persona)) {
                JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al insertar el registro", "Gestor de Consultas", 3);
                limpiarCajas();
            }
            
        }
        else if (ae.getSource() == vista.botonLimpiar) {
            limpiarCajas();
            JOptionPane.showMessageDialog(null, "Texto borrado");
        }
        else if (ae.getSource() == vista.botonSalir) {
            System.exit(0);
        }
        else if (ae.getSource() == vista.botonBuscar) {
            persona.setClave(vista.cajaBuscar.getText());
            
            if (modelo.buscar(persona)) {
                vista.cajaID.setText(String.valueOf(persona.getIdPersona()));
                vista.cajaClave.setText(persona.getClave());
                vista.cajaNombre.setText(persona.getNombre());
                vista.cajaDomicilio.setText(persona.getDomicilio());
                vista.cajaCelular.setText(persona.getCelular());
                vista.cajaCorreo.setText(persona.getCorreo());
                vista.cajaFechaNacimiento.setText(persona.getFecha_nacimiento().toString());
                vista.comboGenero.setSelectedItem(persona.getGenero());
            }
            else{
                JOptionPane.showMessageDialog(null, "No existe una persona con esa clave");
                limpiarCajas();
            }
        }
        else if (ae.getSource() == vista.botonModificar) {
            persona.setIdPersona(Integer.parseInt(vista.cajaID.getText()));
            persona.setClave(vista.cajaClave.getText());
            persona.setNombre(vista.cajaNombre.getText());
            persona.setDomicilio(vista.cajaDomicilio.getText());
            persona.setCelular(vista.cajaCelular.getText());
            persona.setCorreo(vista.cajaCorreo.getText());
            persona.setFecha_nacimiento(Date.valueOf(vista.cajaFechaNacimiento.getText()));
            persona.setGenero((String) vista.comboGenero.getSelectedItem());
            
            if (modelo.modificar(persona)) {
                JOptionPane.showMessageDialog(null, "Modificado correctamente");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar el registro");
                limpiarCajas();
            }
            
        }
        else if (ae.getSource() == vista.botonEliminar) {
            persona.setIdPersona(Integer.parseInt(vista.cajaID.getText()));
            
            if (modelo.eliminar(persona)) {
                JOptionPane.showMessageDialog(null, "registro eliminado correctamente");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }
        }
        
    }
    
    public void limpiarCajas(){
        vista.cajaID.setText(null);
        vista.cajaBuscar.setText(null);
        vista.cajaClave.setText(null);
        vista.cajaNombre.setText(null);
        vista.cajaDomicilio.setText(null);
        vista.cajaCelular.setText(null);
        vista.cajaCorreo.setText(null);
        vista.cajaFechaNacimiento.setText(null);
        vista.comboGenero.setSelectedIndex(0);
    }
    
    
}
