 package cartospot;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class CartoSpot extends javax.swing.JFrame {
     
    /**
     * Creates new form INE
     */
    ArrayList<Municipio>Municipios=new ArrayList<>();
    ArrayList<Seccionid> Secciones1=new ArrayList<>();
    ArrayList<Localidadid> Localidades1=new ArrayList<>();
    
    public CartoSpot() {
        initComponents();
        cargador();
        this.setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        scren = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CartoSpot");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Seccion, Municipio o Localidad...");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                releasedkey(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setToolTipText("");

        scren.setEditable(false);
        scren.setColumns(20);
        scren.setRows(5);
        scren.setBorder(null);
        scren.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scren.setDragEnabled(false);
        scren.setDropTarget(null);
        scren.setSelectionColor(new java.awt.Color(204, 204, 204));
        scren.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                screnMouseClicked(evt);
            }
        });
        scren.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                screnMouseDragged(evt);
            }
        });
        scren.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                screnKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(scren);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("?");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Image getIconImage(){
        Image rv=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Seccion/icon.png"));
        return rv;
    }
    int ls=0;
    
    ArrayList<Integer> saltos=new ArrayList<>();
    
    private void releasedkey(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_releasedkey
        // TODO add your handling code here:
        int kc=evt.getKeyCode();
        if(kc==40){
            //Abajo
            scren.requestFocus();
            scren.setCaretPosition(saltos.get(0));
            scren.moveCaretPosition(saltos.get(1)); 
            ls=0;
        }
        if(kc==39){
            //Abajo
            scren.requestFocus();
            scren.setCaretPosition(saltos.get(0));
            scren.moveCaretPosition(saltos.get(1)); 
            ls=0;
        }
        if(kc==8){
            //Borrar
            www=false;
            scren.setText("");
            if(jTextField1.getText().length()==0){
                prim=true;
                
            } 
        }
    }//GEN-LAST:event_releasedkey
    
    boolean x=true;
    
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        scren.setText("");
        if(prim){
            prim=false;
            jTextField1.setText("");
            jTextField1.setForeground(Color.BLACK);
            scren.setForeground(Color.GRAY);
            x = c<'0'||c>'9';
        }
        if(x){
            BuscaLocalidad(c);
        }else{
            buscaSeccion(c);
        }
          
    }//GEN-LAST:event_jTextField1KeyTyped

    
    ArrayList<Integer> menu1=new ArrayList<>();
    private void screnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_screnKeyReleased
        // TODO add your handling code here:
        int kc=evt.getKeyCode();
        if(kc==10){
             if(www){
                openURL(url);
            }else{
            MuestraInformacionReferente();
            }
        }
        
        if(kc==38){
            //Arriba
            if(ls<1){
                ls=0;
            }else{
                ls--;
            }
            scren.setCaretPosition(saltos.get(ls));
            scren.moveCaretPosition(saltos.get(ls+1));       
        }
        if(kc==37){
            //Arriba
            if(ls<1){
                ls=0;
            }else{
                ls--;
            }
            scren.setCaretPosition(saltos.get(ls));
            scren.moveCaretPosition(saltos.get(ls+1));       
        }
        if(kc==40){
            //Abajo
            if(ls<saltos.size()-2){
                ls++;
            }else{
                ls=saltos.size()-2;
            }        
            scren.setCaretPosition(saltos.get(ls));
            scren.moveCaretPosition(saltos.get(ls+1));    
        }
        if(kc==39){
            //Abajo
            if(ls<saltos.size()-2){
                ls++;
            }else{
                ls=saltos.size()-2;
            }        
            scren.setCaretPosition(saltos.get(ls));
            scren.moveCaretPosition(saltos.get(ls+1));    
        }
        if(kc==8){
            //Borrar
            scren.setText("");
            jTextField1.requestFocus();
            prim=true;
            www=false;
        }
    }//GEN-LAST:event_screnKeyReleased

    private void screnMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_screnMouseDragged
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Solo utiliza las flechas");
    }//GEN-LAST:event_screnMouseDragged

    private void screnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_screnMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Solo utiliza las flechas");
    }//GEN-LAST:event_screnMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AcercaDe xD =new AcercaDe();
        xD.show();
        jButton2.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed
    int xm;
    int ym;
    boolean prim=true;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new INE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea scren;
    // End of variables declaration//GEN-END:variables

    private void cargador(){
        String tex="";
        //File archivo=new File(org.jcp.xml.dsig.internal.dom.Utils.class.getResource("/Seccion/Data").getFile());
        URL dir=getClass().getResource("/Seccion/Data");
        try{
            
            InputStream is=dir.openStream();
            InputStreamReader isr=new InputStreamReader(is);
            try (BufferedReader b = new BufferedReader(isr)) {
                while((tex=b.readLine())!=null){
                    StringTokenizer line=new StringTokenizer(tex,"|");
                    int Seccion=Integer.parseInt(line.nextToken());
                    int Dtto_Loc=Integer.parseInt(line.nextToken());
                    int Dtto_Fed=Integer.parseInt(line.nextToken());
                    int Cve_Mpo=Integer.parseInt(line.nextToken());
                    String Nom_Mpo=line.nextToken();
                    int Cve_Loc=Integer.parseInt(line.nextToken());
                    String Nom_Loc=line.nextToken();
                    int Tipo=Integer.parseInt(line.nextToken());
                    
                    if(!ContineM(Cve_Mpo,Municipios)){
                        Municipio M=new Municipio();
                        M.Clave=Cve_Mpo;
                        M.Nombre=Nom_Mpo;
                        Municipios.add(M);
                        M.Secciones=new ArrayList<>();
                    }
                    
                    int idMun=idMunicipio(Cve_Mpo);
                    if(!ContineS(Seccion, Municipios.get(idMun).Secciones)){
                        Seccion s=new Seccion();
                        s.Clave=Seccion;
                        s.Dtto_Fed=Dtto_Fed;
                        s.Dtto_Loc=Dtto_Loc;
                        s.Localidades=new ArrayList<>();
                        Municipios.get(idMun).Secciones.add(s);
                        Seccionid s1=new Seccionid();
                        s1.Seccion=Seccion;
                        s1.idMunicipio=idMun;
                        s1.idSeccion=Municipios.get(idMun).Secciones.size();
                        Secciones1.add(s1);
                    }
                    
                    int idSec=idSeccion(Seccion,idMun);
                    if(!ContieneL(Cve_Loc,Municipios.get(idMun).Secciones.get(idSec).Localidades)){
                        Localidad l=new Localidad();
                        l.Clave=Cve_Loc;
                        l.Nombre=Nom_Loc;
                        l.tipo=Tipo;
                        Municipios.get(idMun).Secciones.get(idSec).Localidades.add(l);
                        Localidadid l1=new Localidadid();
                        l1.Localidad=Nom_Loc;
                        l1.idLocalidad=Municipios.get(idMun).Secciones.get(idSec).Localidades.size();
                        l1.idMunicipio=idMun;
                        l1.idSeccion=idSec;
                        Localidades1.add(l1);
                    }
                }
            }
        }catch(IOException | NumberFormatException e){
            JOptionPane.showMessageDialog(null,e.getMessage()+"\n"+ tex);
        }
    }

    private boolean ContineM(int Cve_Mpo, ArrayList<Municipio> Munisipios) {
        boolean existe=false;
        for(int i=0; i<Munisipios.size();i++){
            if(Munisipios.get(i).Clave==Cve_Mpo){
                existe=true;
                break;
            }
        }
        return existe;
    }

    private boolean ContineS(int Seccion, ArrayList<Seccion> Secciones) {
       boolean existe=false;
        for(int i=0; i<Secciones.size();i++){
            if(Secciones.get(i).Clave==Seccion){
                existe=true;
                break;
            }
        }
        return existe;
    }

    private boolean ContieneL(int Cve_Loc, ArrayList<Localidad> Localidades) {
        boolean existe=false;
        for(int i=0; i<Localidades.size();i++){
            if(Localidades.get(i).Clave==Cve_Loc){
                existe=true;
                break;
            }
        }
        return existe;
    }
    
    private int idMunicipio(int Cve_Mpo) {
        int id=-1;
        for(int i=0;i<Municipios.size();i++){
            if(Municipios.get(i).Clave==Cve_Mpo){
             id=i;
             break;
            }
        }
        return id;
    }

    private int idSeccion(int Seccion,int idMun) {
        int id=-1;
        for(int i=0;i<Municipios.get(idMun).Secciones.size();i++){
            if(Municipios.get(idMun).Secciones.get(i).Clave==Seccion){
             id=i;
             break;
            }
        }
        return id;  
    }
    
    ArrayList<Integer> SecIndex =new ArrayList<>();
    
    private void buscaSeccion(char c) {
    scren.append("Secciones:\n");
    saltos.clear();
    SecIndex.clear();
    saltos.add(10);
        for(int i=0; i<Secciones1.size();i++){
            try{
                String nSec=Secciones1.get(i).Seccion+"";
                String tex=nSec.substring(0,jTextField1.getText().length()+1);
                if(tex.equals(jTextField1.getText()+c)){
                    int idMun=Secciones1.get(i).idMunicipio;
                    tex=nSec+"\t"+Municipios.get(idMun).Nombre+"\n";
                    scren.append(tex);
                    SecIndex.add(i);
                    saltos.add(tex.length()+saltos.get(saltos.size()-1));
                }
            }catch(Exception e){}
        } 
    }
    
    ArrayList<Integer> locIndex =new ArrayList<>();
    
    private void BuscaLocalidad(char c) {
        scren.append("Localidades:\n");
        saltos.clear();
        locIndex.clear();
        saltos.add(12);
        for(int i=0; i<Localidades1.size();i++){
            String nLoc=Localidades1.get(i).Localidad;
            String tex;
            int idMun;
            int idSec;
            tex=jTextField1.getText()+c;
            if(nLoc.contains(tex.toUpperCase())){
                idMun=Localidades1.get(i).idMunicipio;
                idSec=Localidades1.get(i).idSeccion;                
                tex=nLoc+" "+Municipios.get(idMun).Secciones.get(idSec).Clave+" "+Municipios.get(idMun).Nombre+"\n";
                scren.append(tex);
                locIndex.add(i);
                int espacio=tex.length();
                int suma=saltos.get(saltos.size()-1);
                saltos.add(espacio+suma);
            }
        } 
    }
    String url;
    
    private void Busqueda(){
        scren.append("Municipios y Localidades\n");
        for(int i=0; i<Municipios.size();i++){
            scren.append(Municipios.get(i).Clave+"\t"+Municipios.get(i).Nombre+"\n");
            for(int j=0;j<Municipios.get(i).Secciones.size();j++){
                scren.append("  "+Municipios.get(i).Secciones.get(j).Clave+
                        "  "+Municipios.get(i).Secciones.get(j).Dtto_Fed+
                        "  "+Municipios.get(i).Secciones.get(j).Dtto_Loc+"\n");
                for(int k=0; k<Municipios.get(i).Secciones.get(j).Localidades.size();k++){
                    scren.append("    "+Municipios.get(i).Secciones.get(j).Localidades.get(k).Clave+"  "+
                            Municipios.get(i).Secciones.get(j).Localidades.get(k).Nombre+"\n");
                }
            }
        }
    }
    boolean www=false;
    private void MuestraInformacionReferente() {
        www=true;
        url="http://cartografia.ife.org.mx/sige7/?mapa&e=10&s=";
       saltos.clear();
       if(x){
            //Localidades
            SecIndex.clear();
            int p=locIndex.get(ls);
            int m=Localidades1.get(p).idMunicipio;
            int s=Localidades1.get(p).idSeccion;
            int l=Localidades1.get(p).idLocalidad-1;    
            String NomLoc=Municipios.get(m).Secciones.get(s).Localidades.get(l).Nombre;
            int idLoc=Municipios.get(m).Secciones.get(s).Localidades.get(l).Clave;
            String Mun=Municipios.get(m).Nombre;
            int Secc=Municipios.get(m).Secciones.get(s).Clave;
            int Dtto_Fed=Municipios.get(m).Secciones.get(s).Dtto_Fed;
            int Dtto_Loc=Municipios.get(m).Secciones.get(s).Dtto_Loc;
            int Tipo=Municipios.get(m).Secciones.get(s).Localidades.get(l).tipo;
            String t="";
            switch(Tipo){
                case 3:t="Mixto";break;
                case 4:t="Rural";break;
                case 2:t="Urbano";break;
            }
            scren.setText("Secion: "+Secc+"\n");
            scren.append("Localidad: "+NomLoc+"\n");
            scren.append("Id Localidad: "+idLoc+"\n");
            scren.append("Municipio: "+Mun+"\n");
            scren.append("Dtto_Fed: "+Dtto_Fed+"\n");
            scren.append("Dtto_LOc: "+Dtto_Loc+"\n");
            scren.append("Tipo: "+t+"\n");   
            saltos.add(scren.getText().length());
            scren.append("Ver plano");
            saltos.add(scren.getText().length());
            url+=Municipios.get(m).Secciones.get(s).Clave;
            ls=0;        
        }else{
            //Secciones
            String Loc="";
            locIndex.clear();
            int p=SecIndex.get(ls);
            int m=Secciones1.get(p).idMunicipio;
            int s=Secciones1.get(p).idSeccion-1;
            String Mun=Municipios.get(m).Nombre;
            String ts="";
            int cveMun=Municipios.get(m).Clave;
            int Df=Municipios.get(m).Secciones.get(s).Dtto_Fed;
            int Dl=Municipios.get(m).Secciones.get(s).Dtto_Loc;
            int cr=0,cu=0,i;
            for (i=0;i<Municipios.get(m).Secciones.get(s).Localidades.size();i++){
                int Tipo=Municipios.get(m).Secciones.get(s).Localidades.get(i).tipo;
                String t="";
                switch(Tipo){
                    case 4:t="Rural";cr++;break;
                    case 2:t="Urbano";cu++;break;
                }
                Loc+="  "+Municipios.get(m).Secciones.get(s).Localidades.get(i).Nombre+"  "
                        +Municipios.get(m).Secciones.get(s).Localidades.get(i).Clave+"  "+t+"\n";
                 
                ls=0;
            }
            if(cu==i){
                ts="Urabana";
            }else if(cr==i){
                ts="Rural";
            }else{
                ts="Mixta";
            }
            
            scren.setText("Seccion: "+Secciones1.get(p).Seccion+"\n");
            scren.append("Tipo: "+ts+"\n");
            scren.append("Municipio: "+Mun);
            scren.append("  "+cveMun+"\n");
            scren.append("Dtto_Fed: "+Df+"\n");
            scren.append("Dtto_Loc: "+Dl+"\n");
            scren.append("LOCALIDADES\n");
            scren.append(Loc);
            url+=Secciones1.get(p).Seccion;
            saltos.add(scren.getText().length());
            scren.append("Ver plano");
            saltos.add(scren.getText().length());
        }
    }
    
    public static void openURL(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (osName.startsWith("Mac OS X")) {
                 Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                //Runtime.getRuntime().exec("open " + url);
            } else {
                JOptionPane.showMessageDialog(null,"Please open a browser and go to "+ url);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Please open a browser and go to "+ url);
        }
    }
    
}
