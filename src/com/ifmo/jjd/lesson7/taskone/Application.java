package com.ifmo.jjd.lesson7.taskone;

public class Application {
    public static void main(String[] args) {


        Pupil pupil1 = new Pupil("Иван", 10,"Биология", 0);
        Pupil pupil2 = new Pupil("Петр", 10,"Физика", 0);
        Pupil pupil3 = new Pupil("Николай", 10,"Информатика", 0);
        Pupil pupil4 = new Pupil("Марина", 10,"Информатика", 0);
        Pupil pupil5 = new Pupil("Ольга", 10,"Биология", 0);
        Pupil pupil6 = new Pupil("Настя", 10,"Физика", 0);


        Teacher teacher1 = new Teacher("Тимофей Федорович", 40, "Биология");
        Teacher teacher2 = new Teacher("Анна Николаевна", 42, "Физика");
        Teacher teacher3 = new Teacher("Ольга Владимировна", 56, "Информатика");

        Pupil[] pupils = new Pupil[] {pupil1, pupil2, pupil3, pupil4, pupil5, pupil6};
        Teacher[] teachers = new Teacher[] {teacher1, teacher2, teacher3};
        Director director = new Director("Сегрей Владимирович", 55);


        School school = new School("Гимназия 1", director, teachers, pupils);

        school.dayToSchool(3);
    }
}
