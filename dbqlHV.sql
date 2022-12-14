--create database QuanLyHocVien
go

use QuanLyHocVien ;
go

if OBJECT_ID('ChucVu') is not null
drop table ChucVu
go
create table ChucVu
(
    idChucVu int PRIMARY KEY not null,
    tenChucVu NVARCHAR(50) not null,
	ngayTao date,
	ngaySua date
)
if OBJECT_ID('NhanVien') is not null
drop table NhanVien
go
create table NhanVien
(
    id UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
	maNV varchar(10) UNIQUE not null,
    ho NVARCHAR(10) ,
    tenDem NVARCHAR(10) ,
    ten NVARCHAR(10),
    email NVARCHAR(50)not null,
    diaChi NVARCHAR(50),
	sdt char(11),
	ngaySinh date,
    trangThai int default 0,
    matKhau varchar(50) not null,
    idChucVu int,
	ngayTao date,
    ngaySua date,
    FOREIGN KEY (idChucVu) REFERENCES ChucVu
)
alter table NhanVien alter column anh varchar(500)
alter table HocVien alter column anh varchar(500)
alter table NhanVien add gioiTinh bit
alter table HocVien add gioiTinh bit
if OBJECT_ID('HocKy') is not null
drop table HocKy
go
create table HocKy
(  
    idHocKy UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
    hocKy int not null,
    moTa NVARCHAR(50),
    thoiLuong nvarchar(50) not null,
	trangThai int default 0,
    ngayTao date,
    ngaySua date
)

if OBJECT_ID('HocVien') is not null
drop table HocVien
go
create table HocVien
(
    id UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
	maHV varchar(10)UNIQUE not null,
    ho NVARCHAR(10) ,
    tenDem NVARCHAR(10) ,
    ten NVARCHAR(10),
    email NVARCHAR(50)not null,
    diaChi NVARCHAR(50),
	sdt char(11),
	ngaySinh date,
    trangThai int default 0,
    matKhau varchar(50) not null,
	ngayTao date,
    ngaySua date
)

if OBJECT_ID('CaHoc') is not null
drop table CaHoc
go
create table CaHoc
(   
    id UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
    maCa varchar(10) not null,
    thoiGian varchar(50) not null,
	trangThai int default 0,
    ngayTao date,
    ngaySua date
)



if OBJECT_ID('DangKyHocLai') is not null
drop table DangKyHocLai
go
create table DangKyHocLai
(	
	idDangKyHocLai UNIQUEIDENTIFIER default newID(),
    idHocVien UNIQUEIDENTIFIER ,
    idHocKy UNIQUEIDENTIFIER ,
    ngayDangKy date ,
	hocPhi decimal ,
	trangThai int default 0,
	ngayTao date,
    ngaySua date,
	PRIMARY KEY (idDangKyHocLai),
    FOREIGN KEY (idHocKy) REFERENCES HocKy,
    FOREIGN KEY (idHocVien) REFERENCES HocVien
)
if OBJECT_ID('Vi') is not null
drop table Vi
go
create table Vi
(
    idVi UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
    idHocVien UNIQUEIDENTIFIER not null,
    soDuVi DECIMAL ,
    ngayTao date,
    ngaySua date,
    trangThai int default 0,
    FOREIGN KEY (idHocVien) REFERENCES HocVien
)
if OBJECT_ID('MonHoc') is not null
drop table MonHoc
go
create table MonHoc
(
    id UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY not null,
    idHocKy UNIQUEIDENTIFIER ,
	tenMon nvarchar(50),
	hocPhi decimal,
	thoiLuong int check(thoiLuong>=1 and thoiLuong<=12),
	trangThai int default 0,
	ngayTao date,
    ngaySua date,
    FOREIGN KEY(idHocKy) REFERENCES HocKy,
)
if OBJECT_ID('Lop') is not null
drop table Lop
go
create table Lop
(   
    id UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
	idGiangVien UNIQUEIDENTIFIER ,
    maLop NVARCHAR(50),
    tenLop NVARCHAR(50),
    slHocVien int ,
    slToiDa int ,
    idCa UNIQUEIDENTIFIER not null,
	idMonHoc UNIQUEIDENTIFIER not null,
	trangThai int default 0,
	ngayTao date,
	ngaySua date,
    FOREIGN KEY (idGiangVien) REFERENCES NhanVien,
    FOREIGN KEY (idCa) REFERENCES CaHoc,
	FOREIGN KEY (idMonHoc) REFERENCES MonHoc
)
alter table lop alter column idCa UNIQUEIDENTIFIER 
alter table lop alter column idMonHoc UNIQUEIDENTIFIER
if OBJECT_ID('LopHocVien') is not null
drop table LopHocVien
go
create table LopHocVien
(
	idLopHocVien UNIQUEIDENTIFIER default newid(),
    idLop UNIQUEIDENTIFIER not null,
    idHocVien UNIQUEIDENTIFIER not null,
	trangThai int default 0,
	ngayTao date,
	ngaySua date,
	primary key(idLopHocVien),
    FOREIGN KEY (idLop) REFERENCES Lop,
    FOREIGN KEY (idHocVien) REFERENCES HocVien
)
if OBJECT_ID('DongHocPhi') is not null
drop table DongHocPhi
go
create table DongHocPhi
(
    idDongHP UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY not null,
    idHocVien UNIQUEIDENTIFIER ,
	idMonHoc UNIQUEIDENTIFIER,
    ngayDong DATE ,
    tienDong DECIMAL,
	trangThai int default 0,
    ngayTao date,
    ngaySua date,
    FOREIGN KEY(idHocVien) REFERENCES HocVien,
	FOREIGN KEY(idMonHoc) REFERENCES MonHoc	
)

