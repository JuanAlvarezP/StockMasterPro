package com.yourcompany.stockmasterpro.run;

import org.openxava.util.*;

/**
 * Ejecuta esta clase para arrancar la aplicación.
 *
 * Con OpenXava Studio/Eclipse: Botón derecho del ratón > Run As > Java Application
 */

public class stockmasterpro {

	public static void main(String[] args) throws Exception {
		DBServer.start("stockmasterpro-db"); // Para usar tu propia base de datos comenta esta línea y configura src/main/webapp/META-INF/context.xml
		AppServer.run("stockmasterpro"); // Usa AppServer.run("") para funcionar en el contexto raíz
	}

}
