create table agrar_Farmer (
	id_ LONG not null primary key,
	archive BOOLEAN,
	form INTEGER,
	name VARCHAR(75) null,
	inn VARCHAR(75) null,
	kpp VARCHAR(75) null,
	ogrn VARCHAR(75) null,
	registrationArea LONG,
	registrationDate DATE null
);

create table agrar_FarmerArea (
	id_ LONG not null primary key,
	farmerId LONG,
	areaId LONG,
	description VARCHAR(75) null
);

create table agrar_farmer_Farmer (
	id_ LONG not null primary key,
	archive BOOLEAN,
	form INTEGER,
	name VARCHAR(75) null,
	inn VARCHAR(75) null,
	kpp VARCHAR(75) null,
	ogrn VARCHAR(75) null,
	registrationArea LONG,
	registrationDate DATE null
);

create table agrar_farmer_FarmerArea (
	id_ LONG not null primary key,
	farmerId LONG,
	areaId LONG,
	description VARCHAR(75) null
);