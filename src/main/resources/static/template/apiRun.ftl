<html ang="zh-CN"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>接口运行</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta http-equiv="Cache-Control" content="no-transform">
    <link rel="stylesheet" href="/lemon/css/index.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/pagination.css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/alert.css">
</head>
<body>
        	<div class="right-interlist right-interpre">
        		<div class="nav-interpre">
	        		<ul>
						<li><a href="/lemon/api/toApiView?apiId=${apiId}">预览</a></li>
						<li><a href="/lemon/api/toApiEdit?apiId=${apiId}">编辑</a></li>
						<li class="active"><a href="/lemon/api/toApiRun?apiId=${apiId}">运行</a></li>
					</ul>
				</div>
        		<form name="apiRunForm">
        		<input name="id" value="4" type="hidden">
        		<input name="apiRequestMethod" value="post" type="hidden">
        		<input name="host" value="http://ta.lemonban.com" type="hidden">
        		<input name="projectId" value="4" type="hidden">
        		<div class="del-interrun">
        			<div class="envirset-interrun">
						<div class="line-interedit line-interrun line-com clearfix">
							<select style="width:10%;" name="apiRequestMethod" disabled="disabled">
									<option value="get">GET</option>
									<option value="post" selected="selected">POST</option>
									<option value="put">PUT</option>
									<option value="delete">DELETE</option>
									<option value="head">HEAD</option>
									<option value="option">OPTION</option>
									<option value="patch">PATCH</option>
							</select>
							<div class="ipt-interedit f-l" style="margin-left:5px;width:30%;">
								<input class="iptenvir-interrun" value="http://ta.lemonban.com" disabled="disabled" type="text">
							</div>
							<div class="ipt-interedit" style="margin-left:5px;width:53%;">
								<input readonly="readonly" class="disabled" name="apiRequestUrl" value="/futureloan/mvc/api/member/login" placeholder="接口名称" type="text">
							</div>
						</div>
						<div class="btnbox-interrun f-r">
							<a href="javascript:void(0);" class="btn-send btn-com" style="margin-left:5px;">发送</a>
							<a href="javascript:void(0);" id="btnSaveInter" class="btn-save btn-com">添加到测试集</a>
						</div>
        			</div>
        			<div class="paramlist-interrun">
						<div class="paramcom-interrun radius4">
							<div class="paramtit-interrun"><i class="icon-arrow active"></i>BODY(F9)</div>
							<div class="paramline-interrun active">
								<div class="line-com line-interrun">
									<input name="bodyParams[0].id" value="7" type="hidden">
									<div class="ipt-interrun f-l" style="width:15%">
										<div class="ltipt-interrun">
											<input class=" disabled" readonly="readonly" value="mobilephone" name="bodyParams[0].name" type="text">
										</div>
										<div class="equal-interrun f-r">=</div>
										<input class="disabled f-r" disabled="" checked="" type="checkbox">
									</div>
									<div class="ipt-interrun f-l" style="width:85%">
										<input placeholder="参数值" style="width:100%" name="bodyParams[0].value" value="" type="text">
										<div class="edit-interrun f-l"></div>
									</div>
								</div>
								<div class="line-com line-interrun">
									<input name="bodyParams[1].id" value="8" type="hidden">
									<div class="ipt-interrun f-l" style="width:15%">
										<div class="ltipt-interrun">
											<input class=" disabled" readonly="readonly" value="pwd" name="bodyParams[1].name" type="text">
										</div>
										<div class="equal-interrun f-r">=</div>
										<input class="disabled f-r" disabled="" checked="" type="checkbox">
									</div>
									<div class="ipt-interrun f-l" style="width:85%">
										<input placeholder="参数值" style="width:100%" name="bodyParams[1].value" value="" type="text">
										<div class="edit-interrun f-l"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="paramcom-interrun radius4">
							<div class="paramtit-interrun"><i class="icon-arrow active"></i>HEADERS</div>
							<div class="paramline-interrun active">
								<div class="line-com line-interrun">
									<input name="headerParams[0].id" value="9" type="hidden">
									<div class="ipt-interrun f-l" style="width:15%">
										<div class="ltipt-interrun">
											<input class=" disabled" readonly="readonly" value="Content-Type" name="headerParams[0].name" type="text">
										</div>
										<div class="equal-interrun f-r">=</div>
										<input class="disabled f-r" disabled="" checked="" type="checkbox">
									</div>
									<div class="ipt-interrun f-l" style="width:85%">
										<input placeholder="参数值" style="width:100%" name="headerParams[0].value" value="application/x-www-form-urlencoded" type="text">
										<div class="edit-interrun f-l"></div>
									</div>
								</div>
							</div>
						</div>
        			</div>
        			<div class="response-interrun">
        				<div class="restit-interrun">
							<div class="titnav-interrun">Response</div>
        				</div>
						<div class="reslist-interrun">
							<div class="comlist-interrun headlist-interrun f-l">
								<div class="titlist-interrun">Headers</div>
								<div class="txtlist-interrun radius4" name="responseHeader">
									<pre>{
	"Transfer-Encoding":"chunked",
	"Server":"nginx/1.12.0",
	"Connection":"keep-alive",
	"Date":"Sun, 28 Jul 2019 03:12:50 GMT",
	"Content-Type":"application/json;charset=UTF-8"
}</pre>
								</div>
							</div>
							<div class="comlist-interrun bodylist-interrun f-l">
								<div class="titlist-interrun">Body</div>
								<div class="txtlist-interrun radius4" name="responseData">
									<pre>{"status":0,"code":"20103","data":null,"msg":"手机号不能为空"}</pre>
								</div>
							</div>
						</div>
        			</div>
        		</div>
        	</form>
        	</div>
        
        <!-- 添加到集合 -->
        <div class="addass-layer top-border btm-border" id="addAssemble">
        	<form name="addSuiteForm">
			<div class="top-addass">
				<div class="line-com">
					<label>接口用例名：</label>
					<input placeholder="请输入接口用例名称" name="caseName" class="required" data-valid="isNonEmpty" data-error="内容不能为空" type="text">
				</div>
			</div>
			<div class="sellist-addass">
				<div class="seltit-addass">请选择添加到的集合：</div>
				<ul>
				
				<li class="active"><i class="icon-file"></i>公共测试集</li><li class=""><i class="icon-file"></i>注册用例集</li><li class=""><i class="icon-file"></i>登录用例集</li><li class=""><i class="icon-file"></i>取现用例集</li></ul>
			</div>
			<div class="new-addass radius4">
				<div class="newline-addass comsib-comdul">
				</div>
			</div>
			</form>
     <script type="text/javascript" src="/lemon/js/jquery-1.11.3.js"></script>  
     <script type="text/javascript" src="/lemon/js/jquery.pagination.js"></script>
     <script type="text/javascript" src="/lemon/js/alert.js"></script>
     <script type="text/javascript" src="/lemon/js/base.js"></script>
     <script type="text/javascript" src="/lemon/js/apiRun.js"></script>
     <script type="text/javascript" src="/lemon/js/common.js"></script>
     <script type="text/javascript" src="/lemon/js/jquery-validate.js"></script>


</div></body></html>