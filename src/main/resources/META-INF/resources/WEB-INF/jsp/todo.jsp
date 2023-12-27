   <%@ include file="common/header.jspf" %>
   <%@ include file="common/navigation.jspf" %>
   <div class="container">
      <h1> Welcome to SpringVerse,${username}</h1>
      <hr>
      <h2>Your Todo List is:</h2>
      <table class="table">
        <thead>
           <tr>
                 
                  <th>Description</th>
                  <th>Target Date</th>
                  <th>is Done?</th>
                  <th></th>
                  <th></th>
           </tr>
        </thead>
        
        <tbody>
              <c:forEach items="${todos}" var="todo">
              <tr>
                 
                  <td>${todo.description}</td>
                  <td>${todo.date}</td>
                  <td>${todo.status}</td>
                  <td><a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a></td>
                  <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                  
           </tr>
              </c:forEach>
      </tbody>
      </table>
      <a href="add-todo" class="btn btn-success"> Add Todo</a>
      </div>
      <%@ include file="common/footer.jspf" %>