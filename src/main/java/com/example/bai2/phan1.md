Phần 1 – Phân tích logic
POST: dùng để tạo mới tài nguyên. Nó không idempotent – gửi 
nhiều lần cùng một request có thể tạo ra nhiều bản ghi.

PUT: dùng để cập nhật hoặc thay thế tài nguyên đã tồn tại. 
Nó idempotent – gửi nhiều lần cùng một request sẽ cho kết quả giống nhau,
không tạo thêm bản ghi mới.

Trong code hiện tại, bạn dùng POST cho cả tạo mới và cập nhật.
Khi client gửi cập nhật với ID không tồn tại, hệ thống lại tạo 
thêm bản ghi mới → dẫn đến dữ liệu trùng lặp và không nhất quán.