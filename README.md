# ThemoviedbTesting

Initial repository structure:
- Automations/
- Docs/
- Test-cases/

# Katalon Studio — Hướng dẫn sử dụng cho nhóm

---

## Cài đặt lần đầu

1. Vào [katalon.com/download](https://katalon.com/download)
2. Tải bản **Katalon Studio Free**
3. Cài đặt → mở lên → đăng ký tài khoản miễn phí để activate
4. Mở Katalon → **Open Project** → chọn folder `automation/katalon-project` trong repo

---

## Cấu trúc project

```
automation/katalon-project/
│
├── Test Cases/
│   ├── TS-01-Search/
│   │   ├── TC-01-Search-valid-movie
│   │   ├── TC-02-Search-exact-movie
│   │   └── ...
│   ├── TS-02-Filter/
│   ├── TS-03-MovieDetail/
│   ├── TS-05-Watchlist/
│   └── TS-07-API/
│
├── Test Suites/
│   ├── TS-01-Search-Functionality
│   ├── TS-02-Filter-Sort
│   └── ALL-SCENARIOS
│
├── Object Repository/
│   └── Page_The_Movie_Database/
│       ├── input_Search
│       ├── input_button
│       └── ...
│
└── Reports/
    └── ALL-SCENARIOS/
        └── [ngày giờ chạy]/
            ├── report.html
            └── report.pdf
```

> **Quan trọng:** Mỗi thành viên chỉ tạo Test Cases trong folder scenario của mình, không động vào folder của người khác.

---

## Phân công folder

| Thành viên | Folder |
|-----------|--------|
| Member 1 | `Test Cases/TS-01-Search/` |
| Member 2 | `Test Cases/TS-03-MovieDetail/` |
| Member 3 | `Test Cases/TS-05-Watchlist/` |
| Member 4 | `Test Cases/TS-07-API/` |

---

## Cách Record Test Case

### Bước 1: Mở Record
1. Trên thanh công cụ → click **Record Web** (biểu tượng tròn đỏ)
2. Nhập URL: `https://www.themoviedb.org/`
3. Chọn browser: **Chrome**
4. Click **Record** → trình duyệt tự mở

### Bước 2: Thực hiện thao tác
- Thực hiện các bước test bình thường trên trình duyệt
- Katalon tự ghi lại toàn bộ thao tác

### Bước 3: Dừng và lưu
1. Click **Stop** khi xong
2. Dialog **Add Element to Object Repository** hiện ra:
   - Chọn **"Merge changes into existing objects"** → **OK**
   - *(Chọn cái này khi bị báo element trùng — hoàn toàn bình thường)*
3. Đặt tên test case theo format: `TC-XX-Ten-mo-ta`
4. Lưu vào đúng folder scenario của mình

### Ví dụ record cho từng loại test case

**TC-01: Search valid movie**
```
1. Truy cập https://www.themoviedb.org/
2. Click vào thanh search
3. Gõ "Avengers"
4. Nhấn Enter
5. Quan sát kết quả → Stop
```

**TC-03: Search empty input**
```
1. Truy cập https://www.themoviedb.org/
2. Click vào thanh search
3. Không gõ gì
4. Nhấn Enter
5. Quan sát kết quả → Stop
```

**TC-05: Search special characters**
```
1. Truy cập https://www.themoviedb.org/
2. Click vào thanh search
3. Gõ "!@#$%"
4. Nhấn Enter
5. Quan sát kết quả → Stop
```

---

## Xử lý lỗi "Add Element to Object Repository"

Khi Katalon báo element bị trùng (highlighted màu đỏ):

| Lựa chọn | Khi nào dùng |
|----------|-------------|
| **Merge changes into existing objects** | ✅ Dùng mặc định — element dùng chung giữa các TC |
| Create duplicate objects | ❌ Không dùng — gây rối Object Repository |
| Replace existing objects | ⚠️ Chỉ dùng khi element cũ bị sai hoàn toàn |

> **Lý do bị trùng:** Nhiều TC cùng dùng chung thanh search, nút login... trên cùng 1 trang TMDB. Đây là bình thường, không phải lỗi.

---

## Tạo Test Suite

Sau khi record xong các TC của mình:

1. Click phải vào **Test Suites** → **New Test Suite**
2. Đặt tên: `TS-01-Search-Functionality` (theo scenario của mình)
3. Click **Add** → chọn toàn bộ TC trong folder của mình
4. Sắp xếp thứ tự TC từ TC-01 trở đi

---

## Chạy Test Suite

1. Mở Test Suite vừa tạo
2. Chọn browser muốn chạy
3. Click **Run**
4. Chờ Katalon chạy tự động
5. Xem kết quả trong tab **Log Viewer** phía dưới

---

## Export Report ( Optional vì trưởng nhóm sẽ tự tổng hợp lại)

Sau khi chạy xong:

1. Nhìn panel bên trái → mở folder **Reports**
2. Tìm folder tên theo ngày giờ vừa chạy
3. Click phải → **Export to PDF**
4. Lưu file vào máy cá nhân để xem thử

Kết quả report trông như sau:
```
Test Suite: TS-01-Search-Functionality
Run date: 29/03/2026 | Browser: .....

TC-01  Search valid movie         ✅ PASSED
TC-02  Search exact movie         ✅ PASSED
TC-03  Search empty input         ✅ PASSED
TC-04  Search invalid keyword     ✅ PASSED
TC-05  Search special characters  ❌ FAILED
...

Total: 10 | Pass: 9 | Fail: 1 | Pass Rate: 90%
```

---

## Tổng hợp cuối kỳ (Trưởng nhóm làm)

Sau khi tất cả thành viên push xong:

1. Mở Katalon → tạo **New Test Suite** → đặt tên `ALL-SCENARIOS`
2. Click **Add** → chọn toàn bộ TC của tất cả thành viên
3. Chạy `ALL-SCENARIOS` → Export report
4. Chụp screenshot kết quả để đính vào báo cáo Word

---

## Lưu ý quan trọng

- Luôn **git pull** trước khi mở Katalon để tránh conflict
- Chỉ làm việc trong **folder scenario của mình**
- Sau khi record xong → **git push** ngay để người khác pull về được
- Nếu Katalon báo lỗi không chạy được → thử đổi browser sang **Firefox**
- Report HTML/PDF sau khi export phải **upload lên GitHub** trước khi nộp bài
