/**
 * 
 */

listServer = function(){
	$.ajax({
		url : '/BoardPro/BoardList.do',
		type : 'get',
		success : function(res){
			code = "<div class='container'>";
			code += '<div class="panel-group" id="accordion">';
			$.each(res, function(i, v){
				code += '<div class="panel panel-default">';
   				code += '<div class="panel-heading">';
    			code += '<h3 class="panel-title">';
    			code += '<a data-toggle="collapse" data-parent="#accordion" href="#collapse'+ v.num +'">' + v.subject + '</a>';
    			code += '</h3>';
    			code += '</div>';
    			code += '<div id="collapse'+ v.num +'" class="panel-collapse collapse">';
    			code += '<div class="panel-body">';
    			code += '<p class="p1">';
    			code += '작성자 '+ v.writer +'&emsp;&emsp;&emsp;&emsp;';
    			code += '이메일 '+ v.mail +'&emsp;&emsp;&emsp;&emsp;';
    			code += '조회수<span class="hit">'+ v.hit +'</span> &emsp;&emsp;&emsp;&emsp;';
    			code += '날짜 '+v.wdate;
    			code += '</p>';
    			code += '<p class="p2">';
    			code += '<input idx="'+ v.num +'"type="button" value="수정" class="action" name="edit">';
    			code += '<input idx="'+ v.num +'"type="button" value="삭제" class="action" name="delete">';
    			code += '</p>';
    			code += '<p class="p3">';
    			code += v.content;
    			code += '</p>';
    			code += '<p class="p4">';
    			code += '<textarea rows="5" cols="60"></textarea>';
    			code += '<input idx="'+ v.num +'"type="button" value="등록" class="action" name="reply">';
    			code += '</p>';
    			code += '</div>';
    			code += '</div>';
    			code += '</div>';
			})
			code += '</div>';
			code += '</div>';
			
			$('#d1').html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

currentPage = 1;

listPageServer = function(page){
	stype = $('#stype option:selected').val().trim();
	sword = $('#sword').val().trim();
	
	$.ajax({
		url : '/BoardPro/BoardList.do',
		type : 'post',
		data : {"page" : page,
					"stype" : stype,
					"sword" : sword}, //"서블릿 setAttribute와 일치해 하는 이름"
		success : function(res){
			code = "<div class='container'>";
			code += '<div class="panel-group" id="accordion">';
			$.each(res.data, function(i, v){
				code += '<div class="panel panel-default">';
   				code += '<div class="panel-heading">';
    			code += '<h3 class="panel-title">';
    			code += '<a data-toggle="collapse" data-parent="#accordion" href="#collapse'+ v.num +'">' + v.subject + '</a>';
    			code += '</h3>';
    			code += '</div>';
    			code += '<div id="collapse'+ v.num +'" class="panel-collapse collapse">';
    			code += '<div class="panel-body">';
    			code += '<p class="p1">';
    			code += '작성자 '+ v.writer +'&emsp;&emsp;&emsp;&emsp;';
    			code += '이메일 '+ v.mail +'&emsp;&emsp;&emsp;&emsp;';
    			code += '조회수<span class="hit">'+ v.hit +'</span> &emsp;&emsp;&emsp;&emsp;';
    			code += '날짜 '+v.wdate;
    			code += '</p>';
    			code += '<p class="p2">';
    			code += '<input idx="'+ v.num +'"type="button" value="수정" class="action" name="edit">';
    			code += '<input idx="'+ v.num +'"type="button" value="삭제" class="action" name="delete">';
    			code += '</p>';
    			code += '<p class="p3">';
    			code += v.content;
    			code += '</p>';
    			code += '<p class="p4">';
    			code += '<textarea rows="5" cols="60"></textarea>';
    			code += '<input idx="'+ v.num +'"type="button" value="등록" class="action" name="reply">';
    			code += '</p>';
    			code += '</div>';
    			code += '</div>';
    			code += '</div>';
			})
			code += '</div>';
			code += '</div>';
			
			msg = "첫 번째 페이지입니다.";
			//이전 버튼
			pager = "";
			pager += '<ul class="pagination">';
			if(res.startPage > 1){
				pager += '<li class="page-item"><a class="page-link" href="#">Previous</a></li>';
				pager += '</ul>';
			}else{
				pager += '<li class="page-item"><a class="page-link" onclick="alert(msg)">Previous</a></li>';
			}
			
			//페이지 번호
			pager += '<ul class="pagination pager a">';
			for (i = res.startPage; i <= res.endPage; i++){
				if(i == currentPage){
					pager += '<li class="page-item active pager a"><a class="page-link" href="#">' + i + '</a></li>';
				}else{
					pager += '<li class="page-item pager a"><a class="page-link" href="#">' + i + '</a></li>';
				}
			}
			pager += '</ul>';
			
			endmsg = "마지막 페이지입니다."
			//다음 버튼
				pager += '<ul class="pagination">';
			if(res.totalPage > res.endPage){
				pager += '<li class="page-item"><a class="page-link" href="#">Next</a></li>';
			}else{
				pager += '<li class="page-item"><a class="page-link" onclick="alert(endmsg)">Next</a></li>';
			}
			pager += '</ul>';
				
			
			$('#d1').html(code);
			$('#pageList').html(pager);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}
