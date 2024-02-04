# ChatApplication
ChatApplication using SpringBoot
## Project Overview:
-The project is a chat application that allows users to register, log in, create and join chat groups, send and receive messages in both private and group chats.
-Users can manage their participation in chat groups, including  removing themselves from groups, and administrators can create, modify, and dismantle chat groups.
-The application integrates user management, chat group management, and message management to facilitate real-time communication between users.
## Below are the end-points of the project

### 1. User Controller Endpoints:
#### 1.1. User Login:
Endpoint: /api/user/login
Method: POST
Parameters:
mail: User's email.
password: User's password.
Test:
Open Postman.
Set the request type to POST.
Enter the URL: http://localhost:your_port/api/user/login.
Go to the "Body" tab.
Click "Send" to receive the response.

#### 1.2. User Registration:
Endpoint: /api/user/register
Method: POST
Body: User object containing user details (e.g., username, email, password).
Test:
Open Postman.
Set the request type to POST.
Enter the URL: http://localhost:your_port/api/user/register.
Enter the user details in JSON format.
Click "Send" to receive the response.

#### 1.3. Get User's Groups:
Endpoint: /api/user/groups
Method: POST
Parameters:
id: User ID.
Test:
Open Postman.
Set the request type to POST.
Enter the URL: http://localhost:your_port/api/user/groups.
Add the key-value pair for id.
Click "Send" to receive the response.

#### 1.4. Add User to Group:
Endpoint: /api/user/add-to-group
Method: POST
Parameters:
aid: Admin user ID.
uid: User ID to be added to the group.
gid: Group ID.
Test:
Open Postman.
Set the request type to POST.
Enter the URL: http://localhost:your_port/api/user/add-to-group.
Add the key-value pairs for aid, uid, and gid.
Click "Send" to receive the response.

#### 1.5. Remove User from Group:
Endpoint: /api/user/remove-from-group
Method: POST
Parameters:
aid: Admin user ID.
uid: User ID to be removed from the group.
gid: Group ID.
Test:
Open Postman.
Set the request type to POST.
Enter the URL: http://localhost:your_port/api/user/remove-from-group.
Add the key-value pairs for aid, uid, and gid.
Click "Send" to receive the response.

#### 1.6. Exit User from Group:
Endpoint: /api/user/exit-from-group
Method: POST
Parameters:
uid: User ID to exit from the group.
gid: Group ID.
Test:
Open Postman.
Set the request type to POST.
Enter the URL: http://localhost:your_port/api/user/exit-from-group.
Add the key-value pairs for uid and gid.
Click "Send" to receive the response.

### 2. Message Controller Endpoints:
#### 2.1. Send Message:
Endpoint: /message/send
Method: POST
Body: Message object containing message details (e.g., sender, receiver, content).
Test:
Open Postman.
Set the request type to POST.
Enter the URL: http://localhost:your_port/message/send.
Enter the message details in JSON format.
Click "Send" to receive the response.

#### 2.2. Delete Message:
Endpoint: /message/{id}
Method: DELETE
Path Variable: id (Long): Message ID.
Test:
Open Postman.
Set the request type to DELETE.
Enter the URL: http://localhost:your_port/message/{id}.
Click "Send" to receive the response.

#### 2.3. Get Personal Chat:
Endpoint: `/message/getchat
