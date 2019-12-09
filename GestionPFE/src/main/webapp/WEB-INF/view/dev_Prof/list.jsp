
<%@ include file="../layouts/headerDash.jsp"%>



<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Liste des étudiants</h1>
</div>

<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Liste des étudiants</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Département</th>
						<th>Manage</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${profs}" var="prof" >
						<tr>
							<td><c:out value="${prof.nom}"/></td>
							<td><c:out value="${prof.prenom}"/></td>
							<td><c:out value="${prof.departement}"/></td>
							<td>
							<a href="${contextPath}/Prof/edit_prof?id=${prof.code}" class="btn btn-info btn-circle btn-sm">
									<i class="fas fa-info-circle"></i>
							</a> <a href="${contextPath}/Prof/delete_prof?id=${prof.code}" class="btn btn-danger btn-circle btn-sm"> <i
									class="fas fa-trash"></i>
							</a>
							</td>
						</tr>

					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
</div>



<%@ include file="../layouts/footerDash.jsp"%>
