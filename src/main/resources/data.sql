CREATE TABLE IF NOT EXISTS role (
  `role_id` INT NOT NULL,
  `role_title` VARCHAR(45) NULL
);

CREATE TABLE IF NOT EXISTS designation (
  `designation_id` INT NOT NULL,
  `designation_title` VARCHAR(45) NULL
);


INSERT INTO role(role_id, role_title) SELECT 0, 'admin' FROM DUAL WHERE NOT EXISTS (SELECT * FROM role WHERE role_title='admin');
INSERT INTO role(role_id, role_title) SELECT 1, 'employee' FROM DUAL WHERE NOT EXISTS (SELECT * FROM role WHERE role_title='employee');



INSERT INTO designation(designation_id, designation_title) SELECT 0, 'Associate' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Associate');
INSERT INTO designation(designation_id, designation_title) SELECT 1, 'Software Engineer' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Software Engineer');
INSERT INTO designation(designation_id, designation_title) SELECT 2, 'Senior Software Engineer' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Senior Software Engineer');
INSERT INTO designation(designation_id, designation_title) SELECT 3, 'Principal Engineer' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Principal Engineer');
INSERT INTO designation(designation_id, designation_title) SELECT 4, 'Senior Principal Engineer' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Senior Principal Engineer');
INSERT INTO designation(designation_id, designation_title) SELECT 5, 'Architect' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Architect');
INSERT INTO designation(designation_id, designation_title) SELECT 6, 'Senior Architect' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Senior Architect');
INSERT INTO designation(designation_id, designation_title) SELECT 7, 'Associate Director' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Associate Director');
INSERT INTO designation(designation_id, designation_title) SELECT 8, 'Executive Director' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Executive Director');
INSERT INTO designation(designation_id, designation_title) SELECT 9, 'Managing Director' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Managing Director');
INSERT INTO designation(designation_id, designation_title) SELECT 10, 'HR' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='HR');
INSERT INTO designation(designation_id, designation_title) SELECT 11, 'Senior HR' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Senior HR');
INSERT INTO designation(designation_id, designation_title) SELECT 12, 'Consultant' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Consultant');
INSERT INTO designation(designation_id, designation_title) SELECT 13, 'Senior Consultant' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Senior Consultant');
INSERT INTO designation(designation_id, designation_title) SELECT 14, 'Recruiter' FROM DUAL WHERE NOT EXISTS (SELECT * FROM designation WHERE designation_title='Recruiter');
