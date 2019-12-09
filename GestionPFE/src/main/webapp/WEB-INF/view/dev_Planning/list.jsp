
<%@ include file="../layouts/headerDash.jsp"%>



<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Liste des PFE plannifiés</h1>
</div>

<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Liste des planning</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Date</th>
						<th>Sujet PFE</th>
						<th>Etudiant</th>
						<th>Manage</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${plannings}" var="planning">
						<tr>
							<td><c:out value="${planning.date}" /></td>

							<td><c:out value="${planning.pfe.sujet}" /></td>

							<td><c:out
									value="${planning.etudiant.nom} ${planning.etudiant.prenom}" /></td>
							
							<td>
								<a
								href="${contextPath}/Planning/delete_planning?id=${planning.id_plan}"
								class="btn btn-info btn-circle btn-sm"> <i
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
