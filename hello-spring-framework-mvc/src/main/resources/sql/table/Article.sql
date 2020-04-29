--------------------------------------------------------------------
-- Article table
--------------------------------------------------------------------
	-- DROP TABLE Article

	IF (OBJECT_ID('Article', N'U') IS NULL)
	BEGIN
		CREATE TABLE dbo.Article
		(
			id		INT		IDENTITY NOT NULL
		,	name		NVARCHAR(128)	NOT NULL DEFAULT('')
		,	description	NVARCHAR(MAX)	NOT NULL DEFAULT('')
		,	price		NUMERIC(19,2)	NOT NULL
		,	active		SMALLINT	NOT NULL DEFAULT(1)
		,	CONSTRAINT PK_ArticleID PRIMARY KEY NONCLUSTERED (id)
		)
	END

--------------------------------------------------------------------
-- New/Changed columns
--------------------------------------------------------------------


--------------------------------------------------------------------
-- Indices
--------------------------------------------------------------------

	-- Add the clustered index
	IF NOT EXISTS (SELECT name FROM sys.indexes WHERE name = N'CIX_ArticleID')
		CREATE CLUSTERED INDEX CIX_ArticleID ON Article(id)

	-- Unique Indexes
	IF NOT EXISTS (SELECT name FROM sys.indexes WHERE name = N'UI_Article_Name')
		CREATE UNIQUE INDEX UI_Article_Name ON Article(name)

--------------------------------------------------------------------
-- Foreign keys
--------------------------------------------------------------------

--------------------------------------------------------------------
-- Change Tracking
--------------------------------------------------------------------

--------------------------------------------------------------------
-- Constraints
--------------------------------------------------------------------

--------------------------------------------------------------------
-- Zipcode table end
--------------------------------------------------------------------
GO

/**
	INSERT INTO Article (name, description, price, active)
		SELECT	'Apple', 'Apples description', 3.25, 1
	UNION	SELECT	'Orange', 'Oranges description', 5.12, 1
	UNION	SELECT	'Grapefruit', 'Grapefruits description', 9.12, 1
	UNION	SELECT	'Mandarin', 'Mandarins description', 4.12, 1
	UNION	SELECT	'Lime', 'Limes description', 7.22, 1
	UNION	SELECT	'Nectarine', 'Nectarines description', 8.32, 1
	UNION	SELECT	'Plum', 'Plums description', 2.13, 1
	UNION	SELECT	'Banana', 'Bananas description', 6.24, 1
	UNION	SELECT	'Mango', 'Mangoes description', 7.66, 1
	UNION	SELECT	'Strawberri', 'Strawberries description', 4.18, 0
	UNION	SELECT	'Watermelon', 'Watermelons description', 13.25, 1
**/