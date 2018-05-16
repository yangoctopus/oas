function openPrivielege(pid){
	
	//获得窗口的垂直位置 
    var iTop = (window.screen.availHeight - 30 - 400) / 2; 
    //获得窗口的水平位置 
    var iLeft = (window.screen.availWidth - 10 - 400) / 2; 
	
	 window.open("menusAction_loadPrivilegeUI.action?pid="+pid,""
				,"location=no,height=400,width=400,status=no," +
						"left="+iLeft+",top="+iTop);
	 
}

