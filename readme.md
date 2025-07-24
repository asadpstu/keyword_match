Setup postgres db in local:

docker run -d --name my-postgres-db --network my_pg_network -p 5434:5432 -e POSTGRES_DB=mydatabase -e POSTGRES_USER=myuser -e POSTGRES_PASSWORD=mypassword -v pg_data:/var/lib/postgresql/data postgres:16-alpine


## 🚀 Endpoints

### 🔷 Add Keyword
Add a new keyword for a user.

- **URL:** `/api/keywords/add?userId=<USER_ID>`
- **Method:** `POST`
- **Payload:**
```json
{
  "keyword": "dhaka"
}

---

### 🔷 annotate
Aget the keywordresult for a user.

- **URL:** `/api/annotate?userId=<USER_ID>`
- **Method:** `POST`
- **Payload:**
```json
{
    "content" : "I live in bangladesh. Specifically in Dhaka. i like apple pie"
}

---

### Run the app
Backend: 
Open project in your favorite ide. (Intellij IDEA). Run the app. it will run on port 8080.

Frontend: 
$ cd frontend
$ npm install
$ npm start

open browser, frontend app is running on http://localhost:3000