package me.dwliu.framework.common.node;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树节点，所有需要实现树节点的，都需要继承该类
 *
 * @author eric
 * @since 1.0.0
 */
@Data
@ApiModel(value = "树形节点")
public class TreeNode<T> implements Serializable {
	@ApiModelProperty(value = "当前节点id")
	protected Long id;
	@ApiModelProperty(value = "父节点id")
	protected Long pid;
	@ApiModelProperty(value = "子节点列表")
	protected List<TreeNode<T>> children = new ArrayList<>();

	public void add(TreeNode<T> node) {
		children.add(node);
	}
}
