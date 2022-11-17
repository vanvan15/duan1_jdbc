--create database QLHV
--go

use QLHV ;

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
select*from NhanVien
select*from ChucVu

insert into ChucVu(idChucVu,tenChucVu,ngayTao,ngaySua)
values
('0',N'Giảng Viên','2022/11/15','2022/11/15'),
('1','Admin','2022/11/15','2022/11/15')

insert into NhanVien(ho,tenDem,ten,email,diaChi,sdt,trangThai,matKhau,idChucVu,ngayTao,ngaySua)
values 
('Vu','Van','Nguyen','nguyenvv4@fpt.edu.vn','HN','0999999999','dang day','1234','0','2022/11/15','2022/11/15'),
('Ha','Quoc','Khach','khanhhq@fpt.edu.vn','HN','0999999999','dang day','1234','0','2022/11/15','2022/11/15'),
('Chu','Van','Hieu','hieucv@fpt.edu.vn','HN','0999999999','dang day','1234','0','2022/11/15','2022/11/15'),
('Tran','Duc','Do','dotd@fpt.edu.vn','HN','0999999999','dang day','1234','0','2022/11/15','2022/11/15'),
('Mai','Ngoc','Minh','minhmn@fpt.edu.vn','HN','0999999999','dang day','1234','0','2022/11/15','2022/11/15'),
('Van','Van','Van','vannvph28656@fpt.edu.vn','HN','0999999999','admin','1234','1','2022/11/15','2022/11/15')

