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


INSERT INTO comment (article_id, user_id, content, created_at, updated_at) VALUES
                                                                               (1, 1, 'Great article! Thanks for sharing.', NOW(), NOW()),
                                                                               (1, 2, 'I found this very informative.', NOW(), NOW()),
                                                                               (2, 3, 'Excellent write-up on this topic.', NOW(), NOW()),
                                                                               (2, 4, 'I have some questions about this part...', NOW(), NOW()),
                                                                               (3, 1, 'Can you provide more details on the methodology?', NOW(), NOW()),
                                                                               (3, 2, 'I totally agree with your point.', NOW(), NOW()),
                                                                               (4, 3, 'This helped me understand the subject better.', NOW(), NOW()),
                                                                               (4, 4, 'Could you explain this section further?', NOW(), NOW()),
                                                                               (5, 1, 'Well written and easy to follow.', NOW(), NOW()),
                                                                               (5, 2, 'Looking forward to reading more from you.', NOW(), NOW());