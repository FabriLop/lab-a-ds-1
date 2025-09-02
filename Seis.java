/*Una compañía quiere almacenar en arreglos ordenados la siguiente información para
cada vendedor: nombre y total de ventas. Inicialmente los arreglos están vacíos. Utilizar los
algoritmos estudiados.
Escribir un programa que permita realizar lo siguiente:
1. Dar de alta a un vendedor
2. Modificar el total de ventas de un vendedor determinado.
3. Imprimir el registro de un vendedor determinado.
4. Salir
Los arreglos deberán estar ordenados por el nombre del vendedor. */

import javax.swing.*;

public class Seis{
    public static void main(String args[]){
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de vendedores: "));
        String[] nombre = new String[tam];
        int [] ventas = new int[tam];
        int opc ,  n = -1;
      
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("1. Dar de alta a un vendedor\n2. Modificar el total de ventas de un vendedor determinado\n3. Imprimir el registro de un vendedor determinado\n4. Salir"));
            switch(opc){
                case 1:
                    n= IngresaVendedor(nombre, ventas, n, tam);
                    break;
                case 2:
                    modificarVentas(nombre, ventas, n, tam); 
                    break;
                case 3:
                    n = ImprimirUnRegistro(nombre, ventas, n);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                 
            }
        }while(opc != 4);
    }

    public static int buscarEmpleado(String nombre[], int n, String nombreB){
        String buscar = JOptionPane.showInputDialog("Ingrese el nombre del empleado a buscar: ");
        int i = 0;
        while((i <= n) && (nombre[i].compareTo(nombreB) < 0)){
            i++;
        }
        if((i > n) || (nombre[i].compareTo(nombreB) > 0))
        {
            return -i;
        }else{
            return i;
        }  
    }

    public static int IngresaVendedor(String nombre[], int ventas[], int n, int tam){
        if (n == -1)
        {
            n++;
            nombre[n] = JOptionPane.showInputDialog("Ingrese nombre del empleado");
            ventas[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ventas"));

        }
        else if(n < tam - 1){
          String nombreB = JOptionPane.showInputDialog("Ingrese nombre del empleado");
          int pos = buscarEmpleado(nombre, n, nombreB);
          if((pos > 0) || (nombre[0] == nombreB )){
            JOptionPane.showMessageDialog(null, "El empleado ya existe");
          }else{
            n++;
            pos = pos * -1; //corresponde estar en i posicion y tiene que devolverla negativa 
            for(int i = n; i >= pos + 1; i--){
                nombre[i] = nombre[i-1];
                ventas[i] = ventas[i-1];
            }
            nombre[pos] = nombreB;
            ventas[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario"));
            
            
          }
            
        }else{
            JOptionPane.showMessageDialog(null, "No hay espacio para mas empleados");
        }
       return n;
    }

    public static void modificarVentas(String nombre[], int ventas[], int n, int tam){
        if(n>-1)
		{
			String nombreB = JOptionPane.showInputDialog("Ingrese nombre del empleado");
            int pos = buscarEmpleado(nombre, n, nombreB);
			if ((pos <= 0) && (nombre[0].compareTo(nombreB) != 0))
			{
				JOptionPane.showMessageDialog(null,nombreB + "  no existe");
			}
			else
			{
				ventas[pos]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva venta para el vendendor " + nombre[pos]));
				JOptionPane.showMessageDialog(null, "Modificacion realizada");
			}
		}		
		else{ 
			JOptionPane.showMessageDialog(null, "Array vacio");
        }
    } 

    public static int ImprimirUnRegistro(String nombre[], int ventas[], int n){
        if(n > -1){
            String nombreB = JOptionPane.showInputDialog("Ingrese nombre del empleado");
            int pos = buscarEmpleado(nombre, n, nombreB);
            if((pos <= 0) && (nombre[0].compareTo(nombreB) != 0)){
                JOptionPane.showMessageDialog(null, "no existe");
            }else{
                JOptionPane.showMessageDialog(null, "Nombre: " + nombre[pos] + "\nventas: " + ventas[pos]);
            }
        }else{ 
            JOptionPane.showMessageDialog(null, "Array vacío");
        }
        return n;
    }

    
}