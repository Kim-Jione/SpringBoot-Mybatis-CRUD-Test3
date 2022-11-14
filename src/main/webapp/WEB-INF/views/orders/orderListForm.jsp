<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/header.jsp"%>
<h1>구매목록 페이지</h1>
<div class="container">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>상품가격</th>
                <th>구매수량</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ordersList" items="${ordersList}">
                <tr>
                    <td>${ordersList.productId}</td>
                    <td>${ordersList.ordersName}</td>
                    <td>${ordersList.ordersPrice}</td>
                    <td>${ordersList.ordersCount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../layout/footer.jsp"%>