if OBJECT_ID('KetQuaHT') is not null
drop table KetQuaHT
go
create table KetQuaHT
(
    id UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
    idHocVien UNIQUEIDENTIFIER not null,
	idMonHoc UNIQUEIDENTIFIER not null,
	diemGiuaKy float,
	diemTongKet float,
	danhGia nvarchar(50),
	trangThai int default 0,
	ngayTao date,
    ngaySua date,
    FOREIGN KEY(idHocVien) REFERENCES HocVien,
	FOREIGN KEY(idMonHoc) REFERENCES MonHoc,
)
if OBJECT_ID('LichHoc') is not null
drop table LichHoc
go
create table LichHoc
(
    id UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
    idLop UNIQUEIDENTIFIER not null,
	ngayHoc Date,
	trangThai int default 0,
	ngayTao date,
    ngaySua date,
    FOREIGN KEY(idLop) REFERENCES Lop
)

delete from NhanVien
select*from ChucVu
select * from NhanVien
select*from Lichhoc
select*from HocKy
select*from MonHoc
delete from HocKy
if OBJECT_ID('LichSuNapTien') is not null
drop table LichSuNapTien
go
create table LichSuNapTien
(
    idNapTien UNIQUEIDENTIFIER DEFAULT newID() PRIMARY KEY,
    tienNap decimal default 0,
	ngayNap date,
	idVi UNIQUEIDENTIFIER,
	foreign key (idVi) references Vi
)
update NhanVien set matKhau = '1234' where maNV = 'Nv03'
insert into HocKy(hocKy,moTa,thoiLuong,ngayTao,ngaySua)
values
(1,'Ky 1','4 Month','2022/11/17','2022/11/17'),
(2,'Ky 2','4 Month','2022/11/10','2022/11/17'),
(3,'Ky 3','4 Month','2022/11/10','2022/11/17'),
(4,'Ky 4','4 Month','2022/11/10','2022/11/17'),
(5,'Ky 5','4 Month','2022/11/10','2022/11/17'),
(6,'Ky 6','4 Month','2022/11/10','2022/11/17'),
(7,'Ky 7','4 Month','2022/11/10','2022/11/17')
--week
update NhanVien set sdt = '09876543210'
select * from HocKy
delete from MonHoc
insert into MonHoc(idHocKy,tenMon,hocPhi,thoiLuong,ngayTao,ngaySua)
values 
-- ky 1
('8C50022F-953E-45A6-98A9-D8A85DA308ED',N'Lap trinh C',1800000,8,'2022/11/10','2022/11/17'),
('8C50022F-953E-45A6-98A9-D8A85DA308ED',N'Phat Trien Ca Nhan',1800000,8,'2022/11/10','2022/11/17'),
('8C50022F-953E-45A6-98A9-D8A85DA308ED',N'Tin học',1800000,8,'2022/11/10','2022/11/17'),
('8C50022F-953E-45A6-98A9-D8A85DA308ED',N'Thiết kế hình ảnh với Photoshop',1800000,8,'2022/11/10','2022/11/17'),
('8C50022F-953E-45A6-98A9-D8A85DA308ED',N'Tiếng Anh 1.1',2600000,8,'2022/11/10','2022/11/17'),
--ky2
--select *from HocKy
('73023F9D-E4AA-40E5-8EC2-218619B3CC77',N'Xây dựng trang web',1800000,8,'2022/11/10','2022/11/17'),
('73023F9D-E4AA-40E5-8EC2-218619B3CC77',N'Cơ sở dữ liệu',1800000,8,'2022/11/10','2022/11/17'),
('73023F9D-E4AA-40E5-8EC2-218619B3CC77',N'Lập trình cơ sở với JavaScript',1800000,8,'2022/11/10','2022/11/17'),
('73023F9D-E4AA-40E5-8EC2-218619B3CC77',N'Tiếng Anh 1.2',2600000,8,'2022/11/10','2022/11/17'),
('73023F9D-E4AA-40E5-8EC2-218619B3CC77',N'Lập trình Java 1',1800000,8,'2022/11/10','2022/11/17'),
--ky3
('FBFFE110-B1AE-4435-86E4-E25EA5282F77',N'Hệ quản trị SQL Server',1800000,8,'2022/11/10','2022/11/17'),
('FBFFE110-B1AE-4435-86E4-E25EA5282F77',N'Quản lý dự án với Agile',1800000,8,'2022/11/10','2022/11/17'),
('FBFFE110-B1AE-4435-86E4-E25EA5282F77',N'Tiếng Anh 2.1',2600000,8,'2022/11/10','2022/11/17'),
('FBFFE110-B1AE-4435-86E4-E25EA5282F77',N'Lập trình Java 2',1800000,8,'2022/11/10','2022/11/17'),
('FBFFE110-B1AE-4435-86E4-E25EA5282F77',N'Lập trình Java 3',1800000,8,'2022/11/10','2022/11/17'),
-- ky 4

