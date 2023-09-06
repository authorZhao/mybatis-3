CREATE TABLE `test_user` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) NOT NULL,
                             `sex` tinyint DEFAULT NULL,
                             `avatar` varchar(255) DEFAULT NULL,
                             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             `data_version` int NOT NULL DEFAULT '0',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
