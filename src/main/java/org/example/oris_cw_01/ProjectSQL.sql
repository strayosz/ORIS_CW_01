create table accounts(
   account_id BIGSERIAL PRIMARY KEY,
   login      VARCHAR(50),
   name       VARCHAR(50),
   surname    VARCHAR(50),
   role       VARCHAR(50),
   status     VARCHAR(200),
   biography  VARCHAR(500)
--------------------------------------------------
   CONSTRAINT login_nn   CHECK  (login   is not null),
   CONSTRAINT name_nn    CHECK  (name    is not null),
   CONSTRAINT surname_nn CHECK  (surname is not null),
   CONSTRAINT role_nn    CHECK  (role    is not null),
   CONSTRAINT login_uq   UNIQUE (login)
);