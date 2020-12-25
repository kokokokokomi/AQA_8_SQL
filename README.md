#### Как работать с проектом:
1. Запустить в терминале jar-файл, используя команду `java -jar artifacts/app-deadline.jar`.
2. Запустить контейнер через `docker-compose`, используя команду `docker-compose up -d`.
3. Запустить базу данных, используя команду `docker-compose exec mysqldb mysql -u app app -p`.
4. Для перезапуска SUT надо остановить jar-приложение (`Ctrl+C`) и контейнер (`docker-compose down`).