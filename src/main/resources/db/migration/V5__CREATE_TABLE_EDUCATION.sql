create table if not exists education (
                                         id SERIAL PRIMARY KEY,
                                         institute VARCHAR(100) NOT NULL,
                                         class_title VARCHAR(100) NOT NULL,
                                         started_at date NOT NULL,
                                         finished_at date
)
