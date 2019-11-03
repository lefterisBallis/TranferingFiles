<%-- 
    Document   : welcome
    Created on : Sep 23, 2019, 9:58:12 AM
    Author     : leftb
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.MyFile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Mono:300,300i,400,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/css/vendors/ionicons.min.css">
        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
        <title>WebProject-FileTransfer</title>
    </head>

    <body>
        <header>
            <h1>File Tranfering</h1>
        </header>

        <div class="file-transfer" >
            <form action="Upload" method="POST" enctype="multipart/form-data">
                <input type="file" name="myfile">
                <input type="submit" value="Upload">
            </form>

        </div>
        <div class="file-table">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>File Name</th>
                        <th>File Size</th>
                        <th>Download</th>
                        <th>Delete</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach items="${allFiles}" var="mf">
                        <tr>
                            <td>${mf.id}</td>
                            <td>${mf.filename} </td>
                            
                            <td>${mf.filesize} KB</td>
                            <td><a href="Download?id=${mf.id}" download><i class="icon ion-ios-folder"></i></a></td>
                            <td><a href="DeleteFile?id=${mf.id}"><i class="icon ion-ios-trash"></i></a></td>
                        </tr>
                    </c:forEach>
                </tbody>



            </table>

        </div>
       
        
    </body>

</html>
