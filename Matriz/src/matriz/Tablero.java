
package matriz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Tablero extends JFrame{
    
    JButton arreglo[][] ;
   
    public Tablero(){
        initComponents();
    }
    
    
    public void initComponents(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setTitle("MATRIZ");
        setResizable(false);
        setLocationRelativeTo(null);
        
        JPanel tabla = new JPanel();
        GridBagLayout capa = new GridBagLayout();
        tabla.setLayout(capa);
        tabla.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints restricciones = new GridBagConstraints();
        
         
        
        arreglo = new JButton[10][5];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                arreglo[i][j] = new JButton();
                arreglo[i][j].setFont(new Font("Arial", Font.BOLD, 30));
                
                
                arreglo[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn_presionado = (JButton) e.getSource();
                        //marco el boton con una diferencia
                        marcarbtn(btn_presionado);
                        
                       
                    }
                });
                
                
                restricciones.gridx = j;
                restricciones.gridy = i + 4;
                restricciones.gridwidth = 1;
                restricciones.gridheight = 1;
                restricciones.weightx = 1;
                restricciones.weighty = 1;
                restricciones.fill = GridBagConstraints.BOTH;
                tabla.add(arreglo[i][j], restricciones);
            }
        }
        add(tabla);
        revalidate();
        setVisible(true);
    }
    
    public void marcarbtn(JButton btn){
       btn.setText("x");
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (arreglo[i][j].getText().equals("x")) {
                    int pos_fila = i;
                    int pos_colomna = j;
                    validarpos(pos_fila, pos_colomna);
                }
            }
        }
    }
    
    public void validarpos(int fila, int columna){
        
            if (fila == 9 && columna == 0) {
                for (int i = columna; i < 5; i++) {
                    arreglo[fila][i].setText("o");
                    arreglo[fila][i].setBackground(Color.cyan);
                    arreglo[fila][i].setEnabled(false);
                    System.out.println("nos estamos devolviendo");
                }
                for (int j = 0; j < fila; j++) {
                    arreglo[j][columna].setText("o");
                    arreglo[j][columna].setBackground(Color.cyan);
                    arreglo[j][columna].setEnabled(false);
                    System.out.println("nos estamos devolviendo");

                }
            }else if (fila!=0 && columna!=0) {
                for (int i = 0; i < 10; i++) {
                    arreglo[i][columna].setText("o");
                    arreglo[i][columna].setBackground(Color.cyan);
                    arreglo[i][columna].setEnabled(false);
                }
                for (int j = 0; j < 5; j++) {
                    arreglo[fila][j].setText("o");
                    arreglo[fila][j].setBackground(Color.cyan);
                    arreglo[fila][j].setEnabled(false);
                }
            }else if (columna == 4 && fila == 0) {
                for (int i = 0; i < 5; i++) {
                    arreglo[fila][i].setText("o");
                    arreglo[fila][i].setBackground(Color.cyan);
                    arreglo[fila][i].setEnabled(false);
                }
                for (int j = 0; j < 10; j++) {
                    arreglo[j][columna].setText("o");
                    arreglo[j][columna].setBackground(Color.cyan);
                    arreglo[j][columna].setEnabled(false);
                }
            }else if (fila == 0 && columna==0) {
                
                for (int i = 0; i < 10; i++) {
                    arreglo[i][columna].setText("o");
                    arreglo[i][columna].setBackground(Color.cyan);
                    arreglo[i][columna].setEnabled(false);
                }
                for (int j = 0; j < 5; j++) {
                    arreglo[fila][j].setText("o");
                    arreglo[fila][j].setBackground(Color.cyan);
                    arreglo[fila][j].setEnabled(false);
                }
            }
        

            
            
            
          
        
  
    
    }
    
}
