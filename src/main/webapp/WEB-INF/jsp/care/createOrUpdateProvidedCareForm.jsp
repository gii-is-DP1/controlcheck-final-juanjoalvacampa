<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="Provided Cares">
    <jsp:attribute name="customScript">
    </jsp:attribute>
    <jsp:body>
        <h2>
        	Feeding
    	</h2>
        <form:form modelAttribute="providedCare" class="form-horizontal" id="add-feeding-form">
            <div class="form-group has-feedback">
                
                <petclinic:inputField label="Name" name="name"/>
                <petclinic:inputField label="Description" name="description"/>
                <petclinic:inputField label="Compatible_pet_types" name = "compatible_pet_types"/>
              
                <div class="control-group">
                    <petclinic:selectField name="care" label="Care" names="${cares}" size="1"/>
                </div>
                
            </div>
                       
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default" type="submit">Save provided care</button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</petclinic:layout>
