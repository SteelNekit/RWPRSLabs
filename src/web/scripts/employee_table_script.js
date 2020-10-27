var table_exist = false;

function showTable(){
	if(!table_exist){
		var contentBody = document.getElementById("content_body");
		var table = document.createElement("table");	
		
		drawHeader(table);
		drawInputFields(table);
		contentBody.appendChild(table);
		table_exist = true;
	}else{
		var table = document.getElementById("employee_table");
		table.parentNode.removeChild(table);
		table_exist = false;
	}
}

function drawHeader(table){
	var row = document.createElement("tr");
	var name = document.createElement("td");
	name.id="name";
	var spec = document.createElement("td");
	spec.id="spec";
	var daysold = document.createElement("td");
	daysold.id="daysold"
	daysold.setAttribute('colspan','2');
	
	name.innerHTML = "���";
	spec.innerHTML = "�������������";
	daysold.innerHTML = "������� �� ����";

	row.appendChild(name);
	row.appendChild(spec);
	row.appendChild(daysold);
	table.appendChild(row);
	table.id = "employee_table";
}

function drawInputFields(table){
	var row = document.createElement("tr");
	row.id = "input_row";
	
	//������ ���� ��� ����� �����
	var nameCell = document.createElement("td");
	nameCell.id="nameC";
	var nameField = document.createElement("input");
	nameField.id="nameF";
	nameField.setAttribute('type','text');
	nameCell.appendChild(nameField);
	
	//������ ���� ��� ����� �������������
	var specCell = document.createElement("td");
	nameCell.id="specC";
	var specField = document.createElement("input");
	specField.id="specF";
	specField.setAttribute('type','text');
	specCell.appendChild(specField);
	
	//������ ���� ��� ����� ���-�� ������ �� ����
	var daysoldCell = document.createElement("td");
	daysoldCell.id="daysoldC";
	var daysoldField = document.createElement("input");
	daysoldField.id="daysoldF";
	daysoldField.setAttribute('type','text');
	daysoldCell.appendChild(daysoldField);
	
	//�������� ����� ��� ������
	var buttonCell = document.createElement("td");
	buttonCell.id="buttonC";
	var buttonField = document.createElement("input");
	buttonField.id="buttonF";
	buttonField.setAttribute('type','submit');
	buttonField.setAttribute('value','ok');
	buttonField.setAttribute('onclick',
	"appendToTable(document.getElementById('nameF').value,document.getElementById('specF').value,document.getElementById('daysoldF').value); return false;");
	buttonCell.appendChild(buttonField);
	
	//�������� ����� � �������
	row.appendChild(nameCell);
	row.appendChild(specCell);
	row.appendChild(daysoldCell);
	row.appendChild(buttonCell);
	table.appendChild(row);
}

function eraseInputFields(table){
	var row = document.getElementById("input_row");
	row.parentNode.removeChild(row);
}

function appendToTable(name,spec,daysold){
	if(name.trim() == ''){alert("������� ���� ��� �����"); return;}
	if(spec.trim() == ''){alert("������� ���� ��� �������������"); return;}
	if(daysold.trim() == '' || isNaN(daysold)){alert("��������� ����� ��� ������� ����� ������ ����"); return;}
	
	var table = document.getElementById("employee_table");
	var row = document.createElement("tr");
	var nameIn = document.createElement("td");
	var specIn = document.createElement("td");
	var daysoldIn = document.createElement("td");
	var del_button = document.createElement("input");
	del_button.setAttribute('type','submit');
	del_button.setAttribute('value','X');
	del_button.setAttribute('onclick','deleteParentRow(); return false;');
	del_button.id="del_button";
	nameIn.innerHTML = name;
	specIn.innerHTML = spec;
	daysoldIn.innerHTML = daysold;
	row.appendChild(nameIn);
	row.appendChild(specIn);
	row.appendChild(daysoldIn);
	row.appendChild(del_button);
	eraseInputFields(table);
	table.appendChild(row);
	drawInputFields(table);
}

function deleteParentRow(){
	var row = window.event.srcElement.parentElement;
	var table = document.getElementById("employee_table")
	table.removeChild(row);
}