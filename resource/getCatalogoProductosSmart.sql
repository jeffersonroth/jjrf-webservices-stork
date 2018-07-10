SELECT c_cod_smart, datemodified, c_id_categoria, c_dec_ele, c_mantenimiento, c_id_clase, c_del_ele, c_id_pro, c_des_servicio, c_inventario, c_unidad_inventario, c_id_fabricante, c_supercedido, c_id_seg, c_modelo, c_id_cla,  c_id_fam, c_part_number, c_rfid, c_status
FROM public.app_fd_assetmgnt_dom_ele
WHERE c_status='aprobado';