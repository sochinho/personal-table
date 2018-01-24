INSERT INTO users(user_token, username) VALUES
  ('user_token_1', 'testUser'),
  ('user_token_2', 'testUser2'),
  ('user_token_3', 'testUser3');

INSERT INTO notes(title, description, type, user_id) VALUES
  ('Test title 1', 'Test description 1', 'SIMPLE', 1),
  ('Test title 1', 'Test description 2', 'SIMPLE', 2),
  ('Test title 1', 'Test description 3', 'SIMPLE', 2),
  ('Test title 1', 'Test description 4', 'SIMPLE', 3);