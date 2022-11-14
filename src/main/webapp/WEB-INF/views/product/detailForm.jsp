<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/header.jsp"%>
<div class="container">
    <form
        action="/orders/${detail.productId}"
        method="post"
        accept-charset="UTF-8"
    >
        <div>
            <input
                type="hidden"
                name="ordersName"
                value=" ${detail.productName}"
            />
            <input
                type="hidden"
                name="ordersPrice"
                value=" ${detail.productPrice}"
            />

            <div class="mb-3 mt-3">상품명 : ${detail.productName}</div>
            <div class="mb-3 mt-3">
                상품가격 : ${detail.productPrice}&nbsp;원
            </div>
            <div class="mb-3 mt-3">상품재고 : ${detail.productQty}&nbsp;개</div>
        </div>
        <c:if test="${principal.role == 'member'}">

        <input type="hidden" value="${detail.productId}" />
        <select name="ordersCount">
            <c:forEach begin="1" end="10" var="i">
                <option value="${i}">${i}</option>
            </c:forEach></select
        >&nbsp;개
        </c:if>

        <button type="submit" class="btn btn-primary">구매하기</button>
                        </form>
        <c:if test="${principal.role == 'admin'}"> 
            <span><a href="/product/${detail.productId}/edit" class="btn         btn-warning">수정하러가기</a></span>
           </form>
          <form action="/product/${detail.productId}/delete" method="post">
                <button class="btn btn-danger">삭제하기</button>
           </form>
        </c:if>
</div>

<script></script>
<%@ include file="../layout/footer.jsp"%>
