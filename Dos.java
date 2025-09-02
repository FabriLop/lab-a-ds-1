/*Una empresa registra para cada uno de sus clientes los siguientes datos: Nombre,
Teléfono, Saldo, Moroso (verdadero o falso). Escriba un programa que pueda proporcionar
la siguiente información:
1. Dar de alta a un cliente
2. Modificar el estado moroso del cliente
3. Dar de baja a un cliente.
4. Listar la información completa de un cliente determinado
5. Listar la información de todos los clientes.
6. Salir */

import javax.swing.*;

public class Dos{
    public static void main(String args[]){
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de empleados: "));
        String[] nombre = new String[tam];
        int [] salario = new int[tam];
        int[] telefono = new int[tam];
        boolean[] moroso = new boolean[tam];
        int opc , n = -1;

        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("1. Dar de alta a un empleado\n2. Modificar el estado moroso del empleado\n3. Dar de baja a un empleado\n4. Listar la informacion completa de un empleado determinado\n5. Listar la informacion de todos los empleados\n6. Salir"));
            switch(opc){ 
                case 1:
                    n = IngresaEmpleado(nombre, salario, telefono, moroso, n, tam);
                    break;
                case 2:
                    modificaMoroso(nombre, moroso, n, tam);
                    break;
                case 3:
                    n = EliminaEmpleado(nombre, salario, telefono, moroso, n, tam);
                    break;
                case 4:
                    n = ImprimirUnRegistro(nombre, salario, telefono, moroso, n);
                case 5:
                    n = ImprimirTodosRegistros(nombre, salario, telefono, moroso, n);
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

    public static int IngresaEmpleado(String[] nombre, int[] salario,int[] telefono, boolean[] moroso, int n, int tam){
        if(n < (tam - 1)){
             n++;
            String nom = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
            int sal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario del empleado: "));
            int tel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del empleado: "));
            boolean mor = Boolean.parseBoolean(JOptionPane.showInputDialog("El empleado es moroso? (true/false): "));

           
            nombre[n] = nom;
            salario[n] = sal;
            telefono[n] = tel;
            moroso[n] = mor;
        }
        return n;

    }
    public static int EliminaEmpleado(String[] nombre, int[] salario,int[] telefono, boolean[] moroso, int n, int tam){
        int i = -1;
        String nom = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
        do{
            i++;
        }while((i <= n) && (nombre[i].compareTo(nom) < 0));

        if(i > n ){
            JOptionPane.showMessageDialog(null, "El empleado no existe");
        }else{
            for(int j = i; j < n; j++){
                nombre[j] = nombre[j + 1];
                salario[j] = salario[j + 1];
                telefono[j] = telefono[j + 1];
                moroso[j] = moroso[j + 1];
            }
            n--;
        }
        return n;
    }

    public static void modificaMoroso(String[] nombre, boolean[] moroso, int n, int tam){
        String nombreB = JOptionPane.showInputDialog("Ingrese el nombre del empleado a modificar: ");

        int i = -1;
        do{
            i++;
        }while((i <= n) && (nombre[i].compareTo(nombreB) < 0));

        if((i > n) || (nombre[i].compareTo(nombreB) > 0)){
            JOptionPane.showMessageDialog(null, "El empleado no existe");
        }else{
            boolean mor = Boolean.parseBoolean(JOptionPane.showInputDialog("El empleado es moroso? (true/false): "));
            moroso[i] = mor;
        }
    }

    public static int ImprimirUnRegistro(String[] nombre, int[] salario,int[] telefono, boolean[] moroso, int n){
        String nombreB = JOptionPane.showInputDialog("Ingrese el nombre del empleado a buscar: ");
        int i = 0;
        while((i <= n) && (nombre[i].compareTo(nombreB) < 0)){
            i++;
        }

        if((i > n) || (nombre[i].compareTo(nombreB) > 0))
        {
            JOptionPane.showMessageDialog(null, "El empleado no existe");
        }else{
            JOptionPane.showMessageDialog(null, "Nombre: " + nombre[i] + "\nSalario: " + salario[i] + "\nTelefono: " + telefono[i] + "\nMoroso: " + moroso[i]);
        }
        return n;
    }

    public static int ImprimirTodosRegistros(String[] nombre, int[] salario,int[] telefono, boolean[] moroso, int n){
        String sal = "Registros de empleados:\n";
        for(int i = 0; i <= n; i++){
            sal += "Nombre: " + nombre[i] + "\tSalario: " + salario[i] + "\tTelefono: " + telefono[i] + "\tMoroso: " + moroso[i] + "\n\n";
        }
        JTextArea imp = new JTextArea();
        imp.setText(sal);
        imp.setEditable(false);
        JOptionPane.showMessageDialog(null, imp);
        return n;
    }
   
}