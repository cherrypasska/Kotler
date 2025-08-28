# Kotler
Kotler is AI for marketologs



## Короче, по api:

Все защищенные endpoints требуют JWT токен в заголовке:

Authorization: Bearer <your_token>

# POST /auth/reg
вход:

{
    "username": "user1",
    "email":"paha@mail.ru",
    "password": "user123"
}


выход:

{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwiZW1haWwiOiJwYWhhQG1haWwucnUiLCJzdWIiOiJ1c2VyMSIsImlhdCI6MTc1NjQxOTkzMiwiZXhwIjoxNzU2NDIzNTMyfQ.-f0pDK-eA8mm1X-0vaYOMYV2glC1yHAngrJkFr7Lnkc",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTc1NjQxOTkzMiwiZXhwIjoxNzU3MDI0NzMyfQ.QVHDLkyck_9xzjoJ_yd3qe7sdar0BoE4Kl5xTBOJHVM"
}

# POST /auth/login

вход:

{
    "username": "user1",
    "password": "user123"
}

выход:

{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwiZW1haWwiOiJwYWhhQG1haWwucnUiLCJzdWIiOiJ1c2VyMSIsImlhdCI6MTc1NjQxOTkzMiwiZXhwIjoxNzU2NDIzNTMyfQ.-f0pDK-eA8mm1X-0vaYOMYV2glC1yHAngrJkFr7Lnkc",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTc1NjQxOTkzMiwiZXhwIjoxNzU3MDI0NzMyfQ.QVHDLkyck_9xzjoJ_yd3qe7sdar0BoE4Kl5xTBOJHVM"
}

# POST /auth/refresh

вход
{
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTc1NjQxOTkzMiwiZXhwIjoxNzU3MDI0NzMyfQ.QVHDLkyck_9xzjoJ_yd3qe7sdar0BoE4Kl5xTBOJHVM"
}

выход:

{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwiZW1haWwiOiJwYWhhQG1haWwucnUiLCJzdWIiOiJ1c2VyMSIsImlhdCI6MTc1NjQyMDI1NiwiZXhwIjoxNzU2NDIzODU2fQ.uQdhaMU8THuGsw5uALjA560vcpVIGSnn0Dpx0Mm8ujU",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTc1NjQyMDI1NiwiZXhwIjoxNzU3MDI1MDU2fQ.xm2Nc_4rxHzxLpqHMgCkhYcQ-EWzNqynR1VhXqtD6ks"
}

# защищенные ендпоинты

# Создание чата

# POST /api/chats

Создает новый чат для текущего пользователя.

Headers:

text

Authorization: Bearer <your_token>

Content-Type: application/json

Request Body:

{
	
 "idUser": 1,
 
 "chatName": "Сисечки писечки попочки"

}

Response:

{
   "id": 10,
   
   "idUser": 1,
    
   "chatName": "Сисечки писечки попочки"
}

5. Получение моих чатов

GET /api/chats/my

Возвращает все чаты текущего пользователя.

Headers:

text
Authorization: Bearer <your_token>
Response:

6. Получение чатов пользователя

GET /api/chats/user/{userId}

Возвращает чаты конкретного пользователя (только свои).

Headers:

text
Authorization: Bearer <your_token>
Path Parameters:

userId - ID пользователя
Response: (аналогично /api/chats/my)

💌 Управление сообщениями

7. Отправка сообщения

POST /api/chats/{chatId}/messages

Отправляет сообщение в указанный чат.

Headers:

text
Authorization: Bearer <your_token>
Content-Type: application/json
Path Parameters:

chatId - ID чата
Request Body:

json
{
  "messageText": "Привет! Помоги с маркетинговой стратегией",
  "messageType": "TEXT" // TEXT, IMAGE, FILE, SYSTEM
}
Response:

json
{
  "id": 15,
  "chatId": 1,
  "userId": 5,
  "messageType": "TEXT",
  "messageText": "Привет! Помоги с маркетинговой стратегией"
}
8. Получение сообщений чата

GET /api/chats/{chatId}/messages

Возвращает все сообщения указанного чата.

Headers:

text
Authorization: Bearer <your_token>
Path Parameters:

chatId - ID чата
Response:
