package org.jeecg.modules.demo.test.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.test.entity.Yujingdata;
import org.jeecg.modules.demo.test.service.IYujingdataService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 预警数据
 * @Author: jeecg-boot
 * @Date:   2023-01-17
 * @Version: V1.0
 */
@Api(tags="预警数据")
@RestController
@RequestMapping("/test/yujingdata")
@Slf4j
public class YujingdataController extends JeecgController<Yujingdata, IYujingdataService> {
	@Autowired
	private IYujingdataService yujingdataService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yujingdata
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "预警数据-分页列表查询")
	@ApiOperation(value="预警数据-分页列表查询", notes="预警数据-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yujingdata>> queryPageList(Yujingdata yujingdata,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Yujingdata> queryWrapper = QueryGenerator.initQueryWrapper(yujingdata, req.getParameterMap());
		Page<Yujingdata> page = new Page<Yujingdata>(pageNo, pageSize);
		IPage<Yujingdata> pageList = yujingdataService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yujingdata
	 * @return
	 */
	@AutoLog(value = "预警数据-添加")
	@ApiOperation(value="预警数据-添加", notes="预警数据-添加")
	//@RequiresPermissions("test:yujingdata:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yujingdata yujingdata) {
		yujingdataService.save(yujingdata);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yujingdata
	 * @return
	 */
	@AutoLog(value = "预警数据-编辑")
	@ApiOperation(value="预警数据-编辑", notes="预警数据-编辑")
	//@RequiresPermissions("test:yujingdata:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yujingdata yujingdata) {
		yujingdataService.updateById(yujingdata);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "预警数据-通过id删除")
	@ApiOperation(value="预警数据-通过id删除", notes="预警数据-通过id删除")
	//@RequiresPermissions("test:yujingdata:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yujingdataService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "预警数据-批量删除")
	@ApiOperation(value="预警数据-批量删除", notes="预警数据-批量删除")
	//@RequiresPermissions("test:yujingdata:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yujingdataService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "预警数据-通过id查询")
	@ApiOperation(value="预警数据-通过id查询", notes="预警数据-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yujingdata> queryById(@RequestParam(name="id",required=true) String id) {
		Yujingdata yujingdata = yujingdataService.getById(id);
		if(yujingdata==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yujingdata);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yujingdata
    */
    //@RequiresPermissions("test:yujingdata:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yujingdata yujingdata) {
        return super.exportXls(request, yujingdata, Yujingdata.class, "预警数据");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("test:yujingdata:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yujingdata.class);
    }

}
