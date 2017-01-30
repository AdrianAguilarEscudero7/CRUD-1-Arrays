/**
 * Trabajo CRUD Programación-Sistemas Informáticos - vArray
 *
 * @author Adrián Aguilar
 */
 import java.util.Scanner;

public class TrabajoCRUDvArray {
  
  // Programa Principal ////////////////////////////////////////////////////////////////////////////
  
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Scanner m = new Scanner(System.in);
    Scanner mod = new Scanner(System.in);
    Scanner c = new Scanner(System.in);
    Scanner t = new Scanner(System.in);
    Scanner p = new Scanner(System.in);
    Scanner sp = new Scanner(System.in);
    Scanner volver = new Scanner(System.in);
    
    System.out.println("\nGestión de hardware - Teclados");
    System.out.println("-----------------------------------------------------------------------------");
    
    String[] marca = new String[10];
    String[] modelo = new String[10];
    String[] conect= new String[10];
    String[] tipo = new String[10];
    float[] precio = new float[10];  
    
    // Se inicializan 3 teclados por defecto
    for (int i = 0; i < 10; i++) {
      marca[0] = "Razer";
      marca[1] = "Corsair";
      marca[2] = "Logitech";
      if (i > 2) {
        marca[i] = "Vacío";
      }
    }
    for (int i = 0; i < 10; i++) {
      modelo[0] = "Blackwidow Chroma";
      modelo[1] = "K95";
      modelo[2] = "MK710";
      if (i > 2) {
        modelo[i] = "Vacío";
      }
    }
    for (int i = 0; i < 10; i++) {
      conect[0] = "Cable";
      conect[1] = "Cable";
      conect[2] = "Wireless";
      if (i > 2) {
        conect[i] = "Vacío";
      }
    }
    for (int i = 0; i < 10; i++) {
      tipo[0] = "Mecánico";
      tipo[1] = "Mecánico";
      tipo[2] = "Membrana";
      if (i > 2) {
        tipo[i] = "Vacío";
      }
    }
    for (int i = 0; i < 10; i++) {
      precio[0] = 164;
      precio[1] = 199;
      precio[2] = 79;
      if (i > 2) {
        precio[i] = 0;
      }
    }
    
    int opcionMenu = 0;
    
    // Se selecciona una opción del menú validando la opción introducida
    do {
      do {
        System.out.println("\n1.- Listado.");
        System.out.println("2.- Nuevo artículo.");
        System.out.println("3.- Editar.");
        System.out.println("4.- Borrar.");
        System.out.println("5.- Salir.");
        System.out.print("\nPor favor, seleccione una opción del menú: ");
        opcionMenu = s.nextInt();
        if ((opcionMenu < 1) || (opcionMenu > 5)) {
          System.out.println("\nHa de seleccionar una opción del menú... (1-5).");
        }
      } while ((opcionMenu < 1) || (opcionMenu > 5));
      switch (opcionMenu) {
        // Se muestra el listado mediante la función muestraListado
        case 1:
          muestraListado(marca,modelo,conect,tipo,precio);
        break;
        // Se añaden artículos nuevos mediante la función añadeArticulo
        case 2:
          int otroArticulo;
          do {
            System.out.print("\nIntroduzca la marca del teclado: ");
            String sMarca = m.nextLine();
            System.out.print("\nIntroduzca el modelo del teclado: ");
            String sModelo = mod.nextLine();
            System.out.print("\nIntroduzca la conectividad del teclado: ");
            String sConect = c.nextLine();
            System.out.print("\nIntroduzca el tipo de teclado: ");
            String sTipo = t.nextLine();
            System.out.print("\nIntroduzca el precio del teclado: ");
            float fPrecio = p.nextInt();
            añadeArticulo(marca,modelo,conect,tipo,precio,sMarca,sModelo,sConect,sTipo,fPrecio);
            
            System.out.println("---------------------------------------------------------------------");
            System.out.print("\nPulse 1 para añadir otro artículo, o, cualquier otro número para salir: ");
            otroArticulo = s.nextInt();
          } while (otroArticulo == 1);
        break;
        case 3:
          String intro = "";
          boolean salir;
          int editarOtro;
          // Muestra el listado con números a los laterales para contar las filas
          muestraListadoEdit(marca,modelo,conect,tipo,precio);
          // Se selecciona la fila a editar y se va editando campo por campo o dejando igual 
          do {
            salir = false;
            System.out.print("\nSeleccione el número de fila que desea editar: ");
            int editFila = s.nextInt();
            if (marca[editFila-1].equals("Vacío")) {
              System.out.println("\n¡En esa fila no hay ningún artículo!, por favor, añada uno nuevo.");
            } else {
              for (int i = 1; i <= 10 && !salir; i++) {
                if (i == editFila) {
                  System.out.print("\nIntroduzca la nueva marca de teclado (pulse [Intro] para dejar igual): ");
                  String sMarca = m.nextLine();
                  if (!sMarca.equals(intro)) {
                    marca[i-1] = sMarca;
                  } else {
                    System.out.print("\nIntroduzca el nuevo modelo de teclado (pulse [Intro] para dejar igual): ");
                    String sModelo = mod.nextLine();
                    if (!sModelo.equals(intro)) {
                      modelo[i-1] = sModelo;
                    } else {
                      System.out.print("\nIntroduzca la nueva conectividad del teclado (pulse [Intro] para dejar igual): ");
                      String sConect = c.nextLine();
                      if (!sConect.equals(intro)) {
                        conect[i-1] = sConect;
                      } else {
                        System.out.print("\nIntroduzca el nuevo tipo de teclado (pulse [Intro] para dejar igual): ");
                        String sTipo = t.nextLine();
                        if (!sTipo.equals(intro)) {
                          tipo[i-1] = sTipo;
                        } else {
                          System.out.print("\nIntroduzca el nuevo precio del teclado (pulse [Intro] para dejar igual): ");
                          String sPrecio = sp.nextLine();
                          if (!sPrecio.equals(intro)) {
                            precio[i-1] = Float.parseFloat(sPrecio);
                          } else {
                          }
                        }
                      }
                    }
                  }
                  salir = true;
                }
              }
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.print("\nPulse 1 para editar otro artículo, o, cualquier otro número para salir: ");
            editarOtro = s.nextInt();
          } while (editarOtro == 1);
          break;
          case 4:
            boolean salir2;
            int borrarOtro;
            // Muestra el listado con números a los laterales para contar las filas
            muestraListadoEdit(marca,modelo,conect,tipo,precio);
            // Borra la fila seleccionada
            do {
              salir2 = false;
              System.out.print("\nSeleccione el número de fila que desea borrar: ");
              int borrarFila = s.nextInt();
              for (int i = 1; i <= 10 && !salir2; i++) {
                if (i == borrarFila) {
                  marca[i-1] = "Vacío";
                  modelo[i-1] = "Vacío";
                  conect[i-1] = "Vacío";
                  tipo[i-1] = "Vacío";
                  precio[i-1] = 0;
                  salir2 = true;
                }
              }
              System.out.println("---------------------------------------------------------------------");
              System.out.print("\nPulse 1 para borrar otro artículo, o, cualquier otro número para salir: ");
              borrarOtro = s.nextInt();
            } while (borrarOtro == 1);
          break;
        default:
      }
      // Vuelve al menú de nuevo si la opción seleccionada es distinta a 5 (salir)
      if (opcionMenu != 5) {
          System.out.print("\nPulse [Intro] para volver al menú.");
          volver.nextLine();
      } else {
        System.out.println("\n¡Hasta pronto!.");
      }
    } while (opcionMenu != 5); // Repite el proceso mientras la opción del menú seleccionada sea distinta a 5 (salir)
  }
  
// Funciones ///////////////////////////////////////////////////////////////////////////////////////

