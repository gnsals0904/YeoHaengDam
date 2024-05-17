DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS article CASCADE;
DROP TABLE IF EXISTS notice CASCADE;
DROP TABLE IF EXISTS article_image CASCADE;
DROP TABLE IF EXISTS comment CASCADE;

CREATE TABLE users (
    user_id           INTEGER PRIMARY KEY AUTO_INCREMENT,
    email             VARCHAR(255)                                                                   NOT NULL,
    password          VARCHAR(255)                                                                   NOT NULL,
    nickname          VARCHAR(255)                                                                   NOT NULL,
    profile_image     VARCHAR(500),
    role_type         enum ('USER', 'ADMIN')                               DEFAULT 'USER' NULL,
    created_at        TIMESTAMP                                            DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at        TIMESTAMP                                            DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT users_email_unique UNIQUE (email),
    CONSTRAINT users_nickname_unique UNIQUE (nickname)
);

CREATE TABLE article (
    article_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    hit INT DEFAULT 0,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE comment{
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    article_id INT NOT NULL,
    user_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (article_id) REFERENCES Article(article_id) ON DELETE CASCADE
};


CREATE TABLE Notice (
    notice_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE article_image (
    id INT AUTO_INCREMENT PRIMARY KEY,
    article_id INT NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    FOREIGN KEY (article_id) REFERENCES Article(article_id) ON DELETE CASCADE
);

