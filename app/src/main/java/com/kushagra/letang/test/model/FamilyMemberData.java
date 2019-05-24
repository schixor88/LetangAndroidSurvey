package com.kushagra.letang.test.model;

/**
 * Created by Prabin on 1/6/2019.
 */

public class FamilyMemberData {
    //    String mem_1_name, mem_1_cast, mem_1_gender, mem_1_age, mem_1_relationToOwner, mem_1_birthplace, mem_1_hasEmail, mem_1_hasNoEmail, mem_1_hasLeftHome6Month, mem_1_hasNotLeftHome6Month ,mem_1_leaveHome_place, mem_1_leaveHome_reason;
//    String mem_1_education, mem_1_schoolType, mem_1_leaveSchool_reason, mem_1_schoolLevel;
//    String mem_1_incomeSource, mem_1_abroad_country, mem_1_abroad_moneyTransfer, mem_1_skills, mem_1_hasBankAC, mem_1_hasNoBankAC , mem_1_hasATM, mem_1_hasNoATM,mem_1_useOnlineBanking, mem_1_notUseOnlineBanking,mem_1_regularDeposit, mem_1_notRegularDeposit, mem_1_regularDeposit_to;
//    String mem_1_isHealthy, mem_1_isDisabled, mem_1_disabilityType, mem_1_hasDisabilityCard,mem_1_hasNoDisabilityCard ,mem_1_hasDisease12Month,mem_1_noDisease12Month, mem_1_hasLongTermDisease,mem_1_noLongTermDisease, mem_1_longTermDiseaseName, mem_1_hasCommunicableDisease,mem_1_noCommunicableDisease, mem_1_usesVaccine;
//    String mem_1_socialIdentity, mem_1_socialSecurity_type, mem_1_maritalStatus, mem_1_socialInvolvements, mem_1_hasReceivedTraining, mem_1_notReceivedTraining, mem_1_isPoliticalInfluencer, mem_1_isNotPoliticalInfluencer, mem_1_politicalInfluencerLevel;
//    String mem_1_travelWork, mem_1_travelBusiness, mem_1_travelEducation, mem_1_travelOthers;

    String name, gender, age, relationToOwner, hasLeftHome6Month, leaveHome_reason;
    String education, schoolType, leaveSchool_reason;
    String incomeSource, abroad_country, abroad_moneyTransfer, skills, regularDeposit, regularDeposit_to;
    String usesVaccine;
    String socialInvolvements, hasReceivedTraining, trainingList;
    String travelWork,travelWorkTo, travelBusiness,travelBusinessTo, travelEducation,travelEducationTo, travelOthers,travelOthersTo;

    public FamilyMemberData() {
        this.name  = "0";
        this.gender  = "0";
        this.age  = "0";
        this.relationToOwner  = "0";
        this.hasLeftHome6Month  = "0";
        this.leaveHome_reason  = "0";
        this.education  = "0";
        this.schoolType  = "0";
        this.leaveSchool_reason  = "0";
        this.incomeSource  = "0";
        this.abroad_country  = "0";
        this.abroad_moneyTransfer  = "0";
        this.skills  = "0";
        this.regularDeposit  = "0";
        this.regularDeposit_to  = "0";
        this.usesVaccine  = "0";
        this.socialInvolvements  = "0";
        this.hasReceivedTraining  = "0";
        this.trainingList  = "0";
        this.travelWork  = "0";
        this.travelWorkTo  = "0";
        this.travelBusiness  = "0";
        this.travelBusinessTo  = "0";
        this.travelEducation  = "0";
        this.travelEducationTo  = "0";
        this.travelOthers  = "0";
        this.travelOthersTo  = "0";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setRelationToOwner(String relationToOwner) {
        this.relationToOwner = relationToOwner;
    }

    public void setHasLeftHome6Month(String hasLeftHome6Month) {
        this.hasLeftHome6Month = hasLeftHome6Month;
    }

    public void setLeaveHome_reason(String leaveHome_reason) {
        this.leaveHome_reason = leaveHome_reason;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public void setLeaveSchool_reason(String leaveSchool_reason) {
        this.leaveSchool_reason = leaveSchool_reason;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public void setAbroad_country(String abroad_country) {
        this.abroad_country = abroad_country;
    }

    public void setAbroad_moneyTransfer(String abroad_moneyTransfer) {
        this.abroad_moneyTransfer = abroad_moneyTransfer;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setRegularDeposit(String regularDeposit) {
        this.regularDeposit = regularDeposit;
    }

    public void setRegularDeposit_to(String regularDeposit_to) {
        this.regularDeposit_to = regularDeposit_to;
    }

    public void setUsesVaccine(String usesVaccine) {
        this.usesVaccine = usesVaccine;
    }

    public void setSocialInvolvements(String socialInvolvements) {
        this.socialInvolvements = socialInvolvements;
    }

    public void setHasReceivedTraining(String hasReceivedTraining) {
        this.hasReceivedTraining = hasReceivedTraining;
    }

    public void setTrainingList(String trainingList) {
        this.trainingList = trainingList;
    }

    public void setTravelWork(String travelWork) {
        this.travelWork = travelWork;
    }

    public void setTravelWorkTo(String travelWorkTo) {
        this.travelWorkTo = travelWorkTo;
    }

    public void setTravelBusiness(String travelBusiness) {
        this.travelBusiness = travelBusiness;
    }

    public void setTravelBusinessTo(String travelBusinessTo) {
        this.travelBusinessTo = travelBusinessTo;
    }

    public void setTravelEducation(String travelEducation) {
        this.travelEducation = travelEducation;
    }

    public void setTravelEducationTo(String travelEducationTo) {
        this.travelEducationTo = travelEducationTo;
    }

    public void setTravelOthers(String travelOthers) {
        this.travelOthers = travelOthers;
    }

    public void setTravelOthersTo(String travelOthersTo) {
        this.travelOthersTo = travelOthersTo;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getRelationToOwner() {
        return relationToOwner;
    }

    public String getHasLeftHome6Month() {
        return hasLeftHome6Month;
    }

    public String getLeaveHome_reason() {
        return leaveHome_reason;
    }

    public String getEducation() {
        return education;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public String getLeaveSchool_reason() {
        return leaveSchool_reason;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public String getAbroad_country() {
        return abroad_country;
    }

    public String getAbroad_moneyTransfer() {
        return abroad_moneyTransfer;
    }

    public String getSkills() {
        return skills;
    }

    public String getRegularDeposit() {
        return regularDeposit;
    }

    public String getRegularDeposit_to() {
        return regularDeposit_to;
    }

    public String getUsesVaccine() {
        return usesVaccine;
    }

    public String getSocialInvolvements() {
        return socialInvolvements;
    }

    public String getHasReceivedTraining() {
        return hasReceivedTraining;
    }

    public String getTrainingList() {
        return trainingList;
    }

    public String getTravelWork() {
        return travelWork;
    }

    public String getTravelWorkTo() {
        return travelWorkTo;
    }

    public String getTravelBusiness() {
        return travelBusiness;
    }

    public String getTravelBusinessTo() {
        return travelBusinessTo;
    }

    public String getTravelEducation() {
        return travelEducation;
    }

    public String getTravelEducationTo() {
        return travelEducationTo;
    }

    public String getTravelOthers() {
        return travelOthers;
    }

    public String getTravelOthersTo() {
        return travelOthersTo;
    }
}