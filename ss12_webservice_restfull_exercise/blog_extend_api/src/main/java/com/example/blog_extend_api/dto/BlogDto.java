package com.example.blog_extend_api.dto;

import com.example.blog_extend_api.model.Category;

public class BlogDto {

        private int id;

        private String tittle;

        private String body;

        private String author;

        private String dateWriting;

        private Category category;

        public BlogDto() {
        }

        public BlogDto(int id, String tittle, String body, String author, String dateWriting) {
            this.id = id;
            this.tittle = tittle;
            this.body = body;
            this.author = author;
            this.dateWriting = dateWriting;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTittle() {
            return tittle;
        }

        public void setTittle(String tittle) {
            this.tittle = tittle;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDateWriting() {
            return dateWriting;
        }

        public void setDateWriting(String dateWriting) {
            this.dateWriting = dateWriting;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }


}
