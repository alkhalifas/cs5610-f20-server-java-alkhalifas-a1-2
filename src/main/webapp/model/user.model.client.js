function User(username, password, email, firstName, lastName, role, dob) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.dob = dob;

    this.setUsername = setUsername;
    this.getUsername = getUsername;

    this.setPassword = setPassword;
    this.getPassword = getPassword;

    this.setEmail = setEmail;
    this.getEmail = getEmail;

    this.setFirstName = setFirstName;
    this.getFirstName = getFirstName;

    this.setLastName = setLastName;
    this.getLastName = getLastName;

    this.setRole = setRole;
    this.getRole = getRole;

    this.serDob = setDob;
    this.getDob = getDob;

    // ------------------------------------------- Define all setters ---------------------------

    function setUsername(username) {
        this.username = username;
    }

    function setPassword(password) {
        this.password = password;
    }

    function setEmail(email) {
        this.email = email;
    }

    function setFirstName(firstName) {
        this.firstName = firstName;
    }

    function setLastName(lastName) {
        this.lastName = lastName;
    }

    function setRole(role) {
        this.role = role;
    }

    function setDob(dob) {
        this.dob = dob;
    }

    // ------------------------------------------- Define all getters ---------------------------

    function getUsername(username) {
        return this.username;
    }

    function getPassword(password) {
        return this.password;
    }

    function getEmail(email) {
        return this.email;
    }

    function getFirstName(firstName) {
        return this.firstName;
    }

    function getLastName(lastName) {
        return this.lastName;
    }

    function getRole(role) {
        return this.role;
    }

    function getDob(dob) {
        return this.dob;
    }

}
