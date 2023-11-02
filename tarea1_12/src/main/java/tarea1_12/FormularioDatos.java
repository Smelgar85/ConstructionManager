/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package tarea1_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import org.netbeans.validation.api.builtin.stringvalidation.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author Sebastián Melgar Marín
 */
public class FormularioDatos extends javax.swing.JDialog {
         private FormularioPrincipal parentPrincipal;
    /**
     * Creates new form FormularioDatos
     * @param parent
     * @param modal
     */
    
    
    
    public FormularioDatos(FormularioPrincipal parent, boolean modal) {
        super(parent, modal);
        this.parentPrincipal = parent;
        initComponents();
        deshabilitaTodosServicios();
        jButtonGuardarRegistro.setEnabled(false);
        jSpinnerNEmpleados.setValue(0);
        jSpinnerNEmpleados.setEnabled(false);
        ValidationGroup groupCliente = validationPanelCliente.getValidationGroup();
        groupCliente.add(jTextFieldCodigo, StringValidators.REQUIRE_NON_EMPTY_STRING, new CODIGOValidacion());
        groupCliente.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING, new NOMBREValidacion());
        groupCliente.add(jTextFieldApellidos, StringValidators.REQUIRE_NON_EMPTY_STRING, new APELLDIRValidacion());
        groupCliente.add(jTextFieldTelefono, StringValidators.REQUIRE_NON_EMPTY_STRING, new TELFValidacion());
        groupCliente.add(jTextFieldDireccion, StringValidators.REQUIRE_NON_EMPTY_STRING, new APELLDIRValidacion());
        groupCliente.add(jFormattedTextFieldFecha, StringValidators.REQUIRE_NON_EMPTY_STRING, new FECHAValidacion());
        
        ValidationGroup groupRegistro = validationPanelReforma.getValidationGroup();
        //groupRegistro.add(buttonGroupTipo, );
        //groupRegistro.add(buttonGroupServicios, );
        //groupRegistro.add(jComboBoxEncargado, );
        //groupRegistro.add(jTextFieldCoste, new COSTEValidacion(), new COSTESUBValitacion());
        //groupRegistro.add(jSpinnerNEmpleados);
    
        validationPanelCliente.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanelCliente.getProblem() == null && validationPanelReforma.getProblem()==null)
                    jButtonGuardarRegistro.setEnabled(true);
            else
                    jButtonGuardarRegistro.setEnabled(false);
            
            }
        });
    }
private void habilitaServiciosSanitarios() {
    //Habilita los servicios relacionados con reforma de Sanitarios
    jRadioButtonAlbanileria.setEnabled(true);
    jRadioButtonFontaneria.setEnabled(true);
    jRadioButtonDecoracion.setEnabled(true);

    //Deshabilita los demás servicios
    jRadioButtonEstructura.setEnabled(false);
    jRadioButtonCimentacion.setEnabled(false);
    jRadioButtonCarpinteria.setEnabled(false);
}

private void habilitaServiciosPavimento() {
    //Habilita los servicios relacionados con reforma de Pavimento
    jRadioButtonEstructura.setEnabled(true);
    jRadioButtonCimentacion.setEnabled(true);

    //Deshabilita los demás servicios
    jRadioButtonAlbanileria.setEnabled(false);
    jRadioButtonFontaneria.setEnabled(false);
    jRadioButtonDecoracion.setEnabled(false);
    jRadioButtonCarpinteria.setEnabled(false);
}

private void habilitaServiciosIntegral() {
    //Habilita los servicios relacionados con reforma Integral
    jRadioButtonEstructura.setEnabled(true);
    jRadioButtonCimentacion.setEnabled(true);
    jRadioButtonAlbanileria.setEnabled(true);
    jRadioButtonFontaneria.setEnabled(true);
    jRadioButtonDecoracion.setEnabled(true);
    jRadioButtonCarpinteria.setEnabled(true);
}

