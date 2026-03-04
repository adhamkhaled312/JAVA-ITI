let students = [];
let editIndex = -1;
let currentId = 1;
function Student(id,fname,lname,birthDate,dept){
    this.fname=fname;
    this.lname=lname;
    this.id=id;
    this.birthDate=birthDate;
    this.dept=dept;
}

Student.prototype.getAge = function () {
    let today = new Date();
    let birth = new Date(this.birthDate);

    let age = today.getFullYear() - birth.getFullYear();
    let m = today.getMonth() - birth.getMonth();

    if (m < 0 || (m === 0 && today.getDate() < birth.getDate())) {
        age--;
    }

    return age;
};

Student.prototype.getFullName = function(){
    return this.fname + " " + this.lname;
};

function addStudent(){
    let fname = document.getElementById("fname").value;
    let lname = document.getElementById("lname").value;
    let birth = document.getElementById("birth").value;
    let dept = document.getElementById("dept").value;

    if (!fname || !lname || !birth || !dept) {
        alert("Please fill all fields");
        return;
    }

    if(editIndex!=-1){
        students[editIndex].fname = fname;
        students[editIndex].lname = lname;
        students[editIndex].birthDate = birth;
        students[editIndex].dept = dept;

        editIndex=-1;
    }
    else{
        
        students.push(new Student(currentId,fname,lname,birth,dept));
        currentId++;
    }
    document.getElementById("fname").value="";
    document.getElementById("lname").value="";
    document.getElementById("birth").value="";
    document.getElementById("dept").value="";
    displayStudents();

}

function displayStudents() {

    let tbody = document.getElementById("tableBody");
    tbody.innerHTML = "";

    students.forEach(function (student, index) {

        let row = document.createElement("tr");

        row.innerHTML = `
            <td>${student.id}</td>
            <td>${student.getFullName()}</td>
            <td>${student.getAge()}</td>
            <td>${student.dept}</td>
            <td>
                <button class="edit-btn" onclick="editStudent(${index})">Edit</button>
                <button class="delete-btn" onclick="deleteStudent(${index})">Delete</button>
            </td>
        `;

        tbody.appendChild(row);
    });
}

function editStudent(index){
    let student = students[index];

    document.getElementById("fname").value = student.fname;
    document.getElementById("lname").value = student.lname;
    document.getElementById("birth").value = student.birthDate;
    document.getElementById("dept").value = student.dept;

    editIndex = index;
}

function deleteStudent(index) {
        students.splice(index, 1);
        displayStudents();
}