package com.spring.code.self.circular.dependency;

/**
 * @author dongzonglei
 * @description
 * @date 2019-05-13 18:22
 */
public class StudentC {

    private StudentA studentA;

    public StudentC() {
    }

    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }
}
