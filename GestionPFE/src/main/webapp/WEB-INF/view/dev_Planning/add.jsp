
<%@ include file="../layouts/headerDash.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Ajouter une nouvelle planification</h1>
</div>

<form:form action="submitAddingPlanning" modelAttribute="Planning">
	
	
	<div class="form-group row">
		<label for="sujet">Date</label> <input type="text"
			class="form-control form-control-user" name="date" id="date"
			placeholder="Date" />

	</div>
	
	<div class="form-group">
		<label for="filiere">Etudiant</label> 
		<select class="form-control"
			id="id_etudiant" name="id_etudiant">
			<c:forEach items="${etudiants}" var="etudiant">
				<option value="${etudiant.CNE}" >${etudiant.prenom} ${etudiant.nom}</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="form-group">
		<label for="filiere">PFE</label> <select class="form-control"
			id="id_pfe" name="id_pfe" >
			<c:forEach items="${pfes}" var="pfe">
				<option value="${pfe.id_pfe}" >${pfe.sujet}</option>
			</c:forEach>
		</select>
	</div>

	<div class="form-group" style="text-align:center">
		<button type="submit" class="btn btn-primary btn-icon-split">
			<span class="icon text-white-50"> <i class="fas fa-flag"></i>
			</span> <span class="text">Enregistrer</span>
		</button>
	</div>

</form:form>

<%@ include file="../layouts/footerDash.jsp"%>
