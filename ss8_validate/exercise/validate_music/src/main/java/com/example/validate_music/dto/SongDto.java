package com.example.validate_music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class SongDto  {

    private int id;

    @NotBlank(message = "Cannot be left blank")
    @Size( max = 800, message = " max: 800 character")
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$")
    private String songName;

    @NotBlank(message = "Cannot be left blank")
    @Size( max = 300, message = " max: 300 character")
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$")
    private String singer;

    @NotBlank(message = "Cannot be left blank")
    @Size( max = 1000, message = " max: 1000 character")
    @Pattern(regexp = "^[a-zA-Z0-9, \\+]*$")
    private String type;

    public SongDto() {
    }

    public SongDto(int id, String songName, String singer, String type) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
