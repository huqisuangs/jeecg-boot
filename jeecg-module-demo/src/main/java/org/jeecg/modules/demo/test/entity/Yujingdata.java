package org.jeecg.modules.demo.test.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 预警数据
 * @Author: jeecg-boot
 * @Date:   2023-01-17
 * @Version: V1.0
 */
@Data
@TableName("yujingdata")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="yujingdata对象", description="预警数据")
public class Yujingdata implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**时间*/
	@Excel(name = "时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "时间")
    private java.util.Date datatime;
	/**风速*/
	@Excel(name = "风速", width = 15)
    @ApiModelProperty(value = "风速")
    private java.lang.Double fengsu;
	/**风向*/
	@Excel(name = "风向", width = 15)
    @ApiModelProperty(value = "风向")
    private java.lang.Double fengxiang;
	/**温度*/
	@Excel(name = "温度", width = 15)
    @ApiModelProperty(value = "温度")
    private java.lang.Double wendu;
	/**湿度*/
	@Excel(name = "湿度", width = 15)
    @ApiModelProperty(value = "湿度")
    private java.lang.Double shidu;
}
