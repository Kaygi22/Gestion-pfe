
<%@ include file="../layouts/headerDash.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Ajouter un nouvel étudiant</h1>
</div>

<form:form action="submitAdding"  modelAttribute="Etudiant">
	<div class="form-group row">
		<div class="col-sm-6 mb-3 mb-sm-0">
			<form:input type="text" class="form-control form-control-user" name="nom"
				id="nom" placeholder="Nom" path="Nom" />
		</div>
		<div class="col-sm-6">
			<form:input type="text" class="form-control form-control-user"
				name="prenom" id="prenom" placeholder="Prénom" path="Prenom" />
		</div>
	</div>
	<div class="form-group">
		<label for="cin">CIN</label> <form:input type="text"
			class="form-control form-control-user" id="cin" name="CNE"
			placeholder="CIN d'étudiant" path="CNE" />
	</div>
	<div class="form-group">
		<label for="filiere">Filière</label> <form:select class="form-control"
			id="filiere" path="Filiere">
			<option>Génie informatique</option>
			<option>Génie civil</option>
			<option>Génie de l'eau et l'environnement</option>
			<option>Génie énérgitique et énergies renouvelables</option>
		</form:select>
	</div>

	<div class="form-group" style="text-align:center">
		<button type="submit" class="btn btn-primary btn-icon-split">
			<span class="icon text-white-50"> <i class="fas fa-flag"></i>
			</span> <span class="text">Enregistrer</span>
		</button>
	</div>

</form:form>

<%@ include file="../layouts/footerDash.jsp"%>
