package com.haebun.erhb.information.subject;

import org.json.JSONObject;

public class SubjectData {
    private String name;
    private String real_name;
    private String name_kor;
    private String real_name_kor;
    private String nationality;
    private String age;
    private String subject_number;
    private String job;
    private String battle_type;

    public SubjectData(JSONObject item) throws Exception {
        this.name = item.getString("name");
        this.real_name = item.getString("real_name");
        this.name_kor = item.getString("name_kor");
        this.real_name_kor = item.getString("real_name_kor");
        this.nationality = item.getString("nationality");
        this.age = item.getString("age");
        this.subject_number = item.getString("subject_number");
        this.job = item.getString("job");
        this.battle_type = item.getString("battle_type");
    }

    public String getName() {
        return name;
    }

    public String getName_kor() {
        return name_kor;
    }

    public String getAge() {
        return age;
    }

    public String getBattle_type() {
        return battle_type;
    }

    public String getJob() {
        return job;
    }

    public String getNationality() {
        return nationality;
    }

    public String getReal_name() {
        return real_name;
    }

    public String getReal_name_kor() {
        return real_name_kor;
    }

    public String getSubject_number() {
        return subject_number;
    }
}
