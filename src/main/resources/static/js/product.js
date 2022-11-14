let isProductNameSameCheck = false;


$("#btnSave").click(() => {
	save();
});


$("#btnProductNameSameCheck").click(() => {
	checkProductName();
});



function save() {

	if (isProductNameSameCheck == false) {
		alert("상품명 중복체크를 확인해주세요");
		return;
	}

	if (productPriceKoreanCheck()) {
		alert("가격에 한글이 있으면 안됩니다.");
		return;
	}

	if (productQtyKoreanCheck()) {
		alert("수량에 한글이 있으면 안됩니다.");
		return;
	}

	if (productPriceBlankCheck() == false) {
		alert("상품 가격에 공백이 있으면 안됩니다");
		return;
	}

	if (productQtyBlankCheck() == false) {
		alert("상품 수량에 공백이 있으면 안됩니다");
		return;
	}

	let data = {
		productName: $("#productName").val(),
		productPrice: $("#productPrice").val(),
		productQty: $("#productQty").val()
	};

	$.ajax("/product/add", {
		type: "POST",
		dataType: "json", //응답 데이터(CMRespDto)
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			location.href = "/";
		} else {
			alert("중복체크를 다시 확인해주세요");
			history.back();
		}
	});
}


// 상품명 중복체크
function checkProductName() {
	let productName = $("#productName").val();

	$.ajax("/product/productNameSameCheck?productName=" + productName, {
		type: "GET",
		dataType: "json",
		async: true
	}).done((res) => {
		if (res.code == 1) { // 통신 성공
			if (res.data == false) {
				alert("상품명이 중복되지 않습니다.");
				isProductNameSameCheck = true;
			} else {
				alert("상품명이 중복되었어요. 다른 상품명을 사용해주세요.");
				isProductNameSameCheck = false;
				
			}
		}
	});
}



// 상품가격, 수량 한글체크
function productPriceKoreanCheck() {
	let productPrice = $("#productPrice").val();

	let korRule = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if (korRule.test(productPrice)) {
		return true;
	} else {
		return false;
	}
}

function productQtyKoreanCheck() {
	let productQty = $("#productQty").val();

	let korRule = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if (korRule.test(productQty)) {
		return true;
	} else {
		return false;
	}

}


// 상품가격, 수량 공백체크
function productPriceBlankCheck() {
	let productPrice = $("#productPrice").val();
	let reg = /\s/g;

	if (reg.test(productPrice)) {
		return false;
	} else {
		return true;
	}
}

function productQtyBlankCheck() {
	let productQty = $("#productQty").val();
	let reg = /\s/g;

	if (reg.test(productQty)) {
		return false;
	} else {
		return true;
	}
}







