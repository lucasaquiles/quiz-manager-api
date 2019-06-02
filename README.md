


```
./gradlew run
```

```
http://localhost:8080/
```

add

curl -d '{"title":"Conhecimento tecnico", "alternatives": [], "minScore":"30"}' -H "Content-Type: application/json" -X POST http://localhost:8080/quiz
