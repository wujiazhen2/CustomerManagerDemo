package com.qworldr.customer.controller;

import com.qworldr.customer.bean.CustomerEntitiy;
import com.qworldr.customer.service.CustomerService;
import com.qworldr.customer.query.QueryParam;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wujiazhen
 * @Date 2019/2/2
 */
@RestController
@RequiresUser
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/save")
    public ResponseEntity<Integer> saveCustomer(@RequestBody CustomerEntitiy customerEntitiy) {
        customerService.save(customerEntitiy);
        return ResponseEntity.ok(customerEntitiy.getId());
    }
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody CustomerEntitiy customerEntitiy) {
        customerService.update(customerEntitiy);
        return ResponseEntity.ok().build();
    }
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody ArrayList<Integer> id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/list")
    public ResponseEntity<List<CustomerEntitiy>> list(@RequestBody QueryParam queryParam) {
        List<CustomerEntitiy> list = customerService.list(queryParam);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerEntitiy> get(@PathVariable int id) {
        CustomerEntitiy customerEntitiy = customerService.get(id);
        return ResponseEntity.ok(customerEntitiy);
    }
    @RequiresPermissions("admin")
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<CustomerEntitiy> list = this.customerService.list(new QueryParam());
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("客户信息");
        HSSFRow row = sheet.createRow(0);
        int i=0;
        HSSFCell cell = row.createCell(i++, CellType.STRING);
        cell.setCellValue("编号");
        cell = row.createCell(i++, CellType.STRING);
        cell.setCellValue("姓名");
        cell = row.createCell(i++, CellType.STRING);
        cell.setCellValue("电话");
        cell = row.createCell(i++, CellType.STRING);
        cell.setCellValue("地址");
        cell = row.createCell(i++, CellType.STRING);
        cell.setCellValue("需求");
        int j=1;
        for (CustomerEntitiy customerEntitiy : list) {
            i=0;
            row = sheet.createRow(j);
            cell = row.createCell(i++, CellType.NUMERIC);
            cell.setCellValue(j++);
            cell = row.createCell(i++, CellType.STRING);
            cell.setCellValue(customerEntitiy.getName());
            cell = row.createCell(i++, CellType.STRING);
            cell.setCellValue(customerEntitiy.getPhone());
            cell = row.createCell(i++, CellType.STRING);
            cell.setCellValue(customerEntitiy.getAddress());
            cell = row.createCell(i++, CellType.STRING);
            cell.setCellValue(customerEntitiy.getDescription());
        }
        // 配置文件下载
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 下载文件能正常显示中文
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("客户信息.xls", "UTF-8"));
        workbook.write(response.getOutputStream());
    }
}
