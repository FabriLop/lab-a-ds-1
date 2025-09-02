
//Laboratorio Uno
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;

public class LaboratorioUno {
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new ventane();
            }
        });
    }

    public static void transittion(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //al trtatar de hacerlo como booleano daba error por que tira un dato void 
        }
    }
}

class ventane extends JFrame {
    JButton boton, salir;

    public ventane() {
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        
        boton = new JButton("Siguiente");
        salir = new JButton("Salir");
        boton.setBounds(1100, 550, 150, 120);
        salir.setBounds(75,550,150,120);
        panel.add(boton);
        panel.add(salir);
        setVisible(true);
    }

    
    

    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage bi = null;
        BufferedImage bi2 = null;
        BufferedImage bi3 = null;
        Font f1 = new Font("Arial", Font.BOLD, 30);
        Font f2 = new Font("Arial", Font.BOLD, 23);
     
        try{
            bi = ImageIO.read(new File("C:\\Users\\aless\\OneDrive\\Documentos\\Trabajo\\.vscode\\Java\\image5.jpeg"));
            bi2 = ImageIO.read(new File("C:\\Users\\aless\\OneDrive\\Documentos\\Trabajo\\.vscode\\Java\\image6.jpeg"));
            bi3 = ImageIO.read(new File("C:\\Users\\aless\\OneDrive\\Documentos\\Trabajo\\.vscode\\Java\\image8.jpeg"));
        } catch(IOException e){
            throw new RuntimeException(e);
        }


        g.setColor(Color.BLUE);
        // letra U
        g.fillRect(53, 70, 45, 140);
        LaboratorioUno.transittion();
        g.fillRect(70, 165, 128, 45);
        LaboratorioUno.transittion();
        g.fillRect(153, 120, 45, 50);
        LaboratorioUno.transittion();

        // letra n
        g.fillRect(103, 70, 45, 90);
        LaboratorioUno.transittion();
        g.fillRect(110, 70, 128, 45);
        LaboratorioUno.transittion();
        g.fillRect(203, 70, 45, 140);
        LaboratorioUno.transittion();

        // letra i
        g.fillRect(223, 165, 58, 45);
        LaboratorioUno.transittion();
        g.fillRect(253, 120, 45, 90);
        LaboratorioUno.transittion();
        g.fillRect(253, 70, 45, 45);
        LaboratorioUno.transittion();

        //Letras
        g.setFont(f1);
        g.setColor(Color.BLUE);g.drawString("Universidad nacional de ingenieria", 560, 80);
        LaboratorioUno.transittion();
        g.drawString("DACTIC", 560, 120);
        LaboratorioUno.transittion();
        g.drawString("Ingenieria en computacion", 560, 160);
        LaboratorioUno.transittion();
        g.drawString("2M4-COM-S", 560, 200);
       
        
        //imagenes

        //Fabrizio
        g.setFont(f2);
        LaboratorioUno.transittion();
        Image imagen = bi.getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        g.drawImage(imagen, 75, 250, null); 
        g.drawString("Fabrizio Lopez Mejia", 75, 480);
        g.drawString("2024-1805U", 75, 510);
        
        //Luis
        LaboratorioUno.transittion();
        Image imagen2 = bi2.getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        g.drawImage(imagen2, 550, 250, null); 
        g.drawString("Luis Malespin Areas", 550, 480);
        g.drawString("2024-1811U", 550, 510);

        //Bismarck
        LaboratorioUno.transittion();
        Image imagen3 = bi3.getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        g.drawImage(imagen3, 1025, 250, null); 
        g.drawString("Bismarck Santana Bermudez", 1025, 480);
        g.drawString("2024-1817U", 1025, 510);

        //


    }   
}
