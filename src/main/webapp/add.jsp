<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String appPath = request.getContextPath();
%>


<form role="form" id="add" method="post" action="<%=appPath%>/book/add" accept-charset="utf-8">
                <div class="form-group">
                    <label>图书ID</label><input class="form-control" name="bookId"/>
                </div>
                <div class="form-group">
                    <label>图书名字</label><input class="form-control" name="name"/>
                </div>
                <div class="form-group">
                    <label>图书描述</label><input class="form-control" name="detail"/>
                </div>
                <div class="form-group">
                    <label>图书数量</label><input class="form-control" name="number"/>
                </div>
                <input type="submit" value="Submit">
            </form>