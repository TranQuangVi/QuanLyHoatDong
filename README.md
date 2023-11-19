# Build with
1. Programming language: Java (version: java 20)
2. Framework: SpringBoot
3. Database: MySQL
   
# Getting Started
1. Clone this project:
```
  git clone https://github.com/TranQuangVi/QuanLyHoatDong
```
2. Selete project:
```
- Move to root project:
   cd/QuanLyHoatDong

- Or selete project:
   File -> Open-> QuanLyHoatDong
```
3. Create database: _You can use WorKBench or any tool to run the script._
   - Create new database (Suggested name: quanlyhoatdong )
   - Choose database and run script in file **"DatabaseScript.sql"**
4. Config in **application.properties**:
```
Config:
  spring.datasource.url=jdbc:mysql://localhost:<your host>/<your database name>
  spring.datasource.username= <username>
  spring.datasource.password= <password>

Example:
  spring.datasource.url=jdbc:mysql://localhost:3305/quanlyhoatdong
  spring.datasource.username=TranQuangVi
  spring.datasource.password=tranquangvi123
```
5. Build project.
6. Run and use swagger Api document.
```
  http://localhost:8080/swagger-ui/index.html#
```