('8F58ABD2-0698-471F-9809-CA48CF8169DA',N'Nhập môn Kỹ thuật phần mềm',1800000,8,'2022/11/10','2022/11/17'),
('8F58ABD2-0698-471F-9809-CA48CF8169DA',N'Dự án mẫu (Swing/JDBC)',1800000,8,'2022/11/10','2022/11/17'),
('8F58ABD2-0698-471F-9809-CA48CF8169DA',N'Dự án 1 (Swing/JDBC)',1800000,8,'2022/11/10','2022/11/17'),
('8F58ABD2-0698-471F-9809-CA48CF8169DA',N'Tiếng Anh 2.2',2600000,8,'2022/11/10','2022/11/17'),
('8F58ABD2-0698-471F-9809-CA48CF8169DA',N'Python',1000000,4,'2022/11/10','2022/11/17'),
--ky 5 

('2CFA9BE3-2105-4E54-B96A-E27DE1DF6713',N'Kiểm thử cơ bản',1800000,8,'2022/11/10','2022/11/17'),
('2CFA9BE3-2105-4E54-B96A-E27DE1DF6713',N'Kiểm thử nâng cao',1800000,8,'2022/11/10','2022/11/17'),
('2CFA9BE3-2105-4E54-B96A-E27DE1DF6713',N'Front-end Framework',1800000,8,'2022/11/10','2022/11/17'),
('2CFA9BE3-2105-4E54-B96A-E27DE1DF6713',N'Lập trình Java 4',2600000,8,'2022/11/10','2022/11/17'),
-- ky 6
('1AA3A600-65E1-45BA-A40E-FD5E93DDDA0F',N'Lập trình Java 5',1800000,8,'2022/11/10','2022/11/17'),
('1AA3A600-65E1-45BA-A40E-FD5E93DDDA0F',N'Lập trình Java 6',1800000,8,'2022/11/10','2022/11/17'),
('1AA3A600-65E1-45BA-A40E-FD5E93DDDA0F',N'Python 2',1800000,8,'2022/11/10','2022/11/17'),
('1AA3A600-65E1-45BA-A40E-FD5E93DDDA0F',N'Python 3',2600000,8,'2022/11/10','2022/11/17')
-- ky 7 
insert into MonHoc(idHocKy,tenMon,hocPhi,thoiLuong,ngayTao,ngaySua)
values
('B268729D-1C05-43AB-94DB-70795DE2D7CB',N'Thực tập tốt nghiệp',1800000,8,'2022/11/10','2022/11/17'),
('B268729D-1C05-43AB-94DB-70795DE2D7CB',N'Dự án tốt nghiệp (Spring Boot)',1800000,8,'2022/11/10','2022/11/17'),
('B268729D-1C05-43AB-94DB-70795DE2D7CB',N'Python 2',1800000,8,'2022/11/10','2022/11/17'),
('B268729D-1C05-43AB-94DB-70795DE2D7CB',N'Python 3',2600000,8,'2022/11/10','2022/11/17')
select*from HocKy
select *from MonHoc
select * from HocVien
select id,maNV,ho,ten,tendem,email,diaChi,sdt,ngaySinh,
trangThai,matKhau,idChucVu,ngayTao,ngaySua
from NhanVien Where idChucVu = 0 
select * from HocKy
SELECT id,ngaytao,ngaysua
  from NhanVien
  ORDER by day(ngaySua),MONTH(ngaySua) ,YEAR(ngaySua) asc
INSERT INTO HocVien(maHV,ho,ten,tenDem,email,diaChi,sdt,ngaySinh,trangThai,matKhau,ngayTao,ngaySua)	

     VALUES
        ('mahv001','Cao','Thanh','Lam','lamtcph2000@fpt.edu.vn','HN','0999999999','2003/11/11',0,'1234','2022/11/10','2022/11/14'),
        ('mahv002','Lâm','Cao','Nam','namtcph2000@fpt.edu.vn','HN','0999999999','2003/11/11',0,'1234','2022/11/10','2022/11/14'),
        ('mahv003','Ða','Ma','Anh','anhtcph2000@fpt.edu.vn','HN','0999999999','2003/11/11',0,'1234','2022/11/10','2022/11/14'),
        ('mahv004','Long','Ta','Tâm','tamtcph2000@fpt.edu.vn','HN','0999999999','2003/11/11',0,'1234','2022/11/10','2022/11/14'),
        ('mahv005','Lê','Thanh','Ti?n','tientcph2000@fpt.edu.vn','HN','0999999999','2003/11/11',0,'1234','2022/11/10','2022/11/14')
update NhanVien set gioiTinh = 0
update HocVien set gioiTinh = 0
select * from NhanVien