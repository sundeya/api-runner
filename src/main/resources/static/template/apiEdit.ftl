<html ang="zh-CN"><head></head><body>
<input name="apiId" value="${apiId}" type="hidden">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>接口预览</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta http-equiv="Cache-Control" content="no-transform">
    <link rel="stylesheet" href="/lemon/css/index.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/pagination.css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/alert.css">


        	<div class="right-interlist right-interpre">
        		<div class="nav-interpre">
	        		<ul>
						<li><a href="/lemon/api/toApiView?apiId=${apiId}">预览</a></li>
						<li  class="active"><a href="/lemon/api/toApiEdit?apiId=${apiId}">编辑</a></li>
						<li><a href="/lemon/api/toApiRun?apiId=${apiId}">运行</a></li>
					</ul>
				</div>
        		<form name="apiEditForm">
        		<input name="apiId" value="${apiId}" type="hidden">
        		<div class="del-interpre del-interedit">
 					<div class="basicinfo-interpre basicset-interedit">
						<div class="comtit-interpre notop">基本设置</div>
						<div class="setlist-interedit">
							<div class="line-interedit line-com">
								<label><span>*</span>接口名称：</label>
								<div class="ipt-interedit">
									<input name="apiName" value="${apiEditVO.apiName!''}" placeholder="接口名称" type="text">
								</div>
							</div>
							<div class="line-interedit line-com">
								<label><span>*</span>选择分类：</label>
								<div class="ipt-interedit">
									<select name="apiClassifiId" id="">
										<#if (apiClassifications??)&&(apiClassifications?size>0)>
											<#list apiClassifications as apiClassification>
										<option value="${apiClassification.id}" <#if "${apiEditVO.apiClassifiId}"=="${apiClassification.id}">selected="selected"</#if>>${apiClassification.name}</option>
											</#list>
										</#if>
									</select>
								</div>
							</div>
							<div class="line-interedit line-com">
								<label><span>*</span>请求方法<i class="icon-doubt"></i>：</label>
								<div class="ipt-interedit">
									<select name="apiMethod" id="" class="reqtype-interedit" style="width:15%;margin-right:0;">
										<option value="get"<#if "${apiEditVO.apiMethod}"=="get">selected="selected"</#if>>GET</option>
										<option value="post" <#if "${apiEditVO.apiMethod}"=="post">selected="selected"</#if>>POST</option>
										<option value="put" <#if "${apiEditVO.apiMethod}"=="put">selected="selected"</#if>>PUT</option>
										<option value="delete" <#if "${apiEditVO.apiMethod}"=="delete">selected="selected"</#if>>DELETE</option>
										<option value="head" <#if "${apiEditVO.apiMethod}"=="head">selected="selected"</#if>>HEAD</option>
										<option value="option" <#if "${apiEditVO.apiMethod}"=="option">selected="selected"</#if>>OPTION</option>
										<option value="patch" <#if "${apiEditVO.apiMethod}"=="patch">selected="selected"</#if>>PATCH</option>
									</select>
								</div>
							</div>
							<div class="line-interedit line-com">
								<label><span>*</span>接口地址<i class="icon-doubt"></i>：</label>
								<div class="ipt-interedit">
									<input placeholder="/path" name="apiUrl" value="${apiEditVO.apiUrl}" type="text">
								</div>
							</div>
						</div>
 					</div>
 					<div class="basicinfo-interpre reqparamsset-interedit">
 						<div class="comtit-interpre">请求参数设置</div>
 						<div class="reqplist-interedit">
							<div class="reqpnav-interedit comnav-interedit">
								<ul class="clearfix inline-block">
									<li class="active"><a href="javascript:void(0);">Body</a></li>
									<li><a href="javascript:void(0);">Query</a></li>
									<li class="header"><a href="javascript:void(0);">Headers</a></li>
								</ul>
							</div>
							<div class="reqpdel-interedit comdel-interedit clearfix">
								<div class="reqpcom-interredit active" id="reqpBody">
									<div class="radiobox-interedit">
										<#if (apiEditVO.bodyRawParams??)&&(apiEditVO.bodyRawParams?size>0)>
										<input value="form" type="radio" name="pt">form
										<input value="raw" type="radio" checked="" name="pt">raw
										<#else>
											<input value="form" type="radio" checked="" name="pt">form
											<input value="raw" type="radio"  name="pt">raw
										</#if>
									</div>
									<div class="reqpline-interedit linebox-interedit">
										<a href="javascript:void(0);" class="btn-com">添加body参数</a>
										<#if (apiEditVO.bodyParams??)&&(apiEditVO.bodyParams?size>0)>
											<#list apiEditVO.bodyParams as bodyParams>
										<div class="line-interedit line-com">
											<input name="bodyParams[${bodyParams_index}].id" value="${bodyParams.id}" type="hidden">
											<input name="bodyParams[${bodyParams_index}].apiId" value="${bodyParams.apiId}" type="hidden">
											<input name="bodyParams[${bodyParams_index}].type" value="${bodyParams.type}" type="hidden">
											<input placeholder="name" name="bodyParams[${bodyParams_index}].name" value="${bodyParams.name}" style="width:18%" type="text">
											<select name="bodyParams[${bodyParams_index}].paramType" id="" style="width:12%">
												<option value="text">text</option>
												<option value="file">file</option>
											</select>
											<textarea name="bodyParams[${bodyParams_index}].exampleData" id="" value="" placeholder="参数示例" style="width:20%">${bodyParams.exampleData}</textarea>
											<textarea name="bodyParams[${bodyParams_index}].description" id="" value="" placeholder="备注" style="width:25%">${bodyParams.description}</textarea>
											<i class="icon icon-delete f-l"></i>
										</div>
											</#list>
										</#if>
										<#if (apiEditVO.bodyRawParams??)&&(apiEditVO.bodyRawParams?size>0)>
											<#list apiEditVO.bodyRawParams as bodyRawParams>
										<div class="basicinfo-interpre reqparamsset-interedit">
											<div class="reqplist-interedit">
												<textarea name="bodyRawParams[0].exampleData" id="" class="remark-interedit">${bodyRawParams.exampleData}</textarea>
												<input name="bodyRawParams[0].id" value="${bodyRawParams.id}" type="hidden">
											</div>
										</div>
											</#list>
										</#if>
									</div>
								</div>
								<div class="reqpcom-interredit" id="reqpQuery">
									<div class="reqpline-interedit linebox-interedit">
										<a href="javascript:void(0)" class="btn-com">添加Query参数</a>
										<#if (apiEditVO.queryParams??)&&(apiEditVO.queryParams?size>0)>
										<#list apiEditVO.queryParams as queryParams>
											<div class='line-interedit line-com'>"
												<input type='hidden' name='queryParams[${queryParams_index}].id' value='${queryParams.id}'>
												<input type='hidden' name='queryParams[${queryParams_index}].type' value='${queryParams.type}'>
												<input type='hidden' name='queryParams[${queryParams_index}].apiId' value='${queryParams.apiId}'>
												<input name="queryParams[${queryParams_index}].type" value="${queryParams.type}" type="hidden">
												<input placeholder='参数名称' name='queryParams[${queryParams_index}].name' value='${queryParams.name}' style='width:18%' type='text'>
												<textarea name='queryParams[${queryParams_index}].exampleData' id='' value='' placeholder='参数示例' style='width:22%''>${queryParams.exampleData}</textarea>
												<textarea name='queryParams[${queryParams_index}].description' id='' value='' placeholder='备注' style='width:31%'>${queryParams.description}</textarea>
												<i class='icon icon-delete f-l'></i>
											</div>
										</#list>
										</#if>
									</div>
								</div>

								<div class="reqpcom-interredit" id="reqpHeaders">
									<div class="reqpline-interedit linebox-interedit">
										<a href="javascript:void(0)" class="btn-com">添加Header参数</a>
										<#if (apiEditVO.headerParams??)&&(apiEditVO.headerParams?size>0)>
											<#list apiEditVO.headerParams as headerParams>
										<div class="line-interedit line-com">
											<input name="headerParams[${headerParams_index}].id" value="${headerParams.id}" type="hidden">
											<input name="headerParams[${headerParams_index}].apiId" value="${headerParams.apiId}" type="hidden">
											<input name="headerParams[${headerParams_index}].type" value="${headerParams.type}" type="hidden">
											<input placeholder="参数名称" name="headerParams[${headerParams_index}].name" value="${headerParams.name}" style="width:20%" type="text">
											<input placeholder="参数值" name="headerParams[${headerParams_index}].value" value="${headerParams.value!''}" style="width:20%" type="text">
											<textarea name="headerParams[${headerParams_index}].exampleData" id="" value="" placeholder="参数示例" style="width:20%">${headerParams.exampleData}</textarea>
											<textarea name="headerParams[${headerParams_index}].description" id="" value="" placeholder="备注" style="width:29%">${headerParams.description}</textarea>
											<i class="icon icon-delete f-l"></i>
										</div>
										</#list>
										</#if>
									</div>
								</div>
							</div>
 						</div>
 					</div>
 					<div class="basicinfo-interpre reqparamsset-interedit">
 						<div class="comtit-interpre">备 注</div>
 						<div class="reqplist-interedit">
 							<textarea name="description" id="" class="remark-interedit"></textarea>
 						</div>
 					</div>
        		</div>
        		<div class="comfirm-interedit">
					<a href="javascript:void(0)" class="btn-com">保存</a>
        		</div>
        		</form>
        	</div>
     <script type="text/javascript" src="/lemon/js/jquery-1.11.3.js"></script>  
     <script type="text/javascript" src="/lemon/js/jquery.pagination.js"></script>
     <script type="text/javascript" src="/lemon/js/alert.js"></script>
     <script type="text/javascript" src="/lemon/js/base.js"></script>
     <script type="text/javascript" src="/lemon/js/apiEdit.js"></script>
     <script type="text/javascript" src="/lemon/js/common.js"></script>

</body></html>