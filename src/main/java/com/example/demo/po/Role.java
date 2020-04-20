package com.example.demo.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.example.demo.po.base.DataEntity;

import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangl
 * @since 2017-10-31
 */
@TableName("sys_role")
public class Role extends DataEntity<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
	private String name;

	/**
	 * 商户编号
	 */
	@TableField("merchant_code")
	private String merchantCode;

	@TableField(exist = false)
	private Set<Menu> menuSet;

	@TableField(exist = false)
	private Set<User> userSet;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Set<Menu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
}
