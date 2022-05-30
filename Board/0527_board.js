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
