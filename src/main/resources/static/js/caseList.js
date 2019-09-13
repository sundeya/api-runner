//选择测试环境展开收起
$('.seltit-testass').click(function(){
	$(this).toggleClass('active');
	if($(this).hasClass('active')){
		$(this).siblings().addClass('active');
	}else{
		$(this).siblings().removeClass('active');
	}
})

//测试报告弹框导航切换
$('body').on('click','.nav-testrep li',function(){
	$(this).toggleClass('active').siblings().removeClass('active');
	var index = $(this).index(); 
	$(this).parents('.nav-testrep').siblings().children().eq(index).addClass('active').siblings().removeClass('active');
});

//查看指定用例的测试报告
$(function(){
	$('.data-testass').on('click','.btn-testrep',function(){
		var caseId = $(this).parent().parent().find("[name='caseId']").val();
		$.ajax({
			url:lemon.config.global.rootUrl+"/suite/findCaseRunResult",
			data:{caseId:caseId},
			dataType:'json',
			type:'post',
			async:false,
			success:function(ret){
				if(ret.isSuccess!=1){
					return;
				}
				var reportDiv = '<div class="testrep-layer top-border" id="testReport">'
					+'<div class="nav-testrep">'
					+'<ul class="clearfix">'
					+'<li class="active">Request</li>'
					+'<li>Response</li>'
					+'<li>验证结果</li>'
					+'</ul>'
					+'</div>'
					+'<div class="list-testrep">'
					+'<div class="comdul-testrep active">'
					+'<ul>'
						+'<li>'
						+'<label>Url</label>'
						+'<span>'
						+'<pre>'+ret.data.requestUrl+'</pre>'
						+'</span>'
						+'</li>'
						+'<li>'
						+'<label>Headers</label>'
						+'<span>'
						+'<pre>'+ret.data.requestHeaders+'</pre>'
						+'</span>'
						+'</li>'
						+'<li>'
						+'<label>Body</label>'
						+'<span>'
						+'<pre>'+ret.data.requestBody+'</pre>'
						+'</span>'
						+'</li>'
					+'</ul>'
					+'</div>'
					+'<div class="comdul-testrep">'
						+'<li>'
						+'<label>Headers</label>'
						+'<span>'
						+'<pre>'+ret.data.responseHeaders+'</pre>'
						+'</span>'
						+'</li>'
						+'<li>'
						+'<label>Body</label>'
						+'<span>'
						+'<pre>'+ret.data.responseBody+'</pre>'
						+'</span>'
						+'</li>'
					+'</div>'
					+'<div class="comdul-testrep">'
						+'<li>'
						+'<label>验证结果</label>'
						+'<span>'
						+'<pre>'+ret.data.passFlag+'</pre>'
						+'</span>'
						+'</li>'
					+'</div>'
					+'</div>'
					+'</div>"';
				//以弹窗形式展示报告
				var dialog = jqueryAlert({
				    'style'   : 'pc',
				    'title'   : '测试报告',
				    'content' :  reportDiv,
				    'modal'   : true,
				    'contentTextAlign' : 'left',
				    'width'   : '900px',
				    'animateType' : 'linear',
				    'buttons' :{
				    }
				})
			}
		});
		
	});
	
	//点击"开始测试"，行测试套件
	$("#starttest").click(function(){
		var suiteId = $("[name='idOfSelectedSuite']").val();
		var trs = $("table tr");
		$.each(trs,function(ind,ele){
			//先清除
			$(ele).find("td:eq(1)").html("");
			$(ele).find("td:eq(3)").html("");
		});
		//后台执行套件
		$.ajax({
			url:lemon.config.global.rootUrl+"/suite/runSuite",
			data:{suiteId:suiteId},
			type:'post',
			dataType:'json',
			async:false,
			success:function(ret){
				//处理每一行的显示
				$.each(trs,function(ind,tr){
					//拿到每条用例的执行结果并展示
					if(ret!=null&&ret.isSuccess=="1"){
						$.each(ret.data,function(ind,ele){
							//根据当前tr行中的caseId去找到对应用例的执行结果
							var caseId = $(tr).find("[name='caseId']").val();
							if(caseId==ele.caseId){
								var passFlag = ele.passFlag;
								if(passFlag=="通过"){
									$(tr).find("td:eq(1)").html("<i class=\"icon-success\"></i>");
								}else if(passFlag!=="通过"){
									$(tr).find("td:eq(1)").html("<i class=\"icon-fail\"></i>");
								}
							}
							$(tr).find("td:eq(3)").html("<a href=\"#\" class=\"btn-testrep btn-com btn-default\">测试报告</a>");
						});
					}else{
						alert(ret.message);
					}
				});
			}
		});
			
	});
	
	$("[name='caseEditHref']").click(function(){
		var baseUrl = lemon.config.global.rootUrl;
		var menuFindurl = baseUrl+"/cases/findSuiteSelectedMenu";
		var caseId = $(this).parent().parent().find("[name='caseId']").val();
		var data = {"caseId":caseId};
		var turn2Page = baseUrl+"/cases/toCaseEdit?caseId="+caseId;
		////跳转到对应页面，并选中对应菜单
		selectMenuAndTurn2Page(menuFindurl,data,turn2Page);
	});

	$("[name='apiUrlHref']").click(function(){
		var baseUrl = lemon.config.global.rootUrl;
		var menuFindurl = baseUrl+"/index/findApiSelectedMenu";
		var apiId = $(this).parent().parent().find("[name='apiId']").val();
		var data = {"apiId":apiId};
		var turn2Page = baseUrl+"/index/toindex?tab=1&projectId=1";
		////跳转到对应页面，并选中对应菜单
		selectMenuAndTurn2Page(menuFindurl,data,turn2Page,"测试集合");
	});
	
})