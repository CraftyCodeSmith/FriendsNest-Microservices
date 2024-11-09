-- Insert Roles
INSERT INTO roles (name, description) VALUES
('ADMIN', 'Administrator role with full permissions'),
('USER', 'Regular user with limited permissions'),
('MODERATOR', 'Moderator role with elevated permissions');

-- Insert Permissions
INSERT INTO permission (name, description) VALUES
('READ', 'Permission to read data'),
('WRITE', 'Permission to write data'),
('DELETE', 'Permission to delete data'),
('MODERATE', 'Permission to moderate content');

-- Insert Users
INSERT INTO users (username, email, password, document_id, bio, status, last_login, last_password_change) VALUES
('admin_user', 'admin@example.com', '{bcrypt_hashed_password}', 123456, 'Administrator of the system', true, NOW(), NOW()),
('regular_user', 'user@example.com', '{bcrypt_hashed_password}', 654321, 'A regular user', true, NOW(), NOW()),
('moderator_user', 'moderator@example.com', '{bcrypt_hashed_password}', 112233, 'Moderator of the system', true, NOW(), NOW());

-- Insert RolePermissions (Associating Roles with Permissions)
INSERT INTO role_permissions (role_id, permission_id) VALUES
(1, 1),  -- ADMIN can READ
(1, 2),  -- ADMIN can WRITE
(1, 3),  -- ADMIN can DELETE
(1, 4),  -- ADMIN can MODERATE
(2, 1),  -- USER can READ
(3, 1),  -- MODERATOR can READ
(3, 2),  -- MODERATOR can WRITE
(3, 4);  -- MODERATOR can MODERATE

-- Insert UserRoles (Assigning Roles to Users)
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1),  -- admin_user is assigned the ADMIN role
(2, 2),  -- regular_user is assigned the USER role
(3, 3);  -- moderator_user is assigned the MODERATOR role
