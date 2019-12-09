
<%@ include file="../layouts/headerDash.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Ajouter un nouvel étudiant</h1>
</div>

<form action="submitAddingPFE" modelAttribute="pfe">
	<div class="form-group row">
		<label for="sujet">Sujet</label> <input type="text"
			class="form-control form-control-user" name="sujet" id="sujet"
			placeholder="Nom" />

	</div>
	
	
	<div class="form-group">
		<label for=encadrant>Encadrant</label> 
		<select class="form-control"
			id="encadrant" name="encadrant" multiple="true">
			<c:forEach items="${profs}" var="prof">
				<option value="${prof.code}" >${prof.nom} ${prof.prenom}</option>
			</c:forEach>
		</select>
	</div>  



	<div class="form-group">
		<label for=jury>Jury</label> 
		<select class="form-control"
			id="jury" name="jury" multiple="true">
			<c:forEach items="${profs}" var="prof">
				<option value="${prof.code}">${prof.nom} ${prof.prenom}</option>
			</c:forEach>
		</select>
	</div>

	<div class="form-group" style="text-align: center">
		<button type="submit" class="btn btn-primary btn-icon-split">
			<span class="icon text-white-50"> <i class="fas fa-flag"></i>
			</span> <span class="text">Enregistrer</span>
		</button>
	</div>


</form>

<%@ include file="../layouts/footerDash.jsp"%>
