function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/alkhalifas/users';

    // Retrieves all users as an array of JSON objects
    function findAllUsers() {
        return fetch('https://wbdv-generic-server.herokuapp.com/api/alkhalifas/users')
            .then(response => response.json())
    }

    // Accepts a user object and adds it to a collection of users.
    function createUser(user) {
        return fetch('https://wbdv-generic-server.herokuapp.com/api/alkhalifas/users', {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(response => response.json())
    }

    // Retrieves a single user object whose id is equal to the id parameter.
    function findUserById(userId) {
        for (let i = 0; i < users.length; i++) {
            if (users[i].id === userId) {
                return users[i];
            }
        }
    }

    // Accepts a user id and user object with new property values for the user with user id. Finds
    // the user whose id matches he id parameter and updates it with the values in the user
    // parameter.
    function updateUser(userId, user) {
        return fetch(`https://wbdv-generic-server.herokuapp.com/api/alkhalifas/users/${userId}`, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
    }

    // Removes the user whose id matches the id parameter.
    function deleteUser(userId) {
        return fetch('https://wbdv-generic-server.herokuapp.com/api/alkhalifas/users/' + userId, {
            method: 'DELETE'
        })
    }

}