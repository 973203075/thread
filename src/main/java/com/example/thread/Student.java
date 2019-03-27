package com.example.thread;

public class Student {
    private final String s;
    private final String ss;
    private final int i;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("s='").append(s).append('\'');
        sb.append(", ss='").append(ss).append('\'');
        sb.append(", i=").append(i);
        sb.append('}');
        return sb.toString();
    }

    public String getS() {
        return s;
    }

    public String getSs() {
        return ss;
    }

    public int getI() {
        return i;
    }

    public Student(String s, String ss, int i) {
        this.s = s;
        this.ss = ss;
        this.i = i;
    }
}
