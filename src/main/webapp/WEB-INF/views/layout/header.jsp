<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Product</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
        />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link
            href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
            rel="stylesheet"
        />
        <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            rel="stylesheet"
        />
        <link href="/css/style.css" rel="stylesheet" />
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">쇼핑몰</a>
                <c:if test="${principal.role == 'admin'}">
                    <a class="navbar-brand" href="/">관리자 모드</a></c:if
                >
                <c:if test="${principal.role == 'member'}">
                    <a class="navbar-brand" href="/">구매자 모드</a></c:if
                >

                <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavbar"
                >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav">
                        <c:if test="${principal == null}">
                            <li class="nav-item">
                                <a class="nav-link" href="/loginForm">로그인</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="/admin/joinForm"
                                    >관리자 회원가입</a
                                >
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="/members/joinForm"
                                    >구매자 회원가입</a
                                >
                            </li>
                        </c:if>

                        <li class="nav-item">
                            <a class="nav-link" href="/listForm">상품목록</a>
                        </li>
                        <c:if test="${principal.role == 'member'}">
                            <li class="nav-item">
                                <a class="nav-link" href="/orders/ordersList"
                                    >구매목록</a
                                >
                            </li></c:if
                        >
                        <c:if test="${principal.role == 'admin'}">
                            <li class="nav-item">
                                <a class="nav-link" href="/product/add"
                                    >상품등록페이지</a
                                >
                            </li></c:if
                        >

                        <c:if test="${principal != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="/logout">로그아웃</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
