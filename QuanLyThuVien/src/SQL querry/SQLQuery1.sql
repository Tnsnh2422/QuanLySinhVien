create database QuanLySV
use QuanLySV

create table sinhVien1 (
  tenDangNhap nvarchar(20) primary key,
  matKhau nvarchar(20), 
  hoTen nvarchar(20),
  tuoi int ,
  gioiTinh nvarchar(10)
)
insert into sinhVien1 
values('admin1','123',N'lê nam',20,'nam');
select * from sinhVien1

create table Sach(
	MaSach nvarchar(20) primary key,
	TenSach nvarchar(100),
	TheLoai nvarchar(20)
)
drop table Sach
insert SACH 
Values	( 'CT12', N'Kho tàng tr cổ tích Việt Nam',  N'Cổ Tích'),
		( 'KH20', N'Kỹ Thuật Lập Trình', N'Khoa Học'),
		( 'T112', N'Góc sân và khoảng trời', N'Thơ'),
		( 'TN21', N'Dế mèn phiêu liêu ký', N'Truyện Ngắn'),
		( 'TT10', N'Quê Hương', N'Tiểu thuyết'),
		( 'TT11', N'Con chó mang giỏ hoa hồng', N'Tiểu Thuyết'),
		( 'TT12', 'Doraemon', N'Truyện dài'),
		( 'TT13', N'Doraemon (Đặc biệt)', N'Truyện ngắn'),
		( 'TT14', 'Conan', N'Tiểu thuyết'),
		( 'TT15', N'Quê nội', N'Tiểu thuyết') 
select * from Sach