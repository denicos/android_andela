CREATE TABLE [dbo].[Visitors]
(
	[Visitors_id] INT NOT NULL PRIMARY KEY,
	[Visitor_name] nvarchar(20),
	[Reason] nvarchar(150),
	[TimeIn] datetime ,
	[TimeOut] dateTime,
)
