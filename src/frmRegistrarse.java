
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/*import frmLogin;*/



public class frmRegistrarse extends javax.swing.JPanel {


    public frmRegistrarse() {
        initComponents();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("frmRegistrarse Demo");
        frmRegistrarse panel = new frmRegistrarse();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbApellidos = new javax.swing.JLabel();
        jlbNombres = new javax.swing.JLabel();
        txtCorreo = new java.awt.TextField();
        jlbUsuario = new javax.swing.JLabel();
        jlbContrasena = new javax.swing.JLabel();
        jlbCorreo = new javax.swing.JLabel();
        txtNombres = new java.awt.TextField();
        txtApellidos = new java.awt.TextField();
        txtContrasena = new java.awt.TextField();
        jlbCelular = new javax.swing.JLabel();
        txtCelular = new java.awt.TextField();
        txtUsuario = new java.awt.TextField();
        btnRegistrar = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel1.setText("Registrarse");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 160, 40));

        jlbApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbApellidos.setText("Apellidos:");
        jPanel1.add(jlbApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jlbNombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbNombres.setText("Nombres:");
        jPanel1.add(jlbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 200, 30));

        jlbUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbUsuario.setText("Usuario:");
        jPanel1.add(jlbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, -1, -1));

        jlbContrasena.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbContrasena.setText("Contraseña:");
        jPanel1.add(jlbContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, -1));

        jlbCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbCorreo.setText("Correo:");
        jPanel1.add(jlbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, 30));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 200, 30));
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 200, 30));

        jlbCelular.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbCelular.setText("Celular:");
        jPanel1.add(jlbCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 200, 30));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 200, 30));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
          // Obtener los valores de los campos de texto
    String nombres = txtNombres.getText();
    String apellidos = txtApellidos.getText();
    String contrasena = txtContrasena.getText();
    String celular = txtCelular.getText();
    String usuario = txtUsuario.getText();
    String correo = txtCorreo.getText();


    try (Connection conn = ConexionSQL.getConexion()) {
        //Parametros 
        String query = "INSERT INTO Registrar (Usuario, Contraseña, Email, Nombres, Apellidos, Celular) "
                     + "VALUES (?, ?, ?, ?, ?, ?)";

        // Preparar la declaración SQL
        try (PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            stmt.setString(3, correo);
            stmt.setString(4, nombres);
            stmt.setString(5, apellidos);
            stmt.setString(6, celular);

            // Ejecuta la consulta ._.
            stmt.executeUpdate();

            
            System.out.println("Registro exitoso");
            
            //Abrir el nuevo formulario de login
            /*            frmLogin loginForm = new frmLogin();
            loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginForm.pack();
            loginForm.setVisible(true);*/


        }
    } catch (SQLException ex) {
     
        System.out.println("Error al registrar usuario: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnRegistrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbApellidos;
    private javax.swing.JLabel jlbCelular;
    private javax.swing.JLabel jlbContrasena;
    private javax.swing.JLabel jlbCorreo;
    private javax.swing.JLabel jlbNombres;
    private javax.swing.JLabel jlbUsuario;
    private java.awt.TextField txtApellidos;
    private java.awt.TextField txtCelular;
    private java.awt.TextField txtContrasena;
    private java.awt.TextField txtCorreo;
    private java.awt.TextField txtNombres;
    private java.awt.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
