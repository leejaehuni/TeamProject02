$(document).ready(function(){
	
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
    
    $('.datepicker').datepicker({
	    beforeShow: function() {
	        setTimeout(function(){
	            $('.ui-datepicker').css('z-index', 99999999999999);
	        }, 0);
	    }
	});
    
    //오늘 버튼 클릭시 datePicker 오늘 검색
    $(function(){
    	 var
    	 todayDate = new Date(),
    	 todayYear = todayDate.getFullYear(),
    	 todayMonth = (todayDate.getMonth() + 1),
    	 todayDay = todayDate.getDate();
    	 /*setWeekDay = weekDate.setDate(todayDay - 7),
    	 getWeekDay = setWeekDate.getDate();*/
    	 
    	 /*if(todayMonth < 10){
    		 todayMonth = "0" + todayMonth;
    		 todayDate = (todayYear + "-" + todayMonth);
    		 if(todayDay < 10){
    			 todayDay = "0" + todayDay;
    			 todayDate += "-" + todayDay;
    		 }
    		 else if(todayDay >= 10){
    			 todayDate += "-" + todayDay;
    		 }
    	 }
    	 else if(todayMonth >= 10){
    		 todayDate = (todayYear + "-" + todayMonth); 
    		 if(todayDay < 10){
    			 todayDay = "0" + todayDay;
    			 todayDate += "-" + todayDay;
    		 }else if(todayDay >= 10){
    			 todayDate += "-" + todayDay;
    		 }
    	 }*/
    	 
		var startTodayDate = '';
		startTodayDate += todayYear;
		startTodayDate += '-'
		startTodayDate += todayMonth < 10 ? '0' + todayMonth : todayMonth;
		startTodayDate += '-'
		startTodayDate += todayDay < 10 ? '0' + todayDay : todayDay;
		
		var endTodayDate = '';
		endTodayDate += todayYear;
		endTodayDate += '-'
		endTodayDate += todayMonth < 10 ? '0' + todayMonth : todayMonth;
		endTodayDate += '-'
		endTodayDate += todayDay < 10 ? '0' + todayDay : todayDay;
    			 
    	$('#btn-date1').click(function(){
    		$('#startDate').val(startTodayDate);
    		$('#endDate').val(endTodayDate);
    		
    	});
    	
    	$('#btn-date2').click(function(){
    		var 
    		weekDate = new Date();
    		
    		
    		dayofMonth = weekDate.getDate();
    		
    		weekDay = weekDate.setDate(dayofMonth - 7);
    		weekDay = weekDate.getDate();
    		
    		console.log(weekDate);
    		
    		var getWeekDate = '';
    		getWeekDate += todayYear;
    		getWeekDate += '-'
    		getWeekDate += todayMonth < 10 ? '0' + todayMonth : todayMonth;
    		getWeekDate += '-'
    		getWeekDate += weekDay < 10 ? '0' + weekDay : weekDay;
    		
    		console.log(getWeekDate);
    		$('#endDate').val(endTodayDate);
    	});
    	
    });
    

    
    /*var date = new DATE();
    var date2 = new DATE();
    date.getFullYear();
    date.getMonth() + 1
    date.getDate()
    date2.setDate(date.getDate() - 7)
    date2.getDate()
    date2.setMonth(date.getMonth - 1);
    date.getMonth() + 1;*/
    
});


