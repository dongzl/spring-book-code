package com.spring.code.self.circular.dependency;

/**
 * @author dongzonglei
 * @description
 * @date 2019-05-13 18:22
 */
public class StudentB {

    private StudentC studentC;

    public StudentB() {
    }

    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }

    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }
}
