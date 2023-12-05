package com.example.hearoptima_d_02.entity;

public class HraidImage {
    int hri_id;
    String hri_file_name;
    String hir_file_ext;
    String hir_content;

    public HraidImage() {
    }

    public HraidImage(int hri_id, String hri_file_name, String hir_file_ext, String hir_content) {
        this.hri_id = hri_id;
        this.hri_file_name = hri_file_name;
        this.hir_file_ext = hir_file_ext;
        this.hir_content = hir_content;
    }


    @Override
    public String toString() {
        return "HraidImage{" +
                "hri_id=" + hri_id +
                ", hri_file_name='" + hri_file_name + '\'' +
                ", hir_file_ext='" + hir_file_ext + '\'' +
                ", hir_content='" + hir_content + '\'' +
                '}';
    }

    public int getHri_id() {
        return hri_id;
    }

    public void setHri_id(int hri_id) {
        this.hri_id = hri_id;
    }

    public String getHri_file_name() {
        return hri_file_name;
    }

    public void setHri_file_name(String hri_file_name) {
        this.hri_file_name = hri_file_name;
    }

    public String getHir_file_ext() {
        return hir_file_ext;
    }

    public void setHir_file_ext(String hir_file_ext) {
        this.hir_file_ext = hir_file_ext;
    }

    public String getHir_content() {
        return hir_content;
    }

    public void setHir_content(String hir_content) {
        this.hir_content = hir_content;
    }
}
