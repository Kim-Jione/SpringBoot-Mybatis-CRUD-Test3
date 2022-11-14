<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/header.jsp"%>

<div class="container">
    <form method="post" name="form">
        <div class="mb-3 mt-3">
            <input
                type="text"
                class="form-control"
                placeholder="아이디"
                name="username"
            />
        </div>
        <div class="mb-3">
            <input
                type="password"
                class="form-control"
                placeholder="비밀번호"
                name="password"
            />
        </div>
        <button
            type="submit"
            class="btn btn-warning"
            onclick="javascript: form.action='/admin/login';"
        >
            관리자 로그인
        </button>
        <button
            type="submit"
            class="btn btn-primary"
            onclick="javascript: form.action='/member/login';"
        >
            구매자 로그인
        </button>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>
