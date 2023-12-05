package com.example.hearoptima_d_02.entity;

public class HraidInfoImage {
    int hrii_id;
    String hrii_file_name;
    String hrii_file_ext;
    String hrii_content;

    public HraidInfoImage() {
    }

    public HraidInfoImage(int hrii_id, String hrii_file_name, String hrii_file_ext, String hrii_content) {
        this.hrii_id = hrii_id;
        this.hrii_file_name = hrii_file_name;
        this.hrii_file_ext = hrii_file_ext;
        this.hrii_content = hrii_content;
    }


    @Override
    public String toString() {
        return "HraidImage{" +
                "hrii_id=" + hrii_id +
                ", hrii_file_name='" + hrii_file_name + '\'' +
                ", hrii_file_ext='" + hrii_file_ext + '\'' +
                ", hrii_content='" + hrii_content + '\'' +
                '}';
    }

    public int getHrii_id() {
        return hrii_id;
    }

    public void setHrii_id(int hrii_id) {
        this.hrii_id = hrii_id;
    }

    public String getHrii_file_name() {
        return hrii_file_name;
    }

    public void setHrii_file_name(String hrii_file_name) {
        this.hrii_file_name = hrii_file_name;
    }

    public String getHrii_file_ext() {
        return hrii_file_ext;
    }

    public void setHrii_file_ext(String hrii_file_ext) {
        this.hrii_file_ext = hrii_file_ext;
    }

    public String getHrii_content() {
        return hrii_content;
    }

    public void setHrii_content(String hrii_content) {
        this.hrii_content = hrii_content;
    }
}
