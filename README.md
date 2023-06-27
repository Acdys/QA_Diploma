# Дипломный проект «Тестировщик ПО»

## Описание приложения
Приложение — это веб-сервис "Путешествие дня", который предлагает купить тур по определённой цене двумя способами:

1. Обычная оплата по дебетовой карте.
2. Уникальная технология: выдача кредита по данным банковской карты.

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:

- сервису платежей, далее - Payment Gate;
- кредитному сервису, далее - Credit Gate.

Приложение в собственной СУБД должно сохранять информацию о том, успешно ли был совершён платёж и каким способом. Данные карт при этом сохранять не допускается.

## Отчетная документация по итогам выполнения проекта: 

- [План автоматизации тестирования](https://github.com/Acdys/QA_Diploma/blob/main/docs/Plan.md)
- [Отчёт о проведённом тестировании]( https://github.com/Acdys/QA_Diploma/blob/main/docs/Report.md)
- [Отчёт о проведённой автоматизации]( https://github.com/Acdys/QA_Diploma/blob/main/docs/Summary.md)

#### Необходимое окружение:
- установленный Docker;
- есть подключение к СУБД MySQL и PostgreSQL.

### Необходимые шаги для запуска автотестов:

1.	Клонировать репозиторий 
```
git clone git@github.com: Acdys/QA_Diploma.git
```
2.	Запустить контейнеры с БД
```
docker-compose up
```
3.	Запустить тестируемую систему с помощью jar-файла для MySql
```  
java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
```
4.	Запустить тестируемую систему с помощью jar-файла для PostgreSQL 
```
java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
```
5.	Запустить тесты для MySql 
```
./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"
```
6.	Запустить тесты для PostgreSQL 
```
./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"
```
7.	Запустить формирование отчета с помощью Allure
```
./gradlew allureReport
```
