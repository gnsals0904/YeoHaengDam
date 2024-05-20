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

-- 공지사항 더미 데이터
INSERT INTO notice (notice_id, user_id, title, content, created_at, updated_at) VALUES
  (1, 1, '개인정보 처리방침 변경 안내', '우리는 사용자 데이터 보호를 위해 개인정보 처리방침을 업데이트했습니다.', NOW(), NOW()),
  (2, 2, '서비스 신기능 소개', '이번 달에 새롭게 시작된 기능들을 확인해보세요!', NOW(), NOW()),
  (3, 3, '정기 점검 안내', '정기 점검으로 인해 토요일에 서비스 이용이 일시적으로 중단됩니다.', NOW(), NOW()),
  (4, 4, '더 나은 사용 경험을 위한 팁', '이 팁들을 통해 우리 플랫폼을 더 잘 사용하는 방법을 배워보세요.', NOW(), NOW()),
  (5, 1, '고객 지원 시간 변경 안내', '다음 달부터 고객 지원 가능 시간이 확대됩니다.', NOW(), NOW()),
  (6, 2, '보안 업데이트 안내', '중요 보안 업데이트가 가능합니다. 시스템 업데이트를 해 주세요.', NOW(), NOW()),
  (7, 3, '새 사무실 오픈 소식', '베를린에 새 사무실이 오픈했습니다. 많은 관심 부탁드립니다.', NOW(), NOW()),
  (8, 4, '연말 할인 이벤트', '연말까지 제공되는 특별 할인을 놓치지 마세요.', NOW(), NOW()),
  (9, 1, '서비스 기능 정리 안내', '더 가치 있는 서비스를 제공하기 위해 일부 오래된 기능들을 정리하게 되었습니다.', NOW(), NOW()),
  (10, 2, '설문 조사 참여 요청', '저희 서비스 개선을 위한 최신 설문 조사에 참여해 주세요.', NOW(), NOW());