  /**
   * Muestra el listado
   *
   * @param m la marca del teclado
   * @param mod el modelo del teclado
   * @param c la conectividad del teclado
   * @param t el tipo del teclado
   * @param p el precio del teclado
   */
  public static void muestraListado(String[] m, String[] mod, String[] c, String[] t, float[] p) {
    System.out.println("\n┌────────────────────┬────────────────────┬────────────────────┬────────────────────┬────────────────────┐");
    System.out.printf("│%12s        │%13s       │%16s    │%12s        │%12s        │", "MARCA","MODELO","CONECTIVIDAD","TIPO","PRECIO");
    for (int i = 0; i < m.length; i++) {
      if (m[i].equals("Vacío")) {
      } else {
        System.out.printf("\n├────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┤");
        System.out.printf("\n│%-20s│%-20s│%-20s│%-20s│%6.2f              │", m[i],mod[i],c[i],t[i],p[i]);
      }
    }
    System.out.print("\n└────────────────────┴────────────────────┴────────────────────┴────────────────────┴────────────────────┘");
  }
  
  /**
   * Muestra el listado para editar
   *
   * @param m la marca del teclado
   * @param mod el modelo del teclado
   * @param c la conectividad del teclado
   * @param t el tipo del teclado
   * @param p el precio del teclado
   */
  public static void muestraListadoEdit(String[] m, String[] mod, String[] c, String[] t, float[] p) {
    System.out.println("\n   ┌────────────────────┬────────────────────┬────────────────────┬────────────────────┬────────────────────┐");
    System.out.printf("   │%12s        │%13s       │%16s    │%12s        │%12s        │", "MARCA","MODELO","CONECTIVIDAD","TIPO","PRECIO");
    for (int i = 0; i < m.length; i++) {
      if (m[i].equals("Vacío")) {
      } else {
        System.out.printf("\n   ├────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┤");
        System.out.printf("\n %2d│%-20s│%-20s│%-20s│%-20s│%6.2f              │", (i+1),m[i],mod[i],c[i],t[i],p[i]);
      }
    }
    System.out.print("\n   └────────────────────┴────────────────────┴────────────────────┴────────────────────┴────────────────────┘");
  }
  
  /**
   * Añade un artículo
   *
   * @param m la marca del teclado
   * @param mod el modelo del teclado
   * @param c la conectividad del teclado
   * @param t el tipo del teclado
   * @param p el precio del teclado
   */
  public static void añadeArticulo(String[] m, String[] mod, String[] c, String[] t, 
    float[] p, String marca, String modelo, String conect, String tipo, float precio) {
    
    boolean salir = false;
    for (int i = 0; i < m.length && !salir; i++) {
      if (m[i].equals("Vacío")) {
        m[i] = marca;
        mod[i] = modelo;
        c[i] = conect;
        t[i] = tipo;
        p[i] = precio;
        salir = true;
      }
    }
  }
}

