<!DOCTYPE html>
<html class="indexHtml" ang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>后台管理</title>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta http-equiv="Cache-Control" content="no-transform" />
    <link rel="stylesheet" type="text/css" href="/lemon/css/index.css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/pagination.css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/alert.css">
</head>
<body class="indexBody">
<div class="con-wripper"> 
 <div class="con-top clearfix">
        <div class="left-top f-l">
            <div class="logo-top f-l">
            </div>
            <div class="modname-top f-l">API RUNNER</div>
        </div>
        <div class="right-top f-r">
            <div class="srch-top f-l">
                <input type="text"  class="ipt-top" placeholder="搜索分组/项目/接口" />
            </div>
            <div class="handle-top f-l">
                <i class="icon-top icon-collect"></i>
                <i class="icon-top icon-plus"></i>
                <i class="icon-top icon-doubt"></i>
            </div>
           <div class="ctr-top f-l">
                <div class="btn_stretch">
                    <a class="header-top"></a>
                    <i class="icon-arrow"></i>
                </div>
                <ul class="ctrlist-top">
                    <li class="pctr-top">
                        <a href="#">个人中心</a>
                    </li>
                    <li class="quit-top">
                        <a href="/lemon/user/logout">退出</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>    <div class="main-interlist com-module clearfix mr24">
        <div class="item_tab">
            <a class="tab_span" href="javascript:;">项目列表</a>
        </div>
        <div class="right-interlist item_main">
            <div class="desc-interlist">
                <div class="desctop-interlist desctop_box">
                    <div class="desctit-interlist f-l">个人空间 分组共 <span>(1)</span> 个项目</div>
                    <a href="javascript:;" class="btn-addinter2 btn-com f-r">添加项目</a>
                </div>
                <h3 class="item_title">我的项目</h3>
                <div class="item_body">
                    <#list projects as project>
                	 <a class="item_single" href="/lemon/index/toindex?projectId=${project.id}&tab=1">
                       <span class="item_ic"></span>
                       <span class="item_font">${project.name}</span>
                   	 </a>
                    </#list>
                </div>
            </div>
        </div>
        <!-- 添加项目弹框 -->
        <form id="addForm2">
            <div class="dialog-addinter">
                <div class="line-addinter form_control clearfix" >
                    <label><span>*</span>项目名称：</label>
                    <input type="text" placeholder="项目名称" class="required" data-valid="isNonEmpty" data-error="内容不能为空" name="name">
                    <span class="valid_message"></span>
                </div>
                <div class="line-addinter form_control clearfix">
                    <label>主机地址</label>
                    <input type="text" class="path-addinter required" data-valid="isNonEmpty" data-error="内容不能为空" placeholder="主机地址(域名或ip)" name="host">
                    <span class="valid_message"></span>
                </div>
                <div class="line-addinter form_control clearfix describe">
                    <label>描述：</label>
                    <textarea type="text" class="path-addinter" placeholder="描述" name="description"></textarea>
                    <span class="valid_message"></span>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="/lemon/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/lemon/js/jquery.pagination.js"></script>
<script type="text/javascript" src="/lemon/js/alert.js"></script>
<script type="text/javascript" src="/lemon/js/base.js"></script>
<script type="text/javascript" src="/lemon/js/jquery-validate.js"></script>
<script type="text/javascript" src="/lemon/js/projectList.js"></script>
<script type="text/javascript" src="/lemon/js/common.js"></script>
<script>
    $(function(){
        //高度计算
        function calcHeight() {
            var thispage = document.body.clientHeight
            var itemmain = thispage - 190;
            $(".item_main").height(itemmain);
        }
        calcHeight();
        window.onresize=function(){
            calcHeight();
        }
    })
</script>
</body>
</html>
