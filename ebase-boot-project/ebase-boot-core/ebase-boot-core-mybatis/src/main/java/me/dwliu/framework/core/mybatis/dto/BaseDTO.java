package me.dwliu.framework.core.mybatis.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liudw
 * @date 2019-08-26 15:15
 **/
@Data
public abstract class BaseDTO implements Serializable {

//    /**
//     * 主键id
//     */
//    @ApiModelProperty(value = "主键id")
//    @NotNull(message = "主键不能为空", groups = UpdateGroup.class)
//    @Null(message = "主键必须为空", groups = CreateGroup.class)
//    private Long id;

	//    /**
//     * 状态[1:正常]
//     */
//    @ApiModelProperty(value = "业务状态")
//    private Integer status;

//    /**
//     * 创建部门
//     */
    //@JsonSerialize(using = ToStringSerializer.class)
//    @ApiModelProperty(value = "创建部门")
//    private Long createDept;

    @ApiModelProperty(value = "创建人")
	private String createBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新人")
	private String updateBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

	@ApiModelProperty(value = "是否已删除")
	private Integer delFlag;

    @ApiModelProperty(value = "乐观锁")
    private Integer revision;
}
