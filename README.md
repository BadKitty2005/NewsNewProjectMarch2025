# NewsFlow App

NewsFlow - это андройд приложение для чтения новостей. Приложение демонстрирует навыки работы с Clean Architecture, потоками данных через Flow, локальной базой данных Room и интеграцией с GraphQL API.

## Функционал
- Просмотр списка последних новостей.
- Хранение новостей локально через Room.
- Асинхронная загрузка данных с использованием Kotlin Flow и Coroutines.
- Поддержка оффлайн-режима с кэшированием.
- Чистая архитектура: разделение на слои Presentation, Domain и Data.
- Интеграция с GraphQL API для получения данных.

## Технологии
- **Язык:** Kotlin  
- **UI:** Jetpack Compose  
- **Архитектура:** Clean Architecture (Domain, Data, Presentation)  
- **Асинхронность:** Kotlin Coroutines, Flow  
- **База данных:** Room  
- **DI:** Koin  
- **Networking:** Apollo GraphQL  
- **Image Loading:** Coil  


Особенности
Использование Room + KSP для генерации DAO.
Интеграция Apollo GraphQL с кешированием SQLite.
Полностью построено на Jetpack Compose.

Цель проекта
Этот проект создан для обучения навыкам Android-разработки с современным стеком и подходом Clean Architecture. Благодаря нему я теперь понимаю как это работает и могу использовать их.
