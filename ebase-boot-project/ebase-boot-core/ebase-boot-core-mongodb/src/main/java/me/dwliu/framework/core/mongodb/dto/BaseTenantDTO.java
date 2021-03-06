package me.dwliu.framework.core.mongodb.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liudw
 * @date 2019-08-26 15:15
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseTenantDTO extends BaseDTO {

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    private String tenantCode;

}
