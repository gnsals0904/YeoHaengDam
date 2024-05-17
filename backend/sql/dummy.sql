-- users 테이블 더미 데이터 삽입
INSERT INTO users (email, password, nickname, profile_image, role_type) VALUES
                                                                            ('alice@example.com', 'password123', 'alice', 'profile1.jpg', 'USER'),
                                                                            ('bob@example.com', 'password123', 'bob', 'profile2.jpg', 'USER'),
                                                                            ('charlie@example.com', 'password123', 'charlie', 'profile3.jpg', 'USER'),
                                                                            ('dave@example.com', 'password123', 'dave', 'profile4.jpg', 'USER'),
                                                                            ('eve@example.com', 'password123', 'eve', 'profile5.jpg', 'USER');

-- article 테이블 더미 데이터 삽입
INSERT INTO article (user_id, title, content, hit) VALUES
                                                       (1, 'How to learn SQL', 'This is a comprehensive guide on how to learn SQL.', 15),
                                                       (2, 'Understanding Databases', 'Databases are essential for managing data.', 20),
                                                       (3, 'MySQL vs PostgreSQL', 'Comparing two popular relational databases.', 30),
                                                       (4, 'Database Normalization', 'Why normalization is important in databases.', 25),
                                                       (5, 'Advanced SQL Queries', 'Tips for writing advanced SQL queries.', 35);

-- article_image 테이블 더미 데이터 삽입
INSERT INTO article_image (article_id, image_url) VALUES
                                                      (1, 'https://example.com/images/sql_guide.jpg'),
                                                      (2, 'https://example.com/images/databases.jpg'),
                                                      (3, 'https://example.com/images/mysql_vs_postgresql.jpg'),
                                                      (4, 'https://example.com/images/normalization.jpg'),
                                                      (5, 'https://example.com/images/advanced_sql.jpg');
