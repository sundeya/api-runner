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
        <form name="caseForm">
			<#if caseEdit?? && (caseEdit?size>0)>
        	<div class="right-interlist right-interpre">
        		<div class="paramlist-interrun">
					<div class="paramcom-interrun radius4">
							<div class="paramline-interrun active">
								<div class="line-com line-interrun">
									<div class="ipt-interrun f-l" style="width:100%">
										<input placeholder="参数值" style="width:90%" name="caseName" value="${caseEdit.caseName}" type="text">
										<span class="inter-link" style="margin: 0px 8px 0px 6px; font-size: 12px;"><a class="text" href="/lemon/api/find?id=2">对应接口</a></span>
									</div>
								</div>
							</div>
					</div>
        		<input value="2" name="apiId" type="hidden">
        		<input value="${caseEdit.id}" name="id" type="hidden">
        		<input value="${caseEdit.method}" name="method" type="hidden">
        		<input value="${caseEdit.host}" name="host" type="hidden">
                <input value="${caseEdit.url}" name="url" type="hidden">
        		<div class="del-interrun">
        			<div class="envirset-interrun">
						<div class="line-interedit line-interrun line-com clearfix">
							<select style="width:10%;" disabled="disabled">
								<option value="get" <#if "${caseEdit.method}"=="get">selected="selected"</#if>GET</option>
								<option value="post" <#if "${caseEdit.method}"=="post">selected="selected"</#if>>POST</option>
								<option value="put" <#if "${caseEdit.method}"=="put">selected="selected"</#if>>PUT</option>
								<option value="delete" <#if "${caseEdit.method}"=="delete">selected="selected"</#if>>DELETE</option>
								<option value="head" <#if "${caseEdit.method}"=="head">selected="selected"</#if>>HEAD</option>
								<option value="option" <#if "${caseEdit.method}"=="option">selected="selected"</#if>>OPTION</option>
								<option value="patch" <#if "${caseEdit.method}"=="patch">selected="selected"</#if>>PATCH</option>
							</select>
							<div class="ipt-interedit f-l" style="width:45%;">
								<input class="iptenvir-interrun pointer arrow" value="${caseEdit.host}" disabled="disabled" type="text">
							</div>
							<div class="ipt-interedit" style="width:45%;">
								<input readonly="readonly" class="disabled" name="apiRequestUrl" value="${caseEdit.url}" placeholder="接口地址" type="text">
							</div>
						</div>
						<div class="btnbox-interrun f-r">
							<a href="javascript:void(0);" class="btn-send btn-com">发送</a>
							<a href="javascript:void(0);" id="btnUApi" class="btn-update btn-com">更新</a>
						</div>
        			</div>
        			<div class="paramlist-interrun">
						<div class="paramcom-interrun radius4">
							<div class="paramtit-interrun"><i class="icon-arrow active"></i>BODY(F9)</div>
							<div class="paramline-interrun active">
								<#if (caseEdit.bodyParams??) &&(caseEdit.bodyParams?size>0)>
									<#list caseEdit.bodyParams as bodyParams>
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
										<input placeholder="参数值" style="width:100%" name="bodyParams[${bodyParams_index}].value" value="${bodyParams.value}" type="text">
										<div class="edit-interrun f-l"></div>
									</div>
								</div>
									</#list>
								</#if>
								<#if (caseEdit.bodyRawParams??)&&(caseEdit.bodyRawParams?size>0)>
									<#list caseEdit.bodyRawParams as bodyRawParams>
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
								<#if (caseEdit.headerParams??)&&(caseEdit.headerParams?size>0)>
								<#list caseEdit.headerParams as headerParams>
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
										<input placeholder="参数值" style="width:100%" name="headerParams[${headerParams_index}].value" value="${headerParams.value}" type="text">
										<div class="edit-interrun f-l"></div>
									</div>
								</div>
								</#list>
								</#if>
							</div>
						</div>
						<div class="paramcom-interrun radius4">
							<div class="paramtit-interrun"><i class="icon-arrow active"></i>Querys</div>
							<div class="paramline-interrun active">
								<#if (caseEdit.queryParams??)&&(caseEdit.queryParams?size>0)>
									<#list caseEdit.queryParams as queryParams>
										<div class="line-com line-interrun">
											<input name="headerParams[${queryParams_index}].id" value="${queryParams.id}" type="hidden">
											<div class="ipt-interrun f-l" style="width:15%">
												<div class="ltipt-interrun">
													<input class=" disabled" readonly="readonly" value="${queryParams.name}" name="queryParams[${queryParams_index}].name" type="text">
												</div>
												<div class="equal-interrun f-r">=</div>
												<input class="disabled f-r" disabled="" checked="" type="checkbox">
											</div>
											<div class="ipt-interrun f-l" style="width:85%">
												<input placeholder="参数值" style="width:100%" name="queryParams[${queryParams_index}].value" value="${queryParams.value}" type="text">
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
							<div class="titnav-interrun">Test</div>
        				</div>
						<div class="reslist-interrun">
							<div class="comlist-interrun headlist-interrun f-l">
								<div class="titlist-interrun">Headers</div>
								<div class="txtlist-interrun radius4" name="responseheader">
								</div>
							</div>
							<div class="comlist-interrun bodylist-interrun f-l">
								<div class="titlist-interrun">Body</div>
								<div class="txtlist-interrun radius4" name="responseData">
								</div>
							</div>
						</div>
						<div class="testlist-interrun" style="display:none">
							<div class="comlist-interrun headlist-interrun f-l">
								<div class="titlist-interrun">jsonPath表达式</div>
								<textarea name="caseTestRule.expression" id="" class="remark-interedit"></textarea>
							</div>
							<div class="comlist-interrun bodylist-interrun f-l">
								<div class="titlist-interrun">期望值</div>
								<textarea name="caseTestRule.expected" id="" class="remark-interedit"></textarea>
							</div>
						</div>
        			</div>
        			
        		</div>
        	</div>
        </div>
			</#if>
        </form>
     <script type="text/javascript" src="/lemon/js/jquery-1.11.3.js"></script>  
     <script type="text/javascript" src="/lemon/js/jquery.pagination.js"></script>
     <script type="text/javascript" src="/lemon/js/alert.js"></script>
     <script type="text/javascript" src="/lemon/js/base.js"></script>
     <script type="text/javascript" src="/lemon/js/common.js"></script>
     <script type="text/javascript" src="/lemon/js/jquery-validate.js"></script>
     <script type="text/javascript" src="/lemon/js/caseEdit.js"></script>

</body></html>