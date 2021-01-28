<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>

<section id="empleados">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Empleados</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Salario</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de empleados -->
                            <c:forEach var="empleado" items="${empleados}" varStatus="status" >
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${empleado.nombre} ${empleado.apellido}</td>
                                    <td> 
                                        <fmt:formatNumber value="${empleado.salario}" type="currency"/> </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idEmpleado=${empleado.idEmpleado}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!--Inicio Tarjetas para los totales-->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Salario Total</h3>
                        <h4 class="display-4">
                        <fmt:formatNumber value="${salarioTotal}" type="currency" />
                        </h4>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Empleados</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalEmpleados}
                        </h4>
                    </div>
                </div>        
            </div>
            <!--Fin Tarjetas para los totales-->
        </div>
    </div>
</section>

<!-- Agregar empleado MODAL -->
<jsp:include page="/WEB-INF/paginas/empleados/agregarEmpleado.jsp"/>
                        