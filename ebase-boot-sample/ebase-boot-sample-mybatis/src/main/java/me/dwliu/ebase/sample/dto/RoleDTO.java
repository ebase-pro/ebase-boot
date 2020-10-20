package me.dwliu.ebase.sample.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import me.dwliu.framework.core.mybatis.dto.BaseDTO;

import java.io.Serializable;

/**
 * 角色管理
 *
 * @author eric
 * @since 1.0.0
 */
@Data
@ApiModel(value = "角色管理")
public class RoleDTO extends BaseDTO {

	private Long id;
	private String rolename;

}
