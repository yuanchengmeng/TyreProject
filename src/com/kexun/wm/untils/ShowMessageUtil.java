package com.kexun.wm.untils;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class ShowMessageUtil {
	public static void showErrorName() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("error",
				"<script>alert('用户名输入错误 ,请重新输入！');</script>");
	}
	
	public static void showErrorJobNo() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("error",
				"<script>alert('工号不存在 ,请重新输入！');</script>");
	}

	public static void showModifyAlery() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success",
				"<script>alert('已经修改过了，不能修改！');</script>");
	}

	public static void showErrorVerifyCode() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("error",
				"<script>alert('验证码输入错误 ,请重新输入！');</script>");
	}

	public static void showAddRepeat() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success",
				"<script>alert('该记录已存在!!');</script>");
	}
	
	public static void showRepeatName() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success",
				"<script>alert('规格加速度级层、花纹不能重复!!');</script>");
	}
	
	public static void showRepeatCode() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success",
				"<script>alert('代码不能重复!!');</script>");
	}
	
	public static void showRepeatMessage() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success",
				"<script>alert('品牌或代码不能重复!!');</script>");
	}

	public static void showErrorPwd() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("error",
				"<script>alert('密码输入错误,请重新输入！');</script>");
	}

	public static void showPwdModify() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('密码修改成功！');</script>");
	}

	public static void showErrorUser() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("error", "<script>alert('该用户无权限进入该系统！');</script>");
	}

	public static void showExistSuccess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('该工号已经存在了，不能重复！');</script>");
	}

	public static void showModifySuccess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('修改成功！');</script>");
	}

	public static void showInBackSuccess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('入库成功！');</script>");
	}

	public static void showoutBackSuccess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('出库成功！');</script>");
	}

	public static void showActionFalse() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("unsuccess", "<script>alert('操作失败！');</script>");
	}
	
	public static void showActionSuccess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('操作成功！');</script>");
	}

	public static void showModifyFalse() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("unsuccess", "<script>alert('修改失败！');</script>");
	}

	public static void showAddSuccess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('添加成功！');</script>");
	}

	public static void showAddFalse() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("unsuccess", "<script>alert('添加失败！');</script>");
	}

	public static void showAddRedo() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('改员工信息已存在！');</script>");
	}

	public static void showDeleteSuccess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('删除成功！');</script>");
	}

	public static void showNotDelete() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success",
				"<script>alert('存在已使用的选项，无法删除！');</script>");
	}

	public static void showDeleteFalse() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("unsuccess", "<script>alert('删除失败！');</script>");
	}

	public static void showMaxLength() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("unsuccess", "<script>alert('上传文件太大！');</script>");
	}

	public static void showNotExist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success",
				"<script>alert('库存没有此条码的轮胎！');</script>");
	}

	public static void showExist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success",
				"<script>alert('库存中已存在此条码的轮胎！');</script>");
	}

	public static void showCodeName() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("error",
				"<script>alert('该销售编号已经存在,请重新输入！');</script>");
	}

	public static void showCheckSuccess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('审核订单成功！');</script>");
	}

	public static void showCheckFalure() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('撤单成功！');</script>");
	}

	public static void showExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('excel导出成功！');</script>");
	}
	
	public static void showMessageLess() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('所有选项都要填写！！');</script>");
	}
	
	public static void showMessageLength() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("success", "<script>alert('请填写4位工号！！');</script>");
	}
}

