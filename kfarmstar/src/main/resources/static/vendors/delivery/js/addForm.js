/**
 * Password 확인 버튼
 */

	function hideshow(){
		var password = document.getElementById("password1");
		var slash = document.getElementById("slash");
		var eye = document.getElementById("eye");
		
		if(password.type === 'password'){
			password.type = "text";
			slash.style.display = "block";
			eye.style.display = "none";
		}
		else{
			password.type = "password";
			slash.style.display = "none";
			eye.style.display = "block";
		}

	}
	
/**
 * 입력값 초기화 버튼
 */

	// initialize a validator instance from the "FormValidator" constructor.
	// A "<form>" element is optionally passed as an argument, but is not a must
	var validator = new FormValidator({
	    "events": ['blur', 'input', 'change']
	}, document.forms[0]);
	// on form "submit" event
	document.forms[0].onsubmit = function(e) {
	    var submit = true,
	        validatorResult = validator.checkAll(this);
	    console.log(validatorResult);
	    return !!validatorResult.valid;
	};
	// on form "reset" event
	document.forms[0].onreset = function(e) {
	    validator.reset();
	};
	// stuff related ONLY for this demo page:
	$('.toggleValidationTooltips').change(function() {
	    validator.settings.alerts = !this.checked;
	    if (this.checked)
	        $('form .alert').remove();
	}).prop('checked', false);


/**
 * 하단 페이지 버튼 
 */
	window.pagObj = $('#pagination').twbsPagination({ 
		totalPages: [[${dataListPage.totalPages}]], // 전체 페이지 
		startPage: parseInt([[${dataListPage.number}]] + 1), // 시작(현재) 페이지 
		visiblePages: 10, // 최대로 보여줄 페이지 
		prev: "‹", // Previous Button Label 
		next: "›", // Next Button Label 
		first: '«', // First Button Label 
		last: '»', // Last Button Label 
		onPageClick: function (event, page) { // Page Click event 
			console.info("current page : " + page); 
			} 
	}).on('page', function (event, page) { 
		searchDataList(page); 
	});

