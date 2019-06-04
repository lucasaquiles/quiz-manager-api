Micronaut App using kotlin, Spek, JPA, Open API
 

```
./gradlew run
```

```
http://localhost:8080/
```

add exam
```
curl -d '{"date":"2019-06-02","validDat":"2019-06-20", "active": true, "quizes":[{"title":"Conhecimento tecnico", "alternatives": [], "minScore":"30"}]}' -H "Content-Type: application/json" -X POST http://localhost:8080/exam
```

add quiz to exam
```
curl -d '{"title":"Conhecimento tecnico", "alternatives": [], "minScore":"30"}' -H "Content-Type: application/json" -X POST http://localhost:8080/exam/1/quiz
```

add quiz
```
curl -d '{"title":"Conhecimento tecnico", "alternatives": [], "minScore":"30"}' -H "Content-Type: application/json" -X POST http://localhost:8080/quiz
```
