INSERT INTO owner (first_name, last_name, address, city, telephone)
    VALUES
        ('John', 'Doe', 'The Last Street 12', 'Mumbai', '+9135677654'),
        ('Jane', 'Doe', 'The First Street 32', 'Mumbai', '+91634645913');

INSERT INTO pet_type (name)
    VALUES
        ('Bird');

INSERT INTO pet (name, pet_type_id, owner_id, birth_date)
    VALUES ('Rob', 1, 1, '2018-03-16');