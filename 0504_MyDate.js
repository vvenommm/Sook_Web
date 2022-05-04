/**
 * 
 */

function proc1(){
	var now = new Date();
	
	var today1 = now.toLocaleString();
	var today2 = now.toLocaleDateString();
	var today3 = now.toLocaleTimeString();
	
	var out = document.querySelector('div'); //쿼리 셀렉터는 첫 번째거만 찾을 수 있다. 그래서 id를 주거나 querySelectorAll로 찾아야 함. 그치만 바뀔 수도 있기 때문에 all은 잘 안 씀. 그래서 아이디 사용을 권장
	
	//출력내용 생성
	var str = today1 + "<br>";
	str += today2 + "<br>";
	str += today3 + "<br>";
	
	out.innerHTML = str; 
}
