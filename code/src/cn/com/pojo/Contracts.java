package cn.com.pojo;


import java.util.Objects;

public class Contracts {
    private String cid;
    private String name;
    private String sex;
    private String birth;
    private Integer age;
    private String qq;
    private String number;
    private String phone;
    private String email;
    private String workspace;
    private String address;
    private String postcode;
    private String username;
    private String role;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contracts contracts = (Contracts) o;
        return Objects.equals(cid, contracts.cid) &&
                Objects.equals(name, contracts.name) &&
                Objects.equals(sex, contracts.sex) &&
                Objects.equals(birth, contracts.birth) &&
                Objects.equals(age, contracts.age) &&
                Objects.equals(qq, contracts.qq) &&
                Objects.equals(number, contracts.number) &&
                Objects.equals(phone, contracts.phone) &&
                Objects.equals(email, contracts.email) &&
                Objects.equals(workspace, contracts.workspace) &&
                Objects.equals(address, contracts.address) &&
                Objects.equals(postcode, contracts.postcode) &&
                Objects.equals(username, contracts.username) &&
                Objects.equals(role, contracts.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, name, sex, birth, age, qq, number, phone, email, workspace, address, postcode, username, role);
    }

    @Override
    public String toString() {
        return "Contracts{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", number='" + number + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", workspace='" + workspace + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
