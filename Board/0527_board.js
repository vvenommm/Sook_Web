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
    			code += '작성자 '+ v.writer +'&nbsp;&nbsp;&nbsp;&nbsp;';
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
				cont = v.content;
				content = cont.replace(/\r/g, "").replace(/\n/g, "<br>")
				
				code += '<div class="panel panel-default">';
   				code += '<div class="panel-heading">';
    			code += '<h3 class="panel-title">';
    			code += '<a idx="' + v.num + '" <a data-toggle="collapse" data-parent="#accordion" href="#collapse'+ v.num +'">' + v.subject + '</a>';
    			code += '</h3>';
    			code += '</div>';
    			code += '<div id="collapse'+ v.num +'" class="panel-collapse collapse">';
    			code += '<div class="panel-body">';
    			code += '<p class="p1">';
//    			code += '글번호 '+ v.num +'&nbsp;&nbsp;&nbsp;&nbsp;';
    			code += '글번호 '+ v.num +'&emsp;&emsp;&emsp;&emsp;';
    			code += '작성자<span class="spW"> '+ v.writer +'</span>&emsp;&emsp;&emsp;&emsp;';
    			code += '이메일<span class="spE"> '+ v.mail +'</span>&emsp;&emsp;&emsp;&emsp;';
    			code += '조회수<span class="hit">'+ v.hit +'</span> &emsp;&emsp;&emsp;&emsp;';
    			code += '날짜 '+v.wdate;
    			code += '</p>';
    			code += '<p class="p2">';
    			code += '<input idx="'+ v.num +'"type="button" value="수정" class="action" name="edit">';
    			code += '<input idx="'+ v.num +'"type="button" value="삭제" class="action" name="delete">';
    			code += '</p>';
    			code += '<br>------------------------------------------------------------------------------------------------------------------------<br><br>';
    			code += '<p class="p3">';
    			code += content;
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
			if(res.startPage > 1){
				pager += '<ul class="pagination">';
				pager += '<li class="page-item"><a class="page-link prev" href="#">Previous</a></li>';
				pager += '</ul>';
			}
			
			//페이지 번호
			for (i = res.startPage; i <= res.endPage; i++){
			pager += '<ul class="pagination pager">';
				if(i == currentPage){
					pager += '<li class="page-item active"><a class="page-link" href="#">' + i + '</a></li>';
				}else{
					pager += '<li class="page-item"><a class="page-link" href="#">' + i + '</a></li>';
				}
			pager += '</ul>';
			}
			
			endmsg = "마지막 페이지입니다."
			//다음 버튼
			if(res.totalPage > res.endPage){
				pager += '<ul class="pagination">';
				pager += '<li class="page-item"><a class="page-link nxt" href="#">Next</a></li>';
				pager += '</ul>';
			}
				
			
			$('#d1').html(code);
			$('#pageList').html(pager);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

writeSend=function(){
	//입력한 모든 값 가져오기
	formData = $('#wform').serializeJSON();
	
	$('#wform .wItem').val("");
	$('#writeModal').modal('hide');
	
	$.ajax({
		url : '/BoardPro/Write.do',
		data : formData,
		type : 'post', 
		success : function(res){
//			alert(res.sw);
			listPageServer(currentPage);
		},
		dataType : 'json',
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}
	})
}

deletePostServer=function(){
	
	$.ajax({
		url : '/BoardPro/Delete.do',
		data : {"num" : idx},
		type : 'get',
		success : function(res){
			listPageServer(currentPage);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

editPostServer=function(){
	
	$.ajax({
		url : '/BoardPro/Edit.do',
		data : formData,
		type : 'post',
		async : false, //억지로 동기화 시켜서 동시다발로 수행하지 못하도록. 아니면 success 안에 $.ajax 함수를 넣어서 동기식으로 진행되게
		success : function(res){
			alert(res.sw);
			listPageServer(currentPage);
//			$.ajax({}) -> 동기식으로 하는 방법2
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

updateHitServer=function(){
	
	$.ajax({
		url : '/BoardPro/UpdateHit.do',
		data : {"num" : vnum},
		type : 'get',
		success : function(res){
//			alert(res.sw);
			vhit = $(parent).find('.hit').text();
			$(parent).find('.hit').text(parseInt(vhit) + 1);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

replySaveServer=function(){
	
	$.ajax({
		url : '/BoardPro/ReplySave.do',
		data : reply,
		type : 'post',
		success : function(res){
			alert(res.sw);
		},
		error : function(xhr){
			alert("상태 : " : xhr.status);
		},
		dataType : 'json'
	})
}
