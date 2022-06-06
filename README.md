# gif-rate-generator
Service for parsing rates from external API and set randomly gif answer


<b>Running Tests</b>

Для запуска тестов необходимо изменить переменные с адресами API с реальных на локальные в конфигурационном файле application.properties

#API for prod

`#aleksB.app.exchangeURL = https://openexchangerates.org/api`

`#aleksB.app.giphyURL = https://api.giphy.com/v1/gifs/search`

#API for tests

`aleksB.app.exchangeURL = http://localhost:10000/api`

`aleksB.app.giphyURL = http://localhost:10000/v1/gifs/search`



<b>Building the project</b>

1) Проверить, что #API for prod активированы в конфигурационном файле application.properties

#API for prod

`aleksB.app.exchangeURL = https://openexchangerates.org/api`

`aleksB.app.giphyURL = https://api.giphy.com/v1/gifs/search`

#API for tests

`#aleksB.app.exchangeURL = http://localhost:10000/api`

`#aleksB.app.giphyURL = http://localhost:10000/v1/gifs/search`


2) Для сборки приложения необходим установленный пакет gradle, в терминале необходимо запустить две команды

`gradle  clean`

`gradle build -x test`

3) После сборки в корне проекта сгенерируется папка build/libs

Для запуска приложения необходимо запустить файл gif-rate-generator-0.0.1-SNAPSHOT.jar с помощью команды

<b>java.exe -jar gif-rate-generator-0.0.1-SNAPSHOT.jar</b>

из командной строки терминала

Приложение развернется по адресу http://localhost:8080

