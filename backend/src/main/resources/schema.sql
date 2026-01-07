CREATE TABLE IF NOT EXISTS `Mangas` (
                                        `anime_id` INT,
                                        `title` VARCHAR(512),
    `type` VARCHAR(100), -- Réduit car un type n'est jamais très long
    `score` DOUBLE,
    `scored_by` INT,
    `status` VARCHAR(100),
    `episodes` INT,
    `start_date` VARCHAR(100),
    `end_date` VARCHAR(100),
    `source` VARCHAR(255),
    `members` INT,
    `favorites` INT,
    `episode_duration` VARCHAR(100),
    `total_duration` VARCHAR(100),
    `rating` VARCHAR(100),
    `sfw` VARCHAR(10),
    `approved` VARCHAR(10),
    `created_at` VARCHAR(100),
    `updated_at` VARCHAR(100),
    `start_year` INT,
    `start_season` VARCHAR(100),
    `real_start_date` VARCHAR(100),
    `real_end_date` VARCHAR(100),
    `broadcast_day` VARCHAR(100),
    `broadcast_time` VARCHAR(100),
    `genres` TEXT,        -- CHANGÉ EN TEXT
    `themes` TEXT,        -- CHANGÉ EN TEXT
    `demographics` TEXT,  -- CHANGÉ EN TEXT
    `studios` TEXT,       -- CHANGÉ EN TEXT
    `producers` TEXT,      -- CHANGÉ EN TEXT
    `licensors` TEXT,      -- CHANGÉ EN TEXT
    `synopsis` TEXT,       -- CHANGÉ EN TEXT
    `background` TEXT,     -- CHANGÉ EN TEXT
    `main_picture` VARCHAR(512),
    `url` VARCHAR(512),
    `trailer_url` VARCHAR(512),
    `title_english` VARCHAR(512),
    `title_japanese` VARCHAR(512),
    `title_synonyms` TEXT, -- CHANGÉ EN TEXT
    PRIMARY KEY (`anime_id`)
    );