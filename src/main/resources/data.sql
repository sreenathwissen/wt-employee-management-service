CREATE TABLE role (
  `role_id` INT NOT NULL,
  `role_title` VARCHAR(45) NULL
);

CREATE TABLE designation (
  `designation_id` INT NOT NULL,
  `designation_title` VARCHAR(45) NULL
);

INSERT INTO role values
    (0, "admin"),
    (1, "employee");

INSERT INTO designation values
    (0, "Associate"),
    (1, "Software Engineer"),
    (2, "Senior Software Engineer"),
    (3, "Principal Engineer"),
    (4, "Senior Principal Engineer"),
    (5, "Architect"),
    (6, "Associate Director"),
    (7, "Executive Director"),
    (8, "Managing Director"),
    (9, "HR"),
    (10, "Senior HR"),
    (11, "Consultant"),
    (12, "Senior Consultant");
