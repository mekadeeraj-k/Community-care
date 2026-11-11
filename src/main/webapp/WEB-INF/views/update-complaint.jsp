
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.community.model.Complaint" %>

<%
    Complaint complaint = (Complaint) request.getAttribute("complaint");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community Care - Update Complaint</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f4f7;
        margin: 0;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .update-container {
        background-color: white;
        width: 400px;
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 8px;
        margin: 20px;
    }

    h1, h2, p {
        text-align: center;
    }

    input[type="text"],
    select,
    textarea {
        width: 100%;
        padding: 10px;
        margin: 8px 0 15px;
        box-sizing: border-box;
    }

    textarea {
        min-height: 100px;
    }

    button {
        padding: 10px 15px;
        background-color: #2563eb;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .back-link {
        margin-left: 15px;
    }
</style>
</head>

<body>

<div class="update-container">

    <h1>Community Care</h1>
    <h2>Update Complaint</h2>

    <p>Modify your complaint details and submit the changes.</p>

    <form action="updateComplaint" method="post">

        <input type="hidden" name="complaintId"
               value="<%= complaint.getComplaintId() %>">

        <label>Complaint Title</label>
        <input type="text" name="complaintTitle"
               value="<%= complaint.getComplaintTitle() %>" required>

        <label>Complaint Type</label>
        <select name="complaintType" required>

            <option value="Maintenance"
                <%= "Maintenance".equals(complaint.getComplaintType()) ? "selected" : "" %>>
                Maintenance
            </option>

            <option value="Water"
                <%= "Water".equals(complaint.getComplaintType()) ? "selected" : "" %>>
                Water
            </option>

            <option value="Electricity"
                <%= "Electricity".equals(complaint.getComplaintType()) ? "selected" : "" %>>
                Electricity
            </option>

            <option value="Other"
                <%= "Other".equals(complaint.getComplaintType()) ? "selected" : "" %>>
                Other
            </option>

        </select>

        <label>Description</label>
        <textarea name="description" required><%= complaint.getDescription() %></textarea>

        <button type="submit">Update Complaint</button>

        <a class="back-link"
           href="${pageContext.request.contextPath}/community/resident-dashboard">
            Back
        </a>

    </form>

</div>

</body>
</html>
