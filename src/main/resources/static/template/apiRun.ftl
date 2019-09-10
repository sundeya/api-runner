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
        		<input name="id" value="${apiRunVO.id}" type="hidden">
        		<input name="method" value="${apiRunVO.method!''}" type="hidden">
        		<input name="host" value="${apiRunVO.host}" type="hidden">
        		<input name="projectId" value="4" type="hidden">
        		<div class="del-interrun">
        			<div class="envirset-interrun">
						<div class="line-interedit line-interrun line-com clearfix">
							<select style="width:10%;" name="method" disabled="disabled">
									<option value="get" <#if "${apiRunVO.method}"=="get">selected="selected"</#if>>GET</option>
									<option value="post" <#if "${apiRunVO.method}"=="post">selected="selected"</#if>>POST</option>
									<option value="put" <#if "${apiRunVO.method}"=="put">selected="selected"</#if>>PUT</option>
									<option value="delete" <#if "${apiRunVO.method}"=="delete">selected="selected"</#if>>DELETE</option>
									<option value="head" <#if "${apiRunVO.method}"=="head">selected="selected"</#if>>HEAD</option>
									<option value="option" <#if "${apiRunVO.method}"=="option">selected="selected"</#if>>OPTION</option>
									<option value="patch" <#if "${apiRunVO.method}"=="patch">selected="selected"</#if>>PATCH</option>
							</select>
							<div class="ipt-interedit f-l" style="margin-left:5px;width:30%;">
								<input class="iptenvir-interrun" value="${apiRunVO.host}" disabled="disabled" type="text">
							</div>
							<div class="ipt-interedit" style="margin-left:5px;width:53%;">
								<input readonly="readonly" class="disabled" name="url" value="${apiRunVO.url!''}" placeholder="接口名称" type="text">
							</div>
						</div>
						<div class="btnbox-interrun f-r">
							<a href="javascript:void(0);" class="btn-send btn-com" style="margin-left:5px;">发送</a>
							<a href="javascript:void(0);" id="btnSaveInter" class="btn-save btn-com">添加到测试集</a>
						</div>
        			</div>
        			<div class="paramlist-interrun">
						<div class="paramcom-interrun radius4">
							<div class="paramtit-interrun"><i class="icon-arrow active"></i>QUERY</div>
							<div class="paramline-interrun active">
								<#if (apiRunVO.queryParams??)&&(apiRunVO.queryParams?size>0)>
									<#list apiRunVO.queryParams as queryParams>
										<div class="line-com line-interrun">
											<input name="queryParams[${queryParams_index}].id" value="${queryParams.id}" type="hidden">
											<div class="ipt-interrun f-l" style="width:15%">
												<div class="ltipt-interrun">
													<input class=" disabled" readonly="readonly" value="${queryParams.name}" name="queryParams[${queryParams_index}].name" type="text">
												</div>
												<div class="equal-interrun f-r">=</div>
												<input class="disabled f-r" disabled="" checked="" type="checkbox">
											</div>
											<div class="ipt-interrun f-l" style="width:85%">
												<input placeholder="参数值" style="width:100%" name="queryParams[${queryParams_index}].value" value="" type="text">
												<div class="edit-interrun f-l"></div>
											</div>
										</div>
									</#list>
								</#if>
							</div>
						</div>
						<div class="paramcom-interrun radius4">
							<div class="paramtit-interrun"><i class="icon-arrow active"></i>BODY(F9)</div>
							<div class="paramline-interrun active">
								<#if (apiRunVO.bodyParams??)&&(apiRunVO.bodyParams?size>0)>
									<#list apiRunVO.bodyParams as bodyParams>
								<div class="line-com line-interrun">
									<input name="bodyParams[${bodyParams_index}].id" value="${bodyParams.id}" type="hidden">
									<div class="ipt-interrun f-l" style="width:15%">
										<div class="ltipt-interrun">
											<input class=" disabled" readonly="readonly" value="${bodyParams.name}" name="bodyParams[${bodyParams_index}].name" type="text">
										</div>
										<div class="equal-interrun f-r">=</div>
										<input class="disabled f-r" disabled="" checked="" type="checkbox">
									</div>
									<div class="ipt-interrun f-l" style="width:85%">
										<input placeholder="参数值" style="width:100%" name="bodyParams[${bodyParams_index}].value" value="" type="text">
										<div class="edit-interrun f-l"></div>
									</div>
								</div>
									</#list>
								</#if>
                                <#if (apiRunVO.bodyRawParams??)&&(apiRunVO.bodyRawParams?size>0)>
                                    <#list apiRunVO.bodyRawParams as bodyRawParams>
                                        <div class="basicinfo-interpre reqparamsset-interedit">
											<input name="bodyRawParams[${bodyRawParams_index}].id" value="${bodyRawParams.id}" type="hidden">
                                            <div class="reqplist-interedit">
                                                <textarea name="bodyRawParams[0].exampleData" id="" class="remark-interedit">${bodyRawParams.exampleData}</textarea>
                                                <input name="bodyRawParams[0].id" value="${bodyRawParams.id}" type="hidden">
                                            </div>
                                        </div>
                                    </#list>
                                </#if>
							</div>
						</div>
						<div class="paramcom-interrun radius4">
							<div class="paramtit-interrun"><i class="icon-arrow active"></i>HEADERS</div>
							<div class="paramline-interrun active">
								<#if (apiRunVO.headerParams??)&&(apiRunVO.headerParams?size>0)>
								<#list apiRunVO.headerParams as headerParams>
								<div class="line-com line-interrun">
									<input name="headerParams[${headerParams_index}].id" value="${headerParams.id}" type="hidden">
									<div class="ipt-interrun f-l" style="width:15%">
										<div class="ltipt-interrun">
											<input class=" disabled" readonly="readonly" value="${headerParams.name}" name="headerParams[${headerParams_index}].name" type="text">
										</div>
										<div class="equal-interrun f-r">=</div>
										<input class="disabled f-r" disabled="" checked="" type="checkbox">
									</div>
									<div class="ipt-interrun f-l" style="width:85%">
										<input placeholder="参数值" style="width:100%" name="headerParams[${headerParams_index}].value" value="" type="text">
										<div class="edit-interrun f-l"></div>
									</div>
								</div>
								</#list>
								</#if>
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

								</div>
							</div>
							<div class="comlist-interrun bodylist-interrun f-l">
								<div class="titlist-interrun">Body</div>
								<div class="txtlist-interrun radius4" name="responseData">

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
					<input placeholder="请输入接口用例名称" name="name" class="required" data-valid="isNonEmpty" data-error="内容不能为空" type="text">
				</div>
			</div>
			<div class="sellist-addass">
				<div class="seltit-addass">请选择添加到的集合：</div>
				<ul>
				<#if suites?? && (suites?size>0)>
					<#list suites as suite>
				<li <#if suite.name=='公共测试集'>class="active"</#if> name="" value="${suite.id}"><i class="icon-file"></i>${suite.name}</li>
					</#list>
				</#if>
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