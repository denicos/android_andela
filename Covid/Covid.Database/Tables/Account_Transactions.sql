CREATE TABLE [dbo].[Account_Transactions]
(
	[Transaction_id] INT NOT NULL PRIMARY KEY,
	[action] nvarchar(128),
	[Account_id] nvarchar(128),
	[Notes] nvarchar(max) ,

	constraint [Fk_Account_id] Foreign Key ([Account_id]) references [dbo].[AspNetUsers](Id),
)
