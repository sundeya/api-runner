<html class="indexHtml" ang="zh-CN"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta http-equiv="Cache-Control" content="no-transform">
    <link rel="stylesheet" type="text/css" href="/lemon/css/index.css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/pagination.css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/alert.css">
</head>
<body class="indexBody">
	<input name="projectId" value="${projectId}" type="hidden">
<div class="con-wripper">
 <div class="con-top clearfix">
        <div class="left-top f-l">
            <div class="logo-top f-l">
            </div>
            <div class="modname-top f-l">API RUNNER</div>
        </div>
        <div class="right-top f-r">
            <div class="srch-top f-l">
                <input class="ipt-top" placeholder="搜索分组/项目/接口" type="text">
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
    </div>    <div class="nav-interlist">
        <ul class="clearfix">
            <li class="active"><a href="#">接口</a></li>
            <li><a href="#">设置</a></li>
        </ul>
    </div>
    <div class="main-interlist com-module clearfix">
        <div class="left-interlist f-l" style="height: 297px;">	
            <div class="tab-interlist">
                <div class="tabtype-interlist">
                    <ul class="clearfix">     
                        <li class="active"><a href="index.ftl">接口列表</a></li>
                        <li><a href="index2.html">测试集合</a></li>
                    </ul>
                </div>
                <div class="srchbox-interlist clearfix">
					<input placeholder="搜索接口" class="input-com f-l" type="text">
					<a href="javascript:;" class="btn-addfl btn-com f-r" id="addfl">添加分类</a>
                </div>
            </div>
            <div class="list-interlist" id="listInter">
                <ul class="type_menu">
                    <li class="active">
                        <div class="menu-interlist">
                            <a href="/lemon/api/toApilist?projectId=${projectId}" target="rightIframe">
                                <i class="icon-file"></i>
                                <span>全部接口</span>
                            </a>
                        </div>
                    </li>
                    <#list apiClassifications as apiClassification>
                    <li>
                        <div class="menu-interlist">
                            <a href="/lemon/api/toApilist?apiClassificationId=${apiClassification.id}" target="rightIframe">
                                <i class="icon-file"></i>
                                <span>${apiClassification.name}</span>
                                <div class="hanmenu-interlist">
                                    <i class="icon-edit"></i>
                                    <i class="icon-delete"></i>
                                </div>
                            </a>
                        </div>
                        <ul class="tmenu-interlist">
                        	<!-- 加载此分类下的所有接口 -->
                            <#list apiClassification.apiAndclassifis as apiAndclassifi>
                            <li class="">
                                <a href="/lemon/api/toApiView?apiId=${apiAndclassifi.apiId}" target="rightIframe">
                                   	${apiAndclassifi.apiName}
                                    <div class="hantmenu-interlist">
                                        <i class="icon-delete"></i>
                                    </div>
                                </a>
                            </li>
                            </#list>
                        </ul>
                    </li>
                    </#list>
                </ul>
            </div>
        </div>
       	<iframe class="rightIframe f-l" name="rightIframe" src="/lemon/api/toApilist?projectId=${projectId}" onload="loadFrame(this);" scrolling="yes" style="height: 297px;" frameborder="0"></iframe>
    </div>
    <!-- 添加分类窗口 -->
    <form id="addClassification">
        <div class="dialog-addinter">
            <div class="line-addinter form_control clearfix">
                <label><span>*</span>分类名称：</label>
                <input placeholder="分类名称" class="required" data-valid="isNonEmpty" data-error="内容不能为空" name="name" type="text">
                <span class="valid_message"></span>
            </div>
            <div class="line-addinter form_control clearfix describe">
                <label>描述：</label>
                <textarea type="text" class="path-addinter" placeholder="描述" name="description"></textarea>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="/lemon/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/lemon/js/jquery.pagination.js"></script>
<script type="text/javascript" src="/lemon/js/alert.js"></script>
<script type="text/javascript" src="/lemon/js/base.js"></script>
<script type="text/javascript" src="/lemon/js/jquery-validate.js"></script>
<script type="text/javascript" src="/lemon/js/common.js"></script>
<script type="text/javascript" src="/lemon/js/index.js"></script>


</body></html>