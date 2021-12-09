package ru.attest.reactive_mongo.util;

/**
 * [Description("Пусто")]
 *         isNull = 0,
 *         [Description("Равно|=")]
 *         Equal = 1,
 *         [Description("Не равно|<>")]
 *         NotEqual = 2,
 *         [Description("Меньше|<")]
 *         LessThan = 3,
 *         [Description("Больше|>")]
 *         GreaterThan = 4,
 *         [Description("Меньше или равно|<=")]
 *         LessThanOrEqual = 5,
 *         [Description("Больше или равно|>=")]
 *         GreaterThanOrEqual = 6,
 *         [Description("Содержит")]
 *         Contains = 7,
 *         [Description("Не содержит")]
 *         NotContains = 8,
 *         [Description("Входит в")]
 *         ExistIn = 9,
 *         [Description("Не входит в")]
 *         NotExistIn = 10,
 *         [Description("Не пусто")]
 *         NotNull = 11,
 *         [Description("Доступ на чтение")]
 *         readAccess = 12,
 *         [Description("Между")]
 *         Between = 13,
 *         [Description("Прошлая неделя")]
 *         PrevWeek = 14,
 *         [Description("Эта неделя")]
 *         CurWeek = 15,
 *         [Description("Прошлый месяц")]
 *         PrevMth = 16,
 *         [Description("Этот месяц")]
 *         CurMth = 17,
 *         [Description("Этот год")]
 *         CurYear = 18,
 *         [Description("365 дней")]
 *         LastYear = 19,
 *         [Description("Да")]
 *         True = 20,
 *         [Description("Нет")]
 *         False = 21
 */

public enum TypeComparison {
	isNull{
		final public String name = "Пусто";
		final public String shortName = "Пусто";
		final public int key = 0;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	Equal{
		final public String name = "Равно";
		final public String shortName = "=";
		final public int key = 1;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	NotEqual{
		final public String name = "Не равно";
		final public String shortName = "<>";
		final public int key = 2;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	LessThan{
		final public String name = "Меньше";
		final public String shortName = "<";
		final public int key = 3;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	GreaterThan{
		final public String name = "Больше";
		final public String shortName = ">";
		final public int key = 4;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	LessThanOrEqual{
		final public String name = "Меньше или равно";
		final public String shortName = "<=";
		final public int key = 5;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	GreaterThanOrEqual{
		final public String name = "Больше или равно";
		final public String shortName = ">=";
		final public int key = 6;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	Contains{
		final public String name = "Содержит";
		final public String shortName = "Содержит";
		final public int key = 7;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	NotContains{
		final public String name = "Не содержит";
		final public String shortName = "Не содержит";
		final public int key = 8;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	ExistIn{
		final public String name = "Входит в";
		final public String shortName = "Входит в";
		final public int key = 9;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	NotExistIn{
		final public String name = "Не входит в";
		final public String shortName = "Не входит в";
		final public int key = 10;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	NotNull{
		final public String name = "Не пусто";
		final public String shortName = "Не пусто";
		final public int key = 11;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	ReadAccess{
		final public String name = "Доступ на чтение";
		final public String shortName = "Доступ на чтение";
		final public int key = 12;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	Between{
		final public String name = "Между";
		final public String shortName = "Между";
		final public int key = 13;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	PrevWeek{
		final public String name = "Прошлая неделя";
		final public String shortName = "Прошлая неделя";
		final public int key = 14;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	CurWeek{
		final public String name = "Эта неделя";
		final public String shortName = "Эта неделя";
		final public int key = 15;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	PrevMth{
		final public String name = "Прошлый месяц";
		final public String shortName = "Прошлый месяц";
		final public int key = 16;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	CurMth{
		final public String name = "Этот месяц";
		final public String shortName = "Этот месяц";
		final public int key = 17;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	CurYear{
		final public String name = "Этот год";
		final public String shortName = "Этот год";
		final public int key = 18;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	LastYear{
		final public String name = "365 дней";
		final public String shortName = "365 дней";
		final public int key = 19;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	True{
		final public String name = "Да";
		final public String shortName = "Да";
		final public int key = 20;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	},
	False{
		final public String name = "Нет";
		final public String shortName = "Нет";
		final public int key = 21;

		public String getName(){return name;}
		public String getShortName(){return shortName;}
		public int getKey(){return key;}
	};

	public abstract String getName();
	public abstract String getShortName();
	public abstract int getKey();
}
