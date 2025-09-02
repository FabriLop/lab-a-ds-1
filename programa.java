/*escriba un programa que almacene en arreglos ordenados el nombre y el salario de un grupo de empleados
y realice las siguientes operaciones 1-Dar de alta un empleado 2-Dar de baja 3-Modificar el salario 4-
Imprimir un registro determinado 5-Imprimir todos los registro 6- Salir*/

import javax.swing.*;

public class programa{
    public static void main(String args[]){
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de empleados: "));
        String[] nombre = new String[tam];
        int [] salario = new int[tam];
        int opc ,  n = -1;
        

        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("1-Dar de alta a un empleado\n 2-Dar de baja a un empleado\n 3-Modificar el salario de un empleado\n 4-Imprimir el registro de un empleado determinado\n 5-Imprimir todos los registros\n 6-Salir\n"));
            switch(opc){
                case 1:
                    n= IngresaEmpleado(nombre, salario, n, tam);
                    break;
                case 2:
                    n = EliminaEmpleado(nombre, salario, n, tam);
                    break;
                case 3:
                    modificarVentas(nombre, salario, n, tam); 
                    break;
                case 4:
                    n = ImprimirUnRegistro(nombre, salario, n);
                    break;
                case 5:
                    n = ImprimirTodosRegistros(nombre, salario, n);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                 
            }
        }while(opc != 6);
    }
    
    public static int buscarEmpleado(String nombre[], int n, String nombreB){
        String buscar = JOptionPane.showInputDialog("Ingrese el nombre del empleado a buscar: ");
        int i = 0;
        while((i <= n) && (nombre[i].compareTo(nombreB) < 0)){
            i++;
        }7uj
        if((i > n) || (nombre[i].compareTo(nombreB) > 0))
        {
            return -i;
        }else{
            return i;
        }   
    }

    public static int IngresaEmpleado(String nombre[], int salario[], int n, int tam){
        if (n == -1)
        {
            n++;
            nombre[n] = JOptionPane.showInputDialog("Ingrese nombre del empleado");
            salario[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese salario"));

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
                salario[i] = salario[i-1];
            }
            nombre[pos] = nombreB;
            salario[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario"));
            
            
          }
            
        }else{
            JOptionPane.showMessageDialog(null, "No hay espacio para mas empleados");
        }
       return n;
    }
    
    public static int EliminaEmpleado(String nombre[],int salario[], int tam, int n){
        if(n > -1){
            String nombreB = JOptionPane.showInputDialog("Ingrese nombre del empleado");
            int pos = buscarEmpleado(nombre, n, nombreB);
            if((pos <= 0) && (nombre[0].compareTo(nombreB) != 0)){
                JOptionPane.showMessageDialog(null, "no existe");
            }else{
                n--;
                for(int i = pos; i <= n; i++){
                    nombre[i] = nombre[i + 1];
                    salario[i] = salario[i + 1];
                }
            }
        }else{ 
            JOptionPane.showMessageDialog(null, "Array vacío");
        }
        return n;
    }

   public static void modificarVentas(String nombre[], int salario[], int n, int tam){
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
				salario[pos]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva venta para el vendendor "+nombre[pos]));
				JOptionPane.showMessageDialog(null, "Modificacion realizada");
			}
		}		
		else{ 
			JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }
    public static int ImprimirUnRegistro(String nombre[], int salario[], int n){
        if(n > -1){
            String nombreB = JOptionPane.showInputDialog("Ingrese nombre del empleado");
            int pos = buscarEmpleado(nombre, n, nombreB);
            if((pos <= 0) && (nombre[0].compareTo(nombreB) != 0)){
                JOptionPane.showMessageDialog(null, "no existe");
            }else{
                JOptionPane.showMessageDialog(null, "Nombre: " + nombre[pos] + "\nSalario: " + salario[pos]);
            }
        }else{ 
            JOptionPane.showMessageDialog(null, "Array vacío");
        }
        return n;
    }

    public static int ImprimirTodosRegistros(String nombre[], int salario[], int n){
        if(n > -1){
            String sal = "Registros de empleados:\n";

            for(int i = 0; i <= n; i++){
                sal += "Nombre: " + nombre[i] + "\t Salario: " + salario[i] + "\n";
            }
            JTextArea imp = new JTextArea();
            imp.setText(sal);
            imp.setEditable(false);
            JOptionPane.showMessageDialog(null, imp);
        }else{
            JOptionPane.showMessageDialog(null, "Array vacío");
        }
        return n;
    }
}