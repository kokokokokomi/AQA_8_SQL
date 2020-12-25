# Тестирование функции верификации в приложении app-deadline.jar, работающего с СУБД MySQL
Проведено web-тестирование (использованы позитивные и негативные сценарии) фунцкции верификации (авторизации) пользователя.

В ходе тестирования **найдена ошибка** приложения:

[Система не блокируется после 3-х неудачных попыток ввода пароля.](https://github.com/komisuomi/AQA_8_SQL/issues/1)

#### Как работать с проектом:
1. Запустить контейнер через `docker-compose`: `docker-compose up -d`.
2. Запустить базу данных: `docker-compose exec mysqldb mysql -u app -p app`.
3. Запустить приложение: `java -jar app-deadline.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app -P:jdbc.user=app -P:jdbc.password=pass`.
4. Запустить тесты: `gradlew clean test`.
5. Для перезапуска SUT надо остановить jar-приложение (`Ctrl+C`) и контейнер (`docker-compose down`).
