<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>상품수량</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="product" items="${product}">
				<tr>
					<td>${product.productId}</td>
					<td><a href="/product/${product.productId}">${product.productName}</a></td>
					<td>${product.productPrice}</td>
					<td>${product.productQty}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

<%@ include file="../layout/footer.jsp"%>
