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
   cd/QLHoatDongSinhVien

- Or selete project:
   File -> Open-> QLHoatDongSinhVien
```
3. Create database:
   - Run script in **"DatabaseScript.sql"** with MySQL WordBench or ...
4. Config in application properties:
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
