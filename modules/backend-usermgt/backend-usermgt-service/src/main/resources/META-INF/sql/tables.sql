create table opencps_applicant (
	uuid_ VARCHAR(75) null,
	applicantId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	applicantName VARCHAR(75) null,
	applicantIdType VARCHAR(75) null,
	applicantIdNo VARCHAR(75) null,
	applicantIdDate DATE null,
	address VARCHAR(75) null,
	cityCode VARCHAR(75) null,
	cityName VARCHAR(75) null,
	districtCode VARCHAR(75) null,
	districtName VARCHAR(75) null,
	wardCode VARCHAR(75) null,
	wardName VARCHAR(75) null,
	contactName VARCHAR(75) null,
	contactTelNo VARCHAR(75) null,
	contactEmail VARCHAR(75) null,
	mappingUserId LONG,
	activationCode VARCHAR(75) null,
	lock_ BOOLEAN,
	profile VARCHAR(75) null
);

create table opencps_employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	fullName VARCHAR(75) null,
	employeeNo VARCHAR(75) null,
	gender INTEGER,
	birthDate DATE null,
	telNo VARCHAR(75) null,
	mobile VARCHAR(75) null,
	email VARCHAR(75) null,
	workingStatus INTEGER,
	mappingUserId LONG,
	mainJobPostId LONG,
	photoFileEntryId LONG,
	fileDocId LONG,
	preferences VARCHAR(75) null
);

create table opencps_employee_jobpos (
	uuid_ VARCHAR(75) null,
	employeeJobPosId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	employeeId LONG,
	jobPostId LONG
);

create table opencps_jobpos (
	uuid_ VARCHAR(75) null,
	jobPosId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	workingUnitId LONG,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	directWorkingUnitId LONG,
	leader INTEGER,
	mappingRoleId LONG,
	hiddenJobPos BOOLEAN
);

create table opencps_officesite (
	uuid_ VARCHAR(75) null,
	officeSiteId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	enName VARCHAR(75) null,
	govAgencyCode VARCHAR(75) null,
	address VARCHAR(75) null,
	telNo VARCHAR(75) null,
	faxNo VARCHAR(75) null,
	email VARCHAR(75) null,
	website VARCHAR(75) null,
	logoFileEntryId LONG,
	siteGroupId LONG,
	adminUserId LONG,
	preferences VARCHAR(75) null
);

create table opencps_preferences (
	uuid_ VARCHAR(75) null,
	preferencesId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	preferences VARCHAR(75) null
);

create table opencps_workingunit (
	uuid_ VARCHAR(75) null,
	workingUnitId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	enName VARCHAR(75) null,
	govAgencyCode VARCHAR(75) null,
	parentWorkingUnitId LONG,
	address VARCHAR(75) null,
	telNo VARCHAR(75) null,
	faxNo VARCHAR(75) null,
	email VARCHAR(75) null,
	website VARCHAR(75) null,
	logoFileEntryId LONG,
	sibling VARCHAR(75) null,
	treeIndex VARCHAR(75) null
);