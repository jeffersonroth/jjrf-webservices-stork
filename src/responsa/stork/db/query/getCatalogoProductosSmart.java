package responsa.stork.db.query;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

import responsa.stork.db.DbContract;
import responsa.stork.db.PostgresHelper;

public class getCatalogoProductosSmart {

private static final String SQL_FILE = "/getCatalogoProductosSmart.sql";
	
	private static String _RESPONSE = null;
	private static Integer whileFlag = 0;
	
	public static String main(String codSmart) {
		
		PostgresHelper client = new PostgresHelper(
				DbContract.HOST, 
				DbContract.DB_NAME,
				DbContract.USERNAME,
				DbContract.PASSWORD);
		
		ArrayList<String> queries_01 = null;
		String pathname_01;
		
		//... get queries from sql file .................
		try {
			ClassLoader cl = getCatalogoProductosSmart.class.getClassLoader();
			URL pathURL = cl.getResource(SQL_FILE);
			System.out.println("pathURL: " + pathURL.getPath().toString());
			pathname_01 = pathURL.getPath().toString();
			queries_01 = SQLReader.createQueries(pathname_01);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//.getResourceAsStream("src/responsa/stork/db/query/getCatalogoProductosSmart.sql");
			 
		ArrayList<ResultSet> RSList_01 = new ArrayList<ResultSet>();
		for(String query: queries_01) {
			try {
				RSList_01.add(client.execQuery(query));
				StringBuilder sb = new StringBuilder();
				for (ResultSet s : RSList_01)
				{
				    sb.append(s);
				    sb.append("\t");
				}
				System.out.println("getCatalogoProductosSmart.java RSList_01:  " + sb.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		try {
			ResultSet tmpRS = RSList_01.get(0);
			System.out.println("getCatalogoProductosSmart.java tmpRS.getString(\"c_cod_smart\"):  " + tmpRS.getString("c_cod_smart"));
			if(!tmpRS.isClosed()) {
				System.out.println("tpmRS is not closed!");
				while ( tmpRS.next() ) {
					whileFlag++;
					if(tmpRS.getString("c_cod_smart").equals(codSmart)) {
						System.out.println("getCatalogoProductosSmart.java tmpRS.getString(" + tmpRS.getString("c_cod_smart") + ") found");
						String c_cod_smart = tmpRS.getString("c_cod_smart");
						String datemodified = tmpRS.getTimestamp("datemodified").toString();
						String c_id_categoria = tmpRS.getString("c_id_categoria");
						String c_dec_ele = tmpRS.getString("c_dec_ele");
						String c_mantenimiento = tmpRS.getString("c_mantenimiento");
						String c_id_clase = tmpRS.getString("c_id_clase");
						String c_del_ele = tmpRS.getString("c_del_ele");
						String c_id_pro = tmpRS.getString("c_id_pro");
						String c_des_servicio = tmpRS.getString("c_des_servicio");
						String c_inventario = tmpRS.getString("c_inventario");
						String c_unidad_inventario = tmpRS.getString("c_unidad_inventario");
						String c_id_fabricante = tmpRS.getString("c_id_fabricante");
						String c_supercedido = tmpRS.getString("c_supercedido");
						String c_id_seg = tmpRS.getString("c_id_seg");
						String c_modelo = tmpRS.getString("c_modelo");
						String c_id_cla = tmpRS.getString("c_id_cla");
						String c_id_fam = tmpRS.getString("c_id_fam");
						String c_part_number = tmpRS.getString("c_part_number");
						String c_rfid = tmpRS.getString("c_rfid");
						String c_status = tmpRS.getString("c_status");
						
						JSONObject CatalogoProductoSmart = new JSONObject();
						
						CatalogoProductoSmart.put("c_cod_smart", c_cod_smart);
						CatalogoProductoSmart.put("datemodified", datemodified);
						CatalogoProductoSmart.put("c_id_categoria", c_id_categoria);
						CatalogoProductoSmart.put("c_dec_ele", c_dec_ele);
						CatalogoProductoSmart.put("c_mantenimiento", c_mantenimiento);
						CatalogoProductoSmart.put("c_id_clase", c_id_clase);
						CatalogoProductoSmart.put("c_del_ele", c_del_ele);
						CatalogoProductoSmart.put("c_id_pro", c_id_pro);
						CatalogoProductoSmart.put("c_des_servicio", c_des_servicio);
						CatalogoProductoSmart.put("c_inventario", c_inventario);
						CatalogoProductoSmart.put("c_unidad_inventario", c_unidad_inventario);
						CatalogoProductoSmart.put("c_id_fabricante", c_id_fabricante);
						CatalogoProductoSmart.put("c_supercedido", c_supercedido);
						CatalogoProductoSmart.put("c_id_seg", c_id_seg);
						CatalogoProductoSmart.put("c_modelo", c_modelo);
						CatalogoProductoSmart.put("c_id_cla", c_id_cla);
						CatalogoProductoSmart.put("c_id_fam", c_id_fam);
						CatalogoProductoSmart.put("c_part_number", c_part_number);
						CatalogoProductoSmart.put("c_rfid", c_rfid);
						CatalogoProductoSmart.put("c_status", c_status);
						
						_RESPONSE = CatalogoProductoSmart.toString();
						
						c_cod_smart = null;
						datemodified = null;
						c_id_categoria = null;
						c_dec_ele = null;
						c_mantenimiento = null;
						c_id_clase = null;
						c_del_ele = null;
						c_id_pro = null;
						c_des_servicio = null;
						c_inventario = null;
						c_unidad_inventario = null;
						c_id_fabricante = null;
						c_supercedido = null;
						c_id_seg = null;
						c_modelo = null;
						c_id_cla = null;
						c_id_fam = null;
						c_part_number = null;
						c_rfid = null;
						c_status = null;
						
						break;
						
					}
				 }
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("getCatalogoProductosSmart.java whileFlag: " + whileFlag);
		System.out.println("getCatalogoProductosSmart.java _RESPONSE: " + _RESPONSE);
		return _RESPONSE;
		
	}
	
}
