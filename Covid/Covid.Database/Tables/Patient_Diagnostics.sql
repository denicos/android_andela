CREATE TABLE [dbo].[Patient_Diagnostics]
(
	[Diagnostic_id] INT NOT NULL PRIMARY KEY,
	[Patient_id] nvarchar(128),
	[Diagnosis] nvarchar(200),
	[Doctor_id] nvarchar(128),
	[date] datetime,

	constraint[Fk_Patient_id] foreign key ([Patient_id]) references [dbo].[AspNetUsers](Id),
	constraint[Fk_Doctor_id] foreign key ([Doctor_id]) references [dbo].[AspNetUsers](Id)
)

