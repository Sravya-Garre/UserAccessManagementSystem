<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Software</title>
</head>
<body>
    <h2>Create Software</h2>
    <form action="SoftwareServlet" method="post">
        <label for="name">Software Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>
        <label>Access Levels:</label><br>
        <input type="checkbox" id="read" name="access_levels" value="Read"> Read
        <input type="checkbox" id="write" name="access_levels" value="Write"> Write
        <input type="checkbox" id="admin" name="access_levels" value="Admin"> Admin<br><br>
        <button type="submit">Create Software</button>
    </form>
</body>
</html>
