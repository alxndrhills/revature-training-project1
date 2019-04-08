var currentUser = null;
var dataTable = null;

window.onload = function() {
	console.log('app loading..');
	checkLogin();
}

function showLogin() {
	$('#message').html('');
	$('#loginSection').show();
}

function hideLogin() {
	$('#loginSection').hide();
}

function hideReimbursements() {
	$('#ReimbursementListSection').hide();
	
	if (dataTable) {
		$('#Reimbursements').dataTable().fnDestroy();
	}
	dataTable = null;
}

function loginSuccessful(user) {
	currentUser = user;
	// set element visibilities based on user role
	if (user) {
		if (user.userRoleId == 1) {
			$("#approveReimbursement").hide();
			$("#denyReimbursement").hide();
			$("#statusFilter").hide();
			$("#showNewReimbursement").show();
		}
		else {
			$("#showNewReimbursement").hide();
			$("#approveReimbursement").show();
			$("#denyReimbursement").show();
			$("#statusFilter").show();
		}
	}
	
	refreshList();
}

function checkLogin() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
	
			if (user == null) {
				showLogin();
			} else {
				//logged in
				loginSuccessful(user);
			}
		}
	}
	xhr.open("GET", "login");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send();
}

function validateStrings(str) {
	if (str == null || str == '')
		return false;
	else
		return true;
}

function loginUser() {
	$('#message').html('');
	var name = $('#username').val();
	var pw = $('#password').val();

	if (validateStrings(name) || validateStrings(pw)) {
		var user = {
			username : name,
			password : pw
		};
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var user = JSON.parse(xhr.responseText);

				if (user == null) {
					$('#message').html('Login failed.');
				} else {
					//logged in
					currentUser = user;
					hideLogin();
					loginSuccessful(user);
				}
			}
		}
		xhr.open("POST", "login");
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(JSON.stringify(user));
	} else {
		$('#message').html('Please enter valid username and password!');
	}
}

function logoutUser() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			currentUser = null;
			hideReimbursements();
			showLogin();
		}
	}
	xhr.open("POST", "logout");
	xhr.send();
}

function createReimbursement() {
	let reimbursementType = $('#reimbursementType').val();
	let reimbursementDescription = $('#reimbursementDescription').val();
	let reimbursementAmount = $('#reimbursementAmount').val();
	
	if (validateForm(reimbursementAmount, reimbursementDescription, reimbursementType)) {
		var reimbursement = {
			amount: reimbursementAmount,
			reimbursementDescription: reimbursementDescription,
			reimbursementTypeId: reimbursementType
		};
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					showAlert("Request submitted successfully");
					refreshList();
				}
				else {
					$('#formMessage').html("Error submitting request");
					
				}
				$('#reimbursementType').val("");
				$('#reimbursementDescription').val("");
				$('#reimbursementAmount').val("");
				$('#ReimbursementDetailSection').modal('hide');
				$('#formMessage').html("");
			}
		}
		xhr.open("POST", "reimbursements");
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(JSON.stringify(reimbursement));
	}
}

function setReimbursementStatus(reimbursementId, reimbursementStatusId) {
	
	if (reimbursementId && reimbursementStatusId) {
		var reimbursement = {
			reimbursementId: reimbursementId,
			reimbursementStatusId: reimbursementStatusId
		};
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					showAlert("Reimbursement status updated successfully");
					refreshList();
				}
				else {
					showAlert("Error updating reimbursement status");
				}
			}
		}
		xhr.open("PUT", "reimbursements");
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(JSON.stringify(reimbursement));
	}
}

function statusFilterChange() {
	refreshList();
}

function refreshList() {
	let reimbursementStatusId = $('#reimbursementStatusFilter').val();
	loadReimbursements(currentUser, reimbursementStatusId);
}

function validateForm(reimbursementAmount, reimbursementDescription, reimbursementType) {
	if (!reimbursementAmount || !reimbursementDescription || !reimbursementType) {
		$('#formMessage').html("Please enter type, description and amount");
		$('#reimbursementType').val("");
		$('#reimbursementDescription').val("");
		$('#reimbursementAmount').val("");
		return false;
	}
	return true;
}

function loadReimbursements(user, statusId) {
	var target = "reimbursements";
	
	if (statusId > 0 || (user && user.userRoleId == 1)) {
		target += "?";
		if (statusId > 0) {
			target += "statusId=" + statusId + "&";
		}
		
		if(user && user.userRoleId == 1) {
			target += "authorId=" + user.userId + "&";
		}
		target = target.substring(0, target.length - 1);
	}
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var reimbursements = JSON.parse(xhr.responseText);
			if (reimbursements != null) {
				showReimbursements(reimbursements);
			}
		}
	}
	xhr.open("GET", target);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send();
}

function showReimbursements(reimbursements) {
	$("#ReimbursementListSection").show();
	
	if (dataTable) {
		$('#Reimbursements').dataTable().fnDestroy();
	}
	dataTable = $('#Reimbursements').DataTable( {
		data: reimbursements,
		select: "single",
		columns: [
			{ data: "reimbursementId" },
			{
				data: "amount",
				render: $.fn.dataTable.render.number( ',', '.', 2, '$' )
			},
			{ data: "reimbursementType" },
			{ data: "reimbursementDescription" },
			{ data: "author" },
			{ data: "resolver" },
			{ data: "reimbursementStatus" },
			{ 
				data: "reimbursementSubmitted",
				type: "date",
				render: function (value) {
					return new Date(value).toDateString();
	            }
			},
			{ 
				data: "reimbursementResolved",
				type: "date",
				render: function (value) {
					return value ? new Date(value).toDateString() : '';
	            }
			}
		]
	});
}

function approveReimbursement() {
	var selectedRows = dataTable.rows( { selected: true } ).data();
	if (selectedRows && selectedRows.count() > 0) {
		setReimbursementStatus(selectedRows[0].reimbursementId, 2);
	}
	else {
		showAlert("Please select reimbursement to approve");
	}
}

function denyReimbursement() {
	var selectedRows = dataTable.rows( { selected: true } ).data();
	if (selectedRows && selectedRows.count() > 0) {
		setReimbursementStatus(selectedRows[0].reimbursementId, 3);
	}
	else {
		showAlert("Please select reimbursement to deny");
	}
}

function showAlert(message) {
	$('#alertModalText').html(message);
	$('#alertModal').modal('show');
}