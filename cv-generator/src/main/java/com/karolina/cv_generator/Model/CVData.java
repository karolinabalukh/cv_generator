package com.karolina.cv_generator.Model;

import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.List;

public class CVData {

    // private MultipartFile photo;
    // private String photoBase64;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String phone;
    private String address;
    private String postalCode;
    private String city;
    private LocalDate birthDate;
    private String gender;
    private String website;
    private String linkedin;

    private String summary;
    private List<String> skills;
    private List<Education> educations;
    private List<Experience> expertises;

//    public MultipartFile getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(MultipartFile photo) {
//        this.photo = photo;
//    }
//
//    public String getPhotoBase64() {
//        return photoBase64;
//    }
//
//    public void setPhotoBase64(String photoBase64) {
//        this.photoBase64 = photoBase64;
//    }


    public List<Experience> getExpertises() {
        return expertises;
    }

    public void setExpertises(List<Experience> expertises) {
        this.expertises = expertises;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
