/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     20/09/2023 12:24:05                          */
/*==============================================================*/



/*==============================================================*/
/* Table: ChiTietNoiDung                                        */
/*==============================================================*/
create table ChiTietNoiDung
(
    maNoiDung            varchar(20) not null,
    maSo                 varchar(10) not null,
    vaiTro               varchar(50),
    linkBaiTrinhBay      varchar(100),
    thoiLuongTrinhBay    int,
    qua                  varchar(200),
    ghiChu               varchar(200),
    primary key (maNoiDung, maSo)
);

/*==============================================================*/
/* Table: ChiTietThongBao                                       */
/*==============================================================*/
create table ChiTietThongBao
(
    maSo                 varchar(10) not null,
    maThongBao           varchar(20) not null,
    ngayGui              datetime,
    noiDung              varchar(1024),
    primary key (maSo, maThongBao)
);
/*==============================================================*/
/* Table: ChiTietChucVu                                                */
/*==============================================================*/
create table ChiTietChucVu
(
    maChucVu             varchar(20) not null,
    maSo                 varchar(10) not null,
    primary key (maSo, maChucVu)
);
/*==============================================================*/
/* Table: ChucVu                                                */
/*==============================================================*/
create table ChucVu
(
    maChucVu             varchar(20) not null,
    tenChucVu            varchar(50),
    primary key (maChucVu)
);

/*==============================================================*/
/* Table: DSKhachMoiThamDu                                      */
/*==============================================================*/
create table DSKhachMoiThamDu
(
    maKhachMoi           varchar(20) not null,
    maNoiDung            varchar(20) not null,
    vaiTro               varchar(50),
    linkBaiTrinhBay      varchar(100),
    thoiLuongTrinhBay    int,
    qua                  varchar(200),
    ghiChu               varchar(200),
    primary key (maKhachMoi, maNoiDung)
);

/*==============================================================*/
/* Table: DSSinhVienDangKy                                      */
/*==============================================================*/
create table DSSinhVienDangKy
(
    maHoatDong           varchar(20) not null,
    maSo                 varchar(10) not null,
    ngayDangKy           datetime,
    gioDiemDanh           datetime,
    primary key (maHoatDong, maSo)
);

/*==============================================================*/
/* Table: HoatDong                                              */
/*==============================================================*/
create table HoatDong
(
    maHoatDong           varchar(20) not null,
    maTieuChi            varchar(20),
    maLoaiHoatDong       varchar(20),
    tenHoatDong          varchar(200),
    thoiGianBatDau       datetime,
    thoiGianKetThuc      datetime,
    diaChi               varchar(200),
    soLuongSinhVien      int,
    yeuCau               varchar(1024),
    hinh                 varchar(100),
    trangThai            bool,
    moTa                 varchar(1024),
    maSo                 varchar(10),
    primary key (maHoatDong)
);

/*==============================================================*/
/* Table: KhachMoi                                              */
/*==============================================================*/
create table KhachMoi
(
    maKhachMoi           varchar(20) not null,
    tenKhachMoi          varchar(50),
    sdt                  char(10),
    diaChi               varchar(200),
    email                varchar(200),
    gioiTinh             bool,
    ngaySinh             date,
    chucVu               varchar(20),
    hinh                 varchar(100),
    primary key (maKhachMoi)
);

/*==============================================================*/
/* Table: LoaiHoatDong                                          */
/*==============================================================*/
create table LoaiHoatDong
(
    maLoaiHoatDong       varchar(20) not null,
    tenLoaiHoatDong      varchar(50),
    primary key (maLoaiHoatDong)
);

/*==============================================================*/
/* Table: NoiDungToChuc                                         */
/*==============================================================*/
create table NoiDungToChuc
(
    maNoiDung            varchar(20) not null,
    maHoatDong           varchar(20),
    tenNoiDung           varchar(100),
    thoiGianBatDau       datetime,
    thoiGianKetThuc      datetime,
    noiDung              varchar(1024),
    ghiChu               varchar(200),
    primary key (maNoiDung)
);

/*==============================================================*/
/* Table: PhieuDangKy                                           */
/*==============================================================*/
create table PhieuDangKy
(
    maPhieu              varchar(20) not null,
    maSo                 varchar(10),
    maHoatDong           varchar(20),
    tenPhieu             varchar(100),
    ngayGui              datetime,
    ngayDuyet            datetime,
    trangThai            bool,
    ghiChu               varchar(200),
    primary key (maPhieu)
);

