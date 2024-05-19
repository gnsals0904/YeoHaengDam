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
                                                                               (5, 2, 'Looking forward to reading more from you.', NOW(), NOW()),
                                                                               (6, 3, 'Interesting perspective, never thought of it that way.', NOW(), NOW()),
                                                                               (6, 4, 'This is quite enlightening, thank you!', NOW(), NOW()),
                                                                               (7, 1, 'I have a different opinion on this.', NOW(), NOW()),
                                                                               (7, 2, 'Appreciate the insights shared here.', NOW(), NOW()),
                                                                               (8, 3, 'This was a helpful read.', NOW(), NOW()),
                                                                               (8, 4, 'I have learned something new today.', NOW(), NOW()),
                                                                               (9, 1, 'Fantastic article, very detailed.', NOW(), NOW()),
                                                                               (9, 2, 'I enjoyed reading this, keep it up!', NOW(), NOW()),
                                                                               (10, 3, 'This is very well articulated.', NOW(), NOW()),
                                                                               (10, 4, 'I appreciate the effort put into this.', NOW(), NOW()),
                                                                               (11, 1, 'Can you share your sources?', NOW(), NOW()),
                                                                               (11, 2, 'This raises some important questions.', NOW(), NOW()),
                                                                               (12, 3, 'Could use more examples.', NOW(), NOW()),
                                                                               (12, 4, 'Thorough analysis, thanks for sharing.', NOW(), NOW()),
                                                                               (13, 1, 'I think you missed this point...', NOW(), NOW()),
                                                                               (13, 2, 'Good job, I enjoyed this.', NOW(), NOW()),
                                                                               (14, 3, 'This is quite comprehensive.', NOW(), NOW()),
                                                                               (14, 4, 'I disagree with this part.', NOW(), NOW()),
                                                                               (15, 1, 'Well explained and detailed.', NOW(), NOW()),
                                                                               (15, 2, 'I appreciate the clarity in this.', NOW(), NOW()),
                                                                               (16, 3, 'This helped clarify my doubts.', NOW(), NOW()),
                                                                               (16, 4, 'Looking forward to more articles like this.', NOW(), NOW()),
                                                                               (17, 1, 'Good read, thanks for posting.', NOW(), NOW()),
                                                                               (17, 2, 'This article is very helpful.', NOW(), NOW()),
                                                                               (18, 3, 'I found a small error in this part.', NOW(), NOW()),
                                                                               (18, 4, 'Insightful and informative.', NOW(), NOW()),
                                                                               (19, 1, 'This was a bit confusing at first.', NOW(), NOW()),
                                                                               (19, 2, 'Great insights, thank you.', NOW(), NOW()),
                                                                               (20, 3, 'Can you provide more statistics?', NOW(), NOW()),
                                                                               (20, 4, 'This is quite a comprehensive guide.', NOW(), NOW()),
                                                                               (21, 1, 'I think you nailed it.', NOW(), NOW()),
                                                                               (21, 2, 'This helped me a lot.', NOW(), NOW()),
                                                                               (22, 3, 'Great job explaining this.', NOW(), NOW()),
                                                                               (22, 4, 'I learned a lot from this.', NOW(), NOW()),
                                                                               (23, 1, 'This article is very well written.', NOW(), NOW()),
                                                                               (23, 2, 'I found this very useful.', NOW(), NOW()),
                                                                               (24, 3, 'Thank you for this detailed explanation.', NOW(), NOW()),
                                                                               (24, 4, 'I appreciate your effort.', NOW(), NOW()),
                                                                               (25, 1, 'This was a good read.', NOW(), NOW()),
                                                                               (25, 2, 'I think you explained this very well.', NOW(), NOW()),
                                                                               (26, 3, 'Great content as always.', NOW(), NOW()),
                                                                               (26, 4, 'This helped me understand a lot.', NOW(), NOW()),
                                                                               (27, 1, 'I have a different take on this.', NOW(), NOW()),
                                                                               (27, 2, 'Thank you for sharing your knowledge.', NOW(), NOW()),
                                                                               (28, 3, 'This was very enlightening.', NOW(), NOW()),
                                                                               (28, 4, 'I enjoyed reading this.', NOW(), NOW()),
                                                                               (29, 1, 'Good article, well detailed.', NOW(), NOW()),
                                                                               (29, 2, 'This provided a lot of value.', NOW(), NOW()),
                                                                               (30, 3, 'Can you elaborate on this point?', NOW(), NOW()),
                                                                               (30, 4, 'I think this could be improved.', NOW(), NOW()),
                                                                               (31, 1, 'Thank you for this great article.', NOW(), NOW()),
                                                                               (31, 2, 'I found some parts unclear.', NOW(), NOW()),
                                                                               (32, 3, 'This is a fantastic resource.', NOW(), NOW()),
                                                                               (32, 4, 'I have learned a lot from this.', NOW(), NOW()),
                                                                               (33, 1, 'This was a bit challenging to understand.', NOW(), NOW()),
                                                                               (33, 2, 'I appreciate your perspective.', NOW(), NOW()),
                                                                               (34, 3, 'Very detailed and informative.', NOW(), NOW()),
                                                                               (34, 4, 'This clarified a lot of my doubts.', NOW(), NOW()),
                                                                               (35, 1, 'Thank you for the detailed explanation.', NOW(), NOW()),
                                                                               (35, 2, 'I think this part needs more detail.', NOW(), NOW()),
                                                                               (36, 3, 'Great work on this article.', NOW(), NOW()),
                                                                               (36, 4, 'I learned something new today.', NOW(), NOW()),
                                                                               (37, 1, 'This is a bit complicated.', NOW(), NOW()),
                                                                               (37, 2, 'Thank you for the insights.', NOW(), NOW()),
                                                                               (38, 3, 'This article is very insightful.', NOW(), NOW()),
                                                                               (38, 4, 'I found this quite useful.', NOW(), NOW()),
                                                                               (39, 1, 'Good job on this!', NOW(), NOW()),
                                                                               (39, 2, 'This was very informative.', NOW(), NOW()),
                                                                               (40, 3, 'I have a suggestion for this part.', NOW(), NOW());
