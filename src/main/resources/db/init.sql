DROP TABLE IF EXISTS location_test_data;

CREATE TABLE location_test_data (
    id INT PRIMARY KEY,
    area VARCHAR(100),
    expected_min_results INT
);

INSERT INTO location_test_data (id, area, expected_min_results) VALUES
(1, 'ჭავჭავაძის', 1),
(2, 'თბილისი', 5),
(3, 'ვაკე', 2),
(4, 'საბურთალო', 2);
