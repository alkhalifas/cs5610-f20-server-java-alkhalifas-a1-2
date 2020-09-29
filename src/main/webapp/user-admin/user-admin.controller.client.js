(function () { //best practice is to put all your code inside this function to avoid cluttering namespace

//-------------------------------------- Variable Declaration -----------------------------------

    let tbody;
    let template;
    let clone;
    let $createBtn;
    let $usernameFld;
    let $passwordFld;
    let $firstNameFld;
    let $lastNameFld;
    let $emailFld;
    let $roleFld;

    const userService = new AdminUserServiceClient();
    let selectedUserIndex = -1;

    //-------------------------------------- Event Handlers -----------------------------------

    /**
     *  Executes on document load, when the browser is done parsing the html page and the
     *  dom is ready. Retrieved the dom elements needed later in the controller such as the
     *  form elements, action icons, and templates. Binds action icons, such as create, update,
     *  select, and delete, to respective event handlers.test
     */
    const main = () => {
        tbody = $("tbody");
        template = $("tr.wbdv-template");

        $createBtn = $(".wbdv-create").click(createUser);

        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $roleFld = $("#roleFld");
        $emailFld = $("#emailFld");
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");

        $(".wbdv-update").click(updateUser).click(function () {
            $('.alert').show()
        });
        userService.findAllUsers()
            .then((_users) => {
                console.log(_users);
                users = _users;
                renderUsers(users)
            });

        $("#searchInput").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#tableIdentifier tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });

    };
    $(main);

    /**
     *  Handles create user event when user clicks on plus icon. Reads from the form elements and
     *  creates a user object. Uses the user service createUser() function to create the new user.
     *  Updates the list of users on server response. test.
     */
    const createUser = () => {
        console.log(">> New User Created");
        const username = $usernameFld.val();
        const password = $passwordFld.val();
        const firstName = $firstNameFld.val();
        const lastName = $lastNameFld.val();
        const userRole = $roleFld.val();
        const userEmail = $emailFld.val();

        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("");
        $emailFld.val("");

        const newUser = {
            username: username,
            password: password,
            first: firstName,
            last: lastName,
            role: userRole,
            email: userEmail,
        };

        userService.createUser(newUser)
            .then(actualNewUser => {
                users.push(actualNewUser);
                renderUsers(users)
            })
    };

    /**
     *  Called whenever the list of users needs to be refreshed. Uses user service findAllUsers()
     *  to retrieve all the users and passes response to renderUsers.
     */
    const findAllUsers = () => {
        userService.findAllUsers().then(renderUsers)
    };

    /**
     *  Called whenever a particular user needs to be retrieved by their id, as in when a user
     *  is selected for editing. Reads the user id from the icon id attribute. Uses user
     *  service findUserById() to retrieve user and then updates the form on server response.
     */
    const findUserById = () => {
        renderUser(userService.findUserById(id))
    };

    /**
     *  Handles update user event when user clicks on check mark icon. Reads the user id from the
     *  icon id attribute. Reads new user values form the form, creates a user object and then
     *  uses user service updateUser() to send the new user data to server. Updates user list
     *  on server response.
     */
    const updateUser = () => {
        console.log(">> User Updated");
        const newUsername = $("#usernameFld").val();
        const newPassword = $("#passwordFld").val();
        const newFirstName = $("#firstNameFld").val();
        const newLastName = $("#lastNameFld").val();
        const newEmail = $("#emailFld").val();
        const newRole = $("#roleFld").val();
        const userId = users[selectedUserIndex]._id;
        userService.updateUser(userId, {
            username: newUsername,
            password: newPassword,
            first: newFirstName,
            last: newLastName,
            email: newEmail,
            role: newRole
        })
            .then(response => {
                users[selectedUserIndex].username = newUsername;
                users[selectedUserIndex].password = newPassword;
                users[selectedUserIndex].first = newFirstName;
                users[selectedUserIndex].last = newLastName;
                users[selectedUserIndex].role = newRole;
                users[selectedUserIndex].email = newEmail;
                renderUsers(users)
            });
        clearFields()
    };

    /**
     *  Function that clears all the input fields after using the editUser function.
     */
    function clearFields() {
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $emailFld.val("");
        $roleFld.val("")
    }

    /**
     *  Handles delete user event when user clicks the cross icon. Reads the user id from the
     *  icon id attribute. Uses user service deleteUser() to send a delete request to the
     *  server. Updates user list on server response.
     */
    const deleteUser = (_index) => {
        console.log(">> User Deleted");
        const user = users[_index];
        const userId = user._id;
        userService.deleteUser(userId)
            .then(response => {
                users.splice(_index, 1);
                renderUsers(users)
            })
    };

    /**
     *  Accepts a user object as parameter and updates the form with the user properties.
     */
    const renderUser = (user) => {
        console.log(">> renderUser implemented");

        $usernameFld.val(user.username);
        $passwordFld.val(user.password);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $emailFld.val(user.email);
        $roleFld.val(user.role);

    };

    /**
     *  Accepts an index as an object and allows for the selection of a user and its attributes
     *  based on that specific index.
     */
    const selectUser = (index) => {
        selectedUserIndex = index;
        $("#usernameFld").val(users[index].username);
        $("#passwordFld").val(users[index].password);
        $("#firstNameFld").val(users[index].first);
        $("#lastNameFld").val(users[index].last);
        $("#emailFld").val(users[index].email);
        $("#roleFld").val(users[index].role);
    };

    /**
     *  Accepts an array of user instances, clears the current content of the table body,
     *  iterates over the array of users, clones a table row template for each user instance,
     *  populates the table row with the user object properties, adds the table row to
     *  the table body.
     */
    const renderUsers = (users) => {
        console.log(">> renderUsers implemented");
        tbody.empty();
        const ul = $("<ul>");
        for (let i = 0; i < users.length; i++) {
            const user = users[i];
            const li = $("<li>" + user.username + "</li>");
            ul.append(li);

            clone = template.clone();
            clone.removeClass("wbdv-hidden");

            clone.find(".wbdv-username").html(user.username);
            clone.find(".wbdv-password").html("************");

            // clone.find(".wbdv-password").html(user.password);
            clone.find(".wbdv-first-name").html(user.first);
            clone.find(".wbdv-last-name").html(user.last);
            clone.find(".wbdv-email").html(user.email);
            clone.find(".wbdv-role").html(user.role);

            clone.find(".wbdv-remove").click(() => deleteUser(i));
            clone.find(".wbdv-edit").click(() => selectUser(i));

            tbody.append(clone)
        }
    };

})();
