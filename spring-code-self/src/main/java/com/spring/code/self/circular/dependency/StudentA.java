package com.spring.code.self.circular.dependency;

/**
 * @author dongzonglei
 * @description
 * @date 2019-05-13 18:22
 */
public class StudentA {

    private StudentB studentB;

    public StudentA() {
    }

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }

    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }
}
