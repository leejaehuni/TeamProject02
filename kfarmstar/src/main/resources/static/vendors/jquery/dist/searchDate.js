$(document).ready(function(){
	
	let today = new Date();
	let newDay = new Date(today);
	
	newDay.setDate(today.getDate() + 3);
	
    //btn_reset 을 클릭했을때의 함수
    $( "#btn_reset").click(function () {
        $( "#reset_form" ).each( function () {
            this.reset();
        });
        $(".searchBtn").find('button').removeClass('btn-primary').addClass('btn-light');
    });
    
    $(document).on('click','button[name="filterDate"]', function(){
        console.log('1-1 btn-light == '+ $(this).hasClass('btn-light'));
        console.log('1-2 btn-primary == '+ $(this).hasClass('btn-primary'));
        
        
		if($(this).hasClass('btn-light') == true && $(this).hasClass('btn-primary') == false ){
			$('.searchBtn').find('button').removeClass('btn-primary');
			$(this).removeClass('btn-light').addClass('btn-primary');
		   
		}else if($(this).hasClass('btn-light') == false && $(this).hasClass('btn-primary') == false ){
			$('.searchBtn').find('button').removeClass('btn-primary');
			$(this).removeClass('btn-light').addClass('btn-primary');
		}else {
			$('.searchBtn').find('button').removeClass('btn-light');
			$(this).removeClass('btn-primary').addClass('btn-light');
		}
     });
    
    
    
    function timeFunctionLong(input) {
		setTimeout(function() {
			input.type = 'text';
		}, 60000);
	}
    
    $(function() {
        /*$( ".datepicker" ).datepicker();*/
    	
    	$('#startDate').datepicker({
            onClose: function( selectedDate ) {    
                // 시작일(fromDate) datepicker가 닫힐때
                // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                $("#startDate").datepicker( "option", "minDate", selectedDate );
            }                
        });

        //종료일
        $('#endDate').datepicker({
            onClose: function( selectedDate ) {
                // 종료일(toDate) datepicker가 닫힐때
                // 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
                $("#startDate").datepicker( "option", "maxDate", selectedDate );
            }                
        });
        
        
    });
    
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        prevText: '이전',
        nextText: '다음',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
    
});


