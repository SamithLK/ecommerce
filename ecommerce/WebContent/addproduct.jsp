<%@page import="com.mypackage.dao.CategoryDao"%>
<%@page import="com.mypackage.connection.DbCon"%>
<%@page import="com.mypackage.model.Category"%>
<%@page import= "java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Product</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .container {
      max-width: 400px;
      width: 100%;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 8px;
      background-color: #f9f9f9;
    }
    h1 {
      margin-bottom: 20px;
      text-align: center;
    }
    .form-group {
      margin-bottom: 20px;
    }
    label {
      display: block;
      margin-bottom: 5px;
    }
    input[type="text"],
    input[type="file"] {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    button[type="submit"] {
      width: 100%;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    button[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

<div class="container">
  <h1>Add New Product</h1>
  <form action="AdminUpdateProducts" method="post" enctype="multipart/form-data">
    <input type="hidden" name="operation" value="addProduct">  <div class="form-group">
      <label for="name">Product Name:</label>
      <input type="text" name="name" id="name" required>
    </div>

    <div class="form-group">
      <label for="description">Description:</label>
      <textarea name="description" id="description" rows="5" required></textarea>  </div>

    <div class="form-group">
      <label for="price">Price:</label>
      <input type="number" name="price" id="price" min="0" step="0.01" required>  </div>

    <div class="form-group">
      <label for="discount">Discount (%):</label>
      <input type="number" name="discount" id="discount" min="0" max="100" required>
    </div>

    <div class="form-group">
      <label for="quantity">Quantity:</label>
      <input type="number" name="quantity" id="quantity" min="0" required>
    </div>

    <div class="form-group">
      <label for="photo">Product Image:</label>
      <input type="file" name="photo" id="photo" required>
    </div>

   <div class="form-group">
      <label class="form-label"><b>Select Category Type</b></label> <select
									name="categoryType" class="form-control">
									<option value="0">--Select Category--</option>
									<%
									CategoryDao categoryDao = new CategoryDao(DbCon.getConnection());
									List<Category> categoryList = categoryDao.getAllCategories();
									for (Category c : categoryList) {
									%>
									<option value="<%=c.getCategoryId()%>">
										<%=c.getCategoryName()%></option>
									<%
									}
									%>
								</select>
    </div>

    <button type="submit">Add Product</button>
  </form>
</div>

</body>
</html>
