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
        <div class="mb-3">
            <input
                type="text"
                class="form-control"
                placeholder="이름"
                name="adminName"
            />
        </div>
        <div class="mb-3">
            <input
                type="email"
                class="form-control"
                placeholder="이메일"
                name="adminEmail"
            />
        </div>
        <button
            type="submit"
            class="btn btn-warning"
            onclick="javascript: form.action='/admin/join';"
        >
            관리자 회원가입
        </button>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>
