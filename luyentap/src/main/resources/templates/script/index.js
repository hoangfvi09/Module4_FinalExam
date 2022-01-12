function loadHomeContent() {
    let html = `
        <div class="col-9" id="list-student"></div>
        <div class="col-3" id="classes"></div>`;
    document.getElementById(`content`).innerHTML = html;
    loadCityList();
    // loadCountryList();

}

function loadCityList(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/cities",
        success: function (data) {
            console.log(data);
            let html = `<table><tr>
<td><div class="product p-3"><h3>Id</h3></div></td>
<td><div class="product p-3"><h3>Name</h3></div></td>
<td><div class="product p-3"><h3>Country</h3></div></td>
<td><div class="product p-3" ><h3>Edit</h3></div></td>
<td><div class="product p-3" ><h3>Edit</h3></div></td>
</tr>`;
            for(let i=0;i<data.length;i++){
                html+=`<div class=\"row p-3\">`
               html+=`<tr><td><div class="product p-3">${data[i].id}</div></td>
<td> <div class="product p-3" onclick="showOne(${data[i].id})">${data[i].name}</div></td>`+
               `<td><div class="product p-3">${data[i].country.name}</div></td><td><div onclick="showFormEdit(${data[i].id})" class="product p-3">Edit</div></td><td><div class="product p-3" onclick="deleteCity(${data[i].id})">Delete</div></td></tr>`;
                html += `</div>`;
            }
            html+=`</table>`

            document.getElementById(`list-student`).innerHTML = html;
        }
    })
}
function loadCountryList(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/countries",
        success: function (data) {
            console.log(data);
            let html = `<div class=\"row p-3\">`;
            for(let i=0;i<data.length;i++){
               html+=` <div class="col-12 p-2"><button class="classbtn btn btn-danger" onclick="showByClass(${data[i].id})">${data[i].name}</button></div>`;
            }
            html += `<div class="col-12 p-2"><button class="classbtn btn btn-danger" onclick="loadCityList()">Show All</button></div></div>`;
            document.getElementById(`classes`).innerHTML = html;
        }
    })
}

function showCreateForm() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/countries",
        success: function (data) {
            console.log(data)
            let form = `<table>\n` +
                `        <tr>\n` +
                `            <td>City Name:</td>\n` +
                `            <td><input type="text" id="name"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>Area:</td>\n` +
                `            <td><input type="number" id="area"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>Population:</td>\n` +
                `            <td><input type="number" id="population"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>GDP:</td>\n` +
                `            <td><input type="number" id="gdp"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>Description:</td>\n` +
                `            <td><input type="text" id="description"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>Country:</td>\n` + `<td>`+


                `        <select id="country">`
            for (let i = 0; i < data.length; i++) {
                form += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            form += `</select></td></tr>` +
                `  <tr> <td><button onclick="saveCity()">Add New City</button>        </td> <td><button onclick="loadHomeContent()">Back to list</button>        </td></tr></table>\n`
            ;
            document.getElementById("content").innerHTML = form;
        }
    })
}

// function search(){
//     let q=document.getElementById(`q`).value;
//     $.ajax({
//         type: "GET",
//         url: `http://localhost:8080/students/search?q=${q}`,
//
//         success: function (data) {
//             console.log(data);
//             let html = `<div class=\"row p-3\">`;
//             for(let i=0;i<data.content.length;i++){
//                 html+=` <div class="col-4 product p-3"><h2>${data.content[i].name}</h2></div>`;
//             }
//             html += `</div>`;
//             document.getElementById(`list-student`).innerHTML = html;
//         }
//     })
// }

function showOne(id){
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/cities/${id}`,
        success: function (data) {
            let html = `
<div class="row"><div class="col-12"><p>Id:  ${data.id}</p></div>
<div class="row"><div class="col-12"><p>Name:  ${data.name}</p></div>
<div class="row"><div class="col-12"><p>Area:  ${data.area}</p></div>
<div class="row"><div class="col-12"><p>Population:  ${data.population}</p></div>
<div class="row"><div class="col-12"><p>Gdp:  ${data.gdp}</p></div>
<div class="row"><div class="col-12"><p>Description:  ${data.description}</p></div>
<div class="col-12">
<button class="classbtn btn btn-danger p-3" onclick="loadHomeContent()">Back
</div>
</button>

`;
            document.getElementById(`content`).innerHTML = html;
        }
})
}

function showByClass(id){
    console.log(id)
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/students/class/${id}`,
        success: function (data) {
            console.log(data);
            let html = `<div class=\"row p-3\">`;
            for(let i=0;i<data.content.length;i++){
                html+=` <div class="col-4 product p-3"><h2>${data.content[i].name}</h2></div>`;
            }
            html += `</div>`;
            document.getElementById(`list-student`).innerHTML = html;
        }
    })
}

function saveCity() {
    let name = $("#name").val();
    let area = $("#area").val();
    let population = $("#population").val();
    let description = $("#description").val();
    let gdp = $("#gdp").val();
    let country = $("#country").val();
    let city = {
        name: name,
        area: area,
        population: population,
        description: description,
        gdp: gdp,
        country: {
            id: country
        }
    }
    console.log(city);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "POST",
        url: "http://localhost:8080/cities",
        data: JSON.stringify(city),
        success: function (data) {
            console.log(data)
            loadHomeContent()
        }
    })
}

function showFormEdit(id){
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/cities/`+id,
        success: function (data) {
            let name = data.name
            let area = data.area
            let population = data.population
            let gdp = data.gdp
            let description = data.description
            let country= data.country
            let form = `<table>\n` +
                `        <tr>\n` +
                `            <td>City Name:</td>\n` +
                `            <td><input type="text" value="${name}" id="name"><input type="hidden" value="${id}" id="id"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>Area:</td>\n` +
                `            <td><input type="number" value="${area}" id="area"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>Population:</td>\n` +
                `            <td><input type="number" value="${population}" id="population"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>GDP:</td>\n` +
                `            <td><input type="number" value="${gdp}" id="gdp"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>Description:</td>\n` +
                `            <td><input type="text" value="${description}" id="description"></td>\n` +
                `        </tr>\n` +
                `        <tr>\n` +
                `            <td>Country:</td>\n` + `<td>`+


                `        <select id="country">
<option value="${country.id}" selected="selected">${country.name}</option>`
            
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/countries",
                success: function (data) {
                    console.log(data)
                    for (let i = 0; i < data.length; i++) {
                        form += `<option value="${data[i].id}">${data[i].name}</option>`
                    }
                    form += `</select></td></tr>` +
                        `  <tr> <td><button onclick="editCity()">Edit City</button>        </td> <td><button onclick="loadHomeContent()">Back to list</button>        </td></tr></table>\n`
                    ;
                    document.getElementById("content").innerHTML = form;
                }
            })
        }
    })
}
function deleteCity(id){
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/cities/" + id,
        success: function (data) {
            loadHomeContent()
        }
    })

}

function editCity() {


    let id = $("#id").val();
    let name = $("#name").val();
    let area = $("#area").val();
    let population = $("#population").val();
    let description = $("#description").val();
    let gdp = $("#gdp").val();
    let country = $("#country").val();
    let city = {
        id: id,
        name: name,
        area: area,
        population: population,
        description: description,
        gdp: gdp,
        country: {
            id: country
        }
    }
    console.log(city);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "PUT",
        url: "http://localhost:8080/cities/" + id,
        data: JSON.stringify(city),
        success: function (data) {
            console.log(data)
            loadHomeContent()

        }

    })
}

