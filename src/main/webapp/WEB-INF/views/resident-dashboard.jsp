
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.community.model.Complaint" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community Care - Resident Dashboard</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f4f7;
        margin: 0;
        padding: 30px 15px;
    }

    .dashboard-container {
        max-width: 1000px;
        margin: auto;
        background-color: white;
        padding: 25px;
        border: 1px solid #ddd;
        border-radius: 8px;
    }

    h1, h2 {
        color: #222;
    }

    .welcome {
        margin-bottom: 25px;
    }

    .complaint-form {
        margin-bottom: 35px;
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
        padding: 9px 16px;
        background-color: #2563eb;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 15px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f2f4f7;
    }

    .actions a {
        margin-right: 10px;
    }

    .cancel-button {
        background-color: #dc2626;
    }

    .section {
        margin-top: 30px;
    }
</style>
</head>

<body>

<div class="dashboard-container">

    <h1>Community Care</h1>

    <div class="welcome">
        <h2>Welcome, ${resident.residentName}!</h2>
        <p>Submit and manage your community complaints here.</p>
    </div>

    <div class="complaint-form">

        <h2>Submit a Complaint</h2>

        <form action="${pageContext.request.contextPath}/community/submit-complaint"
              method="post">

            <label>Complaint Title</label>
            <input type="text" name="complaintTitle" required>

            <label>Complaint Type</label>
            <select name="complaintType" required>
                <option value="">Select Complaint Type</option>
                <option value="Plumbing">Plumbing</option>
                <option value="Electrical">Electrical</option>
                <option value="Lift / Elevator">Lift / Elevator</option>
                <option value="Housekeeping">Housekeeping</option>
                <option value="Security">Security</option>
                <option value="Parking">Parking</option>
                <option value="Water Supply">Water Supply</option>
                <option value="Noise">Noise</option>
                <option value="Maintenance">Maintenance</option>
                <option value="Other">Other</option>
            </select>

            <label>Description</label>
            <textarea name="description" required></textarea>

            <button type="submit">Submit Complaint</button>

        </form>

    </div>

    <div class="section">

        <h2>My Complaints</h2>

        <%
            List<Complaint> complaints =
                (List<Complaint>) request.getAttribute("complaints");
        %>

        <% if (complaints != null && !complaints.isEmpty()) { %>

            <table>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Created Date</th>
                    <th>Actions</th>
                </tr>

                <% for (Complaint complaint : complaints) { %>

                    <tr>
                        <td><%= complaint.getComplaintId() %></td>
                        <td><%= complaint.getComplaintTitle() %></td>
                        <td><%= complaint.getComplaintType() %></td>
                        <td><%= complaint.getDescription() %></td>
                        <td><%= complaint.getStatus() %></td>
                        <td><%= complaint.getCreatedAt() %></td>

                        <td class="actions">

                            <a href="${pageContext.request.contextPath}/community/complaintById?complaintId=<%= complaint.getComplaintId() %>">
                                Update
                            </a>

                            <% if ("PENDING".equals(complaint.getStatus())) { %>

                                <form action="${pageContext.request.contextPath}/community/cancelComplaint"
                                      method="post">

                                    <input type="hidden" name="complaintId"
                                           value="<%= complaint.getComplaintId() %>">

                                    <button type="submit" class="cancel-button">
                                        Cancel
                                    </button>

                                </form>

                            <% } %>

                        </td>
                    </tr>

                <% } %>

            </table>

        <% } else { %>

            <p>You haven't submitted any complaints yet.</p>

        <% } %>

    </div>

</div>

</body>
</html>
