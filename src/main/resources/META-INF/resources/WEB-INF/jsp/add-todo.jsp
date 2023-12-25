   <%@ include file="common/header.jspf" %>
   <%@ include file="common/navigation.jspf" %>
   <div class="container">
      <h1> Add Todo </h1>
      <hr>
            <form:form method="post" modelAttribute="todo" action="${pageContext.request.contextPath}/add-todo">
      
                    <fieldset class="mb-3">
                       <form:label path="id">ID</form:label>
                       <form:input type="hidden" path="id"></form:input>
                    </fieldset>
                    
                    <fieldset class="mb-3">
                       <form:label path="id">Description</form:label>
                       <form:input type="text" path="description" required="required"></form:input>
                       <form:errors path="description" cssClass="text-warning"></form:errors>
                    </fieldset>
                    
                    <fieldset class="mb-3">
                       <form:label path="id">Date</form:label>
                       <form:input type="date" path="date"></form:input>
                    </fieldset>
                    
                    <fieldset class="mb-3">
                       <form:label path="id">Status</form:label>
                       <form:input type="text" path="status"></form:input>
                    </fieldset>
                    
                    <input type="submit" class="btn btn-success">
           </form:form>
      </div>
      <%@ include file="common/footer.jspf" %>