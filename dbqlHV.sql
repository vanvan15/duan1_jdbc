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
select*from NhanVien
select*from ChucVu

select*from Lichhoc
select*from HocKy
select*from MonHoc
delete from HocKy

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

delete from MonHoc
insert into MonHoc(idHocKy,tenMon,hocPhi,thoiLuong,ngayTao,ngaySua)
values 
-- ky 1
('16FD5ECA-8795-4A61-A6CD-EED4A87ED410',N'Lap trinh C',1800000,8,'2022/11/10','2022/11/17'),
('16FD5ECA-8795-4A61-A6CD-EED4A87ED410',N'Phat Trien Ca Nhan',1800000,8,'2022/11/10','2022/11/17'),
('16FD5ECA-8795-4A61-A6CD-EED4A87ED410',N'Tin học',1800000,8,'2022/11/10','2022/11/17'),
('16FD5ECA-8795-4A61-A6CD-EED4A87ED410',N'Thiết kế hình ảnh với Photoshop',1800000,8,'2022/11/10','2022/11/17'),
('16FD5ECA-8795-4A61-A6CD-EED4A87ED410',N'Tiếng Anh 1.1',2600000,8,'2022/11/10','2022/11/17'),
--ky2
--select *from HocKy
('6A79D536-DB1D-476C-978B-828516F706A0',N'Xây dựng trang web',1800000,8,'2022/11/10','2022/11/17'),
('6A79D536-DB1D-476C-978B-828516F706A0',N'Cơ sở dữ liệu',1800000,8,'2022/11/10','2022/11/17'),
('6A79D536-DB1D-476C-978B-828516F706A0',N'Lập trình cơ sở với JavaScript',1800000,8,'2022/11/10','2022/11/17'),
('6A79D536-DB1D-476C-978B-828516F706A0',N'Tiếng Anh 1.2',2600000,8,'2022/11/10','2022/11/17'),
('6A79D536-DB1D-476C-978B-828516F706A0',N'Lập trình Java 1',1800000,8,'2022/11/10','2022/11/17'),
--ky3
('A130053B-38FE-4ACF-BEB8-006DD84F3895',N'Hệ quản trị SQL Server',1800000,8,'2022/11/10','2022/11/17'),
('A130053B-38FE-4ACF-BEB8-006DD84F3895',N'Quản lý dự án với Agile',1800000,8,'2022/11/10','2022/11/17'),
('A130053B-38FE-4ACF-BEB8-006DD84F3895',N'Tiếng Anh 2.1',2600000,8,'2022/11/10','2022/11/17'),
('A130053B-38FE-4ACF-BEB8-006DD84F3895',N'Lập trình Java 2',1800000,8,'2022/11/10','2022/11/17'),
('A130053B-38FE-4ACF-BEB8-006DD84F3895',N'Lập trình Java 3',1800000,8,'2022/11/10','2022/11/17'),
-- ky 4

('2B4B0579-0ACC-4769-AEB1-D0E43F0BB07D',N'Nhập môn Kỹ thuật phần mềm',1800000,8,'2022/11/10','2022/11/17'),
('2B4B0579-0ACC-4769-AEB1-D0E43F0BB07D',N'Dự án mẫu (Swing/JDBC)',1800000,8,'2022/11/10','2022/11/17'),
('2B4B0579-0ACC-4769-AEB1-D0E43F0BB07D',N'Dự án 1 (Swing/JDBC)',1800000,8,'2022/11/10','2022/11/17'),
('2B4B0579-0ACC-4769-AEB1-D0E43F0BB07D',N'Tiếng Anh 2.2',2600000,8,'2022/11/10','2022/11/17'),
('2B4B0579-0ACC-4769-AEB1-D0E43F0BB07D',N'Python',1000000,4,'2022/11/10','2022/11/17'),
--ky 5 

('90384634-D77E-4AC4-9460-1DD329256E7A',N'Kiểm thử cơ bản',1800000,8,'2022/11/10','2022/11/17'),
('90384634-D77E-4AC4-9460-1DD329256E7A',N'Kiểm thử nâng cao',1800000,8,'2022/11/10','2022/11/17'),
('90384634-D77E-4AC4-9460-1DD329256E7A',N'Front-end Framework',1800000,8,'2022/11/10','2022/11/17'),
('90384634-D77E-4AC4-9460-1DD329256E7A',N'Lập trình Java 4',2600000,8,'2022/11/10','2022/11/17'),
-- ky 6
('5EFF612F-0C0E-45F0-94CA-65D4D3463CFC',N'Lập trình Java 5',1800000,8,'2022/11/10','2022/11/17'),
('5EFF612F-0C0E-45F0-94CA-65D4D3463CFC',N'Lập trình Java 6',1800000,8,'2022/11/10','2022/11/17'),
('5EFF612F-0C0E-45F0-94CA-65D4D3463CFC',N'Python 2',1800000,8,'2022/11/10','2022/11/17'),
('5EFF612F-0C0E-45F0-94CA-65D4D3463CFC',N'Python 3',2600000,8,'2022/11/10','2022/11/17')
-- ky 7 
insert into MonHoc(idHocKy,tenMon,hocPhi,thoiLuong,ngayTao,ngaySua)
values
('17CD47C2-6A35-4CEE-BCFC-E55C1113D253',N'Thực tập tốt nghiệp',1800000,8,'2022/11/10','2022/11/17'),
('17CD47C2-6A35-4CEE-BCFC-E55C1113D253',N'Dự án tốt nghiệp (Spring Boot)',1800000,8,'2022/11/10','2022/11/17'),
('17CD47C2-6A35-4CEE-BCFC-E55C1113D253',N'Python 2',1800000,8,'2022/11/10','2022/11/17'),
('17CD47C2-6A35-4CEE-BCFC-E55C1113D253',N'Python 3',2600000,8,'2022/11/10','2022/11/17')
select*from HocKy

insert into ChucVu(idChucVu,tenChucVu,ngayTao,ngaySua)
values
('0',N'Giảng Viên','2022/11/15','2022/11/15'),
('1','Admin','2022/11/15','2022/11/15')

insert into NhanVien(maNV,ho,tenDem,ten,email,diaChi,sdt,matKhau,idChucVu,ngayTao,ngaySua)
values 
('nguyenvv','Vu','Van','Nguyen','nguyenvv4@fpt.edu.vn','HN','0999999999','1234','0','2022/11/15','2022/11/15'),
('khanhhq','Ha','Quoc','Khanh','khanhhq@fpt.edu.vn','HN','0999999999','1234','0','2022/11/15','2022/11/15'),
('hieucv','Chu','Van','Hieu','hieucv@fpt.edu.vn','HN','0999999999','1234','0','2022/11/15','2022/11/15'),
('dotd','Tran','Duc','Do','dotd@fpt.edu.vn','HN','0999999999','1234','0','2022/11/15','2022/11/15'),
('minhmn','Mai','Ngoc','Minh','minhmn@fpt.edu.vn','HN','0999999999','1234','0','2022/11/15','2022/11/15'),
('thangnc','Nguyen','Cong','Thang','thangncph20964@fpt.edu.vn','HN','0999999999','1234','0','2022/11/15','2022/11/15'),
('vannv','Nguyen','Van','Van','vannvph28656@fpt.edu.vn','HN','0999999999','1234','1','2022/11/15','2022/11/15')

select * from NhanVien