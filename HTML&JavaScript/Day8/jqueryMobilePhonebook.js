var contacts = JSON.parse(localStorage.getItem('contacts')) || [];
var currentId = null;

function save() { localStorage.setItem('contacts', JSON.stringify(contacts)); }

function getInitials(name) {
    var p = name.trim().split(' ');
    return p.length > 1 ? p[0][0] + p[1][0] : name[0];
}

function render(filter) {
    var html = '';
    var list = contacts;
    
    if (filter && filter.trim() !== '') {
        list = contacts.filter(function(c) {
            return c.name.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
        });
    }
    
    if (list.length === 0) {
        html = '<p style="text-align:center;color:#999;padding:20px;">No contacts found</p>';
    } else {
        list.forEach(function(c) {
            html += '<div class="contact-item" data-id="' + c.id + '">' +
                    '<div class="avatar">' + getInitials(c.name) + '</div>' +
                    '<strong>' + c.name + '</strong><br>' + c.phone + 
                    '<div style="clear:both;"></div></div>';
        });
    }
    
    $('#contacts').html(html);
    
    $('.contact-item').off('click').on('click', function() { 
        showDetail($(this).data('id')); 
    });
}

function showDetail(id) {
    currentId = id;
    var c = contacts.find(function(x) { return x.id === id; });
    $('#dAvatar').text(getInitials(c.name));
    $('#dName, #dFullName').text(c.name);
    $('#dPhone').text(c.phone);
    $('#dEmail').text(c.email || 'N/A');
    $('#dGender').text(c.gender || 'N/A');
    $.mobile.changePage('#detail');
}

function validate(name, phone, email) {
    var ok = true;
    if (!name.trim()) { $('#aName, #eName').addClass('error'); ok = false; }
    if (!phone.trim() || !/^[\d\s\-\(\)]+$/.test(phone)) { $('#aPhone, #ePhone').addClass('error'); ok = false; }
    if (email && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) { $('#aEmail, #eEmail').addClass('error'); ok = false; }
    return ok;
}

$(document).ready(function() {
    $(document).on('keyup', '#search', function() {
        var searchTerm = $(this).val();
        render(searchTerm);
    });
    
    $('#addForm').submit(function(e) {
        e.preventDefault();
        $('input').removeClass('error');
        var name = $('#aName').val(), phone = $('#aPhone').val(), email = $('#aEmail').val();
        if (!validate(name, phone, email)) return;
        contacts.push({id:Date.now(), name:name.trim(), phone:phone.trim(), email:email.trim(), gender:$('#aGender').val()});
        contacts.sort(function(a,b) { return a.name.localeCompare(b.name); });
        save(); 
        $('#addForm')[0].reset(); 
        $.mobile.changePage('#list');
    });
    
    $('#editBtn').click(function() {
        var c = contacts.find(function(x) { return x.id === currentId; });
        $('#eId').val(c.id); 
        $('#eName').val(c.name); 
        $('#ePhone').val(c.phone); 
        $('#eEmail').val(c.email); 
        $('#eGender').val(c.gender);
    });
    
    $('#editForm').submit(function(e) {
        e.preventDefault();
        $('input').removeClass('error');
        var name = $('#eName').val(), phone = $('#ePhone').val(), email = $('#eEmail').val();
        if (!validate(name, phone, email)) return;
        var i = contacts.findIndex(function(x) { return x.id === currentId; });
        contacts[i] = {id:currentId, name:name.trim(), phone:phone.trim(), email:email.trim(), gender:$('#eGender').val()};
        contacts.sort(function(a,b) { return a.name.localeCompare(b.name); });
        save(); 
        showDetail(currentId);
    });
    
    $('#confirmDel').click(function(e) {
        e.preventDefault();
        contacts = contacts.filter(function(x) { return x.id !== currentId; });
        save(); 
        $.mobile.changePage('#list');
    });
    
    $('#call').click(function(e) {
        e.preventDefault();
        var c = contacts.find(function(x) { return x.id === currentId; });
        alert('Calling ' + c.name + ' at ' + c.phone);
    });
    
    $(document).on('pagebeforeshow', '#list', function() { 
        render($('#search').val()); 
    });
    
    render();
});