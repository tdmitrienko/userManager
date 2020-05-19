# userManager

Аннотация. в данном файле представлена документация по сопровождению программного средства.
***
Введение.
Програмное средство предназначено для хранения даннхв о пользователях(их логины и пароли), с возможностью их редактирования удаление или добавления
***
Содержание.

***
Работа с программным средством.

Архитектура приложения-многоуровневая,использован DAO Design Pattern.
Уровень логики приложения взаимодействует с выделенным уровнем доступа к данным (DAO), который взаимодействует с системой управления БД
Программа основана на работе с базой данной mySQL.
Объект доступа к данным (DAO) управляет соединением с источником данных для получения и хранения данных. DAO полностью скрывает детали реализации источника
данных от своих клиентов. Поскольку интерфейс, предоставляемый DAO клиентам, не изменяется при изменении реализации базового источника данных, этот шаблон позволяет
DAO адаптироваться к различным схемам хранения, не затрагивая своих клиентов или бизнес-компоненты. 

В зависимости от используемой БД настройки драйвера и доступа различны.В данной программе используется база данных mySQl 
DB_DRIVER = "com.mysql.jdbc.Driver";
Для подключения к базе данных используется следующая строка подключения
  DB_CONNECTION ="jdbc:mysql://localhost:3306/usersmanager" ;
  DB_USER = "root";
  DB_PASSWORD = "1234";
  DBName="users";
  
Интерфейс доступа к данным DAO. В котором описаны все методы для реализации работы с базой данных.
Класс DBConnect обрабатывает связанные с персональной записью операции с базами данных, такие как поиск, удаление,
обновление пароля с помощью объявленных операторов SQL. Класс User описывает данные пользователя такие как логин и пароль пользователя.
  
