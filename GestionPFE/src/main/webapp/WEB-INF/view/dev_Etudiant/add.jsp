
<%@ include file="../layouts/headerDash.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Ajouter un nouvel �tudiant</h1>
</div>

<form:form action="submitAdding"  modelAttribute="Etudiant">
	<div class="form-group row">
		<div class="col-sm-6 mb-3 mb-sm-0">
			<form:input type="text" class="form-control form-control-user" name="nom"
				id="nom" placeholder="Nom" path="Nom" />
		</div>
		<div class="col-sm-6">
			<form:input type="text" class="form-control form-control-user"
				name="prenom" id="prenom" placeholder="Pr�nom" path="Prenom" />
		</div>
	</div>
	<div class="form-group">
		<label for="cin">CIN</label> <form:input type="text"
			class="form-control form-control-user" id="cin" name="CNE"
			placeholder="CIN d'�tudiant" path="CNE" />
	</div>
	<div class="form-group">
		<label for="filiere">Fili�re</label> <form:select class="form-control"
			id="filiere" path="Filiere">
			<option>G�nie informatique</option>
			<option>G�nie civil</option>
			<option>G�nie de l'eau et l'environnement</option>
			<option>G�nie �n�rgitique et �nergies renouvelables</option>
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
