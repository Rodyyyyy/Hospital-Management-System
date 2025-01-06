CREATE TABLE patients (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    age INTEGER NOT NULL,
    contact_info TEXT NOT NULL,
    medical_history TEXT NOT NULL
);
INSERT INTO patients (name, age, contact_info, medical_history) VALUES
('bebo', 30, '01066863230', 'cold'),
('ahmed', 30, '01066863231', 'Cough'),
('mohamed', 35, '01066863232', 'cancer'),
('salah', 40, '01066863233', 'Headache'),
('abosaleh', 45, '01066863234', 'cold'),
('abdelrahman', 50, '01066863235', 'Back Pain'),
('sara', 55, '01066863236', 'Stomach Ache'),
('sama', 45, '01066863237', 'Headache'),
('rodaina', 29, '01066863238', 'Heart Disease'),
('omar', 49, '01066863239', 'cancer'),
('youssef', 38, '123-456-0020', 'Anxiety');