private void deshabilitaTodosServicios() {
    //Deshabilita y desmarca todos los servicios
    
    jRadioButtonEstructura.setEnabled(false);
    jRadioButtonEstructura.setSelected(false);
    jRadioButtonCimentacion.setEnabled(false);
    jRadioButtonCimentacion.setSelected(false);
    jRadioButtonAlbanileria.setEnabled(false);
    jRadioButtonAlbanileria.setSelected(false);
    jRadioButtonFontaneria.setEnabled(false);
    jRadioButtonFontaneria.setSelected(false);
    jRadioButtonDecoracion.setEnabled(false);
    jRadioButtonDecoracion.setSelected(false);
    jRadioButtonCarpinteria.setEnabled(false);
    jRadioButtonCarpinteria.setSelected(false);
}
private void updateCostePorHoraValidation(String selectedOption) {
    InputVerifier costePorHoraVerifier = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            String costePorHoraText = jTextFieldCoste.getText();
            if (!costePorHoraText.isEmpty()) {
                try {
                    double costePorHora = Double.parseDouble(costePorHoraText);
                    if (selectedOption.equals("Subcontrata") && costePorHora > 80.0) {
                      double tempint;
                      tempint=costePorHora; 
                      ValidationGroup groupRegistro = validationPanelReforma.getValidationGroup();
                      groupRegistro.add(tempint, new COSTESUBValitacion(), new COSTEValidacion());
                    } else if (costePorHora > 99.99) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        }
    };
    jTextFieldCoste.setInputVerifier(costePorHoraVerifier);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        buttonGroupServicios = new javax.swing.ButtonGroup();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabelTipoRef = new javax.swing.JLabel();
        jRadioButtonSanitarios = new javax.swing.JRadioButton();
        jRadioButtonPavimento = new javax.swing.JRadioButton();
        jRadioButtonIntegral = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelServicios = new javax.swing.JLabel();
        jRadioButtonEstructura = new javax.swing.JRadioButton();
        jRadioButtonCimentacion = new javax.swing.JRadioButton();
        jRadioButtonAlbanileria = new javax.swing.JRadioButton();
        jRadioButtonCarpinteria = new javax.swing.JRadioButton();
        jRadioButtonFontaneria = new javax.swing.JRadioButton();
        jRadioButtonDecoracion = new javax.swing.JRadioButton();
        jLabelEncargado = new javax.swing.JLabel();
        jComboBoxEncargado = new javax.swing.JComboBox<>();
        jLabelCoste = new javax.swing.JLabel();
        jTextFieldCoste = new javax.swing.JTextField();
        jButtonGuardarRegistro = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jSpinnerNEmpleados = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        validationPanelCliente = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jFormattedTextFieldFecha = new javax.swing.JFormattedTextField();
        validationPanelReforma = new org.netbeans.validation.api.ui.swing.ValidationPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelCodigo.setText("Codigo");
        jLabelCodigo.setToolTipText("Código de cliente (5 cifras)");

        jLabelNombre.setText("Nombre");
        jLabelNombre.setToolTipText("Nombre del cliente");

        jLabelApellidos.setText("Apellidos");
        jLabelApellidos.setToolTipText("Apellidos del cliente");

        jLabelDireccion.setText("Dirección");
        jLabelDireccion.setToolTipText("Dirección del cliente");

        jLabelTelefono.setText("Telefono");
        jLabelTelefono.setToolTipText("Teléfono del cliente");

        jLabelFecha.setText("Fecha de alta");
        jLabelFecha.setToolTipText("Fecha de alta del cliente");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("DATOS DEL CLIENTE");

        jTextFieldCodigo.setName("Código"); // NOI18N
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jTextFieldNombre.setName("Nombre"); // NOI18N
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldApellidos.setName("Apellidos"); // NOI18N
        jTextFieldApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidosActionPerformed(evt);
            }
        });

        jTextFieldTelefono.setName("Teléfono"); // NOI18N
        jTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefonoActionPerformed(evt);
            }
        });

        jTextFieldDireccion.setName("Dirección"); // NOI18N
        jTextFieldDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDireccionActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("DATOS DE LA REFORMA");

        jLabelTipoRef.setText("TIPO DE REFORMA");
        jLabelTipoRef.setToolTipText("Reforma a realizar");

        buttonGroupTipo.add(jRadioButtonSanitarios);
        jRadioButtonSanitarios.setText("Sanitarios");
        jRadioButtonSanitarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSanitariosActionPerformed(evt);
            }
        });

        buttonGroupTipo.add(jRadioButtonPavimento);
        jRadioButtonPavimento.setText("Pavimento");
        jRadioButtonPavimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPavimentoActionPerformed(evt);
            }
        });

        buttonGroupTipo.add(jRadioButtonIntegral);
        jRadioButtonIntegral.setText("Integral");
        jRadioButtonIntegral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonIntegralActionPerformed(evt);
            }
        });

        jLabelServicios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelServicios.setText("SERVICIOS:");
        jLabelServicios.setToolTipText("Servicios a contratar");

        jRadioButtonEstructura.setText("Estructura");
        jRadioButtonEstructura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEstructuraActionPerformed(evt);
            }
        });

        jRadioButtonCimentacion.setText("Cimentación");
        jRadioButtonCimentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCimentacionActionPerformed(evt);
            }
        });

        jRadioButtonAlbanileria.setText("Albañilería");
        jRadioButtonAlbanileria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAlbanileriaActionPerformed(evt);
            }
        });

        jRadioButtonCarpinteria.setText("Carpintería");
        jRadioButtonCarpinteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCarpinteriaActionPerformed(evt);
            }
        });

        jRadioButtonFontaneria.setText("Fontanería");
        jRadioButtonFontaneria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFontaneriaActionPerformed(evt);
            }
        });

        jRadioButtonDecoracion.setText("Decoración");
        jRadioButtonDecoracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDecoracionActionPerformed(evt);
            }
        });

        jLabelEncargado.setText("ENCARGADO:");
        jLabelEncargado.setToolTipText("Encargado de la reforma");

        jComboBoxEncargado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleados propios", "Autónomos", "Subcontrata" }));
        jComboBoxEncargado.setSelectedIndex(-1);
        jComboBoxEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEncargadoActionPerformed(evt);
            }
        });

        jLabelCoste.setText("COSTE POR HORA");
        jLabelCoste.setToolTipText("Coste €/Hora");

        jTextFieldCoste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCosteActionPerformed(evt);
            }
        });

        jButtonGuardarRegistro.setText("GUARDAR REGISTRO");
        jButtonGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarRegistroActionPerformed(evt);
            }
        });

        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jSpinnerNEmpleados.setModel(new javax.swing.SpinnerNumberModel(2, 2, 50, 1));
        jSpinnerNEmpleados.setToolTipText("");

        jLabel1.setText("Nº Empleados");
        jLabel1.setToolTipText("Empleados a contratar");

        jFormattedTextFieldFecha.setName("Fecha"); // NOI18N
        jFormattedTextFieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelDireccion)
                            .addComponent(jLabelFecha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTipoRef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonSanitarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonPavimento)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonIntegral))
                    .addComponent(jLabelServicios)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jRadioButtonEstructura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonFontaneria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButtonDecoracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonCimentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonCarpinteria)
                            .addComponent(jRadioButtonAlbanileria)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39)
                        .addComponent(validationPanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEncargado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jButtonGuardarRegistro)))
                        .addGap(41, 41, 41)
                        .addComponent(jButtonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCoste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCoste, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerNEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(validationPanelReforma, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelApellidos)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelCodigo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jTextFieldApellidos)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validationPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefono))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDireccion))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFecha)
                    .addComponent(jFormattedTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipoRef)
                            .addComponent(jRadioButtonSanitarios)
                            .addComponent(jRadioButtonPavimento)
                            .addComponent(jRadioButtonIntegral))
                        .addGap(24, 24, 24)
                        .addComponent(jLabelServicios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonEstructura)
                            .addComponent(jRadioButtonCimentacion)
                            .addComponent(jRadioButtonAlbanileria))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonFontaneria)
                            .addComponent(jRadioButtonDecoracion)
                            .addComponent(jRadioButtonCarpinteria))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEncargado)
                            .addComponent(jComboBoxEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCoste)
                            .addComponent(jTextFieldCoste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerNEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGuardarRegistro)
                            .addComponent(jButtonSalir)))
                    .addComponent(validationPanelReforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jTextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefonoActionPerformed

    private void jTextFieldCosteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCosteActionPerformed
        
    }//GEN-LAST:event_jTextFieldCosteActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jRadioButtonSanitariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSanitariosActionPerformed
        deshabilitaTodosServicios();
        if (jRadioButtonSanitarios.isSelected()) {
            habilitaServiciosSanitarios();
        } else {
            deshabilitaTodosServicios();
        }
    }//GEN-LAST:event_jRadioButtonSanitariosActionPerformed

    private void jRadioButtonPavimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPavimentoActionPerformed
        deshabilitaTodosServicios();
        if (jRadioButtonPavimento.isSelected()) {
            habilitaServiciosPavimento();
        } else {
            deshabilitaTodosServicios();
        }
    }//GEN-LAST:event_jRadioButtonPavimentoActionPerformed

    private void jRadioButtonIntegralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonIntegralActionPerformed
        deshabilitaTodosServicios();
        if (jRadioButtonIntegral.isSelected()) {
            habilitaServiciosIntegral();
        } else {
            deshabilitaTodosServicios();
        }
    }//GEN-LAST:event_jRadioButtonIntegralActionPerformed

    private String obtenerSeleccionTipo() {
    if (jRadioButtonSanitarios.isSelected()) {
        return "Sanitarios";
    } else if (jRadioButtonPavimento.isSelected()) {
        return "Pavimento";
    } else if (jRadioButtonIntegral.isSelected()) {
        return "Integral";
    } else {
        return "Ninguno seleccionado";
    }
}
    
   private String obtenerSeleccionesServicios() {
    List<String> selecciones = new ArrayList<>();

    if (jRadioButtonEstructura.isSelected()) {
        selecciones.add("Estructura");
    }
    if (jRadioButtonCimentacion.isSelected()) {
        selecciones.add("Cimentación");
    }
    if (jRadioButtonAlbanileria.isSelected()) {
        selecciones.add("Albañilería");
    }
    if (jRadioButtonFontaneria.isSelected()) {
        selecciones.add("Fontanería");
    }
    if (jRadioButtonDecoracion.isSelected()) {
        selecciones.add("Decoración");
    }
    if (jRadioButtonCarpinteria.isSelected()) {
        selecciones.add("Carpintería");
    }

    if (selecciones.isEmpty()) {
        return "Ninguna selección";
    } else {
        // Convierte la lista de selecciones en un único String separado por comas y espacio
        return String.join(", ", selecciones);
    }
}

    
    
    
    private void jComboBoxEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEncargadoActionPerformed
        jSpinnerNEmpleados.setValue(0);
        String selectedOption = jComboBoxEncargado.getSelectedItem().toString();
        if (selectedOption.equals("Empleados propios")) {
            jSpinnerNEmpleados.setEnabled(false);
        } else if (selectedOption.equals("Autónomos") || selectedOption.equals("Subcontrata")) {
            jSpinnerNEmpleados.setValue(2);
            jSpinnerNEmpleados.setEnabled(true);
        }
        
        // Controlar el valor máximo del campo "Coste por hora de mano de obra (€)"
        updateCostePorHoraValidation(selectedOption);
    }//GEN-LAST:event_jComboBoxEncargadoActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidosActionPerformed

    private void jTextFieldDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDireccionActionPerformed

    private void jFormattedTextFieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldFechaActionPerformed

    private void jRadioButtonEstructuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEstructuraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonEstructuraActionPerformed

    private void jRadioButtonCimentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCimentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCimentacionActionPerformed

    private void jRadioButtonAlbanileriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAlbanileriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAlbanileriaActionPerformed

    private void jRadioButtonFontaneriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFontaneriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonFontaneriaActionPerformed

    private void jRadioButtonDecoracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDecoracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonDecoracionActionPerformed

    private void jRadioButtonCarpinteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCarpinteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCarpinteriaActionPerformed

    private void jButtonGuardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarRegistroActionPerformed
       
       String seleccionTipo = obtenerSeleccionTipo();
       String seleccionServicios = obtenerSeleccionesServicios();
       int valorEmpleados = (int) jSpinnerNEmpleados.getValue();
       String []insercion = new String[11];
       insercion[0]=jTextFieldCodigo.getText();
       insercion[1]=jTextFieldNombre.getText();
       insercion[2]=jTextFieldApellidos.getText();
       insercion[4]=jTextFieldTelefono.getText();
       insercion[3]=jTextFieldDireccion.getText();
       insercion[5]=jFormattedTextFieldFecha.getText();
       insercion[6]=seleccionTipo;
       insercion[7]=seleccionServicios;
       insercion[8]=(String) jComboBoxEncargado.getSelectedItem();
       insercion[9]=jTextFieldCoste.getText();
       insercion[10]=Integer.toString(valorEmpleados);
       parentPrincipal.agregarFilaATabla(insercion);       
              //FormularioPrincipal.jTablePrincipal.addRow(insercion);
    }//GEN-LAST:event_jButtonGuardarRegistroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
       java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            Locale.setDefault(new Locale("es", "ES"));
            FormularioPrincipal mainFrame = new FormularioPrincipal(); // Asumiendo que FormularioPrincipal es tu ventana principal.
            FormularioDatos dialog = new FormularioDatos(mainFrame, true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupServicios;
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JButton jButtonGuardarRegistro;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxEncargado;
    private javax.swing.JFormattedTextField jFormattedTextFieldFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCoste;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEncargado;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelServicios;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTipoRef;
    private javax.swing.JRadioButton jRadioButtonAlbanileria;
    private javax.swing.JRadioButton jRadioButtonCarpinteria;
    private javax.swing.JRadioButton jRadioButtonCimentacion;
    private javax.swing.JRadioButton jRadioButtonDecoracion;
    private javax.swing.JRadioButton jRadioButtonEstructura;
    private javax.swing.JRadioButton jRadioButtonFontaneria;
    private javax.swing.JRadioButton jRadioButtonIntegral;
    private javax.swing.JRadioButton jRadioButtonPavimento;
    private javax.swing.JRadioButton jRadioButtonSanitarios;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnerNEmpleados;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCoste;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelCliente;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelReforma;
    // End of variables declaration//GEN-END:variables
}
