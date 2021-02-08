<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<script type="text/javascript">
    $(function (){
        $("#feedbackTable").jqGrid({
            url : "${path}/feedback/queryAll",
            datatype : "json",
            rowNum : 3,
            rowList : [ 1,3, 10, 20, 30 ],
            pager : '#feedbackPage',
            viewrecords : true,
            styleUI:"Bootstrap",
            autowidth:true,
            height:"auto",
            colNames : [ 'Id', '标题','内容', '用户Id', '上传时间' ],
            colModel : [
                {name : 'id',index : 'id',  width : 55},
                {name : 'title',index : 'invdate',width : 90},
                {name:'content',width : 90},
                {name : 'userId'},
                {name : 'createTime'}
            ]
        });
    })
</script>

<table id="feedbackTable"></table>
<div id="feedbackPage"></div>
