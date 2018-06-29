package com.jfinal.club.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public void setNickname(java.lang.String nickname) {
		set("nickname", nickname);
	}
	
	public java.lang.String getNickname() {
		return getStr("nickname");
	}

	public void setSex(java.lang.String sex) {
		set("sex", sex);
	}
	
	public java.lang.String getSex() {
		return getStr("sex");
	}

	public void setTel(java.lang.Integer tel) {
		set("tel", tel);
	}
	
	public java.lang.Integer getTel() {
		return getInt("tel");
	}

	public void setEmail(java.lang.String email) {
		set("email", email);
	}
	
	public java.lang.String getEmail() {
		return getStr("email");
	}

	public void setLoginDateTime(java.util.Date loginDateTime) {
		set("loginDateTime", loginDateTime);
	}
	
	public java.util.Date getLoginDateTime() {
		return get("loginDateTime");
	}

	public void setRoleId(java.lang.Integer roleId) {
		set("roleId", roleId);
	}
	
	public java.lang.Integer getRoleId() {
		return getInt("roleId");
	}

	public void setRoleName(java.lang.String roleName) {
		set("roleName", roleName);
	}
	
	public java.lang.String getRoleName() {
		return getStr("roleName");
	}

	public void setBankId(java.lang.Integer bankId) {
		set("bankId", bankId);
	}
	
	public java.lang.Integer getBankId() {
		return getInt("bankId");
	}

	public void setBankName(java.lang.String bankName) {
		set("bankName", bankName);
	}
	
	public java.lang.String getBankName() {
		return getStr("bankName");
	}

}