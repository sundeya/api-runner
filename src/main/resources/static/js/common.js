lemon = {
		config :{
				global:{
					rootUrl: document.location.protocol + "//" + document.location.host+"/lemon",
					htmlUrl: document.location.protocol + "//" + document.location.host+"/lemon"
				}
		},
		core:{
			getParameter:function(property, url) {
				var parseUrl = url;
				if(parseUrl == null){
					parseUrl = String(window.document.location.href);
				}
				var rs = new RegExp("(^|)" + property + "=([^\&#]*)(\&|#|$)", "gi").exec(parseUrl), tmp;
				if (tmp = rs) {
					return tmp[2];
				}
				return "";
			}
		}
};



function attachValidate(selector){
	var form = $(selector).validationEngine('attach', {
		  promptPosition: 'bottomRight',
		  maxErrorsPerField:1,
		  autoHidePrompt:false,
		  autoHideDelay:3000,   
		  scroll: false,
		  focusFirstField:false
		}); 
	return form;
}


function selectMenuAndTurn2Page(menuFindurl,data,turn2Page){
	$.post(menuFindurl,data,function(ret){
		if(ret.isSuccess=="1"){
			//一级菜单名
			var firstLevelMenu = ret.data.firstLevelMenu;
			//二级菜单名
			var secondLevelMenu = ret.data.secondLevelMenu;
			//选中对应菜单
			//先判断当前一级菜单是否已经是选中状态
			if(!parent.$(window.parent.document).find("a:contains("+firstLevelMenu+")").parent().parent("li").hasClass("active")){
				parent.$(window.parent.document).find("a:contains("+firstLevelMenu+")").click();
			}
			//先判断当前二级菜单是否已经是选中状态
			if(!parent.$(window.parent.document).find("a:contains("+secondLevelMenu+")").parent("li").hasClass("active")){
				parent.$(window.parent.document).find("a:contains("+secondLevelMenu+")").click();
			}
			//然后跳转到对应的页面
			window.location.href = turn2Page;
		}
	});
}