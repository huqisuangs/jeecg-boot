-- 注意：该页面对应的前台目录为views/test文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2023011709251370570', NULL, '预警数据', '/test/yujingdataList', 'test/YujingdataList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2023-01-17 21:25:57', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023011709251380571', '2023011709251370570', '添加预警数据', NULL, NULL, 0, NULL, NULL, 2, 'test:yujingdata:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-01-17 21:25:57', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023011709251380572', '2023011709251370570', '编辑预警数据', NULL, NULL, 0, NULL, NULL, 2, 'test:yujingdata:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-01-17 21:25:57', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023011709251380573', '2023011709251370570', '删除预警数据', NULL, NULL, 0, NULL, NULL, 2, 'test:yujingdata:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-01-17 21:25:57', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023011709251380574', '2023011709251370570', '批量删除预警数据', NULL, NULL, 0, NULL, NULL, 2, 'test:yujingdata:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-01-17 21:25:57', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023011709251380575', '2023011709251370570', '导出excel_预警数据', NULL, NULL, 0, NULL, NULL, 2, 'test:yujingdata:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-01-17 21:25:57', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023011709251380576', '2023011709251370570', '导入excel_预警数据', NULL, NULL, 0, NULL, NULL, 2, 'test:yujingdata:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-01-17 21:25:57', NULL, NULL, 0, 0, '1', 0);