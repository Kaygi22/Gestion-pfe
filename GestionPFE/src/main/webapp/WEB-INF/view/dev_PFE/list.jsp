
<%@ include file="../layouts/headerDash.jsp"%>



<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Liste des Projets de fin d'année</h1>
</div>

<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Liste des PFE</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Sujet</th>
						<th>Liste des encadrants</th>
						<th>Manage encadrants</th>
						<th>Liste des jurés</th>
						<th>Manage jurés</th>
						<th>Manage pfe</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${pfes}" var="pfe">
						<tr>
							<td><c:out value="${pfe.sujet}" /></td>

							
							<td>
								<ul>
									<c:forEach items="${pfe.encadrants}" var="encadrant">
										<li><c:out value="${encadrant.nom}" /></li>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${pfe.encadrants}" var="encadrant">
										<li><a
											href="${contextPath}/PFE/delete_encadrant?id_pfe=${pfe.id_pfe}&id_prof=${encadrant.code}"
											class="btn btn-info btn-circle btn-sm"> <i
												class="fas fa-trash"></i>
										</a></li>
									</c:forEach>
								</ul>

							</td>
							<td>
								<ul>
									<c:forEach items="${pfe.jury}" var="jury">
										<li><c:out value="${jury.nom}" /></li>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${pfe.jury}" var="jury">
										<li><a
											href="${contextPath}/PFE/delete_jury?id_pfe=${pfe.id_pfe}&id_jury=${jury.code}"
											class="btn btn-info btn-circle btn-sm"> <i
												class="fas fa-trash"></i>
										</a></li>
									</c:forEach>
								</ul>
							</td>
							<td><a
								href="${contextPath}/PFE/delete_PFE?id_pfe=${pfe.id_pfe}"
								class="btn btn-info btn-circle btn-sm"> <i
									class="fas fa-trash"></i>
							</a></td>

						</tr>

					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>



<%@ include file="../layouts/footerDash.jsp"%>
