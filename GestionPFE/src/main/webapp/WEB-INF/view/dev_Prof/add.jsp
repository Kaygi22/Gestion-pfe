
<%@ include file="../layouts/headerDash.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Ajouter un nouvel étudiant</h1>
</div>

<form:form action="submitAddingProf" modelAttribute="Prof">
	<div class="form-group row">
		<label for="nom">Nom</label>
		<form:input type="text" class="form-control form-control-user"
			name="nom" id="nom" placeholder="Nom" path="nom" />

	</div>
	<div class="form-group">
		<label for="cin">Prenom</label>
		<form:input type="text" class="form-control form-control-user"
			id="prenom" name="prenom" placeholder="Prénom du prof" path="prenom" />
	</div>
	<div class="form-group">
		<label for="filiere">Département</label>
		<form:select class="form-control" id="filiere" path="departement">
			<option>DMI</option>
			<option>DGCEE</option>
		</form:select>
	</div>

	<div class="form-group" style="text-align: center">
		<button type="submit" class="btn btn-primary btn-icon-split">
			<span class="icon text-white-50"> <i class="fas fa-flag"></i>
			</span> <span class="text">Enregistrer</span>
		</button>
	</div>

</form:form>

<%@ include file="../layouts/footerDash.jsp"%>
