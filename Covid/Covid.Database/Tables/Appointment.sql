CREATE TABLE [dbo].[Appointment]
(
	[Appointment_id] INT NOT NULL PRIMARY KEY,
	[Appointment_date] datetime not null,
	[ScheduledBy] nvarchar(20) ,
	[Reason] nvarchar(150)
)
