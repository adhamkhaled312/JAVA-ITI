let todos = JSON.parse(localStorage.getItem("todos")) || [];

function save() {
    localStorage.setItem("todos", JSON.stringify(todos));
}

function draw() {

    let list = document.getElementById("list");
    list.innerHTML = "";

    for (let i = 0; i < todos.length; i++) {

        let t = todos[i];

        let div = document.createElement("div");
        div.className = "todo";
        div.draggable = true;
        div.style.background = t.color;
        div.dataset.id = t.id;

        div.ondragstart = function (e) {
            e.dataTransfer.setData("id", t.id);
        };

        let time = document.createElement("div");
        time.innerText = t.time;
        time.style.fontSize = "12px";
        time.style.fontStyle = "italic";

        let text = document.createElement("div");
        text.innerText = "*" + t.text;
        text.style.margin = "10px 0";

        let btn = document.createElement("button");
        btn.innerText = "Delete";
        btn.style.background = "#f44336";
        btn.style.color = "white";

        btn.onclick = function () {
            deleteTodo(t.id);
        };

        div.appendChild(time);
        div.appendChild(text);
        div.appendChild(btn);

        list.appendChild(div);
    }
}

function add() {

    let input = document.getElementById("text");
    let color = document.getElementById("color");

    let value = input.value.trim();

    if (value === "") {
        alert("Enter a todo!");
        return;
    }

    let todo = {
        id: Date.now(),
        text: value,
        color: color.value,
        time: new Date().toLocaleString()
    };

    todos.push(todo);

    save();
    draw();

    input.value = "";
}

function deleteTodo(id) {

    let newTodos = [];

    for (let i = 0; i < todos.length; i++) {

        if (todos[i].id !== id) {
            newTodos.push(todos[i]);
        }
    }

    todos = newTodos;

    save();
    draw();
}

let trash = document.getElementById("trash");

trash.ondragover = function (e) {
    e.preventDefault();
    trash.classList.add("over");
};

trash.ondragleave = function () {
    trash.classList.remove("over");
};

trash.ondrop = function (e) {

    e.preventDefault();
    trash.classList.remove("over");

    let id = e.dataTransfer.getData("id");

    deleteTodo(Number(id));
};

draw();
