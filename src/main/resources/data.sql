DROP TABLE IF EXISTS Contact_Items cascade;

DROP TABLE IF EXISTS Contacts cascade;

CREATE TABLE Contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(250) NOT NULL,
    job VARCHAR(250) DEFAULT NULL
);

CREATE TABLE Contact_Items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    contact_id INT,
    contact_item_type VARCHAR(250) NOT NULL,
    value VARCHAR(250) DEFAULT NULL,
    FOREIGN KEY (contact_id) REFERENCES Contacts(id)
);

INSERT INTO Contacts (full_name, job) VALUES
('Mary Jane Watson', 'Model'),
('Peter Parker', 'Photograph'),
('Gwendolyn Stacy', 'Student');

INSERT INTO Contact_Items (contact_id, contact_item_type, value) VALUES
(1, 'email', 'mjwatson@gmail.com'),
(2, 'phone', '77772005522'),
(3, 'telegram', '@gwen31');