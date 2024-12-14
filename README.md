# Accountability-App

HTTP Method	Endpoint	Description	Request Body
POST	/tasks	Add a new task	{ "title": "Task Title", "description": "Task Description", "status": "Pending", "addedDate": "2024-12-14", "completionDate": "2024-12-20" }

GET	/tasks	Get all tasks	None

GET	/tasks/{id}	Get a task by ID	None

PUT	/tasks/{id}	Update a task by ID	{ "title": "Updated Title", "description": "Updated Description", "status": "Pending", "completionDate": "2024-12-22" }

DELETE	/tasks/{id}	Delete a task by ID	None

PATCH	/tasks/{id}/complete	Mark a task as completed	None
