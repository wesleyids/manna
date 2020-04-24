

CREATE DATABASE IF NOT EXISTS manna;

CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(1000) NOT NULL,
    created DATETIME NOT NULL,
    type VARCHAR(12),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS project (
  id BIGINT AUTO_INCREMENT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(250),
  prefix VARCHAR(4) NOT NULL,
  created DATETIME NOT NULL,
--   account_id BIGINT NOT NULL,
  PRIMARY KEY (id)
--   FOREIGN KEY(account_id) REFERENCES account(id)
);

CREATE TABLE IF NOT EXISTS tasks (
  id BIGINT AUTO_INCREMENT NOT NULL,
  title VARCHAR(100),
  description VARCHAR(10000),
  created DATETIME NOT NULL,
  started DATETIME NOT NULL,
  finished DATETIME NOT NULL,
  status VARCHAR(20),
  project_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(project_id) REFERENCES project(id)
);

-- CREATE TABLE roles (
--
-- )

-- CREATE TABLE dashboard (
--   project_id,
--   task_id,
--   account_id
-- )


-- unicode
-- SET character_set_client = utf8;
-- SET character_set_connection = utf8;
-- SET character_set_results = utf8;
-- SET collation_connection = utf8_general_ci;

-- fix
-- ALTER TABLE manna.project MODIFY COLUMN Hash VARCHAR(255) NOT NULL DEFAULT '';

-- inserts
INSERT INTO project(name, description, created, prefix) VALUES ('test', 'test', now(), 'TES');