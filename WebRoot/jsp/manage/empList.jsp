<%@page import="com.kexun.wm.untils.AllSelectItemUtil"%>
<%@page contentType="application/xml;charset=GBK" import="java.util.List" import="com.kexun.wm.manage.bean.Emp"%><%  
   out.println("[");
   String rubId=request.getParameter("id");
   int id=Integer.parseInt(rubId);
   List<Emp> empList=null;
   if(id==0){
     empList =AllSelectItemUtil.queryEmp();
   }else{
     empList =AllSelectItemUtil.queryEmp(Integer.parseInt(rubId));
   }
   if(empList!=null){
     out.print("{id:"+empList.get(0).getId()+",name:\""+empList.get(0).getEname()+"\"}");
   }
   for(int i=1;i<empList.size();i++){
	 out.print(",{id:"+empList.get(i).getId()+",name:\""+empList.get(i).getEname()+"\"}");
   }
   out.println("]");
%>