/*==============================================================*/
/* Table: TaiKhoan                                              */
/*==============================================================*/
create table TaiKhoan
(
    maSo                 varchar(10) not null,
--    maChucVu             varchar(20),
    hoTen                varchar(100),
    gioiTinh             bool,
    ngaySinh             date,
    email                varchar(200),
    sdt                  char(10),
    diaChi               varchar(200),
    hinh                 varchar(100),
    matKhau              varchar(100),
    primary key (maSo)
);

/*==============================================================*/
/* Table: ThongBao                                              */
/*==============================================================*/
create table ThongBao
(
    maThongBao           varchar(20) not null,
    maHoatDong           varchar(20),
    tenThongBao          varchar(100),
    noiDung              varchar(1024),
    primary key (maThongBao)
);

/*==============================================================*/
/* Table: TieuChi                                               */
/*==============================================================*/
create table TieuChi
(
    maTieuChi            varchar(20) not null,
    tenTieuChi           varchar(50),
    primary key (maTieuChi)
);

alter table ChiTietChucVu add constraint FK_ChiTietChucVu foreign key (maSo)
    references TaiKhoan (maSo) on delete restrict on update restrict;

alter table ChiTietChucVu add constraint FK_ChiTietChucVu2 foreign key (maChucVu)
    references ChucVu (maChucVu) on delete restrict on update restrict;

alter table ChiTietNoiDung add constraint FK_ChiTietNoiDung foreign key (maNoiDung)
    references NoiDungToChuc (maNoiDung) on delete restrict on update restrict;

alter table ChiTietNoiDung add constraint FK_ChiTietNoiDung2 foreign key (maSo)
    references TaiKhoan (maSo) on delete restrict on update restrict;

alter table ChiTietThongBao add constraint FK_ChiTietThongBao foreign key (maSo)
    references TaiKhoan (maSo) on delete restrict on update restrict;

alter table ChiTietThongBao add constraint FK_ChiTietThongBao2 foreign key (maThongBao)
    references ThongBao (maThongBao) on delete restrict on update restrict;

alter table DSKhachMoiThamDu add constraint FK_DSKhachMoiThamDu foreign key (maKhachMoi)
    references KhachMoi (maKhachMoi) on delete restrict on update restrict;

alter table DSKhachMoiThamDu add constraint FK_DSKhachMoiThamDu2 foreign key (maNoiDung)
    references NoiDungToChuc (maNoiDung) on delete restrict on update restrict;

alter table DSSinhVienDangKy add constraint FK_DSSinhVienDangKy foreign key (maHoatDong)
    references HoatDong (maHoatDong) on delete restrict on update restrict;

alter table DSSinhVienDangKy add constraint FK_DSSinhVienDangKy2 foreign key (maSo)
    references TaiKhoan (maSo) on delete restrict on update restrict;

alter table HoatDong add constraint FK_Relationship_1 foreign key (maLoaiHoatDong)
    references LoaiHoatDong (maLoaiHoatDong) on delete restrict on update restrict;

alter table HoatDong add constraint FK_Relationship_2 foreign key (maTieuChi)
    references TieuChi (maTieuChi) on delete restrict on update restrict;

alter table HoatDong add constraint FK_HoatDong_3 foreign key (maSo)
    references TaiKhoan (maSo) on delete restrict on update restrict;

alter table NoiDungToChuc add constraint FK_Relationship_3 foreign key (maHoatDong)
    references HoatDong (maHoatDong) on delete restrict on update restrict;

alter table PhieuDangKy add constraint FK_Relationship_10 foreign key (maSo)
    references TaiKhoan (maSo) on delete restrict on update restrict;

alter table PhieuDangKy add constraint FK_Relationship_7 foreign key (maHoatDong)
    references HoatDong (maHoatDong) on delete restrict on update restrict;

-- alter table TaiKhoan add constraint FK_Relationship_9 foreign key (maChucVu)
--       references ChucVu (maChucVu) on delete restrict on update restrict;

alter table ThongBao add constraint FK_Relationship_8 foreign key (maHoatDong)
    references HoatDong (maHoatDong) on delete restrict on update restrict;

