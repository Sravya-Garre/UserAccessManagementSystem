<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Request Access</title>
</head>
<body>
    <h2>Request Access</h2>
    <form action="RequestServlet" method="post">
        <label for="software">Software Name:</label>
        <select name="software" id="software">
            <!-- Dynamically populate from database -->
        </select><br><br>
        <label for="access_type">Access Type:</label>
        <select name="access_type" id="access_type">
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br><br>
        <label for="reason">Reason:</label>
        <textarea id="reason" name="reason"></textarea><br><br>
        <button type="submit">Request Access</button>
    </form>
</body>
</html>
