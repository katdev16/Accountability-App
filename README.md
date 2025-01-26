<h1>Accountability-App</h1>

A task manager designed to keep track of tasks and ensure accountability with a point system.
<hr></hr>
<h1>🛠️ Tech Stack</h1>
<ul>
<li>Frontend: React</li>
<li>Backend: Java (Spring Boot)</li>
</ul>
<hr></hr>
<h1>🏗️ Architecture</h1>
<uL>
<li>Pattern: Model-View-Controller (MVC)</li>
</ul>
<hr></hr>
<h1>📂 Folder Structure</h1>
<pre>
java
│   ├── com
│   │   └── katdev
│   │       └── accountabilityapp
│   │           ├── AccountabilityApp.java
│   │           ├── config
│   │           │   ├── CorsConfig.java
│   │           │   └── SecurityConfig.java
│   │           ├── controller
│   │           │   ├── TaskController.java
│   │           │   └── UserController.java
│   │           ├── DataTransfer
│   │           │   ├── LoginRequest.java
│   │           │   ├── TaskDTO.java
│   │           │   └── UserDTO.java
│   │           ├── mapper
│   │           │   └── TaskMapper.java
│   │           ├── model
│   │           │   ├── Task.java
│   │           │   └── User.java
│   │           ├── repository
│   │           │   ├── TaskRepository.java
│   │           │   └── UserRepository.java
│   │           └── service
│   │               ├── TaskServiceImpl.java
│   │               ├── TaskService.java
│   │               └── UserService.java
│   ├── resources
│   │   └── application.properties
│   └── Users.java
└── resources
    └── application.properties
</pre>
<hr></hr>
<h1>📖 API Endpoints</h1>

<table>
  <thead>
    <tr>
      <th>HTTP Method</th>
      <th>Endpoint</th>
      <th>Description</th>
      <th>Request Body</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>POST</strong></td>
      <td><code>/tasks</code></td>
      <td>Adds a new task</td>
      <td>
        <pre>
{
  "title": "Task Title",
  "description": "Task Description",
  "status": "Pending",
  "addedDate": "2024-12-14",
  "completionDate": "2024-12-20"
}
        </pre>
      </td>
    </tr>
    <tr>
      <td><strong>GET</strong></td>
      <td><code>/tasks</code></td>
      <td>Retrieves all tasks</td>
      <td>None</td>
    </tr>
    <tr>
      <td><strong>GET</strong></td>
      <td><code>/tasks/{id}</code></td>
      <td>Retrieves a task by its ID</td>
      <td>None</td>
    </tr>
    <tr>
      <td><strong>PUT</strong></td>
      <td><code>/tasks/{id}</code></td>
      <td>Updates a task by its ID</td>
      <td>
        <pre>
{
  "title": "Updated Title",
  "description": "Updated Description",
  "status": "Pending",
  "completionDate": "2024-12-22"
}
        </pre>
      </td>
    </tr>
    <tr>
      <td><strong>DELETE</strong></td>
      <td><code>/tasks/{id}</code></td>
      <td>Deletes a task by its ID</td>
      <td>None</td>
    </tr>
    <tr>
      <td><strong>PATCH</strong></td>
      <td><code>/tasks/{id}/complete</code></td>
      <td>Marks a task as completed</td>
      <td>None</td>
    </tr>
  </tbody>
</table>
