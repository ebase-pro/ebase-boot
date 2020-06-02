package me.dwliu.framework.core.mybatis.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户表默认实体
 *
 * @author liudw
 * @date 2019-06-22 10:44
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseTenantDO extends BaseDO {

	/**
	 * 租户编号
	 */
	private String tenantId;

}
