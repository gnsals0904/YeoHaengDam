DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
   user_id           INTEGER PRIMARY KEY AUTO_INCREMENT,
   email             VARCHAR(255)                                                                   NOT NULL,
   password          VARCHAR(255)                                                                   NOT NULL,
   nickname          VARCHAR(255)                                                                   NOT NULL,
   profile_image     VARCHAR(500),
   role_type         enum ('USER', 'ADMIN')                               DEFAULT 'USER' NULL,
   created_at        TIMESTAMP                                            DEFAULT CURRENT_TIMESTAMP NOT NULL,
   updated_at        TIMESTAMP                                            DEFAULT CURRENT_TIMESTAMP NOT NULL,
   CONSTRAINT users_email_unique UNIQUE (email)
);
