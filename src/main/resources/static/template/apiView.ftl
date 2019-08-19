<html ang="zh-CN"><head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>接口预览</title>
    <meta name="description" content=""> 
    <meta name="keywords" content="">
    <meta http-equiv="Cache-Control" content="no-transform">
    <link rel="stylesheet" type="text/css" href="/lemon/css/index.css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/pagination.css">
    <link rel="stylesheet" type="text/css" href="/lemon/css/alert.css">
</head>
<body>
        	<div class="right-interlist right-interpre">
        		<div class="nav-interpre">
	        		<ul>
						<li class="active"><a href="/lemon/api/toApiView?apiId=${apiId}">预览</a></li>
						<li><a href="/lemon/api/toApiEdit?apiId=${apiId}">编辑</a></li>
						<li><a href="/lemon/api/toApiEdit?apiId=${apiId}">运行</a></li>
					</ul>
				</div>
        		<div class="del-interpre">
 					<div class="basicinfo-interpre">
						<div class="comtit-interpre notop">基本信息</div>
						<div class="basiclist-interpre comlist-interpre">
							<ul>
								<li>
									<label>接口名称：</label>
									<div class="basicintro-interpre">${apiPreview.apiName}</div>
								</li>
								<li class="alone">
									<label>接口路径：</label>
									<div class="basicintro-interpre">
										<i class="icon-badge">${apiPreview.apiMethod}</i>
										${apiPreview.apiUrl}
									</div>
								</li>
								<li>
									<label>创 建 人：</label>
									<div class="basicintro-interpre">
										<a href="#" class="link-perctr">
											<i class="icon-header"></i>
											${apiPreview.createUser!''}
										</a>
									</div>
								</li>
								<li>
									<label>更新时间：</label>
									<div class="basicintro-interpre">${apiPreview.createTime!''}</div>
								</li>
							</ul>
						</div>
 					</div>
 					<div class="remark-interpre">
						<div class="comtit-interpre">备注</div>
						<div class="remarkintro-interpre comlist-interpre">
							
						</div>·
 					</div>
 					<div class="reqparam-interpre">
						<div class="comtit-interpre">请求参数</div>
						<div class="reqcom-interpre reqhead-interpre comlist-interpre">
							<div class="reqtit-interpre">Headers：</div>
							<div class="reqlist-interpre">
								<table>
									<thead>
										<tr>
											<th width="15%">参数名称</th>
											<th width="20%">参数值</th>
											<th width="10%">示例</th>
											<th width="45%">备注</th>
										</tr>
									</thead>
									<tbody>
											<tr>
												<td>Content-Type</td>
												<td>application/x-www-form-urlencoded</td>
												<td></td>
												<td>表单提交参数</td>
											</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="reqcom-interpre reqbody-interpre comlist-interpre">
							<div class="reqtit-interpre">Body：</div>
							<div class="reqlist-interpre">
								<table>
									<thead>
										<tr>
											<th width="15%">参数名称</th>
											<th width="12%">参数类型</th>
											<th width="10%">示例</th>
											<th width="53%">备注</th>
										</tr>
									</thead>
									<tbody>
											<tr>
												<td>mobilephone</td>
												<td></td>
												<td></td>
												<td>手机号</td>
											</tr>
											<tr>
												<td>pwd</td>
												<td></td>
												<td></td>
												<td>密码</td>
											</tr>
									</tbody>
								</table>
							</div>
						</div>
 					</div>
        		</div>
        	</div>
     <script type="text/javascript" src="/lemon/js/jquery-1.11.3.js"></script>  
     <script type="text/javascript" src="/lemon/js/jquery.pagination.js"></script>
     <script type="text/javascript" src="/lemon/js/alert.js"></script>
     <script type="text/javascript" src="/lemon/js/base.js"></script>
     <script type="text/javascript" src="/lemon/js/common.js"></script>


</body></html>