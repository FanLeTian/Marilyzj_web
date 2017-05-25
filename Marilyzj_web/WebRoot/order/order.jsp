<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_jqgrid.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:02 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Marilyzj后台管理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="../css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="../css/font-awesome.min93e3.css" rel="stylesheet">

    <!-- jqgrid-->
    <link href="../css/plugins/jqgrid/ui.jqgridffe4.css" rel="stylesheet">

    <link href="../css/animate.min.css" rel="stylesheet">
    <link href="../css/style.min862f.css" rel="stylesheet">

    <style>
        /* Additional style to fix warning dialog position */

        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>订单管理</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="table_list_2"></table>
                            <div id=pager_list_2></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/plugins/peity/jquery.peity.min.js"></script>
    <script src="../js/plugins/jqgrid/i18n/grid.locale-cnffe4.js"></script>
    <script src="../js/plugins/jqgrid/jquery.jqGrid.minffe4.js"></script>
    <script src="../js/content.min.js"></script>
    <script>
     
        $(document).ready(function(){
        	$.jgrid.defaults.styleUI="Bootstrap";
        	$("#table_list_2").jqGrid({
        		url : "http://localhost:8080/Marilyzj/OrderServlet?method=getAll",
        		datatype : "json",height:450,autowidth:true,
        		shrinkToFit:true,
        		rowNum:20,
        		rowList:[10,20,30],
        		colNames:["订单号","订单名称","客户","金额","日期","订单状态","备注"],
        		colModel:[{name:"orderId",index:"orderId",editable:false,width:60,search:true,align:"center",sortable:false},
        		          {name:"orderName",index:"orderName",editable:false,width:90,align:"center",sortable:false},
        		          {name:"userName",index:"userName",editable:false,width:100,align:"center",sortable:false},
        		          {name:"price",index:"price",editable:false,width:80,align:"center",sortable:true,sorttype:"float"},
        		          {name:"orderData",index:"orderData",editable:false,width:80,align:"center",sorttype:"date",formatter:"date"},
        		          {name:"payStatus",index:"payStatus",editable:true,width:100,sortable:false,align:"center",edittype:"select",editoptions:{value:{3:'已完成',4:'取消订单'}}},
        		          {name:"remark",index:"remark",editable:true,width:100,sortable:false,align:"center"}],
        		          pager:"#pager_list_2",
        		          viewrecords:true,
        		          caption:"订单详情",
        		          editurl:"http://localhost:8080/Marilyzj/OrderServlet?method=edit"
        		          });
        	$("#table_list_2").setSelection(4,true);
        	$("#table_list_2").jqGrid("navGrid","#pager_list_2",{edit:true,add:false,del:true,search:false},
        			{height:200,reloadAfterSubmit:true});
        	$(window).bind("resize",function(){
        		var width=$(".jqGrid_wrapper").width();
        		$("#table_list_1").setGridWidth(width);
        		$("#table_list_2").setGridWidth(width)})});
    </script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_jqgrid.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:02 GMT -->
</html>
